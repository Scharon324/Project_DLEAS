import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;
import java.text.*;
import java.awt.event.*;
import javax.swing.table.*;
import net.proteanit.sql.DbUtils;

public class Student extends JFrame {
    
    public JButton btnDelete;
    private JButton btnGetData;
    private JButton btnNew;
    public JButton btnSave;
    public JButton btnUpdate;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel27;
    private JLabel jLabel29;
    public JLabel jLabel30;
    private JLabel jLabel31;
    private JLabel jLabel32;
    private JLabel jLabel33;
    private JLabel jLabel34;
    private JLabel jLabel35;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    public JTextField txtAddress;
    public JTextField txtBranch;
    public JTextField txtContactNo;
    public JTextField txtCourse;
    public JTextField txtCourseID;
    public JFormattedTextField txtDOB;
    public JTextField txtEmail;
    public JTextField txtEnrollmentNo;
    public JTextField txtFatherName;
    public JTextField txtMotherName;
    public JTextField txtScholarNo;
    public JFormattedTextField txtSession;
    public JTextField txtStudentName;
    
    Connection con=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    /**
     * Creates new form Student
     */
    public Student() {
        initComponents();
        txtCourseID.setVisible(false);
        Get_Data();
        setLocationRelativeTo(null);
    }

    private void Reset()
    {
        txtBranch.setText("");
        txtDOB.setText("");
        txtAddress.setText("");
        txtEnrollmentNo.setText("");
        txtEmail.setText("");
        txtMotherName.setText("");
        txtFatherName.setText("");
        txtContactNo.setText("");
        txtStudentName.setText("");
        txtSession.setText("");
        txtScholarNo.setText("");
        txtCourse.setText("");
        btnSave.setEnabled(true);
        btnDelete.setEnabled(false);
        btnUpdate.setEnabled(false);
        txtScholarNo.requestDefaultFocus();

    }

