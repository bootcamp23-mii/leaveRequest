/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.KaryawanController;
import java.util.Arrays;
import javax.swing.JOptionPane;
import mainTools.HibernateUtil;
import org.hibernate.SessionFactory;

/**
 *
 * @author Pandu
 */
public class Landing extends javax.swing.JFrame {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    KaryawanController kc = new KaryawanController(sessionFactory);

    /**
     * Creates new form Landing
     */
    public Landing() {
        initComponents();
        this.setLocationRelativeTo(null);
        pnLogin.setVisible(true);
        pnSignUp.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnSignUp = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tfRegFirstName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfRegLastName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfRegEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbRegMarried = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cbManagerName = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        tfRegUsername = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfRegPass1 = new javax.swing.JPasswordField();
        tfRegPass2 = new javax.swing.JPasswordField();
        btRegSignUp = new javax.swing.JButton();
        btRegLogin = new javax.swing.JButton();
        pnGimmick = new javax.swing.JPanel();
        pnLogin = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnSignUp.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setText("First Name");

        tfRegFirstName.setBackground(new java.awt.Color(120, 168, 252));
        tfRegFirstName.setFont(new java.awt.Font("Mayeka Light Demo", 0, 18)); // NOI18N
        tfRegFirstName.setForeground(new java.awt.Color(255, 255, 255));
        tfRegFirstName.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel10.setText("Last Name");

        tfRegLastName.setBackground(new java.awt.Color(120, 168, 252));
        tfRegLastName.setFont(new java.awt.Font("Mayeka Light Demo", 0, 18)); // NOI18N
        tfRegLastName.setForeground(new java.awt.Color(255, 255, 255));
        tfRegLastName.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel8.setText("Email");

        tfRegEmail.setBackground(new java.awt.Color(120, 168, 252));
        tfRegEmail.setFont(new java.awt.Font("Mayeka Light Demo", 0, 18)); // NOI18N
        tfRegEmail.setForeground(new java.awt.Color(255, 255, 255));
        tfRegEmail.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel7.setText("Married Status");

        cbRegMarried.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel11.setText("Manager Name");

        cbManagerName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel9.setText("Username");

        tfRegUsername.setBackground(new java.awt.Color(120, 168, 252));
        tfRegUsername.setFont(new java.awt.Font("Mayeka Light Demo", 0, 18)); // NOI18N
        tfRegUsername.setForeground(new java.awt.Color(255, 255, 255));
        tfRegUsername.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setText("Password");

        tfRegPass1.setBackground(new java.awt.Color(120, 168, 252));
        tfRegPass1.setFont(new java.awt.Font("Mayeka Light Demo", 0, 18)); // NOI18N
        tfRegPass1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tfRegPass2.setBackground(new java.awt.Color(120, 168, 252));
        tfRegPass2.setFont(new java.awt.Font("Mayeka Light Demo", 0, 18)); // NOI18N
        tfRegPass2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        btRegSignUp.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btRegSignUp.setText("SIGN UP");
        btRegSignUp.setBorder(null);
        btRegSignUp.setBorderPainted(false);
        btRegSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegSignUpActionPerformed(evt);
            }
        });

        btRegLogin.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btRegLogin.setText("BACK TO LOGIN");
        btRegLogin.setBorder(null);
        btRegLogin.setBorderPainted(false);
        btRegLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnSignUpLayout = new javax.swing.GroupLayout(pnSignUp);
        pnSignUp.setLayout(pnSignUpLayout);
        pnSignUpLayout.setHorizontalGroup(
            pnSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSignUpLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(pnSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnSignUpLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(250, 250, 250))
                    .addGroup(pnSignUpLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(250, 250, 250))
                    .addGroup(pnSignUpLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(258, 258, 258))
                    .addComponent(tfRegEmail)
                    .addComponent(tfRegUsername)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnSignUpLayout.createSequentialGroup()
                        .addGroup(pnSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfRegFirstName)
                            .addGroup(pnSignUpLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(60, 60, 60)))
                        .addGap(20, 20, 20)
                        .addGroup(pnSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnSignUpLayout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(60, 60, 60))
                            .addComponent(tfRegLastName)))
                    .addGroup(pnSignUpLayout.createSequentialGroup()
                        .addGroup(pnSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btRegSignUp, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(tfRegPass1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btRegLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(tfRegPass2)))
                    .addGroup(pnSignUpLayout.createSequentialGroup()
                        .addGroup(pnSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbRegMarried, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnSignUpLayout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(56, 56, 56)))
                        .addGap(18, 18, 18)
                        .addGroup(pnSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbManagerName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnSignUpLayout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(43, 43, 43)))
                        .addGap(2, 2, 2)))
                .addGap(121, 121, 121))
        );
        pnSignUpLayout.setVerticalGroup(
            pnSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSignUpLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(pnSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfRegFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(tfRegLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfRegEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbRegMarried, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(cbManagerName, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfRegUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfRegPass1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(tfRegPass2, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addGroup(pnSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btRegLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(btRegSignUp, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(111, 111, 111))
        );

        getContentPane().add(pnSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 550, 610));

        pnGimmick.setBackground(new java.awt.Color(71, 120, 197));

        javax.swing.GroupLayout pnGimmickLayout = new javax.swing.GroupLayout(pnGimmick);
        pnGimmick.setLayout(pnGimmickLayout);
        pnGimmickLayout.setHorizontalGroup(
            pnGimmickLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );
        pnGimmickLayout.setVerticalGroup(
            pnGimmickLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );

        getContentPane().add(pnGimmick, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 610));

        pnLogin.setBackground(new java.awt.Color(255, 255, 255));

        jTextField1.setBackground(new java.awt.Color(120, 168, 252));
        jTextField1.setFont(new java.awt.Font("Mayeka Light Demo", 0, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jButton1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton1.setText("LOGIN");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel1.setText("Username");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setText("Password");

        jPasswordField1.setBackground(new java.awt.Color(120, 168, 252));
        jPasswordField1.setFont(new java.awt.Font("Mayeka Light Demo", 0, 18)); // NOI18N
        jPasswordField1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jButton2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton2.setText("SIGN UP");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setText("Need an Account's?");

        javax.swing.GroupLayout pnLoginLayout = new javax.swing.GroupLayout(pnLogin);
        pnLogin.setLayout(pnLoginLayout);
        pnLoginLayout.setHorizontalGroup(
            pnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLoginLayout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addGroup(pnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnLoginLayout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        pnLoginLayout.setVerticalGroup(
            pnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLoginLayout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(4, 4, 4)
                .addGroup(pnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(184, Short.MAX_VALUE))
        );

        getContentPane().add(pnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 550, 610));

        mainPanel.setLayout(new javax.swing.OverlayLayout(mainPanel));
        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Home ev = new Home();
        mainPanel.add(ev);
        pnGimmick.setVisible(false);
        pnLogin.setVisible(false);
        ev.setVisible(true);
//        jIFEmployee.setBounds(5, 5, 200, 300);
        ev.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        ev.revalidate();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        pnLogin.setVisible(false);
        pnSignUp.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btRegSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegSignUpActionPerformed
        // TODO add your handling code here:
//        String pass = "";
//        String passconf = "";
//        for (char c : tfRegPass1.getPassword()) {
//            pass += c;
//        }
//        for (char c : tfRegPass2.getPassword()) {
//            passconf += c;
//        }
//        if (tfRegFirstName.getText().isEmpty()
//                || tfRegLastName.getText().isEmpty()
//                || tfRegUsername.getText().isEmpty()
//                || tfRegPass1.getText().isEmpty()
//                || tfRegPass2.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "PLEASE FILL ALL OF YOUR DATA");
//        } else if (kc.getById(tfRegUsername.getText()).size() != 0) {
//            JOptionPane.showMessageDialog(null, "Username sudah digunakan");
//        } else if (!Arrays.equals(tfRegPass1.getPassword(), tfRegPass2.getPassword())) {
//            JOptionPane.showMessageDialog(null, "PASSWORD AREN'T MATCH");
//        } else if (tfRegPass1.getPassword().length < 6) {
//            JOptionPane.showMessageDialog(null, "Password minimal 6 karakter");
//        } else {
//            JOptionPane.showMessageDialog(null, kc.register(tfRegUsername.getText(), pass));
//            pnSignUp.setVisible(false);
//            pnLogin.setVisible(true);
//
//        }
    }//GEN-LAST:event_btRegSignUpActionPerformed

    private void btRegLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegLoginActionPerformed
        // TODO add your handling code here:
        pnLogin.setVisible(true);
        pnSignUp.setVisible(false);
    }//GEN-LAST:event_btRegLoginActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Landing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Landing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Landing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Landing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Landing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btRegLogin;
    private javax.swing.JButton btRegSignUp;
    private javax.swing.JComboBox<String> cbManagerName;
    private javax.swing.JComboBox<String> cbRegMarried;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel pnGimmick;
    private javax.swing.JPanel pnLogin;
    private javax.swing.JPanel pnSignUp;
    private javax.swing.JTextField tfRegEmail;
    private javax.swing.JTextField tfRegFirstName;
    private javax.swing.JTextField tfRegLastName;
    private javax.swing.JPasswordField tfRegPass1;
    private javax.swing.JPasswordField tfRegPass2;
    private javax.swing.JTextField tfRegUsername;
    // End of variables declaration//GEN-END:variables
}