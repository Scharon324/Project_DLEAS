import net.proteanit.sql.DbUtils;
import java.text.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.sql.*;

public class StudentsTrainingReport extends JFrame {
    private JButton btnReset;
    private JButton jButton1;
    private JPanel jPanel6;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JTextField txtCourse;

    Connection con=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    /**
     * Creates new form StudentTrainingRecord
     */
    public StudentsTrainingReport() {
        initComponents();
        setLocationRelativeTo(null);
        Get_data();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel6 = new JPanel();
        txtCourse = new JTextField();
        btnReset = new JButton();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        jButton1 = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Students Training Report");
        setResizable(false);
        addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent evt) {
                    formWindowClosing(evt);
                }
            });

        jPanel6.setBorder(BorderFactory.createTitledBorder("Search Record By Course"));

        txtCourse.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    txtCourseActionPerformed(evt);
                }
            });

        GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(txtCourse, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCourse, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 1136, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReset)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
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
        String sql= "select Student.ScholarNo as 'Scholar No',EnrollmentNo as 'Enrollment No',StudentName as 'Student Name',Session,Coursename as 'Course', Branch,Companyname as 'Company',TrainingDuration as 'Duration(in months)' from Course,Student,StudentTraining where Course.CourseID=Student.CourseID and StudentTraining.ScholarNo=Student.ScholarNo order by StudentName"; 
        try{
            pst=con.prepareStatement(sql);
            rs= pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void txtCourseActionPerformed(ActionEvent evt) {
        con=Connect.ConnectDB();
        String sql= "select Student.ScholarNo as 'Scholar No',EnrollmentNo as 'Enrollment No',StudentName as 'Student Name',Session,Coursename as 'Course',Branch,Companyname as 'Company',TrainingDuration as 'Duration(in months)' from Course,Student,StudentTraining where Course.CourseID=Student.CourseID and StudentTraining.ScholarNo=Student.ScholarNo and CourseName like '" + txtCourse.getText() + "%' order by StudentName";
        try{
            pst=con.prepareStatement(sql);
            rs= pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void btnResetActionPerformed(ActionEvent evt) {
        txtCourse.setText("");
        Get_data();
        txtCourse.requestDefaultFocus();
    }

    private void jTable1MouseClicked(MouseEvent evt) {

    }

    private void formWindowClosing(WindowEvent evt) {

    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        MessageFormat header= new MessageFormat("Student Training Report");
        MessageFormat footer= new MessageFormat(" Page{0,number,integer} ");
        try{

            jTable1.print(JTable.PrintMode.FIT_WIDTH,header,footer);

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void main(String args[]) {
        new StudentTrainingRecord().setVisible(true);
    }
}
