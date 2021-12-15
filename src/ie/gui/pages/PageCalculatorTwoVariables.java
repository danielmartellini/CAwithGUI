/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.gui.pages;

import javax.swing.JOptionPane;

/**
 *
 * @author danie
 */
public class PageCalculatorTwoVariables extends javax.swing.JInternalFrame {

    /**
     * Creates new form PageCalculatorTwoByTwo
     */
    public PageCalculatorTwoVariables() {
        initComponents();
    }

    private void solveTwoVariables() {
        double a11, a12, a13, constant1;
        double a21, a22, a23, constant2;

        if ("".equals(txtXone.getText()) || "".equals(txtYone.getText()) || "".equals(txtEqualsone.getText())) {
            JOptionPane.showMessageDialog(null, "It seems that one of your variables on the first equation was left blank");
        } else if ("".equals(txtXtwo.getText()) || "".equals(txtYtwo.getText()) || "".equals(txtEqualstwo.getText())) {
            JOptionPane.showMessageDialog(null, "It seems that one of your variables on the second equation was left blank");

        } else {
            try {
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

                    matrice[0][0] = a11;
                    matrice[0][1] = a12;

                    matrice[1][0] = a21;
                    matrice[1][1] = a22;

                    det = (matrice[0][0] * matrice[1][1]) - (matrice[0][1] * matrice[1][0]);

                    txtDeterminant.setText(String.valueOf(det));

                    if (det == 0) {
                        JOptionPane.showMessageDialog(null, "Determinant equal to Zero, impossible to proceed.");
                    } else {

                        invertedMatrice[0][0] = matrice[1][1];
                        invertedMatrice[0][1] = - matrice[0][1];
                        invertedMatrice[1][0] = - matrice[1][0];
                        invertedMatrice[1][1] = matrice[0][0];

                        double doubleXfinal = (invertedMatrice[0][0] * constant1) + (invertedMatrice[0][1] * constant2);
                        double doubleYfinal = (invertedMatrice[1][0] * constant1) + (invertedMatrice[1][1] * constant2);

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
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtDeterminant = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        btnSolve = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        jLabel8.setText(" x +");

        jLabel9.setText("y =");

        txtYone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtYoneActionPerformed(evt);
            }
        });

        txtEqualsone.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                txtEqualsoneAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        txtEqualsone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEqualsoneActionPerformed(evt);
            }
        });

        txtXone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtXoneActionPerformed(evt);
            }
        });

        jLabel10.setText(" x +");

        jLabel11.setText("y =");

        txtYtwo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtYtwoActionPerformed(evt);
            }
        });

        txtEqualstwo.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                txtEqualstwoAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        txtEqualstwo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEqualstwoActionPerformed(evt);
            }
        });

        txtXtwo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtXtwoActionPerformed(evt);
            }
        });

        txtYfinal.setFocusable(false);

        txtXfinal.setFocusable(false);
        txtXfinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtXfinalActionPerformed(evt);
            }
        });

        jLabel12.setText("X =");

        jLabel13.setText("Y =");

        txtDeterminant.setFocusable(false);

        jLabel14.setText("Determinant=");

        btnSolve.setText("Solve");
        btnSolve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtXfinal)
                                    .addComponent(txtYfinal, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtDeterminant, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addComponent(btnSolve, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(51, 51, 51)))
                .addContainerGap(167, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
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
                .addGap(24, 24, 24)
                .addComponent(btnSolve)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtDeterminant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtXfinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtYfinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        setBounds(0, 0, 540, 410);
    }// </editor-fold>//GEN-END:initComponents

    private void txtYoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtYoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtYoneActionPerformed

    private void txtEqualsoneAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txtEqualsoneAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEqualsoneAncestorAdded

    private void txtEqualsoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEqualsoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEqualsoneActionPerformed

    private void txtXoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtXoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtXoneActionPerformed

    private void txtYtwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtYtwoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtYtwoActionPerformed

    private void txtEqualstwoAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txtEqualstwoAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEqualstwoAncestorAdded

    private void txtEqualstwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEqualstwoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEqualstwoActionPerformed

    private void txtXtwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtXtwoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtXtwoActionPerformed

    private void txtXfinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtXfinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtXfinalActionPerformed

    private void btnSolveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolveActionPerformed
        solveTwoVariables();
    }//GEN-LAST:event_btnSolveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSolve;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
