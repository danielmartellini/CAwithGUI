/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.gui.pages;

import ie.gui.connector.Connector;
import java.sql.*;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author danie
 */
public class PageViewUsers extends javax.swing.JInternalFrame {

    /**
     * Creates new form PageViewUsers
     */
    Connection connection = null;
    PreparedStatement sqlStatement = null;
    ResultSet resultSet = null;

    public PageViewUsers() {
        initComponents();
       
        connection = Connector.connector();
    }

    private void setFieldsFromTable() {
        int set = tblUsers.getSelectedRow();
        txtUsername.setText(tblUsers.getModel().getValueAt(set, 1).toString());
        txtPassword.setText(tblUsers.getModel().getValueAt(set, 2).toString());

        if ("1".equals(tblUsers.getModel().getValueAt(set, 3).toString())) {
            cboAdmin.setSelectedItem("Admin");
        } else {
            cboAdmin.setSelectedItem("User");
            System.out.println(tblUsers.getModel().getValueAt(set, 3).toString());
        }

    }

    private void fetchAndRefresh() {
        String sql = "SELECT * FROM user";

        try {
            sqlStatement = connection.prepareStatement(sql);

            resultSet = sqlStatement.executeQuery();

            tblUsers.setModel(DbUtils.resultSetToTableModel(resultSet));

            txtUsername.setText(null);
            txtPassword.setText(null);

            btnFetch.setText("Refresh database");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something went wrong in our database " + e);
        }

    }

    private void quickSearch() {
        String sql = "SELECT * FROM user WHERE username LIKE ?";

        try {
            sqlStatement = connection.prepareStatement(sql);
            sqlStatement.setString(1, txtQuickSearch.getText() + "%");
            resultSet = sqlStatement.executeQuery();

            tblUsers.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something went wrong in our database " + e);
        }

    }

    private void delete() {
        int confirm = JOptionPane.showConfirmDialog(null, "ARE YOU SURE YOU WANT TO DELETE THE SELECTED USER?", "WARNING", JOptionPane.YES_NO_OPTION);
        int set = tblUsers.getSelectedRow();
        if (confirm == JOptionPane.YES_OPTION) {
            String sql = "DELETE FROM user WHERE id=?";
            try {

                sqlStatement = connection.prepareStatement(sql);
                sqlStatement.setString(1, tblUsers.getModel().getValueAt(set, 0).toString());
                int deleted = sqlStatement.executeUpdate();
                if (deleted > 0) {

                    JOptionPane.showMessageDialog(null, "User deleted from database");

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Couldn't connect to database properly");

            }
        }
    }

    private void update() {
        String sql = "UPDATE user SET username=?,pass=?,isAdmin=? WHERE id=?";
        String sqlUsernameQuery = "SELECT * FROM user WHERE username=?";
        int set = tblUsers.getSelectedRow();

        try {

            sqlStatement = connection.prepareStatement(sqlUsernameQuery);
            sqlStatement.setString(1, txtUsername.getText());
            resultSet = sqlStatement.executeQuery();

            if (!tblUsers.getModel().getValueAt(set, 1).toString().equals(txtUsername.getText()) && resultSet.next()) {
                //user will reach this if username is already taken
                System.out.println(tblUsers.getModel().getValueAt(set, 1).toString() + "original");
                System.out.println(txtUsername.getText() + "read");
                JOptionPane.showMessageDialog(null, "This username is already registered in our database");
            } else if ("".equals(txtPassword.getText()) || "".equals(txtUsername.getText())) {

                JOptionPane.showMessageDialog(null, "Username and Password fields can't be left blank");
            } else {

                sqlStatement = connection.prepareStatement(sql);
                sqlStatement.setString(1, txtUsername.getText());
                sqlStatement.setString(2, txtPassword.getText());
                if ("Admin".equals(cboAdmin.getSelectedItem().toString())) {
                    sqlStatement.setString(3, "1");
                } else {
                    sqlStatement.setString(3, "0");
                }
                sqlStatement.setString(4, tblUsers.getModel().getValueAt(set, 0).toString());
                sqlStatement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Account updated "
                        + "Please click on refresh database to see modifications");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsers = new javax.swing.JTable();
        lblSearch = new javax.swing.JLabel();
        txtQuickSearch = new javax.swing.JTextField();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        cboAdmin = new javax.swing.JComboBox<>();
        lblAdmin = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnFetch = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("View users");

        tblUsers = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUsers.getTableHeader().setReorderingAllowed(false);
        tblUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsers);

        lblSearch.setText("Search by username:");

        txtQuickSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuickSearchActionPerformed(evt);
            }
        });
        txtQuickSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQuickSearchKeyReleased(evt);
            }
        });

        lblUsername.setText("Username:");

        lblPassword.setText("Password:");

        cboAdmin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "User" }));

        lblAdmin.setText("Admin:");

        btnUpdate.setText("Update User");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete User");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnFetch.setText("Search for users on database");
        btnFetch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFetchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPassword)
                            .addComponent(lblUsername))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsername)
                            .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addGap(40, 40, 40)
                        .addComponent(lblAdmin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnFetch)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtQuickSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(btnFetch)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSearch)
                    .addComponent(txtQuickSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAdmin)
                    .addComponent(btnUpdate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPassword)
                    .addComponent(btnDelete)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        setBounds(0, 0, 540, 410);
    }// </editor-fold>//GEN-END:initComponents

    private void txtQuickSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuickSearchActionPerformed
        quickSearch();
    }//GEN-LAST:event_txtQuickSearchActionPerformed

    private void txtQuickSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuickSearchKeyReleased
        quickSearch();
    }//GEN-LAST:event_txtQuickSearchKeyReleased

    private void tblUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsersMouseClicked
        setFieldsFromTable();
    }//GEN-LAST:event_tblUsersMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        update();
        fetchAndRefresh();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        delete();
        fetchAndRefresh();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnFetchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFetchActionPerformed
        fetchAndRefresh();

    }//GEN-LAST:event_btnFetchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFetch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboAdmin;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAdmin;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTable tblUsers;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtQuickSearch;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
