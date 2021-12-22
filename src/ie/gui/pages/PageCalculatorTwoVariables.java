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
public class PageCalculatorTwoVariables extends javax.swing.JInternalFrame {

    /**
     * Creates new form PageCalculatorTwoByTwo
     */
    Connection connection = null;
    PreparedStatement sqlStatement = null;
    ResultSet resultSet = null;
    
    public PageCalculatorTwoVariables() {
        initComponents();
        connection = Connector.connector();
    }

    private void solveTwoVariables() {
        double a11, a12, constant1;
        double a21, a22, constant2;

        if ("".equals(txtXone.getText()) || "".equals(txtYone.getText()) || "".equals(txtEqualsone.getText())) {
            JOptionPane.showMessageDialog(null, "It seems that one of your variables on the first equation was left blank");
        } else if ("".equals(txtXtwo.getText()) || "".equals(txtYtwo.getText()) || "".equals(txtEqualstwo.getText())) {
            JOptionPane.showMessageDialog(null, "It seems that one of your variables on the second equation was left blank");

        } else {
            try {
                //parsing data
                a11 = Double.parseDouble(txtXone.getText());
                a12 = Double.parseDouble(txtYone.getText());

                constant1 = Double.parseDouble(txtEqualsone.getText());

                a21 = Double.parseDouble(txtXtwo.getText());
                a22 = Double.parseDouble(txtYtwo.getText());

                constant2 = Double.parseDouble(txtEqualstwo.getText());

                double det = 0;
                double matrice[][] = new double[2][2];

                double invertedMatrice[][] = new double[2][2];
                try {
                    //assigning values

                    matrice[0][0] = a11;
                    matrice[0][1] = a12;

                    matrice[1][0] = a21;
                    matrice[1][1] = a22;

                    det = (matrice[0][0] * matrice[1][1]) - (matrice[0][1] * matrice[1][0]);

                    txtDeterminant.setText(String.valueOf(det));

                    if (det == 0) {
                        JOptionPane.showMessageDialog(null, "Determinant equal to Zero, impossible to proceed.");
                    } else {
                        
                        //inverting matrix

                        invertedMatrice[0][0] = matrice[1][1];
                        invertedMatrice[0][1] = - matrice[0][1];
                        invertedMatrice[1][0] = - matrice[1][0];
                        invertedMatrice[1][1] = matrice[0][0];
                        
                        System.out.println(invertedMatrice[0][0]);
                        System.out.println(invertedMatrice[0][1]);
                        System.out.println(invertedMatrice[1][0]);
                        System.out.println(invertedMatrice[1][1]);
                        System.out.println(constant1);
                        System.out.println(constant2);
                        
                        //multiplying inverted matrix by the constants to find variable values.
                        

                        double doubleXfinal = ((invertedMatrice[0][0] * constant1) + (invertedMatrice[0][1] * constant2))/det;
                        double doubleYfinal = ((invertedMatrice[1][0] * constant1) + (invertedMatrice[1][1] * constant2))/det;

                        txtXfinal.setText(String.valueOf(Math.round(doubleXfinal * 100.0) / 100.0));
                        txtYfinal.setText(String.valueOf(Math.round(doubleYfinal * 100.0) / 100.0));

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

        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtYone = new javax.swing.JTextField();
        txtEqualsone = new javax.swing.JTextField();
        txtXone = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtYtwo = new javax.swing.JTextField();
        txtEqualstwo = new javax.swing.JTextField();
        txtXtwo = new javax.swing.JTextField();
        txtYfinal = new javax.swing.JTextField();
        txtXfinal = new javax.swing.JTextField();
        lblX = new javax.swing.JLabel();
        lblY = new javax.swing.JLabel();
        txtDeterminant = new javax.swing.JTextField();
        lblDet = new javax.swing.JLabel();
        btnSolve = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        btnUpdateToDB = new javax.swing.JButton();
        lblWarning = new javax.swing.JLabel();
        lblWarningtwo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("2 Variables calculator");

        jLabel8.setText(" x +");

        jLabel9.setText("y =");

        jLabel10.setText(" x +");

        jLabel11.setText("y =");

        txtYfinal.setFocusable(false);

        txtXfinal.setFocusable(false);

        lblX.setText("X =");

        lblY.setText("Y =");

        txtDeterminant.setFocusable(false);

        lblDet.setText("Determinant=");

        btnSolve.setText("Solve");
        btnSolve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolveActionPerformed(evt);
            }
        });

        btnUpdateToDB.setText("Upload operation to database");
        btnUpdateToDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateToDBActionPerformed(evt);
            }
        });

        lblWarning.setText(" *If you have to enter a negative number");

        lblWarningtwo.setText("just put the negative sign before it.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdateToDB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtXtwo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtXone, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtYtwo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEqualstwo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtYone, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEqualsone, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblY)
                                    .addComponent(lblX))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtXfinal)
                                    .addComponent(txtYfinal, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDet)
                                .addGap(18, 18, 18)
                                .addComponent(txtDeterminant, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(51, 51, 51)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(btnSolve, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblWarningtwo)))
                .addGap(146, 146, 146))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtXone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtYone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEqualsone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtXtwo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtYtwo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEqualstwo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSolve)
                    .addComponent(lblWarning))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblWarningtwo)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDet)
                            .addComponent(txtDeterminant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtXfinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblX))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtYfinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblY))
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdateToDB)))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        setBounds(0, 0, 540, 410);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSolveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolveActionPerformed
        solveTwoVariables();
    }//GEN-LAST:event_btnSolveActionPerformed

    private void btnUpdateToDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateToDBActionPerformed
             //only gonna work after the equations been solved
             int id=0;
             //finds the user id to pass it as a parameter to the other table
              String sqlUsernameQuery = "SELECT * FROM user WHERE username=?;";
              try {
            sqlStatement = connection.prepareStatement(sqlUsernameQuery);
            sqlStatement.setString(1, PageMain.menuMyProfile.getText());
             
            resultSet = sqlStatement.executeQuery();
            resultSet.next();
              id= resultSet.getInt(1);
              
            
                  resultSet = null;
           
            
              }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Something went wrong in our database 1 "+e);
                    
                    }
            
        if("".equals(txtXfinal.getText())){
            JOptionPane.showMessageDialog(null, "Make sure you solve your equation before you click on update to database");
        }
        else {
        //code to send equation to database
         String sqlUpdateOperation = "INSERT INTO operations (operation, result, userId, dateOperation) VALUES(?,?,?,?)";
        try {
            sqlStatement = connection.prepareStatement(sqlUpdateOperation);
            sqlStatement.setString(1,txtXone.getText()+"x + "+txtYone.getText()+"y = "+txtEqualsone.getText()+" , "+txtXtwo.getText()+"x + "+txtYtwo.getText()+"y = "+txtEqualstwo.getText());
            sqlStatement.setString(2,"X = "+ txtXfinal.getText()+", Y = "+txtYfinal.getText());
            
            
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
            LocalDateTime now = LocalDateTime.now();  
            sqlStatement.setInt(3,id);
            sqlStatement.setString(4,dtf.format(now));
       
            //Result set returns info from a row, 4 in this case is where we verify is it's and admin or not
            sqlStatement.executeUpdate();
           
                JOptionPane.showMessageDialog(null, "Operation updated to database.");
                
            txtDeterminant.setText(null);
            txtXfinal.setText(null);
            txtYfinal.setText(null);
            txtXone.setText(null);
            txtYone.setText(null);
            txtXtwo.setText(null);
            txtYtwo.setText(null);
            txtEqualsone.setText(null);
            txtEqualstwo.setText(null);
            
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something went wrong in our database 2"+e);
            System.out.println(e);
        }
        
        
            System.out.println(txtXone.getText()+"x + "+txtYone.getText()+"y = "+txtEqualsone.getText());
            System.out.println(txtXtwo.getText()+"x + "+txtYtwo.getText()+"y = "+txtEqualstwo.getText());
            
            
        }
    }//GEN-LAST:event_btnUpdateToDBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSolve;
    private javax.swing.JButton btnUpdateToDB;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblDet;
    private javax.swing.JLabel lblWarning;
    private javax.swing.JLabel lblWarningtwo;
    private javax.swing.JLabel lblX;
    private javax.swing.JLabel lblY;
    private javax.swing.JTextField txtDeterminant;
    private javax.swing.JTextField txtEqualsone;
    private javax.swing.JTextField txtEqualstwo;
    private javax.swing.JTextField txtXfinal;
    private javax.swing.JTextField txtXone;
    private javax.swing.JTextField txtXtwo;
    private javax.swing.JTextField txtYfinal;
    private javax.swing.JTextField txtYone;
    private javax.swing.JTextField txtYtwo;
    // End of variables declaration//GEN-END:variables
}
