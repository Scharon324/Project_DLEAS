import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
import net.proteanit.sql.DbUtils;

public class UsersRegistrationRecord extends JFrame {
    private JScrollPane jScrollPane1;
    private JTable jTable1;

    Connection con=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    /**
     * Creates new form UsersRegistrationRecord
     */
    public UsersRegistrationRecord() {
        initComponents();
        con= Connect.ConnectDB();
        Get_Data();
        setLocationRelativeTo(null);
    }

        public static void main(String args[]) {
        new UsersRegistrationRecord().setVisible(true);
    }
    
    private void Get_Data(){
        String sql="select NameOfUser as 'Name', UserName as 'User Name',Password,ContactNo as 'Contact No.',Email as 'Email ID' from Registration";
        try{
            pst=con.prepareStatement(sql);
            rs= pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);

        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Record");
        setResizable(false);
        addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent evt) {
                    formWindowClosing(evt);
                }
            });

        jTable1.setModel(new DefaultTableModel(
                new Object [][] {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String [] {
                    "Title 1", "Title 2", "Title 3", "Title 4"
                }
            ));
        jTable1.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    jTable1MouseClicked(evt);
                }
            });
        jScrollPane1.setViewportView(jTable1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 385, GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }

    private void jTable1MouseClicked(MouseEvent evt) {
        try{
            con=Connect.ConnectDB();
            int row= jTable1.getSelectedRow();
            String table_click= jTable1.getModel().getValueAt(row, 1).toString();
            String sql= "select * from registration where username= '" + table_click + "'";
            pst=con.prepareStatement(sql);
            rs=  pst.executeQuery();
            if(rs.next()){
                this.hide();
                UsersRegistration frm = new UsersRegistration();
                frm.setVisible(true);
                String add1=rs.getString("Username");
                frm.txtUserName.setText(add1);
                String add2=rs.getString("Password");
                frm.txtPassword.setText(add2);
                String add3=rs.getString("NameOfUser");
                frm.txtName.setText(add3);
                String add4=rs.getString("ContactNo");
                frm.txtContactNo.setText(add4);
                String add5=rs.getString("Email");
                frm.txtEmailID.setText(add5);
                frm.Save.setEnabled(false);
                frm.Delete.setEnabled(true);
                frm.Update.setEnabled(true);
            }

        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex);
        }
    }

    private void formWindowClosing(WindowEvent evt) {
        this.hide();
        UsersRegistration frm = new UsersRegistration();
        frm.setVisible(true);
    }
}
