/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrame;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JFrame;

/**
 *
 * @author AST
 */
public class LoginScreen extends javax.swing.JFrame {

    /**
     * Creates new form LoginScreen
     */
    private int mousePX, mousePY;
    
    public LoginScreen() {
        initComponents();
        
        //setting window screen
        this.setSize(1600,900);
        this.setLocationRelativeTo(null);
        
        //changing exit bar background
        jPanelExitBar.setBackground(new Color(250,250,250,20));
        
        //setting focus on exit bar to avoid focus on text fields
        //------------------
        jPanelExitBar.requestFocusInWindow();
        //------------------

        //setting Hints in email and password fields
        
        //---------------------------------------------------------------
        
        jLabelEmail.setText("Email"); //initializing email and password strings
        
        jLabelPass.setText("Password");
        
        //Listening if the user has clicked on email or password fields
        
        jEmailField.addFocusListener(new FocusListener() {

             String email = "";
             
            @Override
            public void focusGained(FocusEvent e) {
                
                //If clicked, changing color of the text to complete white
                jLabelEmail.setForeground(new Color(255,255,255));  /** color is not changing to white**/
                email = jEmailField.getText();
                
                if (jLabelEmail.getText().equals("Email") || !email.isEmpty())
                    jLabelEmail.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                
                email = jEmailField.getText();
                
                if (jLabelEmail.getText().equals("") && email.isEmpty()){
                    jLabelEmail.setText("Email");
                    //if deselected and field is empty, changing color back to grey
                    jLabelEmail.setForeground(new Color(120,120,120));
                }
            }
        });
        jPasswordField.addFocusListener(new FocusListener() {

            String pass = "";
            
            @Override
            public void focusGained(FocusEvent e) {
                
                //If clicked, changing color of the text to complete white
                jLabelPass.setForeground(new Color(255,255,255));  /** color is not changing to white**/
                pass = jPasswordField.getText();
                
                if (jLabelPass.getText().equals("Password") || !pass.isEmpty())
                    jLabelPass.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                
                pass = jPasswordField.getText();
                
                if (jLabelPass.getText().equals("") && pass.isEmpty()){
                    jLabelPass.setText("Password");
                    
                    //if deselected and field is empty, changing color back to grey
                    jLabelPass.setForeground(new Color(120,120,120));
                }
            }
        });
        
        //------------------------------------------------------------------
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelExitBar = new javax.swing.JPanel();
        jLabelLoginExit = new javax.swing.JLabel();
        jLabelLoginMinimize = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jEmailField = new javax.swing.JTextField();
        jLabelPass = new javax.swing.JLabel();
        jPasswordField = new javax.swing.JPasswordField();
        jButtonSignup = new javax.swing.JButton();
        jButtonLogin = new javax.swing.JButton();
        jLabelEmailWarning = new javax.swing.JLabel();
        jLabelPassWarning = new javax.swing.JLabel();
        jLabelLoginPanelBackground = new javax.swing.JLabel();
        jLabelLoginBg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanelExitBar.setBackground(new java.awt.Color(44, 62, 80));
        jPanelExitBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanelExitBarMouseDragged(evt);
            }
        });
        jPanelExitBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelExitBarMousePressed(evt);
            }
        });

        jLabelLoginExit.setFont(new java.awt.Font("Viner Hand ITC", 0, 36)); // NOI18N
        jLabelLoginExit.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLoginExit.setText("X");
        jLabelLoginExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLoginExitMouseClicked(evt);
            }
        });

        jLabelLoginMinimize.setFont(new java.awt.Font("Viner Hand ITC", 1, 48)); // NOI18N
        jLabelLoginMinimize.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLoginMinimize.setText("-");
        jLabelLoginMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLoginMinimizeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelExitBarLayout = new javax.swing.GroupLayout(jPanelExitBar);
        jPanelExitBar.setLayout(jPanelExitBarLayout);
        jPanelExitBarLayout.setHorizontalGroup(
            jPanelExitBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelExitBarLayout.createSequentialGroup()
                .addContainerGap(1546, Short.MAX_VALUE)
                .addComponent(jLabelLoginExit)
                .addGap(31, 31, 31))
            .addGroup(jPanelExitBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelExitBarLayout.createSequentialGroup()
                    .addContainerGap(1494, Short.MAX_VALUE)
                    .addComponent(jLabelLoginMinimize)
                    .addGap(82, 82, 82)))
        );
        jPanelExitBarLayout.setVerticalGroup(
            jPanelExitBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelLoginExit, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
            .addGroup(jPanelExitBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelExitBarLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabelLoginMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 59, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        getContentPane().add(jPanelExitBar);
        jPanelExitBar.setBounds(0, 0, 1600, 70);

        jLabelEmail.setFont(new java.awt.Font("Poppins Light", 0, 36)); // NOI18N
        jLabelEmail.setForeground(new java.awt.Color(120, 120, 120));
        getContentPane().add(jLabelEmail);
        jLabelEmail.setBounds(610, 280, 380, 90);

        jEmailField.setFont(new java.awt.Font("Poppins Light", 0, 36)); // NOI18N
        jEmailField.setForeground(new java.awt.Color(250, 250, 250));
        jEmailField.setToolTipText("");
        jEmailField.setBorder(null);
        jEmailField.setOpaque(false);
        jEmailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEmailFieldActionPerformed(evt);
            }
        });
        getContentPane().add(jEmailField);
        jEmailField.setBounds(610, 280, 380, 90);

        jLabelPass.setFont(new java.awt.Font("Poppins Light", 0, 36)); // NOI18N
        jLabelPass.setForeground(new java.awt.Color(120, 120, 120));
        getContentPane().add(jLabelPass);
        jLabelPass.setBounds(610, 420, 380, 80);

        jPasswordField.setBackground(new java.awt.Color(38, 15, 48));
        jPasswordField.setFont(new java.awt.Font("Poppins Light", 0, 36)); // NOI18N
        jPasswordField.setForeground(new java.awt.Color(250, 250, 250));
        jPasswordField.setBorder(null);
        getContentPane().add(jPasswordField);
        jPasswordField.setBounds(610, 420, 380, 80);

        jButtonSignup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/signupButton.png"))); // NOI18N
        jButtonSignup.setBorder(null);
        jButtonSignup.setBorderPainted(false);
        jButtonSignup.setContentAreaFilled(false);
        jButtonSignup.setFocusPainted(false);
        jButtonSignup.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/signupButtonPressed.png"))); // NOI18N
        jButtonSignup.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/signupButtonRollover.png"))); // NOI18N
        jButtonSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSignupActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSignup);
        jButtonSignup.setBounds(650, 660, 290, 120);

        jButtonLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/loginButton.png"))); // NOI18N
        jButtonLogin.setBorder(null);
        jButtonLogin.setBorderPainted(false);
        jButtonLogin.setContentAreaFilled(false);
        jButtonLogin.setFocusPainted(false);
        jButtonLogin.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/loginButtonPressed.png"))); // NOI18N
        jButtonLogin.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/loginButtonRollover.png"))); // NOI18N
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLogin);
        jButtonLogin.setBounds(650, 530, 290, 120);

        jLabelEmailWarning.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabelEmailWarning.setForeground(new java.awt.Color(204, 0, 51));
        getContentPane().add(jLabelEmailWarning);
        jLabelEmailWarning.setBounds(590, 370, 220, 20);

        jLabelPassWarning.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabelPassWarning.setForeground(new java.awt.Color(204, 0, 51));
        getContentPane().add(jLabelPassWarning);
        jLabelPassWarning.setBounds(590, 510, 220, 20);

        jLabelLoginPanelBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/LoginPanelBg.png"))); // NOI18N
        getContentPane().add(jLabelLoginPanelBackground);
        jLabelLoginPanelBackground.setBounds(520, 100, 540, 720);

        jLabelLoginBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/sd-gif.gif"))); // NOI18N
        getContentPane().add(jLabelLoginBg);
        jLabelLoginBg.setBounds(0, 0, 1620, 900);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelLoginExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLoginExitMouseClicked
        //closing window
        System.exit(0);
    }//GEN-LAST:event_jLabelLoginExitMouseClicked

    private void jLabelLoginMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLoginMinimizeMouseClicked
        //minimizing window
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabelLoginMinimizeMouseClicked

    private void jPanelExitBarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelExitBarMouseDragged
       
        //setting screen location according to mouse pointer
        int coordinateX = evt.getXOnScreen();
        int coordinateY = evt.getYOnScreen();
        
        this.setLocation(coordinateX-mousePX,coordinateY-mousePY);
    }//GEN-LAST:event_jPanelExitBarMouseDragged

    private void jPanelExitBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelExitBarMousePressed
        
        //getting coordinates of mouse pointer
        mousePX = evt.getX();
        mousePY = evt.getY();
    }//GEN-LAST:event_jPanelExitBarMousePressed

    private void jEmailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEmailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jEmailFieldActionPerformed

    private void jButtonSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSignupActionPerformed
        
        //moving to register screen
        RegisterScreen rg = new RegisterScreen();
        rg.setVisible(true);
    }//GEN-LAST:event_jButtonSignupActionPerformed

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        
        
        String email = "" , pass = "";
        email = jEmailField.getText();
        pass = jPasswordField.getText();
        
        //if the user does not fill up either email or password
        if(email.isEmpty()|| pass.isEmpty())
        {
            if(email.isEmpty())
            {
                jLabelEmailWarning.setText("Field can not be empty");
            }
            else
            {
                jLabelEmailWarning.setText("");
            }
            if(pass.isEmpty())
            {
                jLabelPassWarning.setText("Field can not be empty");
            }
            else
            {
                jLabelPassWarning.setText("");
            }
        }
        else
        {
            jLabelEmailWarning.setText("");
            jLabelPassWarning.setText("");
        }
    }//GEN-LAST:event_jButtonLoginActionPerformed

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
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JButton jButtonSignup;
    private javax.swing.JTextField jEmailField;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelEmailWarning;
    private javax.swing.JLabel jLabelLoginBg;
    private javax.swing.JLabel jLabelLoginExit;
    private javax.swing.JLabel jLabelLoginMinimize;
    private javax.swing.JLabel jLabelLoginPanelBackground;
    private javax.swing.JLabel jLabelPass;
    private javax.swing.JLabel jLabelPassWarning;
    private javax.swing.JPanel jPanelExitBar;
    private javax.swing.JPasswordField jPasswordField;
    // End of variables declaration//GEN-END:variables
}
