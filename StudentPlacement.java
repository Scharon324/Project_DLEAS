import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.text.*;
import java.awt.event.*;
import javax.swing.text.*;
import javax.swing.table.*;
import net.proteanit.sql.DbUtils;

public class StudentPlacement extends JFrame {
    
    public JButton btnDelete;
    private JButton btnGetData;
    private JButton btnNew;
    public JButton btnSave;
    public JButton btnUpdate;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel29;
    private JLabel jLabel3;
    public JLabel jLabel30;
    private JLabel jLabel31;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel8;
    public JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTable jTable1;
    private JTable jTable2;
    public JTextField txtBranch;
    public JTextField txtCompanyID;
    public JTextField txtCompanyName;
    public JTextField txtCourse;
    public JTextField txtEnrollmentNo;
    public JTextField txtID;
    public JTextField txtPackage;
    public JFormattedTextField txtPlacementDate;
    public JTextField txtScholarNo;
    public JTextField txtSession;
    public JTextField txtStudentName;
    
    Connection con=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    /**
     * Creates new form StudentPlacement
     */
    public StudentPlacement() {
        initComponents();
        setLocationRelativeTo(null);
        Get_data();
        txtCompanyID.setVisible(false);
        txtID.setVisible(false);
        GetRecord();
    }

    private void Reset()
    {
        txtBranch.setText("");
        txtCompanyName.setText("");
        txtPlacementDate.setText("");
        txtPackage.setText("");
        txtEnrollmentNo.setText("");
        txtStudentName.setText("");
        txtSession.setText("");
        txtScholarNo.setText("");
        txtCourse.setText("");
        btnSave.setEnabled(true);
        btnDelete.setEnabled(false);
        btnUpdate.setEnabled(false);

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

    private void GetRecord(){
        String sql="select CompanyID as 'Company ID', CompanyName as 'Company Name' from Company order by CompanyName";
        try{
            con=Connect.ConnectDB();
            pst=con.prepareStatement(sql);
            rs= pst.executeQuery();
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);

        }
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
        jLabel8 = new JLabel();
        txtCompanyName = new JTextField();
        txtPackage = new JTextField();
        jLabel4 = new JLabel();
        txtPlacementDate = new JFormattedTextField();
        jLabel30 = new JLabel();
        jPanel2 = new JPanel();
        btnNew = new JButton();
        btnSave = new JButton();
        btnUpdate = new JButton();
        btnDelete = new JButton();
        btnGetData = new JButton();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        jScrollPane2 = new JScrollPane();
        jTable2 = new JTable();
        txtCompanyID = new JTextField();
        txtID = new JTextField();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Students Placement");
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

        jPanel1.setBorder(BorderFactory.createTitledBorder("Company and Placement Info"));

        jLabel3.setText("Company Name");

        jLabel8.setText("Package");

        txtCompanyName.setEditable(false);

        txtPackage.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent evt) {
                    txtPackageKeyTyped(evt);
                }
            });

        jLabel4.setText("Placement Date");

        txtPlacementDate.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("dd/MM/yyyy"))));

        jLabel30.setText("(DD/MM/YYYY)");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(jLabel4))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtPlacementDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel30))
                    .addComponent(txtPackage, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCompanyName, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
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
                    .addComponent(jLabel8)
                    .addComponent(txtPackage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPlacementDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel30))
                    .addComponent(jLabel4))
                .addContainerGap())
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

        jTable2.setModel(new DefaultTableModel(
                new Object [][] {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String [] {
                    "Title 1", "Title 2", "Title 3", "Title 4"
                }
            ));
        jTable2.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    jTable2MouseClicked(evt);
                }
            });
        jScrollPane2.setViewportView(jTable2);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtID, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                            .addComponent(txtCompanyID))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 510, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(txtCompanyID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }

    private void txtPackageKeyTyped(KeyEvent evt) {

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
                JOptionPane.showMessageDialog( this, "Please retrieve company name","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (txtPackage.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Please enter package","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txtPlacementDate.getText().equals("")) {
                JOptionPane.showMessageDialog( this, "Please enter placement date","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Statement stmt;
            stmt= con.createStatement();
            String sql1="Select ScholarNo,CompanyID from StudentPlacement where ScholarNo= '" + txtScholarNo.getText() + "' and CompanyID=" + txtCompanyID.getText() + "";
            rs=stmt.executeQuery(sql1);
            if(rs.next()){
                JOptionPane.showMessageDialog( this, "Record already exists","Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String sql= "insert into StudentPlacement(ScholarNo,CompanyID,Package,PlacementDate)values('"+ txtScholarNo.getText() + "'," + txtCompanyID.getText() + "," + txtPackage.getText() + ",'" + txtPlacementDate.getText() + "')";
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
            String sql= "update StudentPlacement set ScholarNo='"+ txtScholarNo.getText() + "',CompanyID=" + txtCompanyID.getText() + ",Package=" + txtPackage.getText() + ",PlacementDate='" + txtPlacementDate.getText() + "' where ID=" + txtID.getText() + "";
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
                String sql= "delete from StudentPlacement where ID = " + txtID.getText() + "";
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
        StudentsPlacementRecord frm= new StudentsPlacementRecord();
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

    private void jTable2MouseClicked(MouseEvent evt) {
        try{
            con=Connect.ConnectDB();
            int row= jTable2.getSelectedRow();
            String add= jTable2.getModel().getValueAt(row, 0).toString();
            txtCompanyID.setText(add);
            String add1= jTable2.getModel().getValueAt(row, 1).toString();
            txtCompanyName.setText(add1);

        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,ex);
        }
    }


    public static void main(String args[]) {
        new StudentPlacement().setVisible(true);
    }
}
