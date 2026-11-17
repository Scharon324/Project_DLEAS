import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.*;
import net.proteanit.sql.DbUtils;

public class StudentsPlacementRecord extends JFrame {
    private JButton btnReset;
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
    public StudentsPlacementRecord() {
        initComponents();
        setLocationRelativeTo(null);
        Get_data();
    }

        public static void main(String args[]) {
        new StudentTrainingRecord().setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel6 = new JPanel();
        txtStudentName = new JTextField();
        btnReset = new JButton();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Students Training Record");
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

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 1151, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReset)
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
                        .addComponent(btnReset)
                        .addGap(28, 28, 28)))
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE))
        );

        pack();
    }

    private void Get_data()
    {
        con=Connect.ConnectDB();
        String sql= "select ID,Student.ScholarNo as 'Scholar No',EnrollmentNo as 'Enrollment No',StudentName as 'Student Name',Session,Coursename as 'Course',Branch,Company.CompanyID as 'Company ID',Companyname as 'Company',Package,PlacementDate as 'Placement Date' from Company,Student,StudentPlacement,Course where Company.CompanyID=StudentPlacement.CompanyID and StudentPlacement.ScholarNo=Student.ScholarNo and Student.CourseID = Course.CourseID order by StudentName";
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
        String sql= "select ID,Student.ScholarNo as 'Scholar No',EnrollmentNo as 'Enrollment No',StudentName as 'Student Name',Session,Coursename as 'Course',Branch,Company.CompanyID as 'Company ID',Companyname as 'Company',Package,PlacementDate as 'Placement Date' from Company,Student,StudentPlacement,Course where Company.CompanyID=StudentPlacement.CompanyID and StudentPlacement.ScholarNo=Student.ScholarNo and Student.CourseID = Course.CourseID and CourseName like '" + txtStudentName.getText() + "%' order by StudentName";
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
        try{
            con=Connect.ConnectDB();
            this.hide();
            StudentPlacement frm= new StudentPlacement();
            frm.setVisible(true);
            int row= jTable1.getSelectedRow();
            String add= jTable1.getModel().getValueAt(row,0).toString();
            frm.txtID.setText(add);
            String add1= jTable1.getModel().getValueAt(row,1).toString();
            frm.txtScholarNo.setText(add1);
            String add2= jTable1.getModel().getValueAt(row,2).toString();
            frm.txtEnrollmentNo.setText(add2);
            String add3= jTable1.getModel().getValueAt(row,3).toString();
            frm.txtStudentName.setText(add3);
            String add4= jTable1.getModel().getValueAt(row,4).toString();
            frm.txtSession.setText(add4);
            String add5= jTable1.getModel().getValueAt(row,5).toString();
            frm.txtCourse.setText(add5);
            String add6= jTable1.getModel().getValueAt(row,6).toString();
            frm.txtBranch.setText(add6);
            String add7= jTable1.getModel().getValueAt(row,7).toString();
            frm.txtCompanyID.setText(add7);
            String add8= jTable1.getModel().getValueAt(row,8).toString();
            frm.txtCompanyName.setText(add8);
            String add9= jTable1.getModel().getValueAt(row,9).toString();
            frm.txtPackage.setText(add9);
            String add10= jTable1.getModel().getValueAt(row,10).toString();
            frm.txtPlacementDate.setText(add10);
            frm.btnUpdate.setEnabled(true);
            frm.btnDelete.setEnabled(true);
            frm.btnSave.setEnabled(false);

        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex);
        }
    }

    private void formWindowClosing(WindowEvent evt) {
        this.hide();
        StudentPlacement frm = new StudentPlacement();
        frm.setVisible(true);
    }
}
