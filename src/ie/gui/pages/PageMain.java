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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        menuBar2 = new java.awt.MenuBar();
        menu3 = new java.awt.Menu();
        menu4 = new java.awt.Menu();
        menuBar3 = new java.awt.MenuBar();
        menu5 = new java.awt.Menu();
        menu6 = new java.awt.Menu();
        desktopArea = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuMyProfile = new javax.swing.JMenu();
        menuItemEditMyProfile = new javax.swing.JMenuItem();
        menuAdminFunctions = new javax.swing.JMenu();
        menuItemViewUsers = new javax.swing.JMenuItem();
        menuItemCreateUser = new javax.swing.JMenuItem();
        menuLogout = new javax.swing.JMenu();
        menuItemChangeUser = new javax.swing.JMenuItem();
        menuItemExit = new javax.swing.JMenuItem();

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        menu3.setLabel("File");
        menuBar2.add(menu3);

        menu4.setLabel("Edit");
        menuBar2.add(menu4);

        menu5.setLabel("File");
        menuBar3.add(menu5);

        menu6.setLabel("Edit");
        menuBar3.add(menu6);

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
            .addGap(0, 410, Short.MAX_VALUE)
        );

        menuMyProfile.setText("My Profile");

        menuItemEditMyProfile.setText("Edit my account");
        menuItemEditMyProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEditMyProfileActionPerformed(evt);
            }
        });
        menuMyProfile.add(menuItemEditMyProfile);

        jMenuBar1.add(menuMyProfile);

        menuAdminFunctions.setText("Admin Functions");
        menuAdminFunctions.setEnabled(false);

        menuItemViewUsers.setText("View Users");
        menuAdminFunctions.add(menuItemViewUsers);

        menuItemCreateUser.setText("Create User");
        menuItemCreateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCreateUserActionPerformed(evt);
            }
        });
        menuAdminFunctions.add(menuItemCreateUser);

        jMenuBar1.add(menuAdminFunctions);

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

        jMenuBar1.add(menuLogout);

        setJMenuBar(jMenuBar1);

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
        int logout = JOptionPane.showConfirmDialog(null, "Are you sure you want to go back to the Login page?","WARNING",JOptionPane.YES_NO_OPTION);
       if (logout == JOptionPane.YES_OPTION){               
                PageLogin pageLogin ;
                pageLogin = new PageLogin();
                pageLogin.setVisible(true);
                this.dispose();
            
      }
        
    }//GEN-LAST:event_menuItemChangeUserActionPerformed

    private void menuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemExitActionPerformed
        int exit = JOptionPane.showConfirmDialog(null, "Are you sure you want to close the program?","WARNING",JOptionPane.YES_NO_OPTION);
        if (exit == JOptionPane.YES_OPTION){
            System.exit(0);
    }//GEN-LAST:event_menuItemExitActionPerformed
    }
    private void menuItemCreateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCreateUserActionPerformed
        //opens a form to add a user, only if u are an admin you will get this option
        PageCreateUser addUser = new PageCreateUser();
        addUser.setVisible(true);
        desktopArea.add(addUser);
    }//GEN-LAST:event_menuItemCreateUserActionPerformed

    private void menuItemEditMyProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEditMyProfileActionPerformed
        String passwordTest = JOptionPane.showInputDialog("Please confirm your password to be able to do that:");
        String sql = "SELECT * FROM user where username=? and pass=? ";
        try {
            sqlStatement = connection.prepareStatement(sql);
            sqlStatement.setString(1, menuMyProfile.getText());
            sqlStatement.setString(2, passwordTest);
            System.out.println(passwordTest);
            //Result set returns info from a row, 4 in this case is where we verify is it's and admin or not
            resultSet = sqlStatement.executeQuery();
            if (resultSet.next()){
                PageEditMyProfile editProfile = new  PageEditMyProfile();
                editProfile.setVisible(true);
                desktopArea.add(editProfile);
                PageEditMyProfile.txtIdField.setText(resultSet.getString(1));                
                PageEditMyProfile.txtUsername.setText(resultSet.getString(2));
                PageEditMyProfile.txtPassword.setText(resultSet.getString(3));
            }
            else{
                JOptionPane.showMessageDialog(null, "Credentials do NOT Match");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Something went wrong in our database");
            System.out.println(e);
        }
    }//GEN-LAST:event_menuItemEditMyProfileActionPerformed
    
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
    private javax.swing.JDesktopPane desktopArea;
    private javax.swing.JMenuBar jMenuBar1;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.Menu menu3;
    private java.awt.Menu menu4;
    private java.awt.Menu menu5;
    private java.awt.Menu menu6;
    public static javax.swing.JMenu menuAdminFunctions;
    private java.awt.MenuBar menuBar1;
    private java.awt.MenuBar menuBar2;
    private java.awt.MenuBar menuBar3;
    private javax.swing.JMenuItem menuItemChangeUser;
    private javax.swing.JMenuItem menuItemCreateUser;
    private javax.swing.JMenuItem menuItemEditMyProfile;
    private javax.swing.JMenuItem menuItemExit;
    private javax.swing.JMenuItem menuItemViewUsers;
    private javax.swing.JMenu menuLogout;
    public static javax.swing.JMenu menuMyProfile;
    // End of variables declaration//GEN-END:variables
}
