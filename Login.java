import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame {
    private JButton btnCancel;
    private JButton btnOK;
    //Box.Filler creates invisible components for better component positioning.
    private Box.Filler filler1;
    private Box.Filler filler2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    //private JLabel jLabel3;
    private JMenuItem jMenuItem1;
    private JSplitPane jSplitPane1;
    // Makes JText field when typed the password into the field not to show real password.
    public JPasswordField txtPassword;
    public JTextField txtUserName;

    Connection con=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public static void main(String args[]){
        new Login().setVisible(true);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jMenuItem1 = new JMenuItem();
        // Anishilizing the minimum, preffered and maximum size of the component
        filler1 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 0), new Dimension(32767, 0));
        jSplitPane1 = new JSplitPane();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        txtUserName = new JTextField();
        txtPassword = new JPasswordField();
        btnOK = new JButton();
        btnCancel = new JButton();
        // Anishilizing the minimum, preffered and maximum size of the component
        filler2 = new Box.Filler(new Dimension(0, 0), new Dimension(0, 0), new Dimension(32767, 0));

        jMenuItem1.setText("jMenuItem1");
        //Exit the application using the System exit method
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //The title of the frame
        setTitle("Login Form");
        //The resizable window cannot be resized.
        setResizable(false);

        addWindowListener(new WindowAdapter() {
                public void windowOpened(WindowEvent evt) {
                    formWindowOpened(evt);
                }
            });

        jLabel1.setText("User Name");

        jLabel2.setText("Password");

        txtUserName.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    txtUserNameMouseClicked(evt);
                }
            });

        txtUserName.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    txtUserNameActionPerformed(evt);
                }
            });

        txtPassword.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent evt) {
                    txtPasswordKeyPressed(evt);
                }
            });

        btnOK.setText("OK");
        btnOK.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    btnOKMouseClicked(evt);
                }
            });

        btnOK.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    btnOKActionPerformed(evt);
                }
            });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    btnCancelActionPerformed(evt);
                }
            });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(

            layout.createParallelGroup(GroupLayout.Alignment.LEADING)

            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)

                //.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)

                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)

                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)

                        .addComponent(txtUserName, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
                    .addComponent(filler2, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)

                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(24, 24, 24)

                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)  
                            .addGroup(layout.createSequentialGroup()

                                .addComponent(btnOK, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

                                .addComponent(btnCancel))

                            .addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE)));
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtUserName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(btnOK)
                            .addComponent(btnCancel))
                        .addGap(11, 11, 11)
                        .addComponent(filler2, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
        ))));
        pack();
    }

    private void btnOKMouseClicked(MouseEvent evt) {                                   
        if (txtUserName.getText().equals("")) {
            JOptionPane.showMessageDialog( this, "Please enter user name","Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String Password= String.valueOf(txtPassword.getPassword());
        if (Password.equals("")) {
            JOptionPane.showMessageDialog( this, "Please enter password","Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        con=Connect.ConnectDB();
        String sql= "select * from users where UserName= '" + txtUserName.getText() + "' and user_Password ='" + txtPassword.getText() + "'";
        try
        {
            pst=con.prepareStatement(sql);
            rs= pst.executeQuery();
            if (rs.next()){
                this.hide();
                MainMenu frm=new MainMenu();
                frm.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "Login Failed..Try again !","Access denied",JOptionPane.ERROR_MESSAGE);
            }
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e); 

        }                                     
    }                                  

    private void txtPasswordKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            con=Connect.ConnectDB();
            String sql= "select * from users where UserName= '" + txtUserName.getText() + "' and user_Password ='" + txtPassword.getText() + "'";
            try
            {
                pst=con.prepareStatement(sql);
                rs= pst.executeQuery();
                if (rs.next()){
                    this.hide();
                    MainMenu frm=new MainMenu();
                    frm.setVisible(true);
                }
                else{

                    JOptionPane.showMessageDialog(null, "Login Failed..Try again !","Access denied",JOptionPane.ERROR_MESSAGE);
                    txtUserName.setText("");
                    txtPassword.setText("");
                    txtUserName.requestDefaultFocus();
                }
            }catch(SQLException | HeadlessException e){
                JOptionPane.showMessageDialog(null, e); 

            }            
        }
    }
    
    private void btnCancelActionPerformed(ActionEvent evt) {
        System.exit(0);
    }
    
    private void txtUserNameMouseClicked(MouseEvent evt) {

    }
    
    private void formWindowOpened(WindowEvent evt) {

    }

    private void txtUserNameActionPerformed(ActionEvent evt) {  
    }
    
    private void btnOKActionPerformed(ActionEvent evt) {
    }
}
