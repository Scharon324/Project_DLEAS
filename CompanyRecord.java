import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class CompanyRecord extends JFrame {
    private JScrollPane jScrollPane1;
    private JTable jTable1;

    Connection con=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    /**
     * Creates new form CompanyRecord
     */
    public CompanyRecord() {
        initComponents();
        setLocationRelativeTo(null);
        Get_Data();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Comapny Record");
        setResizable(false);
        addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    formMouseClicked(evt);
                }
            });
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 960, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
        );

        pack();
    }
    
    private void Get_Data(){
        con=Connect.ConnectDB();
        String sql="select CompanyID as 'Company ID',CompanyName as 'Company Name',Address, ContactNo as 'Contact No.',Website from Company order by CompanyName";
        try{
            pst=con.prepareStatement(sql);
            rs= pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);

        }
    }

    private void formMouseClicked(MouseEvent evt) {

    }

    private void formWindowClosing(WindowEvent evt) {
        this.hide();
        Company frm = new Company();
        frm.setVisible(true);
    }

    private void jTable1MouseClicked(MouseEvent evt) {
        try{
            con=Connect.ConnectDB();
            this.hide();
            Company frm= new Company();
            frm.setVisible(true);
            int row= jTable1.getSelectedRow();
            String add= jTable1.getModel().getValueAt(row,0).toString();
            frm.txtCompanyID.setText(add);
            String add1= jTable1.getModel().getValueAt(row,1).toString();
            frm.txtCompanyName.setText(add1);
            String add2= jTable1.getModel().getValueAt(row,2).toString();
            frm.txtAddress.setText(add2);
            String add3= jTable1.getModel().getValueAt(row,3).toString();
            frm.txtContactNo.setText(add3);
            String add4= jTable1.getModel().getValueAt(row,4).toString();
            frm.txtWebsite.setText(add4);
            frm.btnUpdate.setEnabled(true);
            frm.btnDelete.setEnabled(true);
            frm.btnSave.setEnabled(false);

        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex);
        }
    }

    public static void main(String args[]) {
        new CompanyRecord().setVisible(true);
        /* Set the Nimbus look and feel */
        /*
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CompanyRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CompanyRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CompanyRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CompanyRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new CompanyRecord().setVisible(true);
                }
            });
            */
    }
}
