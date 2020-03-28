/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrame;

import Model.TextToSpeech;
import java.awt.Color;
import sd.project.SDProject;
import marytts.modules.synthesis.Voice;

/**
 *
 * @author AST
 */
public class SmartAssistant extends javax.swing.JFrame {
    
    /**
     * Creates new form SmartAssistant
     */
    TextToSpeech tts = new TextToSpeech();
    
    public SmartAssistant() {
        initComponents();
        
        this.setSize(1600,900);
        this.setLocationRelativeTo(null);
        jButtonLogin.setBackground(new Color(0,0,0,0));
        jButtonLogin.setBorderPainted(false);
        jButtonLogin.setOpaque(false);
        jButtonLogin.setContentAreaFilled(false);
        jButtonLogin.setBorderPainted(false);
        jButtonLogin.setBorder(null);

        
        
        //printing available voices
        //Voice.getAvailableVoices().stream().forEach(System.out::println);
        tts.setVoice("dfki-poppy-hsmm");
        tts.speak("Welcome! I am Alice. Click next to proceed.", 2.0f, false, false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonLogin = new javax.swing.JButton();
        jLabelWelcomeBg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jButtonLogin.setBackground(new java.awt.Color(0, 0, 0));
        jButtonLogin.setFont(new java.awt.Font("Viner Hand ITC", 1, 36)); // NOI18N
        jButtonLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/NextButton.png"))); // NOI18N
        jButtonLogin.setBorder(null);
        jButtonLogin.setBorderPainted(false);
        jButtonLogin.setContentAreaFilled(false);
        jButtonLogin.setFocusPainted(false);
        jButtonLogin.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/NextButtonPressed.png"))); // NOI18N
        jButtonLogin.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/NextButtonRollover.png"))); // NOI18N
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLogin);
        jButtonLogin.setBounds(890, 430, 300, 110);

        jLabelWelcomeBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/Alice.gif"))); // NOI18N
        jLabelWelcomeBg.setFocusable(false);
        getContentPane().add(jLabelWelcomeBg);
        jLabelWelcomeBg.setBounds(0, 0, 1600, 900);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        
        //closing current JFrame
        dispose();
        
        //moving to next JFrame
        LoginScreen Lg = new LoginScreen();
        Lg.setVisible(true);
        
        tts.stopSpeaking();
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
            java.util.logging.Logger.getLogger(SmartAssistant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SmartAssistant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SmartAssistant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SmartAssistant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SmartAssistant().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabelWelcomeBg;
    // End of variables declaration//GEN-END:variables
}
