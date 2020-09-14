/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrame;

import Model.SpeechToText;
import Model.TextToSpeech;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import sd.project.MyConnection;

/**
 *
 * @author AST
 */
public class LoginScreen extends javax.swing.JFrame {

    //declaring global variables to store co-ordinates of mouse pointer
    private int mousePX, mousePY;

    //creating object of register screen
    RegisterScreen rg = new RegisterScreen();
    //SpeechToText st = new SpeechToText();

    public LoginScreen() {
        initComponents();

        //setting window screen
        this.setSize(1600, 900);
        this.setLocationRelativeTo(null);

        //changing exit bar background
        jPanelExitBar.setBackground(new Color(250, 250, 250, 20));

        //setting focus on exit bar to avoid focus on text fields
        //------------------
        jPanelExitBar.requestFocusInWindow();
        //------------------

        //setting Hints in email and password fields
        //---------------------------------------------------------------
        jLabelName.setText("User Name"); //initializing email and password strings
        jLabelPass.setText("Password");

        //Listening if the user has clicked on email or password fields
        jNamelField.addFocusListener(new FocusListener() {

            String username = "";

            @Override
            public void focusGained(FocusEvent e) {

                //If clicked, changing color of the text to complete white
                jLabelName.setForeground(new Color(255, 255, 255));
                /**
                 * color is not changing to white*
                 */
                username = jNamelField.getText();

                if (jLabelName.getText().equals("User Name") || !username.isEmpty()) {
                    jLabelName.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {

                username = jNamelField.getText();

                if (jLabelName.getText().equals("") && username.isEmpty()) {
                    jLabelName.setText("User Name");
                    //if deselected and field is empty, changing color back to grey
                    jLabelName.setForeground(new Color(120, 120, 120));
                }
            }
        });
        jPasswordField.addFocusListener(new FocusListener() {

            String pass = "";

            @Override
            public void focusGained(FocusEvent e) {

                //If clicked, changing color of the text to complete white
                jLabelPass.setForeground(new Color(255, 255, 255));
                /**
                 * color is not changing to white*
                 */
                pass = jPasswordField.getText();

                if (jLabelPass.getText().equals("Password") || !pass.isEmpty()) {
                    jLabelPass.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {

                pass = jPasswordField.getText();

                if (jLabelPass.getText().equals("") && pass.isEmpty()) {
                    jLabelPass.setText("Password");

                    //if deselected and field is empty, changing color back to grey
                    jLabelPass.setForeground(new Color(120, 120, 120));
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
        jLabelName = new javax.swing.JLabel();
        jNamelField = new javax.swing.JTextField();
        jLabelPass = new javax.swing.JLabel();
        jPasswordField = new javax.swing.JPasswordField();
        jButtonSignup = new javax.swing.JButton();
        jButtonLogin = new javax.swing.JButton();
        jLabelNameWarning = new javax.swing.JLabel();
        jLabelPassWarning = new javax.swing.JLabel();
        jCheckBoxRememberMe = new javax.swing.JCheckBox();
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

        jLabelName.setBackground(new java.awt.Color(38, 14, 48));
        jLabelName.setFont(new java.awt.Font("Poppins Light", 0, 36)); // NOI18N
        jLabelName.setForeground(new java.awt.Color(120, 120, 120));
        getContentPane().add(jLabelName);
        jLabelName.setBounds(610, 290, 380, 70);

        jNamelField.setBackground(new java.awt.Color(38, 14, 48));
        jNamelField.setFont(new java.awt.Font("Poppins Light", 0, 36)); // NOI18N
        jNamelField.setForeground(new java.awt.Color(250, 250, 250));
        jNamelField.setToolTipText("");
        jNamelField.setBorder(null);
        jNamelField.setOpaque(false);
        jNamelField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNamelFieldActionPerformed(evt);
            }
        });
        getContentPane().add(jNamelField);
        jNamelField.setBounds(610, 290, 380, 70);

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
        jButtonSignup.setBounds(650, 680, 290, 120);

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
        jButtonLogin.setBounds(650, 570, 290, 120);

        jLabelNameWarning.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelNameWarning.setForeground(new java.awt.Color(204, 0, 51));
        getContentPane().add(jLabelNameWarning);
        jLabelNameWarning.setBounds(590, 370, 220, 20);

        jLabelPassWarning.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelPassWarning.setForeground(new java.awt.Color(204, 0, 51));
        getContentPane().add(jLabelPassWarning);
        jLabelPassWarning.setBounds(590, 510, 220, 20);

        jCheckBoxRememberMe.setBackground(new java.awt.Color(153, 0, 153));
        jCheckBoxRememberMe.setFont(new java.awt.Font("Verdana", 2, 18)); // NOI18N
        jCheckBoxRememberMe.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBoxRememberMe.setText(" Remember me");
        jCheckBoxRememberMe.setBorder(null);
        jCheckBoxRememberMe.setContentAreaFilled(false);
        jCheckBoxRememberMe.setFocusPainted(false);
        jCheckBoxRememberMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxRememberMeActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBoxRememberMe);
        jCheckBoxRememberMe.setBounds(590, 540, 200, 16);

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

        this.setLocation(coordinateX - mousePX, coordinateY - mousePY);
    }//GEN-LAST:event_jPanelExitBarMouseDragged

    private void jPanelExitBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelExitBarMousePressed

        //getting coordinates of mouse pointer
        mousePX = evt.getX();
        mousePY = evt.getY();
    }//GEN-LAST:event_jPanelExitBarMousePressed

    private void jNamelFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNamelFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNamelFieldActionPerformed

    private void jButtonSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSignupActionPerformed

        //current sign up button is made off limits if a sign up window already exitsts
        if (!rg.isActive()) {
            //register screen is activated
            rg.setVisible(true);

            //voice assistant
            TextToSpeech tts = new TextToSpeech();

            tts.setVoice("dfki-poppy-hsmm");
            tts.speak("The star fields must have to be filled up",2.0f,false,false);
        }
    }//GEN-LAST:event_jButtonSignupActionPerformed

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed

        String username = "", pass = "";
        username = jNamelField.getText();
        pass = new String(jPasswordField.getPassword());
        boolean loginAction = true;

        //if the user does not fill up either email or password
        if (username.isEmpty() || pass.isEmpty()) {
            loginAction = false;
            if (username.isEmpty()) {
                jLabelNameWarning.setText("Field can not be empty");
            } else {
                jLabelNameWarning.setText("");
            }
            if (pass.isEmpty()) {
                jLabelPassWarning.setText("Field can not be empty");
            } else {
                jLabelPassWarning.setText("");
            }
        } else {
            jLabelNameWarning.setText("");
            jLabelPassWarning.setText("");
        }

        //action after all information filled up 
        if (loginAction) {
            PreparedStatement ps;
            ResultSet rs;

            String searchUser = "SELECT * FROM `userinfo` WHERE `u_username` =? AND `u_pass` =?";

            try {

                //establishing connection to database
                ps = MyConnection.getConnection().prepareStatement(searchUser);

                ps.setString(1, username);
                ps.setString(2, pass);

                //searching for registered user
                rs = ps.executeQuery();

                //if user found then showing yes, else showing no
                if (rs.next()) {

                    String fname1 = rs.getString("u_fname");
                    String lname1 = rs.getString("u_lname");
                    String username1 = rs.getString("u_username");
                    String pass1 = rs.getString("u_pass");
                    String email = rs.getString("u_email");
                    String question1 = rs.getString("u_squestion");
                    String answer1 = rs.getString("u_sanswer");
                    String hangman = rs.getString("hangman");
                    String snake = rs.getString("snake");
                    //.out.println(email);

                    //Save user email address for saving score
                    try {
                        FileWriter file = new FileWriter("resources/Status/id.txt");
                        file.write(fname1 + "\n");
                        file.write(lname1 + "\n");
                        file.write(username1 + "\n");
                        file.write(pass1 + "\n");
                        file.write(email + "\n");
                        file.write(question1 + "\n");
                        file.write(answer1 + "\n");
                        file.write(hangman + "\n");
                        file.write(snake + "\n");
                        file.close();
                    } catch (IOException ex) {
                        Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JOptionPane.showMessageDialog(null, "Login Successful");

                    //storing user status inside cache
                    if (jCheckBoxRememberMe.isSelected()) {
                        try {

                            //writing user status in cache
                            FileWriter writer = new FileWriter("resources/Status/cache.txt");

                            writer.write(username);

                            //closing writer
                            writer.close();
                        } catch (IOException ex) {
                            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    dispose();
                    //moving on to next JFRAME
                    new UserScreen(username).setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
                }

            } catch (SQLException ex) {
                Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void jCheckBoxRememberMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxRememberMeActionPerformed

    }//GEN-LAST:event_jCheckBoxRememberMeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                System.out.println(args);
                new LoginScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JButton jButtonSignup;
    private javax.swing.JCheckBox jCheckBoxRememberMe;
    private javax.swing.JLabel jLabelLoginBg;
    private javax.swing.JLabel jLabelLoginExit;
    private javax.swing.JLabel jLabelLoginMinimize;
    private javax.swing.JLabel jLabelLoginPanelBackground;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelNameWarning;
    private javax.swing.JLabel jLabelPass;
    private javax.swing.JLabel jLabelPassWarning;
    private javax.swing.JTextField jNamelField;
    private javax.swing.JPanel jPanelExitBar;
    private javax.swing.JPasswordField jPasswordField;
    // End of variables declaration//GEN-END:variables
}