    private void Get_Data(){
        con=Connect.ConnectDB();
        String sql="select CourseID as 'Course ID',CourseName as 'Course Name',Branch from Course order by CourseName,Branch";
        try{
            pst=con.prepareStatement(sql);
            rs= pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);

        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel3 = new JPanel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel27 = new JLabel();
        txtScholarNo = new JTextField();
        txtEnrollmentNo = new JTextField();
        txtDOB = new JFormattedTextField();
        jLabel29 = new JLabel();
        jLabel30 = new JLabel();
        txtStudentName = new JTextField();
        jLabel31 = new JLabel();
        jLabel32 = new JLabel();
        jLabel33 = new JLabel();
        jLabel34 = new JLabel();
        jLabel35 = new JLabel();
        txtAddress = new JTextField();
        txtContactNo = new JTextField();
        txtMotherName = new JTextField();
        jLabel7 = new JLabel();
        txtFatherName = new JTextField();
        txtEmail = new JTextField();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        txtCourse = new JTextField();
        txtBranch = new JTextField();
        txtSession = new JFormattedTextField();
        jPanel2 = new JPanel();
        btnNew = new JButton();
        btnSave = new JButton();
        btnUpdate = new JButton();
        btnDelete = new JButton();
        btnGetData = new JButton();
        txtCourseID = new JTextField();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Student");
        setResizable(false);

        jPanel3.setBorder(BorderFactory.createTitledBorder("Student Info"));

        jLabel5.setText("Scholar No.");

        jLabel6.setText("Enrollment No.");

        jLabel27.setText("DOB");

        txtDOB.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("dd/MM/yyyy"))));

        jLabel29.setText("Student Name");

        jLabel30.setText("(DD/MM/YYYY)");

        jLabel31.setText("Session");

        jLabel32.setText("Father's Name");

        jLabel33.setText("Mother's Name");

        jLabel34.setText("Address");

        jLabel35.setText("Contact No.");

        txtContactNo.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent evt) {
                    txtContactNoKeyTyped(evt);
                }
            });

        jLabel7.setText("Email ID");

        jLabel1.setText("Course");

        jLabel2.setText("Branch");

        txtCourse.setEditable(false);

        txtBranch.setEditable(false);

        try {
            txtSession.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("####-####")));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel27)
                    .addComponent(jLabel29)
                    .addComponent(jLabel32)
                    .addComponent(jLabel31)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34)
                    .addComponent(jLabel35)
                    .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel7)
                        .addGroup(GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(jLabel2))
                        .addComponent(jLabel1, GroupLayout.Alignment.LEADING)))
                .addGap(53, 53, 53)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtContactNo, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtScholarNo)
                        .addComponent(txtEnrollmentNo)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(txtDOB, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel30))
                        .addComponent(txtStudentName)
                        .addComponent(txtFatherName)
                        .addComponent(txtMotherName))
                    .addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAddress, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtBranch, GroupLayout.Alignment.LEADING)
                        .addComponent(txtCourse, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                    .addComponent(txtSession, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(txtScholarNo, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtEnrollmentNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(txtStudentName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(txtDOB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(txtSession, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel32)
                            .addComponent(txtFatherName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(txtMotherName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(txtAddress, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(txtContactNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addComponent(jLabel7)
                        .addContainerGap(99, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCourse, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBranch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(23, 23, 23))))
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

        txtCourseID.setEditable(false);

        jTable1.setModel(new DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Course ID", "Course Name", "Branch"
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
                .addGap(27, 27, 27)
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCourseID, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCourseID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45))
                            .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE))))
                .addGap(29, 29, 29))
        );

        pack();
    }

    private void btnNewActionPerformed(ActionEvent evt) {
        Reset();
    }

    private void btnSaveActionPerformed(ActionEvent evt) {
        try{
            con=Connect.ConnectDB();
            if (txtScholarNo.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Please enter scholar no.","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtEnrollmentNo.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Please enter enrollment no.","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtStudentName.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Please enter student name","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtDOB.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Please enter DOB","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtSession.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Please enter session","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtFatherName.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Please enter father's name","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtMotherName.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Please enter mother's name","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtAddress.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Please enter address","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtContactNo.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Please enter contact no.","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtCourse.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Please retrieve course","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Statement stmt;
            stmt= con.createStatement();
            String sql1="Select ScholarNo from Student where ScholarNo= '" + txtScholarNo.getText() + "'" ;
            rs=stmt.executeQuery(sql1);
            if(rs.next()){
                JOptionPane.showMessageDialog( this, "Scholar No. already exists","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String sql= "insert into Student(ScholarNo,EnrollmentNo,StudentName,DOB,Session,Fathername,MotherName,Address,ContactNo,Email,CourseID)values('"+ txtScholarNo.getText() + "','" + txtEnrollmentNo.getText() + "','" + txtStudentName.getText() + "','" + txtDOB.getText() + "','" + txtSession.getText() + "','" + txtFatherName.getText() + "','" + txtMotherName.getText() + "','" + txtAddress.getText() + "','" + txtContactNo.getText() + "','" + txtEmail.getText() + "'," + txtCourseID.getText() + ")"; pst=con.prepareStatement(sql);
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
            String sql= "update Student set EnrollmentNo='" + txtEnrollmentNo.getText() + "',StudentName='" + txtStudentName.getText() + "',DOB='" + txtDOB.getText() + "',Session='" + txtSession.getText() + "',Fathername='" + txtFatherName.getText() + "',Mothername='" + txtMotherName.getText() + "',Address='" + txtAddress.getText() + "',Contactno='" + txtContactNo.getText() + "',Email='" + txtEmail.getText() + "',CourseID=" + txtCourseID.getText() + " where ScholarNo= '" + txtScholarNo.getText()  + "'";
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
                String sql= "delete from Student where ScholarNo = '" + txtScholarNo.getText() + "'";
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
        StudentRecord frm= new StudentRecord();
        frm.setVisible(true);
    }

    private void jTable1MouseClicked(MouseEvent evt) {
        try{
            con=Connect.ConnectDB();
            int row= jTable1.getSelectedRow();
            String add= jTable1.getModel().getValueAt(row,0).toString();
            txtCourseID.setText(add);
            String add1= jTable1.getModel().getValueAt(row,1).toString();
            txtCourse.setText(add1);
            String add2= jTable1.getModel().getValueAt(row,2).toString();
            txtBranch.setText(add2);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex);
        }
    }

    private void txtContactNoKeyTyped(KeyEvent evt) {
        char c=evt.getKeyChar();
        if (!(Character.isDigit(c)|| (c== KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))){
            getToolkit().beep();
            evt.consume();
        }
    }

    public static void main(String args[]) {
         new Student().setVisible(true);
        /* Set the Nimbus look and feel */
        /*

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new Student().setVisible(true);
                }
            });
            */
    }
}
