/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SnakeGame;

import static SnakeGame.music.MusicPlayer.player;
import static SnakeGame.States.SAVED_STATE;
import javax.sound.sampled.Clip;
import static SnakeGame.States.SPEED_STATES;
import static SnakeGame.States.MUSIC_STATES;
import SnakeGame.screens.Screen;
import java.io.File;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Lassassin
 */
public class Options extends javax.swing.JFrame {

    /**
     * Creates new form Options
     */
    String GUITAR_MASS = "resources/Snake.Resources/track_1.wav";
    String ADVENTURE_TIME = "resources/Snake.Resources/track_2.wav";
    String JOJO = "resources/Snake.Resources/track_3.wav";
    String ISON = "resources/Snake.Resources/track_4.wav";

    public Options() {

        initComponents();
        setLocationRelativeTo(null);
        initializeStates();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loadCustomTrackButton = new javax.swing.JButton();
        save_button = new javax.swing.JButton();
        music_2 = new javax.swing.JButton();
        music_3 = new javax.swing.JButton();
        music_4 = new javax.swing.JButton();
        music_1 = new javax.swing.JButton();
        speed_2 = new javax.swing.JButton();
        speed_3 = new javax.swing.JButton();
        speed_4 = new javax.swing.JButton();
        speed_1 = new javax.swing.JButton();
        music_box = new javax.swing.JLabel();
        speed_box = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1600, 800));
        setResizable(false);
        setSize(new java.awt.Dimension(1600, 800));
        getContentPane().setLayout(null);

        loadCustomTrackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/snake_inside_options/load_custom_track.png"))); // NOI18N
        loadCustomTrackButton.setBorder(null);
        loadCustomTrackButton.setBorderPainted(false);
        loadCustomTrackButton.setContentAreaFilled(false);
        loadCustomTrackButton.setFocusPainted(false);
        loadCustomTrackButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/snake_inside_options/load_custom_track_rollover.png"))); // NOI18N
        loadCustomTrackButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/snake_inside_options/2box.png"))); // NOI18N
        loadCustomTrackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadCustomTrackButtonActionPerformed(evt);
            }
        });
        getContentPane().add(loadCustomTrackButton);
        loadCustomTrackButton.setBounds(820, 460, 483, 71);

        save_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/snake_inside_options/save_button.png"))); // NOI18N
        save_button.setBorder(null);
        save_button.setBorderPainted(false);
        save_button.setContentAreaFilled(false);
        save_button.setFocusPainted(false);
        save_button.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/snake_inside_options/save_button_rollover.png"))); // NOI18N
        save_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(save_button);
        save_button.setBounds(740, 610, 147, 68);

        music_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/snake_inside_options/2.png"))); // NOI18N
        music_2.setBorder(null);
        music_2.setBorderPainted(false);
        music_2.setContentAreaFilled(false);
        music_2.setFocusPainted(false);
        music_2.setRolloverEnabled(false);
        music_2.setSelected(true);
        music_2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/snake_inside_options/2box.png"))); // NOI18N
        music_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                music_2ActionPerformed(evt);
            }
        });
        getContentPane().add(music_2);
        music_2.setBounds(1040, 330, 46, 50);

        music_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/snake_inside_options/3.png"))); // NOI18N
        music_3.setBorder(null);
        music_3.setBorderPainted(false);
        music_3.setContentAreaFilled(false);
        music_3.setFocusPainted(false);
        music_3.setRolloverEnabled(false);
        music_3.setSelected(true);
        music_3.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/snake_inside_options/3box.png"))); // NOI18N
        music_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                music_3ActionPerformed(evt);
            }
        });
        getContentPane().add(music_3);
        music_3.setBounds(1130, 330, 46, 50);

        music_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/snake_inside_options/4.png"))); // NOI18N
        music_4.setBorder(null);
        music_4.setBorderPainted(false);
        music_4.setContentAreaFilled(false);
        music_4.setFocusPainted(false);
        music_4.setRolloverEnabled(false);
        music_4.setSelected(true);
        music_4.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/snake_inside_options/4box.png"))); // NOI18N
        music_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                music_4ActionPerformed(evt);
            }
        });
        getContentPane().add(music_4);
        music_4.setBounds(1210, 330, 46, 50);

        music_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/snake_inside_options/1.png"))); // NOI18N
        music_1.setBorder(null);
        music_1.setBorderPainted(false);
        music_1.setContentAreaFilled(false);
        music_1.setFocusPainted(false);
        music_1.setRolloverEnabled(false);
        music_1.setSelected(true);
        music_1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/snake_inside_options/1box.png"))); // NOI18N
        music_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                music_1ActionPerformed(evt);
            }
        });
        getContentPane().add(music_1);
        music_1.setBounds(950, 330, 46, 50);

        speed_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/snake_inside_options/2.png"))); // NOI18N
        speed_2.setBorder(null);
        speed_2.setBorderPainted(false);
        speed_2.setContentAreaFilled(false);
        speed_2.setFocusPainted(false);
        speed_2.setRolloverEnabled(false);
        speed_2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/snake_inside_options/2box.png"))); // NOI18N
        speed_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                speed_2ActionPerformed(evt);
            }
        });
        getContentPane().add(speed_2);
        speed_2.setBounds(1040, 180, 46, 50);

        speed_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/snake_inside_options/3.png"))); // NOI18N
        speed_3.setBorder(null);
        speed_3.setBorderPainted(false);
        speed_3.setContentAreaFilled(false);
        speed_3.setFocusPainted(false);
        speed_3.setRolloverEnabled(false);
        speed_3.setSelected(true);
        speed_3.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/snake_inside_options/3box.png"))); // NOI18N
        speed_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                speed_3ActionPerformed(evt);
            }
        });
        getContentPane().add(speed_3);
        speed_3.setBounds(1130, 180, 46, 50);

        speed_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/snake_inside_options/4.png"))); // NOI18N
        speed_4.setBorder(null);
        speed_4.setBorderPainted(false);
        speed_4.setContentAreaFilled(false);
        speed_4.setFocusPainted(false);
        speed_4.setRolloverEnabled(false);
        speed_4.setSelected(true);
        speed_4.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/snake_inside_options/4box.png"))); // NOI18N
        speed_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                speed_4ActionPerformed(evt);
            }
        });
        getContentPane().add(speed_4);
        speed_4.setBounds(1210, 180, 46, 50);

        speed_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/snake_inside_options/1.png"))); // NOI18N
        speed_1.setBorder(null);
        speed_1.setBorderPainted(false);
        speed_1.setContentAreaFilled(false);
        speed_1.setFocusPainted(false);
        speed_1.setRolloverEnabled(false);
        speed_1.setSelected(true);
        speed_1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/snake_inside_options/1box.png"))); // NOI18N
        speed_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                speed_1ActionPerformed(evt);
            }
        });
        getContentPane().add(speed_1);
        speed_1.setBounds(950, 180, 46, 50);

        music_box.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/snake_inside_options/music_track_box.png"))); // NOI18N
        getContentPane().add(music_box);
        music_box.setBounds(350, 310, 959, 100);

        speed_box.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/snake_inside_options/speed_box.png"))); // NOI18N
        speed_box.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/snake_inside_options/speed_box.png"))); // NOI18N
        getContentPane().add(speed_box);
        speed_box.setBounds(350, 150, 959, 101);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/snake_options_background.png"))); // NOI18N
        getContentPane().add(background);
        background.setBounds(0, 0, 1600, 800);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void speed_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_speed_2ActionPerformed
        // TODO add your handling code here:
        if (!speed_2.isSelected()) {
            speed_1.setSelected(false);
            speed_2.setSelected(true);
            speed_3.setSelected(false);
            speed_4.setSelected(false);

            SPEED_STATES[0] = false;
            SPEED_STATES[1] = true;
            SPEED_STATES[2] = false;
            SPEED_STATES[3] = false;
            
            setFramerate(45);
            
        }


    }//GEN-LAST:event_speed_2ActionPerformed

    private void speed_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_speed_1ActionPerformed
        if (!speed_1.isSelected()) {
            speed_1.setSelected(true);
            speed_2.setSelected(false);
            speed_3.setSelected(false);
            speed_4.setSelected(false);

            SPEED_STATES[0] = true;
            SPEED_STATES[1] = false;
            SPEED_STATES[2] = false;
            SPEED_STATES[3] = false;
            
            setFramerate(30);

        }

