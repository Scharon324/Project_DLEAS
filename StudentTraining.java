import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.awt.*;
import net.proteanit.sql.DbUtils;

public class StudentTraining extends JFrame {
    
    public JButton btnDelete;
    private JButton btnGetData;
    private JButton btnNew;
    public JButton btnSave;
    public JButton btnUpdate;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel29;
    private JLabel jLabel3;
    private JLabel jLabel31;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    public JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    public JTextField txtAddress;
    public JTextField txtBranch;
    public JTextField txtCompanyName;
    public JTextField txtContactNo;
    public JTextField txtCourse;
    public JTextField txtDurartion;
    public JTextField txtEmail;
    public JTextField txtEnrollmentNo;
    public JTextField txtID;
    public JTextField txtScholarNo;
    public JTextField txtSession;
    public JTextField txtStudentName;
    
    Connection con=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    /**
     * Creates new form StudentTraining
     */
    public StudentTraining() {
        initComponents();
        setLocationRelativeTo(null);
        Get_data();
        txtID.setVisible(false);
    }

    private void Get_data()
    {
        con=Connect.ConnectDB();
        String sql= " select ScholarNo as 'Scholar No.',EnrollmentNo as 'Enrollment No.',StudentName as 'Student Name',Session,Coursename as 'Course', Branch from Course,Student where Course.CourseID=Student.CourseID  order by StudentName ";   
        try{
            pst=con.prepareStatement(sql);
            rs= pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void Reset()
    {
        txtBranch.setText("");
        txtCompanyName.setText("");
        txtAddress.setText("");
        txtEmail.setText("");
        txtEnrollmentNo.setText("");
        txtDurartion.setText("");
        txtContactNo.setText("");
        txtStudentName.setText("");
        txtSession.setText("");
        txtScholarNo.setText("");
        txtCourse.setText("");
        btnSave.setEnabled(true);
        btnDelete.setEnabled(false);
        btnUpdate.setEnabled(false);

    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel3 = new JPanel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        txtScholarNo = new JTextField();
        txtEnrollmentNo = new JTextField();
        jLabel29 = new JLabel();
        txtStudentName = new JTextField();
        jLabel31 = new JLabel();
        txtSession = new JTextField();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        txtCourse = new JTextField();
        txtBranch = new JTextField();
        jPanel1 = new JPanel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        txtCompanyName = new JTextField();
        txtAddress = new JTextField();
        txtContactNo = new JTextField();
        txtDurartion = new JTextField();
        jLabel9 = new JLabel();
        txtEmail = new JTextField();
        jPanel2 = new JPanel();
        btnNew = new JButton();
        btnSave = new JButton();
        btnUpdate = new JButton();
        btnDelete = new JButton();
        btnGetData = new JButton();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        txtID = new JTextField();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Students Training");
        setResizable(false);

        jPanel3.setBorder(BorderFactory.createTitledBorder("Student Info"));

        jLabel5.setText("Scholar No.");

        jLabel6.setText("Enrollment No.");

        txtScholarNo.setEditable(false);

        txtEnrollmentNo.setEditable(false);

        jLabel29.setText("Student Name");

        txtStudentName.setEditable(false);

        jLabel31.setText("Session");

        txtSession.setEditable(false);

        jLabel1.setText("Course");

        jLabel2.setText("Branch");

        txtCourse.setEditable(false);

        txtBranch.setEditable(false);

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel29)
                    .addComponent(jLabel31)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(54, 54, 54)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtScholarNo, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(txtEnrollmentNo)
                        .addComponent(txtSession, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtStudentName))
                    .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtBranch, GroupLayout.Alignment.LEADING)
                        .addComponent(txtCourse, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
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
                    .addComponent(jLabel31)
                    .addComponent(txtSession, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCourse, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBranch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel1.setBorder(BorderFactory.createTitledBorder("Company and Training Info"));

        jLabel3.setText("Company Name");

        jLabel4.setText("Address");

        jLabel7.setText("Contact No.");

        jLabel8.setText("Training Durartion (in months)");

        txtContactNo.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent evt) {
                    txtContactNoKeyTyped(evt);
                }
            });

        txtDurartion.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent evt) {
                    txtDurartionKeyTyped(evt);
                }
            });

        jLabel9.setText("Email ID");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtContactNo, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCompanyName)
                    .addComponent(txtAddress)
                    .addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(txtDurartion, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCompanyName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtContactNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtDurartion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
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

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 605, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(104, 104, 104))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 461, GroupLayout.PREFERRED_SIZE))))
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
                JOptionPane.showMessageDialog( this, "Please retrieve scholar no.","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtCompanyName.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Please enter company name","Error", JOptionPane.ERROR_MESSAGE);
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
            if (txtDurartion.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Please enter durartion","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Statement stmt;
            stmt= con.createStatement();
            String sql1="Select ScholarNo,Companyname from StudentTraining where ScholarNo= '" + txtScholarNo.getText() + "' and Companyname='" + txtCompanyName.getText() + "'";
            rs=stmt.executeQuery(sql1);
            if(rs.next()){
                JOptionPane.showMessageDialog( this, "Record already exists","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String sql= "insert into StudentTraining(ScholarNo,Companyname,Address,ContactNo,Email,TrainingDuration)values('"+ txtScholarNo.getText() + "','" + txtCompanyName.getText() + "','" + txtAddress.getText() + "','" + txtContactNo.getText() + "','" + txtEmail.getText() + "'," + txtDurartion.getText() + ") ";
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
            String sql= "update StudentTraining set ScholarNo='"+ txtScholarNo.getText() + "',CompanyName='" + txtCompanyName.getText() + "',Address='" + txtAddress.getText() + "',ContactNo='" + txtContactNo.getText() + "',Email='" + txtEmail.getText() + "',TrainingDuration=" + txtDurartion.getText() + " where ID=" + txtID.getText() + "";
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
                String sql= "delete from StudentTraining where ID = " + txtID.getText() + "";
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
        StudentTrainingRecord frm= new StudentTrainingRecord();
        frm.setVisible(true);
    }

    private void jTable1MouseClicked(MouseEvent evt) {
        try{
            con=Connect.ConnectDB();
            int row= jTable1.getSelectedRow();
            String add= jTable1.getModel().getValueAt(row,0).toString();
            txtScholarNo.setText(add);
            String add1= jTable1.getModel().getValueAt(row,1).toString();
            txtEnrollmentNo.setText(add1);
            String add2= jTable1.getModel().getValueAt(row,2).toString();
            txtStudentName.setText(add2);
            String add3= jTable1.getModel().getValueAt(row,3).toString();
            txtSession.setText(add3);
            String add4= jTable1.getModel().getValueAt(row,4).toString();
            txtCourse.setText(add4);
            String add5= jTable1.getModel().getValueAt(row,5).toString();
            txtBranch.setText(add5);
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

    private void txtDurartionKeyTyped(KeyEvent evt) {
        char c=evt.getKeyChar();
        if (!(Character.isDigit(c)|| (c== KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))){
            getToolkit().beep();
            evt.consume();
        }    
    }


    public static void main(String args[]) {
        new StudentTraining().setVisible(true);
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
            java.util.logging.Logger.getLogger(StudentTraining.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentTraining.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentTraining.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentTraining.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new StudentTraining().setVisible(true);
                }
            });
            */
    }
}
