import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ChangePassword extends JFrame {
    private JButton btnChangePassword;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JPasswordField txtConfirmPassword;
    private JPasswordField txtNewPassword;
    private JPasswordField txtOldPassword;
    private JTextField txtUsername;

    Connection con=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    /**
     * Creates new form ChangePassword
     */
    public ChangePassword() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        txtUsername = new JTextField();
        btnChangePassword = new JButton();
        txtOldPassword = new JPasswordField();
        txtNewPassword = new JPasswordField();
        txtConfirmPassword = new JPasswordField();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Change Password");
        setResizable(false);
        addWindowListener(new WindowAdapter() {
                public void windowOpened(WindowEvent evt) {
                    formWindowOpened(evt);
                }
            });

        jLabel1.setFont(new Font("Palatino Linotype", 1, 12)); 
        jLabel1.setText("User Name");

        jLabel2.setFont(new Font("Palatino Linotype", 1, 12)); 
        jLabel2.setText("Old Password");

        jLabel3.setFont(new Font("Palatino Linotype", 1, 12)); 
        jLabel3.setText("New Password");

        jLabel4.setFont(new Font("Palatino Linotype", 1, 12)); 
        jLabel4.setText("Confirm Password");

        btnChangePassword.setFont(new Font("Palatino Linotype", 1, 12)); 
        btnChangePassword.setText("Change Password");
        btnChangePassword.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    btnChangePasswordMouseClicked(evt);
                }
            });
        btnChangePassword.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    btnChangePasswordActionPerformed(evt);
                }
            });

        txtConfirmPassword.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent evt) {
                    txtConfirmPasswordKeyPressed(evt);
                }
            });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                        .addGap(22, 22, 22))
                    .addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(txtOldPassword, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNewPassword, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtConfirmPassword, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(btnChangePassword)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOldPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNewPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtConfirmPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(btnChangePassword, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        layout.linkSize(SwingConstants.VERTICAL, new Component[] {txtConfirmPassword, txtNewPassword, txtOldPassword, txtUsername});

        pack();
    }

    private void btnChangePasswordMouseClicked(MouseEvent evt) {

    }

    private void formWindowOpened(WindowEvent evt) {

    }

    private void btnChangePasswordActionPerformed(ActionEvent evt) {
        try{
            String Newpass=String.valueOf(txtNewPassword.getPassword());
            String ConfPass=String.valueOf(txtConfirmPassword.getPassword());
            String OldPass=String.valueOf(txtOldPassword.getPassword());
            String uName=txtUsername.getText();
            if (uName.equals("")) {

                JOptionPane.showMessageDialog( this, "Please enter a username",
                    "Error", JOptionPane.ERROR_MESSAGE);
                return;

            } else if (OldPass.equals("")) {

                JOptionPane.showMessageDialog( this, "Please enter a old password",
                    "Error", JOptionPane.ERROR_MESSAGE);
                return;

            } else if (Newpass.equals("")) {

                JOptionPane.showMessageDialog( this, "Please enter a new password",
                    "Error", JOptionPane.ERROR_MESSAGE);
                return;

            } else if (ConfPass.equals("")) {

                JOptionPane.showMessageDialog( this, "Please enter a confirmed password",
                    "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } 
            else if (Newpass.length()< 5) {

                JOptionPane.showMessageDialog(this,
                    "The New Password Should be of Atleast 5 Characters",
                    "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            else if ((Newpass).equals(OldPass)) {
                JOptionPane.showMessageDialog(this,
                    "Password is same..Re-enter new password","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else if (!(Newpass).equals(ConfPass)) {

                JOptionPane.showMessageDialog(this,
                    "New Password doesn't match with Confirmed Password",
                    "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            con=Connect.ConnectDB();
            String sql= "select Username,User_Password from users where Username='" + txtUsername.getText() + "' and User_Password= '" + txtOldPassword.getText() + "'";
            pst=con.prepareStatement(sql);
            rs= pst.executeQuery();
            while(rs.next())
            {
                String usrname = rs.getString("username").trim();
                String passwd = rs.getString("user_password").trim();
                if(uName.equals(usrname) && OldPass.equals(passwd))
                {
                    con=Connect.ConnectDB();
                    String sql1= "update users set User_password= '" + Newpass + "' where Username= '" + uName + "' and User_password = '" + OldPass + "'";
                    Statement stmt = con.createStatement();
                    stmt.execute(sql1.toString());
                    stmt.close();
                    JOptionPane.showMessageDialog(this,"Password Successfully Changed");
                    this.dispose();
                    return;
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"invalid user name or password","Error", JOptionPane.ERROR_MESSAGE);   
                    txtUsername.setText("");
                    txtOldPassword.setText("");
                    txtNewPassword.setText("");
                    txtConfirmPassword.setText("");
                    return;
                }
            }    
        }catch(SQLException | HeadlessException ex){
            JOptionPane.showMessageDialog(this,ex); 
        }
    }

    private void txtConfirmPasswordKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            try{
                String Newpass=String.valueOf(txtNewPassword.getPassword());
                String ConfPass=String.valueOf(txtConfirmPassword.getPassword());
                String OldPass=String.valueOf(txtOldPassword.getPassword());
                String uName=txtUsername.getText();
                if (uName.equals("")) {

                    JOptionPane.showMessageDialog( this, "Please enter a username",
                        "Error", JOptionPane.ERROR_MESSAGE);
                    return;

                } else if (OldPass.equals("")) {

                    JOptionPane.showMessageDialog( this, "Please enter a old password",
                        "Error", JOptionPane.ERROR_MESSAGE);
                    return;

                } else if (Newpass.equals("")) {

                    JOptionPane.showMessageDialog( this, "Please enter a new password",
                        "Error", JOptionPane.ERROR_MESSAGE);
                    return;

                } else if (ConfPass.equals("")) {

                    JOptionPane.showMessageDialog( this, "Please enter a confirmed password",
                        "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                } 
                else if (Newpass.length()< 5) {

                    JOptionPane.showMessageDialog(this,
                        "The New Password Should be of Atleast 5 Characters",
                        "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                else if ((Newpass).equals(OldPass)) {
                    JOptionPane.showMessageDialog(this,
                        "Password is same..Re-enter new password","Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                else if (!(Newpass).equals(ConfPass)) {

                    JOptionPane.showMessageDialog(this,
                        "New Password doesn't match with Confirmed Password",
                        "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                con=Connect.ConnectDB();
                String sql= "select Username,User_Password from users where Username='" + txtUsername.getText() + "' and User_Password= '" + txtOldPassword.getText() + "'";
                pst=con.prepareStatement(sql);
                rs= pst.executeQuery();
                while(rs.next())
                {
                    String usrname = rs.getString("username").trim();
                    String passwd = rs.getString("user_password").trim();
                    if(uName.equals(usrname) && OldPass.equals(passwd))
                    {
                        con=Connect.ConnectDB();
                        String sql1= "update users set User_password= '" + Newpass + "' where Username= '" + uName + "' and User_password = '" + OldPass + "'";
                        Statement stmt = con.createStatement();
                        stmt.execute(sql1.toString());
                        stmt.close();
                        JOptionPane.showMessageDialog(this,"Password Successfully Changed");
                        this.dispose();
                        return;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this,"invalid user name or password","Error", JOptionPane.ERROR_MESSAGE);   
                        txtUsername.setText("");
                        txtOldPassword.setText("");
                        txtNewPassword.setText("");
                        txtConfirmPassword.setText("");
                        return;
                    }
                }    
            }catch(SQLException | HeadlessException ex){
                JOptionPane.showMessageDialog(this,ex); 
            }

        }
    }

    public static void main(String args[]) {
        new ChangePassword().setVisible(true);
        /* Set the Nimbus look and feel */
        /*
        try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Metal".equals(info.getName())) {
        javax.swing.UIManager.setLookAndFeel(info.getClassName());
        break;
        }
        }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
        new ChangePassword().setVisible(true);
        }
        });
         */
    }
}