// TODO add your handling code here:
    }//GEN-LAST:event_speed_1ActionPerformed

    private void speed_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_speed_3ActionPerformed
        if (!speed_3.isSelected()) {
            speed_3.setSelected(true);
            speed_2.setSelected(false);
            speed_4.setSelected(false);
            speed_1.setSelected(false);

            SPEED_STATES[0] = false;
            SPEED_STATES[1] = false;
            SPEED_STATES[2] = true;
            SPEED_STATES[3] = false;
            
            setFramerate(60);

        }
// TODO add your handling code here:

    }//GEN-LAST:event_speed_3ActionPerformed

    private void speed_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_speed_4ActionPerformed
        // TODO add your handling code here:
        if (!speed_4.isSelected()) {
            speed_4.setSelected(true);
            speed_3.setSelected(false);
            speed_2.setSelected(false);
            speed_1.setSelected(false);

            SPEED_STATES[0] = false;
            SPEED_STATES[1] = false;
            SPEED_STATES[2] = false;
            SPEED_STATES[3] = true;
            
            setFramerate(90);

        }
    }//GEN-LAST:event_speed_4ActionPerformed

    private void music_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_music_1ActionPerformed
        // TODO add your handling code here:
        if (!music_1.isSelected()) {
            music_1.setSelected(true);
            music_2.setSelected(false);
            music_3.setSelected(false);
            music_4.setSelected(false);

            player.clip.close();
            player.clip.stop();
            player.loadMusic(GUITAR_MASS);
            player.clip.start();
            
            player.clip.loop(Clip.LOOP_CONTINUOUSLY);

            MUSIC_STATES[0] = true;
            MUSIC_STATES[1] = false;
            MUSIC_STATES[2] = false;
            MUSIC_STATES[3] = false;

        }
    }//GEN-LAST:event_music_1ActionPerformed

    private void music_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_music_2ActionPerformed
        if (!music_2.isSelected()) {
            music_2.setSelected(true);
            music_3.setSelected(false);
            music_4.setSelected(false);
            music_1.setSelected(false);

            player.clip.close();
            player.clip.stop();
            player.loadMusic(ADVENTURE_TIME);
            player.clip.start();

            player.clip.loop(Clip.LOOP_CONTINUOUSLY);

            MUSIC_STATES[0] = false;
            MUSIC_STATES[1] = true;
            MUSIC_STATES[2] = false;
            MUSIC_STATES[3] = false;
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_music_2ActionPerformed

    private void music_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_music_3ActionPerformed
        if (!music_3.isSelected()) {
            music_3.setSelected(true);
            music_2.setSelected(false);
            music_4.setSelected(false);
            music_1.setSelected(false);

            player.clip.close();
            player.clip.stop();
            player.loadMusic(JOJO);
            player.clip.start();

            player.clip.loop(Clip.LOOP_CONTINUOUSLY);

            MUSIC_STATES[0] = false;
            MUSIC_STATES[1] = false;
            MUSIC_STATES[2] = true;
            MUSIC_STATES[3] = false;
        }

// TODO add your handling code here:
    }//GEN-LAST:event_music_3ActionPerformed

    private void music_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_music_4ActionPerformed
        if (!music_4.isSelected()) {
            music_4.setSelected(true);
            music_3.setSelected(false);
            music_2.setSelected(false);
            music_1.setSelected(false);

            player.clip.close();
            player.clip.stop();
            player.loadMusic(ISON);
            player.clip.start();

            player.clip.loop(Clip.LOOP_CONTINUOUSLY);

            MUSIC_STATES[0] = false;
            MUSIC_STATES[1] = false;
            MUSIC_STATES[2] = false;
            MUSIC_STATES[3] = true;
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_music_4ActionPerformed

    private void save_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_buttonActionPerformed
        // TODO add your handling code here:
//        save();
        dispose();
    }//GEN-LAST:event_save_buttonActionPerformed

    private void loadCustomTrackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadCustomTrackButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser jFileChooser = new JFileChooser();
        
        jFileChooser.showOpenDialog(null);
        
        File songFile = jFileChooser.getSelectedFile();

        if (jFileChooser.getSelectedFile().getName().contains(".wav")) {
            player.clip.stop();
            player.clip.close();

            player.loadMusic(songFile);

            player.clip.start();
            
            player.clip.loop(Clip.LOOP_CONTINUOUSLY);
        }else{
            JOptionPane.showMessageDialog(rootPane, "Please open a .wav file");
        }


    }//GEN-LAST:event_loadCustomTrackButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Options.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Options.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Options.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Options.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Options().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton loadCustomTrackButton;
    private javax.swing.JButton music_1;
    private javax.swing.JButton music_2;
    private javax.swing.JButton music_3;
    private javax.swing.JButton music_4;
    private javax.swing.JLabel music_box;
    private javax.swing.JButton save_button;
    private javax.swing.JButton speed_1;
    private javax.swing.JButton speed_2;
    private javax.swing.JButton speed_3;
    private javax.swing.JButton speed_4;
    private javax.swing.JLabel speed_box;
    // End of variables declaration//GEN-END:variables

    private void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void initializeStates() {
        if (SAVED_STATE == -1) {

            speed_1.setSelected(true);
            speed_2.setSelected(false);
            speed_3.setSelected(false);
            speed_4.setSelected(false);

            SPEED_STATES[0] = true;
            SPEED_STATES[1] = false;
            SPEED_STATES[2] = false;
            SPEED_STATES[3] = false;

            music_1.setSelected(true);
            music_2.setSelected(false);
            music_3.setSelected(false);
            music_4.setSelected(false);

            MUSIC_STATES[0] = true;
            MUSIC_STATES[1] = false;
            MUSIC_STATES[2] = false;
            MUSIC_STATES[3] = false;

            SAVED_STATE = 0;
        } else {
            speed_1.setSelected(SPEED_STATES[0]);
            speed_2.setSelected(SPEED_STATES[1]);
            speed_3.setSelected(SPEED_STATES[2]);
            speed_4.setSelected(SPEED_STATES[3]);

            music_1.setSelected(MUSIC_STATES[0]);
            music_2.setSelected(MUSIC_STATES[1]);
            music_3.setSelected(MUSIC_STATES[2]);
            music_4.setSelected(MUSIC_STATES[3]);

        }
    }

    private void setFramerate(int i) {
        
        Screen.FRAMES_PER_SECOND = i;
    }
}
