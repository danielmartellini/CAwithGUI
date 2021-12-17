/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.gui.pages;

import ie.gui.connector.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author danie
 */
public class PageMain extends javax.swing.JFrame {

    /**
     * Creates new form pageMain
     */
    Connection connection = null;
    PreparedStatement sqlStatement = null;
    ResultSet resultSet = null;

    public PageMain() {
        initComponents();
        connection = Connector.connector();

    }
    private void editMyProfilePasswordTest(){
         String passwordTest = JOptionPane.showInputDialog("Please confirm your password to be able to do that:");
        String sql = "SELECT * FROM user where username=? and pass=? ";
        try {
            sqlStatement = connection.prepareStatement(sql);
            sqlStatement.setString(1, menuMyProfile.getText());
            sqlStatement.setString(2, passwordTest);
            System.out.println(passwordTest);
            //Result set returns info from a row, 4 in this case is where we verify is it's and admin or not
            resultSet = sqlStatement.executeQuery();
            if (resultSet.next()) {
                PageEditMyProfile editProfile = new PageEditMyProfile();
                editProfile.setVisible(true);
                desktopArea.add(editProfile);
                PageEditMyProfile.txtIdField.setText(resultSet.getString(1));
                PageEditMyProfile.txtUsername.setText(resultSet.getString(2));
                PageEditMyProfile.txtPassword.setText(resultSet.getString(3));
                
                //i only output the message if the user tries a password that is wrong;
            } else if (passwordTest!=null){
                JOptionPane.showMessageDialog(null, "Credentials do NOT Match");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something went wrong in our database");
            System.out.println(e);
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

        desktopArea = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        menuMyProfile = new javax.swing.JMenu();
        menuItemEditMyProfile = new javax.swing.JMenuItem();
        menuCalculator = new javax.swing.JMenu();
        menuItemCalculatorTwoVariables = new javax.swing.JMenuItem();
        menuItemCalculatorThreeByThree = new javax.swing.JMenuItem();
        menuAdminFunctions = new javax.swing.JMenu();
        menuItemViewUsers = new javax.swing.JMenuItem();
        menuItemCreateUser = new javax.swing.JMenuItem();
        menuLogout = new javax.swing.JMenu();
        menuItemChangeUser = new javax.swing.JMenuItem();
        menuItemExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        setResizable(false);

        javax.swing.GroupLayout desktopAreaLayout = new javax.swing.GroupLayout(desktopArea);
        desktopArea.setLayout(desktopAreaLayout);
        desktopAreaLayout.setHorizontalGroup(
            desktopAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );
        desktopAreaLayout.setVerticalGroup(
            desktopAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 374, Short.MAX_VALUE)
        );

        menuMyProfile.setText("My Profile");

        menuItemEditMyProfile.setText("Edit my account");
        menuItemEditMyProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEditMyProfileActionPerformed(evt);
            }
        });
        menuMyProfile.add(menuItemEditMyProfile);

        menuBar.add(menuMyProfile);

        menuCalculator.setText("Calculator");

        menuItemCalculatorTwoVariables.setText("2 variables system");
        menuItemCalculatorTwoVariables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCalculatorTwoVariablesActionPerformed(evt);
            }
        });
        menuCalculator.add(menuItemCalculatorTwoVariables);

        menuItemCalculatorThreeByThree.setText("3 variables system");
        menuItemCalculatorThreeByThree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCalculatorThreeByThreeActionPerformed(evt);
            }
        });
        menuCalculator.add(menuItemCalculatorThreeByThree);

        menuBar.add(menuCalculator);

        menuAdminFunctions.setText("Admin Functions");
        menuAdminFunctions.setEnabled(false);

        menuItemViewUsers.setText("View Users");
        menuItemViewUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemViewUsersActionPerformed(evt);
            }
        });
        menuAdminFunctions.add(menuItemViewUsers);

        menuItemCreateUser.setText("Create User");
        menuItemCreateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCreateUserActionPerformed(evt);
            }
        });
        menuAdminFunctions.add(menuItemCreateUser);

        menuBar.add(menuAdminFunctions);

        menuLogout.setText("Logout");

        menuItemChangeUser.setText("Change user profile");
        menuItemChangeUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemChangeUserActionPerformed(evt);
            }
        });
        menuLogout.add(menuItemChangeUser);

        menuItemExit.setText("Exit");
        menuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemExitActionPerformed(evt);
            }
        });
        menuLogout.add(menuItemExit);

        menuBar.add(menuLogout);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktopArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(desktopArea)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(660, 440));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemChangeUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemChangeUserActionPerformed
        int logout = JOptionPane.showConfirmDialog(null, "Are you sure you want to go back to the Login page?", "WARNING", JOptionPane.YES_NO_OPTION);
        if (logout == JOptionPane.YES_OPTION) {
            PageLogin pageLogin;
            pageLogin = new PageLogin();
            pageLogin.setVisible(true);
            this.dispose();

        }

    }//GEN-LAST:event_menuItemChangeUserActionPerformed

    private void menuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemExitActionPerformed
        int exit = JOptionPane.showConfirmDialog(null, "Are you sure you want to close the program?", "WARNING", JOptionPane.YES_NO_OPTION);
        if (exit == JOptionPane.YES_OPTION) {
            System.exit(0);
    }//GEN-LAST:event_menuItemExitActionPerformed
    }
    private void menuItemCreateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCreateUserActionPerformed
        //opens a form to add a user, only if u are an admin you will get this option
        PageNewUser addUser = new PageNewUser();
        addUser.setVisible(true);
        PageNewUser.cboAdmin.setEnabled(true);

    }//GEN-LAST:event_menuItemCreateUserActionPerformed

    private void menuItemEditMyProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEditMyProfileActionPerformed
       editMyProfilePasswordTest();
    }//GEN-LAST:event_menuItemEditMyProfileActionPerformed

    private void menuItemViewUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemViewUsersActionPerformed
        PageViewUsers viewUsers = new PageViewUsers();
        viewUsers.setVisible(true);
        desktopArea.add(viewUsers);
    }//GEN-LAST:event_menuItemViewUsersActionPerformed

    private void menuItemCalculatorThreeByThreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCalculatorThreeByThreeActionPerformed
        PageCalculatorThreeVariables calculatorThreebyThree = new PageCalculatorThreeVariables();
        calculatorThreebyThree.setVisible(true);
        desktopArea.add(calculatorThreebyThree);

    }//GEN-LAST:event_menuItemCalculatorThreeByThreeActionPerformed

    private void menuItemCalculatorTwoVariablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCalculatorTwoVariablesActionPerformed
        PageCalculatorTwoVariables calculatorTwoByTwo = new PageCalculatorTwoVariables();
        calculatorTwoByTwo.setVisible(true);
        desktopArea.add(calculatorTwoByTwo);
    }//GEN-LAST:event_menuItemCalculatorTwoVariablesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PageMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PageMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PageMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PageMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PageMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane desktopArea;
    public static javax.swing.JMenu menuAdminFunctions;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuCalculator;
    private javax.swing.JMenuItem menuItemCalculatorThreeByThree;
    private javax.swing.JMenuItem menuItemCalculatorTwoVariables;
    private javax.swing.JMenuItem menuItemChangeUser;
    private javax.swing.JMenuItem menuItemCreateUser;
    private javax.swing.JMenuItem menuItemEditMyProfile;
    private javax.swing.JMenuItem menuItemExit;
    public javax.swing.JMenuItem menuItemViewUsers;
    private javax.swing.JMenu menuLogout;
    public static javax.swing.JMenu menuMyProfile;
    // End of variables declaration//GEN-END:variables
}
