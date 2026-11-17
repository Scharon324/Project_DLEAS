import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Company extends JFrame {

    public JButton btnDelete;
    private JButton btnGetData;
    private JButton btnNew;
    public JButton btnSave;
    public JButton btnUpdate;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JPanel jPanel1;
    private JPanel jPanel2;
    public JTextField txtAddress;
    public JTextField txtCompanyID;
    public JTextField txtCompanyName;
    public JTextField txtContactNo;
    public JTextField txtWebsite;

    Connection con=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    /**
     * Creates new form Company
     */
    public Company() {
        initComponents();
        setLocationRelativeTo(null);
        txtCompanyID.setVisible(false);
    }
    // Resets all the text in the txt fields
    private void Reset()
    {
        txtCompanyName.setText("");
        txtAddress.setText("");
        txtCompanyID.setText("");
        txtContactNo.setText("");
        txtWebsite.setText("");
        btnSave.setEnabled(true);
        btnDelete.setEnabled(false);
        btnUpdate.setEnabled(false);
        txtCompanyName.requestDefaultFocus();

    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        txtCompanyName = new JTextField();
        txtAddress = new JTextField();
        jLabel3 = new JLabel();
        txtContactNo = new JTextField();
        jLabel4 = new JLabel();
        txtWebsite = new JTextField();
        jPanel2 = new JPanel();
        btnNew = new JButton();
        btnSave = new JButton();
        btnUpdate = new JButton();
        btnDelete = new JButton();
        btnGetData = new JButton();
        txtCompanyID = new JTextField();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Company");
        setResizable(false);

        jPanel1.setBorder(BorderFactory.createTitledBorder("Company Info"));

        jLabel1.setText("Company Name");

        jLabel2.setText("Address");

        jLabel3.setText("Contact No.");

        txtContactNo.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent evt) {
                    txtContactNoKeyTyped(evt);
                }
            });

        jLabel4.setText("Website");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(txtCompanyName)
                    .addComponent(txtAddress)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtContactNo, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 199, Short.MAX_VALUE))
                    .addComponent(txtWebsite))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCompanyName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtContactNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtWebsite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel2.setBorder(BorderFactory.createTitledBorder(""));

        btnNew.setText("New");
        btnNew.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    btnNewActionPerformed(evt);
                }
            });

        btnSave.setText("Save");
        btnSave.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    btnSaveActionPerformed(evt);
                }
            });

        btnUpdate.setText("Update");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    btnUpdateActionPerformed(evt);
                }
            });

        btnDelete.setText("Delete");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    btnDeleteActionPerformed(evt);
                }
            });

        btnGetData.setText("Get Data");
        btnGetData.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    btnGetDataActionPerformed(evt);
                }
            });

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGetData, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSave, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNew, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNew)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGetData)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(txtCompanyID, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCompanyID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }
    
    private void btnNewActionPerformed(ActionEvent evt) {
        Reset();
    }

    private void btnSaveActionPerformed(ActionEvent evt) {
        try{
            con=Connect.ConnectDB();
            if (txtCompanyName.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Please enter company name","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtAddress.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Please enter address","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Statement stmt;
            stmt= con.createStatement();
            String sql1="Select CompanyName from Company where CompanyName= '" + txtCompanyName.getText() + "'" ;
            rs=stmt.executeQuery(sql1);
            if(rs.next()){
                JOptionPane.showMessageDialog( this, "Record already exists","Error", JOptionPane.ERROR_MESSAGE);
                Reset();
                return;
            }

            String sql= "insert into Company(Companyname,Address,ContactNo,website)values('"+ txtCompanyName.getText() + "','" + txtAddress.getText() + "','" + txtContactNo.getText() + "','" + txtWebsite.getText() + "')";
            pst=con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this,"Successfully saved","Record",JOptionPane.INFORMATION_MESSAGE);
            btnSave.setEnabled(false);
        }catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(this,ex);
        }
    }

    private void btnUpdateActionPerformed(ActionEvent evt) {
        try{
            con=Connect.ConnectDB();

            String sql= "Update Company set Companyname='"+ txtCompanyName.getText() + "',Address='" + txtAddress.getText() + "',ContactNo='" + txtContactNo.getText() + "',Website='" + txtWebsite.getText() + "' where CompanyID= " + txtCompanyID.getText() + "";
            pst=con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this,"Successfully updated","Record",JOptionPane.INFORMATION_MESSAGE);
            btnUpdate.setEnabled(false);
        }catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(this,ex);
        }
    }

    private void btnDeleteActionPerformed(ActionEvent evt) {
        try
        {
            int P = JOptionPane.showConfirmDialog(null," Are you sure want to delete ?","Confirmation",JOptionPane.YES_NO_OPTION);
            if (P==0)
            {
                con=Connect.ConnectDB();
                String sql= "delete from Company where CompanyID = " + txtCompanyID.getText() + "";
                pst=con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(this,"Successfully deleted","Record",JOptionPane.INFORMATION_MESSAGE);
                Reset();

            }
        }catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(this,ex);
        }

    }

    private void btnGetDataActionPerformed(ActionEvent evt) {
        this.hide();
        CompanyRecord frm= new CompanyRecord();
        frm.setVisible(true);
    }

    private void txtContactNoKeyTyped(KeyEvent evt) {
        char c=evt.getKeyChar();
        if (!(Character.isDigit(c)|| (c== KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))){
            getToolkit().beep();
            evt.consume();
        }
    }

    public static void main(String args[]) {
        new Company().setVisible(true);
    }
}
