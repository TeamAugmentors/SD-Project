/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrame;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import SnakeGame.boards.SnakeBoard;
import JFrame.Symbol;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author AST
 */
public class UserScreen extends javax.swing.JFrame {

    String userName;
    
    //static variable declared to get instance
    public static SnakeGameMainMenu SNAKE_GAME_MAIN_MENU;
    
    public UserScreen() {
        initComponents();
        
    }
    
    public UserScreen(String userName){
        initComponents();
        
        this.setSize(1600, 900);
        this.setLocationRelativeTo(null);
        this.userName = userName;
        //setting welcome text for user
        jLabelWelcome.setText(jLabelWelcome.getText()+' '+userName);
       
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonTicTacToe = new javax.swing.JButton();
        jButtonHangman = new javax.swing.JButton();
        jLabelWelcome = new javax.swing.JLabel();
        jButtonSnakeGame = new javax.swing.JButton();
        jButtonSignOut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonTicTacToe.setFont(new java.awt.Font("Yu Gothic Light", 1, 24)); // NOI18N
        jButtonTicTacToe.setText("TicTacToe");
        jButtonTicTacToe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTicTacToeActionPerformed(evt);
            }
        });

        jButtonHangman.setFont(new java.awt.Font("Yu Gothic Light", 1, 24)); // NOI18N
        jButtonHangman.setText("Hangman");
        jButtonHangman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHangmanActionPerformed(evt);
            }
        });

        jLabelWelcome.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jLabelWelcome.setText("Welcome");

        jButtonSnakeGame.setFont(new java.awt.Font("Yu Gothic Light", 1, 24)); // NOI18N
        jButtonSnakeGame.setText("Snake");
        jButtonSnakeGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSnakeGameActionPerformed(evt);
            }
        });

        jButtonSignOut.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButtonSignOut.setText("Sign out");
        jButtonSignOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSignOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(529, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonTicTacToe, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                            .addComponent(jButtonHangman, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                            .addComponent(jButtonSnakeGame, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
                        .addGap(661, 661, 661))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(509, 509, 509))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonSignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(162, 162, 162))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jLabelWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158)
                .addComponent(jButtonTicTacToe, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(jButtonHangman, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(jButtonSnakeGame, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addComponent(jButtonSignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonTicTacToeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTicTacToeActionPerformed
        
        //disposing current jframe and opening tictactoe
        dispose();
        new Symbol(userName).setVisible(true);
    }//GEN-LAST:event_jButtonTicTacToeActionPerformed

    private void jButtonHangmanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHangmanActionPerformed
        
        //disposing current jframe and opening hangman
        dispose();
        try {
              new HangManGame().setVisible(true);
              
            } catch (FileNotFoundException ex) {
                    Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
    }//GEN-LAST:event_jButtonHangmanActionPerformed

    private void jButtonSnakeGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSnakeGameActionPerformed
        //closing current JFrame
        dispose();
        
        SNAKE_GAME_MAIN_MENU = new SnakeGameMainMenu();
        SNAKE_GAME_MAIN_MENU.setName(userName);
        //moving to next JFrame
        SNAKE_GAME_MAIN_MENU.setVisible(true);
    }//GEN-LAST:event_jButtonSnakeGameActionPerformed

    private void jButtonSignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSignOutActionPerformed
        dispose();
        try {
            FileWriter writer = new FileWriter("resources/Status/cache.txt");
            
            //clearing user status from cache
            writer.write("");
            
            //closing writer
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(UserScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        new LoginScreen().setVisible(true);
    }//GEN-LAST:event_jButtonSignOutActionPerformed

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
            java.util.logging.Logger.getLogger(UserScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonHangman;
    private javax.swing.JButton jButtonSignOut;
    private javax.swing.JButton jButtonSnakeGame;
    private javax.swing.JButton jButtonTicTacToe;
    private javax.swing.JLabel jLabelWelcome;
    // End of variables declaration//GEN-END:variables
}
