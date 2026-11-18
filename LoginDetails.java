import java.sql.*;
import java.awt.*;
import java.awt.Font.*;
import javax.swing.table.*;
import javax.swing.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;

public class LoginDetails extends JFrame {
    
    private JTable Users_table;
    private JScrollPane jScrollPane1;

    Connection con=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    /**
     * Creates new form LoginDetails
     */
    public LoginDetails() {
        initComponents();
        con= Connect.ConnectDB();
        Get_Data();
        setLocationRelativeTo(null);
    }

    private void Get_Data(){
        String sql="select UserName as 'User Name',User_Password as 'Password' from users";
        try{
            pst=con.prepareStatement(sql);
            rs= pst.executeQuery();
            Users_table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);

        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new JScrollPane();
        Users_table = new JTable();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new WindowAdapter() {
                public void windowOpened(WindowEvent evt) {
                    formWindowOpened(evt);
                }
            });

        Users_table.setFont(new Font("Palatino Linotype", 1, 12));
        Users_table.setModel(new DefaultTableModel(
                new Object [][] {
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null}
                },
                new String [] {
                    "User Name", "Password"
                }
            ) {
                boolean[] canEdit = new boolean [] {
                        false, false
                    };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
        Users_table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(Users_table);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }

    private void formWindowOpened(WindowEvent evt) {

    }

    public static void main(String args[]) {
        new LoginDetails().setVisible(true);
    }
}
