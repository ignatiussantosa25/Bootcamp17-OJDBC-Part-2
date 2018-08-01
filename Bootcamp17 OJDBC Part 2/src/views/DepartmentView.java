/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.DepartmentController;
import controllers.EmployeeController;
import controllers.LocationController;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Simbok_pc
 */
public class DepartmentView extends javax.swing.JInternalFrame {

    private final DepartmentController departmentController;
    private final EmployeeController employeeController;
    private final LocationController locationController;
    private final ViewProccess viewProccess; 
    private final Connection connection;
    private final String[] header = {"Department ID", "Department Name", "Manager ID", "Location ID"};
    private final String[] categories;
    private List<Object[]> managerTemp;
    private List<Object[]> locationTemp;
    
    /**
     * Creates new form DepartmentView
     */
    public DepartmentView(Connection connection) {
        
        this.connection = connection;
        this.categories = new String[]{"department_id", "department_name", "manager_id", "location_id"};
        initComponents();
        this.departmentController = new DepartmentController(connection);
        this.employeeController = new EmployeeController(connection);
        this.locationController = new LocationController(connection);
        this.viewProccess = new ViewProccess();
        this.managerTemp=this.getDataMng();
        this.locationTemp=this.getDataLoc();
        this.loadSearchComboBox();
        this.loadmanager();
        this.loadlocation();
        this.bindingTable();
        this.reset();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        cmbCategory = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDepartment = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDeptId = new javax.swing.JTextField();
        txtDeptName = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnDrop = new javax.swing.JButton();
        cmbManager = new javax.swing.JComboBox<>();
        cmbLocation = new javax.swing.JComboBox<>();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jInternalFrame2.setVisible(true);

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Departments");

        cmbCategory.setToolTipText("");
        cmbCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoryActionPerformed(evt);
            }
        });

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
        });

        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        tblDepartment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblDepartment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDepartmentMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDepartment);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Department Details"));

        jLabel1.setText("Department ID");

        jLabel2.setText("Department Name");

        jLabel3.setText("Manager ID");

        jLabel4.setText("Location ID");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDrop.setText("Drop");
        btnDrop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDropActionPerformed(evt);
            }
        });

        cmbManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbManagerActionPerformed(evt);
            }
        });

        cmbLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLocationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(35, 35, 35)
                        .addComponent(txtDeptId, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDeptName)
                            .addComponent(cmbManager, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbLocation, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnDrop)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSave))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDeptId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDeptName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(cmbManager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(cmbLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnDrop))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFind)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFind))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
       this.saveOrEdit(txtDeptId.getText(), txtDeptName.getText(), cmbManager.getSelectedItem().toString(), cmbLocation.getSelectedItem().toString(), txtDeptId.isEnabled());
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        this.searchTable(this.viewProccess.getCategory(this.categories, cmbCategory), txtSearch.getText());
    }//GEN-LAST:event_btnFindActionPerformed

    private void tblDepartmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDepartmentMouseClicked
        this.mouseClicked(tblDepartment.getSelectedRow());
    }//GEN-LAST:event_tblDepartmentMouseClicked

    private void btnDropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDropActionPerformed
        this.drop(txtDeptId.getText());
    }//GEN-LAST:event_btnDropActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
       
    }//GEN-LAST:event_txtSearchActionPerformed

    private void cmbCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoryActionPerformed
        this.searchTable(this.viewProccess.getCategory(this.categories, cmbCategory), txtSearch.getText());
    }//GEN-LAST:event_cmbCategoryActionPerformed

    private void cmbManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbManagerActionPerformed
        this.loadmanager();
    }//GEN-LAST:event_cmbManagerActionPerformed

    private void cmbLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLocationActionPerformed
        this.loadlocation();
    }//GEN-LAST:event_cmbLocationActionPerformed

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
         if (this.viewProccess.keyPressed(evt)){
            this.searchTable(this.viewProccess.getCategory(this.categories, cmbCategory), txtSearch.getText());
        }
    }//GEN-LAST:event_txtSearchKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDrop;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbCategory;
    private javax.swing.JComboBox<String> cmbLocation;
    private javax.swing.JComboBox<String> cmbManager;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDepartment;
    private javax.swing.JTextField txtDeptId;
    private javax.swing.JTextField txtDeptName;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    public void bindingTable() {
        this.viewProccess.viewTable(tblDepartment, header,
                this.departmentController.bindingSort(categories[0], "asc"));
    }

    public void searchTable(String category, String data) {
        this.viewProccess.viewTable(tblDepartment, header,
                this.departmentController.find(category, data));
    }

    public void loadmanager() {
        this.viewProccess.loadDetails(cmbManager, employeeController.binding(), 0);
    }
    
    public  void loadlocation(){
        this.viewProccess.loadDetails(cmbLocation, locationController.binding(), 0);
    }
    
    public void loadSearchComboBox() {
        this.viewProccess.loadSearchComboBox(cmbCategory, header);
    }

    public void drop(String departmentId) {
        if (this.viewProccess.dropConfirm(this)) {
            this.viewProccess.dropData(this, this.departmentController.drop(departmentId));
        }
        this.reset();
    }

    public void saveOrEdit(String departmentId, String departmentName, String managerId, String locationId, boolean isSave) {
        boolean flag = false;
        if (isSave) {
            flag = this.departmentController.save(txtDeptId.getText(),txtDeptName.getText(),this.getDataM(),this.getDataL());
        } else {
            flag = this.departmentController.edit(txtDeptId.getText(),txtDeptName.getText(),this.getDataM(),this.getDataL());
        }
        this.viewProccess.saveData(this, flag, isSave);
        this.reset();
    }

    public void reset() {
        txtDeptId.setEnabled(true);
        txtDeptId.setEditable(false);
        txtDeptId.setText(this.departmentController.getAutoId());
        txtDeptName.setText("");
        txtSearch.setText("");
        cmbManager.getSelectedItem();
        cmbLocation.getSelectedItem();
        this.bindingTable();
        btnDrop.setEnabled(false);
    }

    public void mouseClicked(int row){
        txtDeptId.setEnabled(false);
        btnDrop.setEnabled(true);
        txtDeptId.setText(tblDepartment.getValueAt(row, 0).toString());
        txtDeptName.setText(tblDepartment.getValueAt(row, 1).toString());
        cmbManager.setSelectedItem(tblDepartment.getValueAt(row, 2).toString());
        cmbLocation.setSelectedItem(tblDepartment.getValueAt(row, 3).toString());
    }

    
    public List<Object[]> getDataMng(){
        return new EmployeeController(connection).bindingSort("employee_id", "asc");
    }
    
    public List<Object[]> getDataLoc(){
        return new LocationController(connection).bindingSort("location_id", "asc");
    }
    
    private String getDataM(){
        return this.viewProccess.getIdfromComboBox(this.managerTemp, cmbManager.getSelectedIndex());
    }
    private String getDataL(){
        return this.viewProccess.getIdfromComboBox(this.locationTemp, cmbLocation.getSelectedIndex());
    }
}