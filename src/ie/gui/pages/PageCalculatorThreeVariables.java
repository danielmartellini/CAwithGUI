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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author danie
 */
public class PageCalculatorThreeVariables extends javax.swing.JInternalFrame {

    /**
     * Creates new form PageCalculatorThreeVariables
     */
    Connection connection = null;
    PreparedStatement sqlStatement = null;
    ResultSet resultSet = null;

    public PageCalculatorThreeVariables() {
        initComponents();
        connection = Connector.connector();
    }

    private void solveThreeVariables() {
        double a11, a12, a13, constant1;
        double a21, a22, a23, constant2;
        double a31, a32, a33, constant3;

        if ("".equals(txtXone.getText()) || "".equals(txtYone.getText()) || "".equals(txtZone.getText()) || "".equals(txtEqualsone.getText())) {
            JOptionPane.showMessageDialog(null, "It seems that one of your variables on the first equation was left blank");
        } else if ("".equals(txtXtwo.getText()) || "".equals(txtYtwo.getText()) || "".equals(txtZtwo.getText()) || "".equals(txtEqualstwo.getText())) {
            JOptionPane.showMessageDialog(null, "It seems that one of your variables on the second equation was left blank");
        } else if ("".equals(txtXthree.getText()) || "".equals(txtYthree.getText()) || "".equals(txtZthree.getText()) || "".equals(txtEqualsthree.getText())) {
            JOptionPane.showMessageDialog(null, "It seems that one of your variables on the third equation was left blank");
        } else {
            try {
                //parsing int to double
                a11 = Double.parseDouble(txtXone.getText());
                a12 = Double.parseDouble(txtYone.getText());
                a13 = Double.parseDouble(txtZone.getText());
                constant1 = Double.parseDouble(txtEqualsone.getText());

                a21 = Double.parseDouble(txtXtwo.getText());
                a22 = Double.parseDouble(txtYtwo.getText());
                a23 = Double.parseDouble(txtZtwo.getText());
                constant2 = Double.parseDouble(txtEqualstwo.getText());

                a31 = Double.parseDouble(txtXthree.getText());
                a32 = Double.parseDouble(txtYthree.getText());
                a33 = Double.parseDouble(txtZthree.getText());
                constant3 = Double.parseDouble(txtEqualsthree.getText());
                double det = 0;
                double matrice[][] = new double[3][3];

                double invertedMatrice[][] = new double[3][3];
                try {
                    //assigning values to array

                    matrice[0][0] = a11;
                    matrice[0][1] = a12;
                    matrice[0][2] = a13;

                    matrice[1][0] = a21;
                    matrice[1][1] = a22;
                    matrice[1][2] = a23;

                    matrice[2][0] = a31;
                    matrice[2][1] = a32;
                    matrice[2][2] = a33;
                    
                    // this website https://www.thejavaprogrammer.com/java-program-find-inverse-matrix/ helped me in finding a way of inverting a 3x3 matrix

                    for (int i = 0; i < 3; i++) {
                        det = det + (matrice[0][i] * (matrice[1][(i + 1) % 3] * matrice[2][(i + 2) % 3] - matrice[1][(i + 2) % 3] * matrice[2][(i + 1) % 3]));
                    }

                    txtDet.setText(String.valueOf(det));

                    if (det == 0) {
                        JOptionPane.showMessageDialog(null, "Determinant equal to Zero, impossible to proceed.");
                    } else {

                        for (int i = 0; i < 3; ++i) {
                            for (int j = 0; j < 3; ++j) {
                                
                                //using % to access the right varible

                                invertedMatrice[i][j] = ((((matrice[(j + 1) % 3][(i + 1) % 3] * matrice[(j + 2) % 3][(i + 2) % 3]) - (matrice[(j + 1) % 3][(i + 2) % 3] * matrice[(j + 2) % 3][(i + 1) % 3])) / det));
                            }

                        }
                        //multiplying inverted matrix with the constants to find the variables value.

                        double doubleXfinal = (invertedMatrice[0][0] * constant1) + (invertedMatrice[0][1] * constant2) + (invertedMatrice[0][2] * constant3);
                        double doubleYfinal = (invertedMatrice[1][0] * constant1) + (invertedMatrice[1][1] * constant2) + (invertedMatrice[1][2] * constant3);
                        double doubleZfinal = (invertedMatrice[2][0] * constant1) + (invertedMatrice[2][1] * constant2) + (invertedMatrice[2][2] * constant3);
                        //using a method to round my doubles and make sure they only have to numbers after the comma
                        txtXfinal.setText(String.valueOf(Math.round(doubleXfinal * 100.0) / 100.0));
                        txtYfinal.setText(String.valueOf(Math.round(doubleYfinal * 100.0) / 100.0));
                        txtZfinal.setText(String.valueOf(Math.round(doubleZfinal * 100.0) / 100.0));
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Something went wrong with the calculation");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "One of the variables entered was not a number, try again!");
            }

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

        txtZthree = new javax.swing.JTextField();
        txtEqualsthree = new javax.swing.JTextField();
        btnSolve = new javax.swing.JButton();
        lblDet = new javax.swing.JLabel();
        txtYfinal = new javax.swing.JTextField();
        txtXfinal = new javax.swing.JTextField();
        txtZfinal = new javax.swing.JTextField();
        lblX = new javax.swing.JLabel();
        lxlY = new javax.swing.JLabel();
        lblXtwo = new javax.swing.JLabel();
        lblZ = new javax.swing.JLabel();
        lblYtwo = new javax.swing.JLabel();
        txtDet = new javax.swing.JTextField();
        lblZtwo = new javax.swing.JLabel();
        txtXtwo = new javax.swing.JTextField();
        txtYtwo = new javax.swing.JTextField();
        txtZtwo = new javax.swing.JTextField();
        txtEqualstwo = new javax.swing.JTextField();
        lblXthree = new javax.swing.JLabel();
        lblYthree = new javax.swing.JLabel();
        lblZthree = new javax.swing.JLabel();
        lblXone = new javax.swing.JLabel();
        lblYone = new javax.swing.JLabel();
        lblZone = new javax.swing.JLabel();
        txtXone = new javax.swing.JTextField();
        txtYone = new javax.swing.JTextField();
        txtZone = new javax.swing.JTextField();
        txtEqualsone = new javax.swing.JTextField();
        txtXthree = new javax.swing.JTextField();
        txtYthree = new javax.swing.JTextField();
        lblWarning = new javax.swing.JLabel();
        btnUploadtoDB = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("3 Variables calculator");
        setPreferredSize(new java.awt.Dimension(540, 410));

        btnSolve.setText("Solve");
        btnSolve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolveActionPerformed(evt);
            }
        });

        lblDet.setText("Determinant:");

        txtYfinal.setFocusable(false);

        txtXfinal.setFocusable(false);

        txtZfinal.setFocusable(false);

        lblX.setText("X =");

        lxlY.setText("Y =");

        lblXtwo.setText("  x +");

        lblZ.setText("Z = ");

        lblYtwo.setText("  y +");

        txtDet.setFocusable(false);

        lblZtwo.setText("  z =");

        lblXthree.setText("  x +");

        lblYthree.setText("  y +");

        lblZthree.setText("  z =");

        lblXone.setText("  x +");

        lblYone.setText("  y +");

        lblZone.setText("  z =");

        lblWarning.setText(" *If you have to enter a negative number just put the negative sign before it.");

        btnUploadtoDB.setText("Upload operation to database");
        btnUploadtoDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadtoDBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblWarning)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(lxlY))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnSolve, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                        .addComponent(lblDet)
                                        .addGap(8, 8, 8)
                                        .addComponent(txtDet, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(lblX)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtXfinal)
                                    .addComponent(txtYfinal, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnUploadtoDB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(84, 84, 84)
                                .addComponent(lblZ)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtZfinal, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(108, 108, 108))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtXthree, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(txtXtwo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(txtXone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblXone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblXtwo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblXthree, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtYthree, javax.swing.GroupLayout.PREFERRED_SIZE, 48, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblYthree, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtYone, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(txtYtwo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblYtwo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblYone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(txtZthree, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblZthree)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtEqualsthree, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(txtZtwo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblZtwo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtEqualstwo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtZone, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblZone)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtEqualsone, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(247, 247, 247)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(143, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtXfinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblX))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDet, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSolve)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtYfinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lxlY))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtZfinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblZ)
                    .addComponent(btnUploadtoDB))
                .addGap(31, 31, 31)
                .addComponent(lblWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtYone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtZone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtEqualsone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblXone)
                        .addComponent(lblYone)
                        .addComponent(lblZone)
                        .addComponent(txtXone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtYtwo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtZtwo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtEqualstwo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblXtwo)
                        .addComponent(lblYtwo)
                        .addComponent(lblZtwo)
                        .addComponent(txtXtwo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtYthree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtZthree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtEqualsthree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblXthree)
                        .addComponent(lblYthree)
                        .addComponent(lblZthree)
                        .addComponent(txtXthree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(263, Short.MAX_VALUE)))
        );

        setBounds(0, 0, 540, 410);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSolveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolveActionPerformed
        solveThreeVariables();
    }//GEN-LAST:event_btnSolveActionPerformed

    private void btnUploadtoDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadtoDBActionPerformed
        //only gonna work after the equations been solved
        if ("".equals(txtXfinal.getText())) {
            JOptionPane.showMessageDialog(null, "Make sure you solve your equation before you click on update to database");
        } else {
            //code to send equation to database
            
             //only gonna work after the equations been solved
             int id=0;
             //finds the user id to pass it as a parameter to the other table
              String sqlUsernameQuery = "SELECT * FROM user WHERE username=?;";
              try {
            sqlStatement = connection.prepareStatement(sqlUsernameQuery);
            sqlStatement.setString(1, PageMain.menuMyProfile.getText());
            resultSet = sqlStatement.executeQuery();
            resultSet.next();
            //reading id number from the query made using username from main page
            id= resultSet.getInt(1);
              
            
                  resultSet = null;
           
            
              }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Something went wrong in our database, "+e);
                    
                    }
            
        if("".equals(txtXfinal.getText())){
            JOptionPane.showMessageDialog(null, "Make sure you solve your equation before you click on update to database");
        }
        else {
        //code to send equation to database
         String sqlUpdateOperation = "INSERT INTO operations (operation, result, userId, dateOperation) VALUES(?,?,?,?)";
        try {
            sqlStatement = connection.prepareStatement(sqlUpdateOperation);
            sqlStatement.setString(1,txtXone.getText()+"x + "+txtYone.getText()+"y + "+txtZone.getText()+"z = "+txtEqualsone.getText()+" , "+txtXtwo.getText()+"x + "+txtYtwo.getText()+"y + "+txtZtwo.getText()+"z = "+txtEqualstwo.getText()+" , "+txtXthree.getText()+"x + "+txtYtwo.getText()+"y + "+txtZthree.getText()+"z = "+txtEqualsthree.getText());
            sqlStatement.setString(2,"X = "+ txtXfinal.getText()+", Y = "+txtYfinal.getText()+", Z = "+txtZfinal.getText());
            
            
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
            LocalDateTime now = LocalDateTime.now();  
           //one user can have more than one operation, so i have one autoincremented id for operations and another column for user id
            sqlStatement.setInt(3,id);
            sqlStatement.setString(4,dtf.format(now));
       
            //Result set returns info from a row, 4 in this case is where we verify is it's and admin or not
            sqlStatement.executeUpdate();
           
                JOptionPane.showMessageDialog(null, "Operation updated to database.");
               
            txtXfinal.setText(null);
            txtYfinal.setText(null);
            txtZfinal.setText(null);
            txtXone.setText(null);
            txtYone.setText(null);
            txtZone.setText(null);
            txtXtwo.setText(null);
            txtYtwo.setText(null);
            txtZtwo.setText(null);
            txtXthree.setText(null);
            txtYthree.setText(null);
            txtZthree.setText(null);
            txtEqualsone.setText(null);
            txtEqualstwo.setText(null);
            txtEqualsthree.setText(null);
            txtDet.setText(null);
            
                    
            
            
                
                
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something went wrong in our database, "+e);
            System.out.println(e);
        }
           

        }}
    }//GEN-LAST:event_btnUploadtoDBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSolve;
    private javax.swing.JButton btnUploadtoDB;
    private javax.swing.JLabel lblDet;
    private javax.swing.JLabel lblWarning;
    private javax.swing.JLabel lblX;
    private javax.swing.JLabel lblXone;
    private javax.swing.JLabel lblXthree;
    private javax.swing.JLabel lblXtwo;
    private javax.swing.JLabel lblYone;
    private javax.swing.JLabel lblYthree;
    private javax.swing.JLabel lblYtwo;
    private javax.swing.JLabel lblZ;
    private javax.swing.JLabel lblZone;
    private javax.swing.JLabel lblZthree;
    private javax.swing.JLabel lblZtwo;
    private javax.swing.JLabel lxlY;
    private javax.swing.JTextField txtDet;
    private javax.swing.JTextField txtEqualsone;
    private javax.swing.JTextField txtEqualsthree;
    private javax.swing.JTextField txtEqualstwo;
    private javax.swing.JTextField txtXfinal;
    private javax.swing.JTextField txtXone;
    private javax.swing.JTextField txtXthree;
    private javax.swing.JTextField txtXtwo;
    private javax.swing.JTextField txtYfinal;
    private javax.swing.JTextField txtYone;
    private javax.swing.JTextField txtYthree;
    private javax.swing.JTextField txtYtwo;
    private javax.swing.JTextField txtZfinal;
    private javax.swing.JTextField txtZone;
    private javax.swing.JTextField txtZthree;
    private javax.swing.JTextField txtZtwo;
    // End of variables declaration//GEN-END:variables
}
