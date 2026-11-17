import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class About extends JFrame {

    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;

    public About() {
        initComponents();
        /*Sets the Java JFrameto the center of the screen that why we use the location
           relevent to null command.*/
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel5 = new JLabel();
        jButton1 = new JButton();
        //jLabel4 = new JLabel();
        jLabel6 = new JLabel();
        /* this causes the application to close when the frame is closed */
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About");
        /* setResizable will set the JFrame to be not resizable, that means user cant extend the
           JFrame*/ 
        setResizable(false);

        jLabel1.setFont(new Font("", 1, 18)); 
        jLabel1.setText("DLEAS");

        jLabel2.setFont(new Font("", 0, 14)); 
        jLabel2.setText("Alpha Version 0.6");

        jLabel3.setFont(new Font("", 0, 12)); 
        jLabel3.setText("Developed By : Andres Ipits");

        jLabel5.setFont(new Font("", 0, 12)); 
        jLabel5.setText("Comments: ");

        jLabel6.setFont(new Font("Andres", 0, 12)); 
        jLabel6.setText("Be aware this is onlythe Alpha version of my project, this project /n " + 
        "This project will be developed for Leksiko Iluharidus kesku and will be later on /n " +
        "continued to develop further");

        jButton1.setText("OK");
        jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    jButton1ActionPerformed(evt);
                }
            });

        //jLabel4.setIcon(new ImageIcon(getClass().getResource("/61.gif")));

        //jLabel6.setFont(new Font("Andres", 0, 12));
        //jLabel6.setText("Andres Ipits");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                //.addComponent(jLabel4)
                .addGap(36, 36, 36))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        //.addComponent(jLabel4)
                        .addGap(27, 27, 27)))
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        this.dispose();
    }

    public static void main(String args[]) {
        new About().setVisible(true);
    }
}
