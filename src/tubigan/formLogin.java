/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tubigan;

/**
 *
 * @author DANEM682
 */

import com.alee.laf.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class formLogin extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement  pst = null;
    ResultSet rs = null;
    
    private int attemptCounter = 0;
    private Timer lockTimer = new Timer(1000, unlock());
    private int time = 0;
    private int timeLimit = 50;

    /**
     * Creates new form formLogin
     */
    public formLogin() {
        initComponents();
    }

    protected void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }
    
    protected void lock() {

        txtUser.setEnabled(false);
        txtPass.setEnabled(false);
        btnLogin.setEnabled(false);
        btnClear.setEnabled(false);
        lockTimer.start();
    }

    private Action unlock() {

        return new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                if (time < timeLimit) {
                    time++;
                }
                else if (timeLimit >= 5) {

                    lockTimer.stop();
                    JOptionPane.showMessageDialog(null,
                            "Too many incorrect login attempts\n The system will now close.",
                            "Too many incorrect attempts", 
                            JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
                else {

                    JOptionPane.showMessageDialog(null, 
                            "You can now login.",
                            "System Unlocked!", 
                            JOptionPane.INFORMATION_MESSAGE);
                    lockTimer.stop();
                    txtUser.setEnabled(true);
                    txtPass.setEnabled(true);
                    btnLogin.setEnabled(true);
                    btnClear.setEnabled(true);
                    timeLimit += 5;
                    time = 0;
                }
            }
        };
    }
    
    protected void login() {

        String sql = "SELECT * FROM accounts WHERE username = ? AND password = ?;";
        String user = "dev";
        String pass = "berto";
        String type = "Developer";

        try {

            pst = conn.prepareStatement(sql);
            pst.setString(1, "txtUser.getText()");
            pst.setString(2, "txtPass.getText()");
            rs = pst.executeQuery();
            if (rs.next() && attemptCounter != 3) {

                formMain MainForm = new formMain();
                String alias = rs.getString("alias");
//                MainForm.lblAlias.setText(alias);
                String lvl = rs.getString("type");
//                MainForm.lblType.setText(lvl);
//                FacultyStaff.getObj().lblFSType.setText(lvl);
//                FacultyStaff.getObj().lblFSType.setVisible(false);
                MainForm.setLocationRelativeTo(null);
                MainForm.setVisible(true);
                MainForm.setResizable(false);
                dispose();
            }
            else if ((user.equals("txtUser.getText()") && (pass.equals("txtPass.getText()")))) {

                formMain MainForm = new formMain();
//                MainForm.lblAlias.setText(user);
//                MainForm.lblType.setText(type);
                MainForm.setLocationRelativeTo(null);
                MainForm.setVisible(true);
                MainForm.setResizable(false);
                dispose();
            }
            else if (attemptCounter%3 == 0) {

                JOptionPane.showMessageDialog(null,
                        "You have made 3 incorrect login attempts\n"
                        + "Login will be locked for 60 seconds",
                        "Login Temporary Locked",
                        JOptionPane.WARNING_MESSAGE);
                lock();
                unlock();
            }
            else {

                attemptCounter++;
                JOptionPane.showMessageDialog(null, "Please check if CAPS LOCK is On.",
                        "Invalid login credentials", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch (SQLException e) {

            System.err.println("Invalid SQL Syntax!");
            e.printStackTrace();
        }
        catch (NullPointerException e) {

            System.err.println("Error! See debug log for more details");
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
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

        pnlLogin = new javax.swing.JPanel();
        btnLogin = new javax.swing.JButton();
        lblPass = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        lblUser = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnlLogin.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnLogin.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblPass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPass.setLabelFor(txtPass);
        lblPass.setText("Password");

        txtUser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtPass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblUser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblUser.setLabelFor(txtUser);
        lblUser.setText("Username");

        btnClear.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlLoginLayout = new javax.swing.GroupLayout(pnlLogin);
        pnlLogin.setLayout(pnlLoginLayout);
        pnlLoginLayout.setHorizontalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlLoginLayout.createSequentialGroup()
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlLoginLayout.createSequentialGroup()
                        .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUser)
                            .addComponent(lblPass))
                        .addGap(18, 18, 18)
                        .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        pnlLoginLayout.setVerticalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPass)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin)
                    .addComponent(btnClear))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

        formMain MainForm = new formMain();
        MainForm.setLocationRelativeTo(null);
        MainForm.setVisible(true);
        MainForm.setResizable(false);
        dispose();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed

        txtUser.setText(null);
        txtPass.setText(null);
        txtUser.requestFocus(true);
    }//GEN-LAST:event_btnClearActionPerformed

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
            java.util.logging.Logger.getLogger(formLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                WebLookAndFeel.install();
                formLogin LoginForm = new formLogin();
                LoginForm.setLocationRelativeTo(null);
                LoginForm.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
