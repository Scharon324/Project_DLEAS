import java.sql.*;
import java.text.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
import net.proteanit.sql.DbUtils;

public class StudentsPlacementReport extends JFrame {
    private JButton btnReset;
    private JButton jButton1;
    private JPanel jPanel6;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JTextField txtStudentName;

    Connection con=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    /**
     * Creates new form StudentTrainingRecord
     */
    public StudentsPlacementReport() {
        initComponents();
        setLocationRelativeTo(null);
        Get_data();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel6 = new JPanel();
        txtStudentName = new JTextField();
        btnReset = new JButton();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        jButton1 = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Students Placement Report");
        setResizable(false);
        addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent evt) {
                    formWindowClosing(evt);
                }
            });

        jPanel6.setBorder(BorderFactory.createTitledBorder("Search Record by Course"));

        txtStudentName.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    txtStudentNameActionPerformed(evt);
                }
            });

        GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(txtStudentName, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtStudentName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnReset.setText("Reset");
        btnReset.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    btnResetActionPerformed(evt);
                }
            });

        jTable1.setModel(new DefaultTableModel(
                new Object [][] {

                },
                new String [] {

                }
            ));
        jTable1.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    jTable1MouseClicked(evt);
                }
            });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Print");
        jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    jButton1ActionPerformed(evt);
                }
            });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReset)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(758, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(btnReset)
                            .addComponent(jButton1))
                        .addGap(28, 28, 28)))
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE))
        );

        pack();
    }

    private void Get_data()
    {
        con=Connect.ConnectDB();
        String sql= "select Student.ScholarNo as 'Scholar No',EnrollmentNo as 'Enrollment No',StudentName as 'Student Name',Session,Coursename as 'Course',Branch,Companyname as 'Company',Package,PlacementDate as 'Placement Date' from Company,Student,StudentPlacement,Course where Company.CompanyID=StudentPlacement.CompanyID and StudentPlacement.ScholarNo=Student.ScholarNo and Student.CourseID = Course.CourseID order by StudentName";
        try{
            pst=con.prepareStatement(sql);
            rs= pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void txtStudentNameActionPerformed(ActionEvent evt) {
        con=Connect.ConnectDB();
        String sql= "select Student.ScholarNo as 'Scholar No',EnrollmentNo as 'Enrollment No',StudentName as 'Student Name',Session,Coursename as 'Course',Branch,Companyname as 'Company',Package,PlacementDate as 'Placement Date' from Company,Student,StudentPlacement,Course where Company.CompanyID=StudentPlacement.CompanyID and StudentPlacement.ScholarNo=Student.ScholarNo and Student.CourseID = Course.CourseID and CourseName like '" + txtStudentName.getText() + "%' order by StudentName";
        try{
            pst=con.prepareStatement(sql);
            rs= pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void btnResetActionPerformed(ActionEvent evt) {
        txtStudentName.setText("");
        Get_data();
        txtStudentName.requestDefaultFocus();
    }

    private void jTable1MouseClicked(MouseEvent evt) {

    }

    private void formWindowClosing(WindowEvent evt) {

    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        MessageFormat header= new MessageFormat("Students Placement Report");
        MessageFormat footer= new MessageFormat(" Page{0,number,integer} ");
        try{

            jTable1.print(JTable.PrintMode.FIT_WIDTH,header,footer);

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void main(String args[]) {
        new StudentTrainingRecord().setVisible(true);
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
            java.util.logging.Logger.getLogger(StudentTrainingRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentTrainingRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentTrainingRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentTrainingRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new StudentTrainingRecord().setVisible(true);
                }
            });
            */
    }
}
