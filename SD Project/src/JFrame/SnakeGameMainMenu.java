/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrame;

import SnakeGame.music.MusicPlayer;
import SnakeGame.boards.SnakeBoard;
import SnakeGame.MapEditor;
import SnakeGame.Options;
import SnakeGame.States;
import SnakeGame.boards.MapBoard;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

/**
 *
 * @author Lassassin
 */
public class SnakeGameMainMenu extends javax.swing.JFrame {

    public static SnakeBoard SNAKE_BOARD;
    
    public static MapBoard MAP_BOARD;
    
    public static MusicPlayer player = MusicPlayer.getInstance();
    
    String filePath = "resources/track_1.wav";
    
    static boolean isPlaying = true;
   
    /**
     * Creates new form SnakeGameMainMenu
     */
    public SnakeGameMainMenu() {
        
        initComponents();
        
       
        player.loadMusic(filePath);
        
        player.clip.start();
        
        player.clip.loop(Clip.LOOP_CONTINUOUSLY);
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mapsButton1 = new javax.swing.JButton();
        mapsButton = new javax.swing.JButton();
        optionsButton = new javax.swing.JButton();
        startButton = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1600, 800));
        setResizable(false);
        setSize(new java.awt.Dimension(1600, 800));
        getContentPane().setLayout(null);

        mapsButton1.setBackground(new java.awt.Color(0, 0, 0));
        mapsButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/snakebackbutton.png"))); // NOI18N
        mapsButton1.setBorder(null);
        mapsButton1.setBorderPainted(false);
        mapsButton1.setContentAreaFilled(false);
        mapsButton1.setFocusPainted(false);
        mapsButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/snakebackbutton_rollover.png"))); // NOI18N
        mapsButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mapsButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(mapsButton1);
        mapsButton1.setBounds(30, 30, 70, 70);

        mapsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/snake_maps.png"))); // NOI18N
        mapsButton.setBorder(null);
        mapsButton.setBorderPainted(false);
        mapsButton.setContentAreaFilled(false);
        mapsButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/snake_maps_rollover.png"))); // NOI18N
        mapsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mapsButtonActionPerformed(evt);
            }
        });
        getContentPane().add(mapsButton);
        mapsButton.setBounds(920, 510, 170, 70);

        optionsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/snake_options.png"))); // NOI18N
        optionsButton.setBorder(null);
        optionsButton.setBorderPainted(false);
        optionsButton.setContentAreaFilled(false);
        optionsButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/snake_options_rollover.png"))); // NOI18N
        optionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionsButtonActionPerformed(evt);
            }
        });
        getContentPane().add(optionsButton);
        optionsButton.setBounds(730, 510, 170, 70);

        startButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/snake_start.png"))); // NOI18N
        startButton.setBorder(null);
        startButton.setBorderPainted(false);
        startButton.setContentAreaFilled(false);
        startButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/snake_start_rollover.png"))); // NOI18N
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        getContentPane().add(startButton);
        startButton.setBounds(530, 510, 170, 70);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/snakeGif.gif"))); // NOI18N
        getContentPane().add(background);
        background.setBounds(0, 0, 1600, 800);
        background.getAccessibleContext().setAccessibleName("Background");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void optionsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionsButtonActionPerformed
        // TODO add your handling code here:

        new Options().setVisible(true);

    }//GEN-LAST:event_optionsButtonActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // TODO add your handling code here:
        SNAKE_BOARD = new SnakeBoard();
        SNAKE_BOARD.setVisible(true);
        if(States.TUTORIAL_GAME == 0){
            JOptionPane.showMessageDialog(null, "Use arrow keys to move!\nPress ESC to go back");
            States.TUTORIAL_GAME++;
        }

        setVisible(false);
    }//GEN-LAST:event_startButtonActionPerformed

    private void mapsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mapsButtonActionPerformed
        MAP_BOARD = new MapBoard();
        MAP_BOARD.setVisible(true);
         if(States.TUTORIAL_MAP == 0){
            JOptionPane.showMessageDialog(null, "Use arrow keys to move the green square!\nPress SPACE to add a wall and press BACKSPACE to remove a wall\nPress ESC to save changes and go back");
            States.TUTORIAL_MAP++;
        }
        
        setVisible(false);
    }//GEN-LAST:event_mapsButtonActionPerformed

    private void mapsButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mapsButton1ActionPerformed
        //returning to user screen
        new UserScreen().setVisible(true);
        UserScreen.SNAKE_GAME_MAIN_MENU.dispose();
        player.clip.stop();
        player.clip.close();
        dispose();
    }//GEN-LAST:event_mapsButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(SnakeGameMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SnakeGameMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SnakeGameMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SnakeGameMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SnakeGameMainMenu().setVisible(true);

            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton mapsButton;
    private javax.swing.JButton mapsButton1;
    private javax.swing.JButton optionsButton;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
}
