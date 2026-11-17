import javax.swing.*;

public class Contact extends JFrame {

    private JLabel jLabel1;
    private JLabel jLabel2;

    /**
     * Creates new form Contact
     */
    public Contact() {
        initComponents();
        setLocationRelativeTo(null);
    }

        public static void main(String args[]) {
        new Contact().setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Contact");
        setResizable(false);

        jLabel1.setText("+07522337068");

        jLabel2.setText("Andres Ipits");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }
}
