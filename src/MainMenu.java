import java.awt.event.*;
import javax.swing.*;

public class MainMenu extends JFrame {

    private JLabel MainMenuBox;
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenu jMenu5;
    private JMenu jMenu7;
    private JMenu jMenu8;
    private JMenuBar jMenuBar1;
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem10;
    private JMenuItem jMenuItem11;
    private JMenuItem jMenuItem12;
    private JMenuItem jMenuItem2;
    private JMenuItem jMenuItem3;
    private JMenuItem jMenuItem4;
    private JMenuItem jMenuItem5;
    private JMenuItem jMenuItem6;
    private JMenuItem jMenuItem7;
    private JMenuItem jMenuItem8;
    private JMenuItem jMenuItem9;

    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        initComponents();
        setLocationRelativeTo(null);
    }

        public static void main(String args[]) {
           new MainMenu().setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {
        MainMenuBox = new JLabel();
        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        jMenuItem1 = new JMenuItem();
        jMenuItem2 = new JMenuItem();
        jMenu2 = new JMenu();
        jMenuItem3 = new JMenuItem();
        jMenuItem4 = new JMenuItem();
        jMenuItem5 = new JMenuItem();
        jMenu5 = new JMenu();
        jMenuItem6 = new JMenuItem();
        jMenuItem7 = new JMenuItem();
        jMenuItem8 = new JMenuItem();
        jMenu7 = new JMenu();
        jMenuItem9 = new JMenuItem();
        jMenuItem10 = new JMenuItem();
        jMenu8 = new JMenu();
        jMenuItem11 = new JMenuItem();
        jMenuItem12 = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        //Jmenu is Master Entry
        jMenu1.setText("Master Entry");
        // Key stroke uses the command to easily use the keyboard shortcuts to access desired
        // entries faster (ALT_MASK) is the alt key + (VK_C) is the C key on the keyboard
        jMenuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_MASK));
        jMenuItem1.setText("Course");
        jMenuItem1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    jMenuItem1ActionPerformed(evt);
                }
            });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_MASK | InputEvent.CTRL_MASK));
        jMenuItem2.setText("Company");
        jMenuItem2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    jMenuItem2ActionPerformed(evt);
                }
            });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Users");

        jMenuItem3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_MASK));
        jMenuItem3.setText("Registration");
        jMenuItem3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    jMenuItem3ActionPerformed(evt);
                }
            });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.SHIFT_MASK));
        jMenuItem4.setText("Change Password");
        jMenuItem4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    jMenuItem4ActionPerformed(evt);
                }
            });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.ALT_MASK));
        jMenuItem5.setText("Login Details");
        jMenuItem5.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    jMenuItem5ActionPerformed(evt);
                }
            });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        jMenu5.setText("Students");

        jMenuItem6.setText("Profile Entry");
        jMenuItem6.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    jMenuItem6ActionPerformed(evt);
                }
            });
        jMenu5.add(jMenuItem6);

        jMenuItem7.setText("Training");
        jMenuItem7.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    jMenuItem7ActionPerformed(evt);
                }
            });
        jMenu5.add(jMenuItem7);

        jMenuItem8.setText("Placement");
        jMenuItem8.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    jMenuItem8ActionPerformed(evt);
                }
            });
        jMenu5.add(jMenuItem8);

        jMenuBar1.add(jMenu5);

        jMenu7.setText("Reports");

        jMenuItem9.setText("Students Training");
        jMenuItem9.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    jMenuItem9ActionPerformed(evt);
                }
            });
        jMenu7.add(jMenuItem9);

        jMenuItem10.setText("Students Placement");
        jMenuItem10.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    jMenuItem10ActionPerformed(evt);
                }
            });
        jMenu7.add(jMenuItem10);

        jMenuBar1.add(jMenu7);

        jMenu8.setText("Help");

        jMenuItem11.setText("About");
        jMenuItem11.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    jMenuItem11ActionPerformed(evt);
                }
            });
        jMenu8.add(jMenuItem11);

        jMenuItem12.setText("Contact");
        jMenuItem12.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    jMenuItem12ActionPerformed(evt);
                }
            });
        jMenu8.add(jMenuItem12);

        jMenuBar1.add(jMenu8);

        setJMenuBar(jMenuBar1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(MainMenuBox, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(MainMenuBox, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void jMenuItem3ActionPerformed(ActionEvent evt) {
        UsersRegistration frm= new UsersRegistration();
        frm.setVisible(true);
    }

    private void jMenuItem1ActionPerformed(ActionEvent evt) {
        Course frm = new Course();
        frm.setVisible(true);
    }

    private void jMenuItem2ActionPerformed(ActionEvent evt) {
        Company frm = new Company();
        frm.setVisible(true);
    }

    private void jMenuItem4ActionPerformed(ActionEvent evt) {
        ChangePassword frm = new ChangePassword();
        frm.setVisible(true);
    }

    private void jMenuItem5ActionPerformed(ActionEvent evt) {
        LoginDetails frm = new LoginDetails();
        frm.setVisible(true);
    }

    private void jMenuItem6ActionPerformed(ActionEvent evt) {
        Student frm = new Student();
        frm.setVisible(true);
    }

    private void jMenuItem7ActionPerformed(ActionEvent evt) {
        StudentTraining frm = new StudentTraining();
        frm.setVisible(true);
    }

    private void jMenuItem11ActionPerformed(ActionEvent evt) {
        About frm= new About();
        frm.setVisible(true);
    }

    private void jMenuItem9ActionPerformed(ActionEvent evt) {
        StudentsTrainingReport frm = new StudentsTrainingReport();
        frm.setVisible(true);
    }

    private void jMenuItem8ActionPerformed(ActionEvent evt) {
        StudentPlacement frm = new StudentPlacement();
        frm.setVisible(true);
    }

    private void jMenuItem10ActionPerformed(ActionEvent evt) {
        StudentsPlacementReport frm = new StudentsPlacementReport();
        frm.setVisible(true);
    }

    private void jMenuItem12ActionPerformed(ActionEvent evt) {
        Contact frm= new Contact();
        frm.setVisible(true);
    }
}
