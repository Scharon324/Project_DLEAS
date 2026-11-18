import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.table.*;
import net.proteanit.sql.DbUtils;

public class StudentRecord extends JFrame {
    private JButton btnReset;
    private JComboBox cmbBranch;
    private JComboBox cmbCourse;
    private JComboBox cmbSession;
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTabbedPane jTabbedPane1;
    private JTable jTable1;
    private JTable jTable2;
    private JTextField txtStudentName;

    Connection con=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    /**
     * Creates new form StudentRecord
     */
    public StudentRecord() {
        initComponents();
        setLocationRelativeTo(null);
        Get_data();
        fillCourse();
        cmbCourse.setSelectedIndex(-1);
    }

    private void fillCourse()
    {
        try{

            con=Connect.ConnectDB();
            String sql= "select distinct Coursename from Student,Course where Student.CourseID=Course.CourseID order by coursename ";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                String add=rs.getString("Coursename");
                cmbCourse.addItem(add);

            }
        }catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(this,ex); 
        }
    }

    private void Get_data()
    {
        con=Connect.ConnectDB();
        String sql= " select ScholarNo as 'Scholar No.',EnrollmentNo as 'Enrollment No.',StudentName as 'Student Name',DOB,Session,Fathername as 'Fathers Name',MotherName as 'Mother Name',Address,ContactNo as 'Contact No.',Email as 'Email ID',Course.CourseID as 'Course ID',Coursename as 'Course', Branch from Course,Student where Course.CourseID=Student.CourseID  order by StudentName ";   
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

        jPanel1 = new JPanel();
        jTabbedPane1 = new JTabbedPane();
        jPanel2 = new JPanel();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        jPanel6 = new JPanel();
        txtStudentName = new JTextField();
        btnReset = new JButton();
        jPanel3 = new JPanel();
        jPanel7 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        cmbCourse = new JComboBox();
        cmbBranch = new JComboBox();
        jLabel3 = new JLabel();
        cmbSession = new JComboBox();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jScrollPane2 = new JScrollPane();
        jTable2 = new JTable();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Students Record");
        setResizable(false);
        addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent evt) {
                    formWindowClosing(evt);
                }
            });

        jTable1.setBorder(BorderFactory.createTitledBorder(""));
        jTable1.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    jTable1MouseClicked(evt);
                }
            });
        jScrollPane1.setViewportView(jTable1);

        jPanel6.setBorder(BorderFactory.createTitledBorder("Search Student"));

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

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 1053, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnReset)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("By Student Name", jPanel2);

        jPanel7.setBorder(BorderFactory.createTitledBorder(""));

        jLabel1.setText("Course");

        jLabel2.setText("Branch");

        cmbCourse.addPopupMenuListener(new PopupMenuListener() {
                public void popupMenuWillBecomeVisible(PopupMenuEvent evt) {
                }

                public void popupMenuWillBecomeInvisible(PopupMenuEvent evt) {
                    cmbCoursePopupMenuWillBecomeInvisible(evt);
                }

                public void popupMenuCanceled(PopupMenuEvent evt) {
                }
            });
        cmbCourse.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    cmbCourseActionPerformed(evt);
                }
            });

        cmbBranch.setEditable(true);
        cmbBranch.setEnabled(false);
        cmbBranch.addPopupMenuListener(new PopupMenuListener() {
                public void popupMenuWillBecomeVisible(PopupMenuEvent evt) {
                }

                public void popupMenuWillBecomeInvisible(PopupMenuEvent evt) {
                    cmbBranchPopupMenuWillBecomeInvisible(evt);
                }

                public void popupMenuCanceled(PopupMenuEvent evt) {
                }
            });
        cmbBranch.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    cmbBranchActionPerformed(evt);
                }
            });

        jLabel3.setText("Session");

        cmbSession.setEditable(true);
        cmbSession.setEnabled(false);

        GroupLayout jPanel7Layout = new GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cmbCourse, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(cmbBranch, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(cmbSession, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(cmbCourse, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbBranch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cmbSession, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jButton1.setText("Get Data");
        jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    jButton1ActionPerformed(evt);
                }
            });

        jButton2.setText("Reset");
        jButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    jButton2ActionPerformed(evt);
                }
            });

        jTable2.setBorder(BorderFactory.createTitledBorder(""));
        jTable2.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    jTable2MouseClicked(evt);
                }
            });
        jScrollPane2.setViewportView(jTable2);

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(343, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("By Course and Branch", jPanel3);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, GroupLayout.PREFERRED_SIZE, 1068, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, GroupLayout.PREFERRED_SIZE, 644, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }

    private void formWindowClosing(WindowEvent evt) {
        this.hide();
        Student frm= new Student();
        frm.setVisible(true);
    }

    private void txtStudentNameActionPerformed(ActionEvent evt) {
        con=Connect.ConnectDB();
        String sql= " select ScholarNo as 'Scholar No.',EnrollmentNo as 'Enrollment No.',StudentName as 'Student Name',DOB,Session,Fathername as 'Fathers Name',MotherName as 'Mother Name',Address,ContactNo as 'Contact No',Email as 'Email ID',Course.CourseID as 'Course ID',Coursename as 'Course', Branch from Course,Student where Course.CourseID=Student.CourseID and StudentName like '" + txtStudentName.getText() + "%' order by StudentName ";   
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
    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        cmbBranch.setSelectedIndex(-1);
        cmbCourse.setSelectedIndex(-1);
        cmbSession.setSelectedIndex(-1);
        cmbBranch.setEnabled(false);
        cmbSession.setEnabled(false);
        DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
        dtm.setNumRows(0); 

    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        con=Connect.ConnectDB();
        String sql= "select ScholarNo as 'Scholar No',EnrollmentNo as 'Enrollment No',StudentName as 'Student Name',DOB,Session,Fathername as 'Father Name',MotherName as 'Mother Name',Address,ContactNo as 'Contact No',Email as 'Email ID',Course.CourseID as 'Course ID',Coursename as 'Course', Branch from Course,Student where Course.CourseID=Student.CourseID and Coursename='" + cmbCourse.getSelectedItem()+ "' and Branch= '" + cmbBranch.getSelectedItem() + "' and Session='" + cmbSession.getSelectedItem()+ "'order by StudentName";    
        try{
            pst=con.prepareStatement(sql);
            rs= pst.executeQuery();
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void jTable1MouseClicked(MouseEvent evt) {
        try{
            con=Connect.ConnectDB();
            this.hide();
            Student frm= new Student();
            frm.setVisible(true);
            int row= jTable1.getSelectedRow();
            String add= jTable1.getModel().getValueAt(row,0).toString();
            frm.txtScholarNo.setText(add);
            String add1= jTable1.getModel().getValueAt(row,1).toString();
            frm.txtEnrollmentNo.setText(add1);
            String add2= jTable1.getModel().getValueAt(row,2).toString();
            frm.txtStudentName.setText(add2);
            String add3= jTable1.getModel().getValueAt(row,3).toString();
            frm.txtDOB.setText(add3);
            String add4= jTable1.getModel().getValueAt(row,4).toString();
            frm.txtSession.setText(add4);
            String add5= jTable1.getModel().getValueAt(row,5).toString();
            frm.txtFatherName.setText(add5);
            String add6= jTable1.getModel().getValueAt(row,6).toString();
            frm.txtMotherName.setText(add6);
            String add7= jTable1.getModel().getValueAt(row,7).toString();
            frm.txtAddress.setText(add7);
            String add8= jTable1.getModel().getValueAt(row,8).toString();
            frm.txtContactNo.setText(add8);
            String add9= jTable1.getModel().getValueAt(row,9).toString();
            frm.txtEmail.setText(add9);
            String add10= jTable1.getModel().getValueAt(row,10).toString();
            frm.txtCourseID.setText(add10); 
            String add11= jTable1.getModel().getValueAt(row,11).toString();
            frm.txtCourse.setText(add11);
            String add12= jTable1.getModel().getValueAt(row,12).toString();
            frm.txtBranch.setText(add12);
            frm.txtDOB.setText(add3);
            frm.btnUpdate.setEnabled(true);
            frm.btnDelete.setEnabled(true);
            frm.btnSave.setEnabled(false);

        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex);
        }
    }

    private void jTable2MouseClicked(MouseEvent evt) {
        try{
            con=Connect.ConnectDB();
            this.hide();
            Student frm= new Student();
            frm.setVisible(true);
            int row= jTable2.getSelectedRow();
            String add= jTable2.getModel().getValueAt(row,0).toString();
            frm.txtScholarNo.setText(add);
            String add1= jTable2.getModel().getValueAt(row,1).toString();
            frm.txtEnrollmentNo.setText(add1);
            String add2= jTable2.getModel().getValueAt(row,2).toString();
            frm.txtStudentName.setText(add2);
            String add3= jTable2.getModel().getValueAt(row,3).toString();
            frm.txtDOB.setText(add3);
            String add4= jTable2.getModel().getValueAt(row,4).toString();
            frm.txtSession.setText(add4);
            String add5= jTable2.getModel().getValueAt(row,5).toString();
            frm.txtFatherName.setText(add5);
            String add6= jTable2.getModel().getValueAt(row,6).toString();
            frm.txtMotherName.setText(add6);
            String add7= jTable2.getModel().getValueAt(row,7).toString();
            frm.txtAddress.setText(add7);
            String add8= jTable2.getModel().getValueAt(row,8).toString();
            frm.txtContactNo.setText(add8);
            String add9= jTable2.getModel().getValueAt(row,9).toString();
            frm.txtEmail.setText(add9);
            String add10= jTable2.getModel().getValueAt(row,10).toString();
            frm.txtCourseID.setText(add10); 
            String add11= jTable2.getModel().getValueAt(row,11).toString();
            frm.txtCourse.setText(add11);
            String add12= jTable2.getModel().getValueAt(row,12).toString();
            frm.txtBranch.setText(add12);
            frm.txtDOB.setText(add3);
            frm.btnUpdate.setEnabled(true);
            frm.btnDelete.setEnabled(true);
            frm.btnSave.setEnabled(false);

        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex);
        }
    }

    private void cmbCoursePopupMenuWillBecomeInvisible(PopupMenuEvent evt) {
        cmbBranch.removeAllItems();
        cmbBranch.setSelectedItem("");
        cmbBranch.setEnabled(true);

        con=Connect.ConnectDB();
        String sql= "select distinct branch from Course,Student where Course.CourseID=Student.CourseID and Coursename= '" + cmbCourse.getSelectedItem() + "' order by branch";
        try{
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next())
            {
                String add=rs.getString("branch");
                cmbBranch.addItem(add);
            }

        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex);
        }
    }

    private void cmbCourseActionPerformed(ActionEvent evt) {
    }

    private void cmbBranchActionPerformed(ActionEvent evt) {
    }

    private void cmbBranchPopupMenuWillBecomeInvisible(PopupMenuEvent evt) {
        cmbSession.removeAllItems();
        cmbSession.setSelectedItem("");
        cmbSession.setEnabled(true);

        con=Connect.ConnectDB();
        String sql= "select distinct Session from Course,Student where Course.CourseID=Student.CourseID and Coursename= '" + cmbCourse.getSelectedItem() + "' and Branch='" + cmbBranch.getSelectedItem() + "' order by session";
        try{
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next())
            {
                String add=rs.getString("Session");
                cmbSession.addItem(add);
            }

        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex);
        }
    }

    public static void main(String args[]) {
        new StudentRecord().setVisible(true);
    }
}
