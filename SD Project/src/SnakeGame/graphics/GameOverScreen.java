/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SnakeGame.graphics;

import JFrame.UserScreen;
import SnakeGame.boards.SnakeBoard;
import static JFrame.SnakeGameMainMenu.SNAKE_BOARD;

/**
 *
 * @author Lassassin
 */
public class GameOverScreen extends javax.swing.JFrame {

    /**
     * Creates new form GameOverScreen
     */
    public GameOverScreen() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        startAgain = new javax.swing.JButton();
        mainMenu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setLocationByPlatform(true);
        setPreferredSize(new java.awt.Dimension(1600, 800));
        setResizable(false);
        setSize(new java.awt.Dimension(1600, 800));
        getContentPane().setLayout(null);

        startAgain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/snake_main_menu.png"))); // NOI18N
        startAgain.setBorder(null);
        startAgain.setBorderPainted(false);
        startAgain.setContentAreaFilled(false);
        startAgain.setFocusPainted(false);
        startAgain.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/snake_main_menu_rollover.png"))); // NOI18N
        startAgain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startAgainActionPerformed(evt);
            }
        });
        getContentPane().add(startAgain);
        startAgain.setBounds(660, 510, 267, 72);

        mainMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/snake_try_again.png"))); // NOI18N
        mainMenu.setBorder(null);
        mainMenu.setBorderPainted(false);
        mainMenu.setContentAreaFilled(false);
        mainMenu.setFocusPainted(false);
        mainMenu.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/snake_try_again_rollover.png"))); // NOI18N
        mainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenuActionPerformed(evt);
            }
        });
        getContentPane().add(mainMenu);
        mainMenu.setBounds(660, 370, 264, 72);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/snake_game_over_background.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1600, 800);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void startAgainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startAgainActionPerformed
        // TODO add your handling code here:
        UserScreen.SNAKE_GAME_MAIN_MENU.setVisible(true);
        dispose();
    }//GEN-LAST:event_startAgainActionPerformed

    private void mainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenuActionPerformed
        // TODO add your handling code here:
        
        
        
        SNAKE_BOARD = new SnakeBoard();
        SNAKE_BOARD.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_mainMenuActionPerformed

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
            java.util.logging.Logger.getLogger(GameOverScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameOverScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameOverScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameOverScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GameOverScreen gameOverScreen = new GameOverScreen();
                
                gameOverScreen.setVisible(true);
                
                
                gameOverScreen.setLocationRelativeTo(null);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton mainMenu;
    private javax.swing.JButton startAgain;
    // End of variables declaration//GEN-END:variables
}
