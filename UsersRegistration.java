import javax.swing.*;
import java.awt.event.*;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UsersRegistration extends JFrame {
    public JButton Delete;
    private JButton GetData;
    private JButton New;
    public JButton Save;
    public JButton Update;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JPanel jPanel1;
    private JPanel jPanel2;
    public JTextField txtContactNo;
    public JTextField txtEmailID;
    public JTextField txtName;
    public JPasswordField txtPassword;
    public JTextField txtUserName;

    Connection con=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    /**
     * Creates new form UsersRegistration
     */
    public UsersRegistration() {
        initComponents();
        setLocationRelativeTo(null);
    }

        public static void main(String args[]) {
        new UsersRegistration().setVisible(true);
    }
    
    private void Reset()
    {
        txtName.setText("");
        txtUserName.setText("");
        txtPassword.setText("");
        txtEmailID.setText("");
        txtContactNo.setText("");
        Save.setEnabled(true);
        Delete.setEnabled(false);
        Update.setEnabled(false);
        txtUserName.requestDefaultFocus();

    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new JPanel();
        New = new JButton();
        Save = new JButton();
        Delete = new JButton();
        Update = new JButton();
        GetData = new JButton();
        jPanel2 = new JPanel();
        jLabel1 = new JLabel();
        txtName = new JTextField();
        jLabel2 = new JLabel();
        txtUserName = new JTextField();
        jLabel3 = new JLabel();
        txtPassword = new JPasswordField();
        jLabel4 = new JLabel();
        txtEmailID = new JTextField();
        jLabel5 = new JLabel();
        txtContactNo = new JTextField();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("User Registration");
        setResizable(false);

        jPanel1.setBorder(BorderFactory.createTitledBorder(""));

        New.setText("New");
        New.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    NewActionPerformed(evt);
                }
            });

        Save.setText("Save");
        Save.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    SaveActionPerformed(evt);
                }
            });

        Delete.setText("Delete");
        Delete.setEnabled(false);
        Delete.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    DeleteActionPerformed(evt);
                }
            });

        Update.setText("Update");
        Update.setEnabled(false);
        Update.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    UpdateActionPerformed(evt);
                }
            });

        GetData.setText("Get Data");
        GetData.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    GetDataActionPerformed(evt);
                }
            });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(New, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Save, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Delete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Update, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GetData, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(New, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Save, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Delete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Update, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GetData, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("User Details"));

        jLabel1.setText("Name");

        jLabel2.setText("User Name");

        jLabel3.setText("Password");

        jLabel4.setText("Email ID");

        jLabel5.setText("Contact No.");

        txtContactNo.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent evt) {
                    txtContactNoKeyTyped(evt);
                }
            });

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmailID)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtPassword, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                    .addComponent(txtName, GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtContactNo)))
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtUserName, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUserName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtEmailID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtContactNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }

    private void NewActionPerformed(ActionEvent evt) {
        Reset();
    }

    private void SaveActionPerformed(ActionEvent evt) {
        try{
            con=Connect.ConnectDB();
            if (txtName.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Please enter name","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtUserName.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Please enter user name","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String Password= String.valueOf(txtPassword.getPassword());
            if (Password.equals("")) {
                JOptionPane.showMessageDialog( this, "Please enter password","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtContactNo.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Please enter contact no.","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Statement stmt;
            stmt= con.createStatement();
            String sql1="Select username from Registration where Username= '" + txtUserName.getText() + "'";
            rs=stmt.executeQuery(sql1);
            if(rs.next()){
                JOptionPane.showMessageDialog( this, "User name already exists","Error", JOptionPane.ERROR_MESSAGE);
                txtUserName.setText("");
                txtUserName.requestDefaultFocus();
                return;
            }
            String Password1= String.valueOf(txtPassword.getPassword());
            String sql= "insert into Registration(username,password,nameofuser,Email,ContactNo)values('"+ txtUserName.getText() + "','" + Password1 + "','" + txtName.getText() + "','" + txtEmailID.getText() + "','" + txtContactNo.getText() + "')";

            pst=con.prepareStatement(sql);
            pst.execute();
            String sql2= "insert into Users(username,user_password)values('" + txtUserName.getText() + "','" + Password1 + "')";

            pst=con.prepareStatement(sql2);
            pst.execute();
            JOptionPane.showMessageDialog(this,"Successfully Registered","User",JOptionPane.INFORMATION_MESSAGE); 
            Save.setEnabled(false);
        }catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(this,ex); 
        }
    }

    private void DeleteActionPerformed(ActionEvent evt) {
        try
        {
            int P = JOptionPane.showConfirmDialog(null," Are you sure want to delete ?","Confirmation",JOptionPane.YES_NO_OPTION);
            if (P==0)
            {
                con=Connect.ConnectDB();

                String sql= "delete from Registration where Username = '" + txtUserName.getText() + "'";
                pst=con.prepareStatement(sql);
                pst.execute();  
                String sql1= "delete from Users where Username = '" + txtUserName.getText() + "'";
                pst=con.prepareStatement(sql1);
                pst.execute(); 
                JOptionPane.showMessageDialog(this,"Successfully deleted","Record",JOptionPane.INFORMATION_MESSAGE); 
                Reset();
            }
        }catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(this,ex); 
        }

    }

    private void UpdateActionPerformed(ActionEvent evt) {
        try{
            con=Connect.ConnectDB();
            String Password1= String.valueOf(txtPassword.getPassword());
            String sql= "update Registration set password='" + Password1 + "',nameofuser='" + txtName.getText() + "',Email='" + txtEmailID.getText() + "',ContactNo='" + txtContactNo.getText() + "' where Username='" + txtUserName.getText() + "'";

            pst=con.prepareStatement(sql);
            pst.execute();
            String sql2= "update Users set user_password='" + Password1 + "' where username='" + txtUserName.getText() + "'";

            pst=con.prepareStatement(sql2);
            pst.execute();
            JOptionPane.showMessageDialog(this,"Successfully updated","User info",JOptionPane.INFORMATION_MESSAGE); 
            Update.setEnabled(false);
        }catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(this,ex); 
        }
    }

    private void GetDataActionPerformed(ActionEvent evt) {
        this.hide();
        UsersRegistrationRecord frm = new UsersRegistrationRecord();
        frm.setVisible(true); 
    }

    private void txtContactNoKeyTyped(KeyEvent evt) {
        char c=evt.getKeyChar();
        if (!(Character.isDigit(c)|| (c== KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))){
            getToolkit().beep();
            evt.consume();
        }          
    }
}
