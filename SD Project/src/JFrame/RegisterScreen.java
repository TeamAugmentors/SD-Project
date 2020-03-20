/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrame;

/**
 *
 * @author Atiqur Rahman
 */
public class RegisterScreen extends javax.swing.JFrame {

    /**
     * Creates new form RegisterScreen
     */
    //private String fn = null, ln = null, pass = null, conpass = null, un = null, secques = null, secans = null, em = null;
    private String firstName = null, lastName = null, password = null, confirmPassword = null, un = null, securityQuestion = null, securityAnswer = null, em = null;
    
    //Atikur please dont name vars like this, name them fully
    //I could not understand what un and em meant. Code that your fellow developers can not understand is not conventional code  ~Sanjid
    
    
    /*** TO DO - Make the sign up panel 450 x 939, and do the same as you did for the login (give hints) ***/
    
    boolean flag, flagPass;
    boolean[] ara = new boolean[6];

    public RegisterScreen() {
        initComponents();
        this.setSize(1600, 900);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        securityAnswerTextField = new javax.swing.JTextField();
        securityQuestionTextField = new javax.swing.JTextField();
        registerButton = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField = new javax.swing.JPasswordField();
        email = new javax.swing.JTextField();
        userName = new javax.swing.JTextField();
        lastNameTextField = new javax.swing.JTextField();
        firstNameTextField = new javax.swing.JTextField();
        SignupPanelBg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(378, 1000));
        getContentPane().setLayout(null);

        securityAnswerTextField.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        securityAnswerTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        securityAnswerTextField.setBorder(null);
        securityAnswerTextField.setOpaque(false);
        securityAnswerTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                securityAnswerTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(securityAnswerTextField);
        securityAnswerTextField.setBounds(70, 680, 330, 40);

        securityQuestionTextField.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        securityQuestionTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        securityQuestionTextField.setBorder(null);
        securityQuestionTextField.setOpaque(false);
        securityQuestionTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                securityQuestionTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(securityQuestionTextField);
        securityQuestionTextField.setBounds(70, 600, 330, 40);

        registerButton.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        registerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/signupButton.png"))); // NOI18N
        registerButton.setBorder(null);
        registerButton.setBorderPainted(false);
        registerButton.setContentAreaFilled(false);
        registerButton.setFocusPainted(false);
        registerButton.setFocusable(false);
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });
        getContentPane().add(registerButton);
        registerButton.setBounds(90, 760, 280, 130);

        jPasswordField1.setBorder(null);
        jPasswordField1.setOpaque(false);
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(70, 520, 330, 40);

        jPasswordField.setBorder(null);
        jPasswordField.setOpaque(false);
        jPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldActionPerformed(evt);
            }
        });
        getContentPane().add(jPasswordField);
        jPasswordField.setBounds(70, 440, 330, 40);

        email.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        email.setBorder(null);
        email.setOpaque(false);
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        getContentPane().add(email);
        email.setBounds(70, 360, 330, 40);

        userName.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        userName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        userName.setBorder(null);
        userName.setOpaque(false);
        userName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameActionPerformed(evt);
            }
        });
        getContentPane().add(userName);
        userName.setBounds(70, 280, 330, 40);

        lastNameTextField.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lastNameTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lastNameTextField.setBorder(null);
        lastNameTextField.setOpaque(false);
        lastNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(lastNameTextField);
        lastNameTextField.setBounds(70, 200, 330, 40);

        firstNameTextField.setFont(new java.awt.Font("Poppins Light", 1, 36)); // NOI18N
        firstNameTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        firstNameTextField.setBorder(null);
        firstNameTextField.setOpaque(false);
        firstNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(firstNameTextField);
        firstNameTextField.setBounds(70, 120, 330, 40);

        SignupPanelBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/signupPanelBg.png"))); // NOI18N
        getContentPane().add(SignupPanelBg);
        SignupPanelBg.setBounds(0, 0, 450, 939);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void firstNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameTextFieldActionPerformed

    }//GEN-LAST:event_firstNameTextFieldActionPerformed

    private void lastNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameTextFieldActionPerformed

    }//GEN-LAST:event_lastNameTextFieldActionPerformed

    private void userNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameActionPerformed

    }//GEN-LAST:event_userNameActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed

    }//GEN-LAST:event_emailActionPerformed

    private void securityQuestionTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_securityQuestionTextFieldActionPerformed

    }//GEN-LAST:event_securityQuestionTextFieldActionPerformed

    private void securityAnswerTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_securityAnswerTextFieldActionPerformed

    }//GEN-LAST:event_securityAnswerTextFieldActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        flag = false;
        firstName = firstNameTextField.getText();
        lastName = lastNameTextField.getText();
        un = userName.getText();
        em = email.getText();
        securityQuestion = securityQuestionTextField.getText();
        securityAnswer = securityAnswerTextField.getText();
        password = jPasswordField.getText();
        confirmPassword = jPasswordField1.getText();
        if (firstNameTextField.equals("")) {
            jLabelfn.setText("Must filled");
            flag = true;
        }
        if (lastNameTextField.equals("")) {
            jLabelln.setText("Must filled");
            flag = true;
        }
        if (em.equals("")) {
            jLabelem.setText("Must filled");
            flag = true;
        }
        if (un.equals("")) {
            jLabelun.setText("Must filled");
            flag = true;
        }
        if (password.equals("")) {
            jLabelpass.setText("Must filled");
            flag = true;
        }
        if (confirmPassword.equals("")) {
            jLabelconpass.setText("Must filled");
            flag = true;
        }
        if (!firstNameTextField.equals("")) {
            jLabelfn.setText("");
        }
        if (!lastNameTextField.equals("")) {
            jLabelln.setText("");
        }
        if (!em.equals("")) {
            jLabelem.setText("");
        }
        if (!un.equals("")) {
            jLabelun.setText("");
        }
        if (!password.equals("")) {
            jLabelpass.setText("");
        }
        if (!confirmPassword.equals("")) {
            jLabelconpass.setText("");
        }
        if (flag == false) {
            if (password != "" && confirmPassword != "") {
                if (password.equals(confirmPassword) == false) {
                    System.out.println("Failed");
                    jLabelpassMatch.setText("Passward doesn't match");
                } else {
                    jLabelpassMatch.setText("");
                    System.out.println("Successfull");
                }
            }
        } else {
            System.out.println("Failed");
        }
    }//GEN-LAST:event_registerButtonActionPerformed

    private void jPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldActionPerformed

    }//GEN-LAST:event_jPasswordFieldActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel SignupPanelBg;
    private javax.swing.JTextField email;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JButton registerButton;
    private javax.swing.JTextField securityAnswerTextField;
    private javax.swing.JTextField securityQuestionTextField;
    private javax.swing.JTextField userName;
    // End of variables declaration//GEN-END:variables
}
