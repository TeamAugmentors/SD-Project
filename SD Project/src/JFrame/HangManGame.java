/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrame;

import Model.Game_HangMan.HangManMethods;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Atiqur Rahman
 */
public class HangManGame extends javax.swing.JFrame {

    /**
     * Creates new form HangManGame
     */
    HangManMethods hg = new HangManMethods();
    Scanner sc = new Scanner(System.in);
    int i;
    char[] guess;
    int amountOfGuesses;//How many times player can guess the word
    char[] playerGuess;
    int tries,gameendFlag=0;
    public HangManGame() throws FileNotFoundException {
        initComponents();
        this.setSize(800, 650);
        setLocationRelativeTo(null);
        initializeGame();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonB = new javax.swing.JButton();
        jButtonA = new javax.swing.JButton();
        jButtonD = new javax.swing.JButton();
        jButtonC = new javax.swing.JButton();
        jButtonF = new javax.swing.JButton();
        jButtonE = new javax.swing.JButton();
        jButtonH = new javax.swing.JButton();
        jButtonG = new javax.swing.JButton();
        jButtonJ = new javax.swing.JButton();
        jButtonI = new javax.swing.JButton();
        jButtonL = new javax.swing.JButton();
        jButtonK = new javax.swing.JButton();
        jButtonN = new javax.swing.JButton();
        jButtonM = new javax.swing.JButton();
        jButtonP = new javax.swing.JButton();
        jButtonO = new javax.swing.JButton();
        jButtonR = new javax.swing.JButton();
        jButtonQ = new javax.swing.JButton();
        jButtonT = new javax.swing.JButton();
        jButtonS = new javax.swing.JButton();
        jButtonV = new javax.swing.JButton();
        jButtonU = new javax.swing.JButton();
        jButtonX = new javax.swing.JButton();
        jButtonW = new javax.swing.JButton();
        jButtonY = new javax.swing.JButton();
        jButtonZ = new javax.swing.JButton();
        jTextFieldOutput = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabelNotification = new javax.swing.JLabel();
        jLabelHint = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButtonB.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonB.setText("B");
        jButtonB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonB);
        jButtonB.setBounds(140, 250, 70, 60);

        jButtonA.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonA.setText("A");
        jButtonA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonA);
        jButtonA.setBounds(50, 250, 70, 60);

        jButtonD.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonD.setText("D");
        jButtonD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonD);
        jButtonD.setBounds(320, 250, 70, 60);

        jButtonC.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonC.setText("C");
        jButtonC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonC);
        jButtonC.setBounds(230, 250, 70, 60);

        jButtonF.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonF.setText("F");
        jButtonF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonF);
        jButtonF.setBounds(500, 250, 70, 60);

        jButtonE.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonE.setText("E");
        jButtonE.setToolTipText("");
        jButtonE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonE);
        jButtonE.setBounds(410, 250, 70, 60);

        jButtonH.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonH.setText("H");
        jButtonH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonH);
        jButtonH.setBounds(680, 250, 70, 60);

        jButtonG.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonG.setText("G");
        jButtonG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonG);
        jButtonG.setBounds(590, 250, 70, 60);

        jButtonJ.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonJ.setText("J");
        jButtonJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonJActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonJ);
        jButtonJ.setBounds(140, 330, 70, 60);

        jButtonI.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonI.setText("I");
        jButtonI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonI);
        jButtonI.setBounds(50, 330, 70, 60);

        jButtonL.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonL.setText("L");
        jButtonL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonL);
        jButtonL.setBounds(320, 330, 70, 60);

        jButtonK.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonK.setText("K");
        jButtonK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonKActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonK);
        jButtonK.setBounds(230, 330, 70, 60);

        jButtonN.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonN.setText("N");
        jButtonN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonN);
        jButtonN.setBounds(500, 330, 70, 60);

        jButtonM.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonM.setText("M");
        jButtonM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonM);
        jButtonM.setBounds(410, 330, 70, 60);

        jButtonP.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonP.setText("P");
        jButtonP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonP);
        jButtonP.setBounds(680, 330, 70, 60);

        jButtonO.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonO.setText("O");
        jButtonO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonO);
        jButtonO.setBounds(590, 330, 70, 60);

        jButtonR.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonR.setText("R");
        jButtonR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonR);
        jButtonR.setBounds(140, 410, 70, 60);

        jButtonQ.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonQ.setText("Q");
        jButtonQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonQ);
        jButtonQ.setBounds(50, 410, 70, 60);

        jButtonT.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonT.setText("T");
        jButtonT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonT);
        jButtonT.setBounds(320, 410, 70, 60);

        jButtonS.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonS.setText("S");
        jButtonS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonS);
        jButtonS.setBounds(230, 410, 70, 60);

        jButtonV.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonV.setText("V");
        jButtonV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonV);
        jButtonV.setBounds(500, 410, 70, 60);

        jButtonU.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonU.setText("U");
        jButtonU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonU);
        jButtonU.setBounds(410, 410, 70, 60);

        jButtonX.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonX.setText("X");
        jButtonX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonX);
        jButtonX.setBounds(680, 410, 70, 60);

        jButtonW.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonW.setText("W");
        jButtonW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonWActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonW);
        jButtonW.setBounds(590, 410, 70, 60);

        jButtonY.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonY.setText("Y");
        jButtonY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonYActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonY);
        jButtonY.setBounds(320, 490, 70, 60);

        jButtonZ.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonZ.setText("Z");
        jButtonZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonZActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonZ);
        jButtonZ.setBounds(410, 490, 70, 60);

        jTextFieldOutput.setEditable(false);
        jTextFieldOutput.setFont(new java.awt.Font("Unispace", 3, 36)); // NOI18N
        jTextFieldOutput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(jTextFieldOutput);
        jTextFieldOutput.setBounds(160, 90, 500, 60);

        jLabel1.setFont(new java.awt.Font("Unispace", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Guess The Word");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(270, 40, 280, 40);

        jLabelNotification.setFont(new java.awt.Font("Unispace", 3, 18)); // NOI18N
        jLabelNotification.setForeground(new java.awt.Color(102, 0, 102));
        jLabelNotification.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabelNotification);
        jLabelNotification.setBounds(310, 170, 220, 30);

        jLabelHint.setFont(new java.awt.Font("Unispace", 3, 18)); // NOI18N
        jLabelHint.setForeground(new java.awt.Color(102, 0, 102));
        jLabelHint.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabelHint);
        jLabelHint.setBounds(290, 204, 240, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBActionPerformed
        if(gameendFlag==0)
            game('b');
    }//GEN-LAST:event_jButtonBActionPerformed

    private void jButtonMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMActionPerformed
        if(gameendFlag==0)
            game('m');
    }//GEN-LAST:event_jButtonMActionPerformed

    private void jButtonAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAActionPerformed
        if(gameendFlag==0)
            game('a');
    }//GEN-LAST:event_jButtonAActionPerformed

    private void jButtonCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCActionPerformed
        if(gameendFlag==0)
            game('c');
    }//GEN-LAST:event_jButtonCActionPerformed

    private void jButtonDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDActionPerformed
        if(gameendFlag==0)
            game('d');
    }//GEN-LAST:event_jButtonDActionPerformed

    private void jButtonEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEActionPerformed
        if(gameendFlag==0)
            game('e');
    }//GEN-LAST:event_jButtonEActionPerformed

    private void jButtonFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFActionPerformed
        if(gameendFlag==0)
            game('f');
    }//GEN-LAST:event_jButtonFActionPerformed

    private void jButtonGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGActionPerformed
        if(gameendFlag==0)
            game('g');
    }//GEN-LAST:event_jButtonGActionPerformed

    private void jButtonHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHActionPerformed
        if(gameendFlag==0)
            game('h');
    }//GEN-LAST:event_jButtonHActionPerformed

    private void jButtonIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIActionPerformed
        if(gameendFlag==0)
            game('i');
    }//GEN-LAST:event_jButtonIActionPerformed

    private void jButtonJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonJActionPerformed
        if(gameendFlag==0)
            game('j');
    }//GEN-LAST:event_jButtonJActionPerformed

    private void jButtonKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonKActionPerformed
        if(gameendFlag==0)
            game('k');
    }//GEN-LAST:event_jButtonKActionPerformed

    private void jButtonLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLActionPerformed
        if(gameendFlag==0)
            game('l');
    }//GEN-LAST:event_jButtonLActionPerformed

    private void jButtonNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNActionPerformed
        if(gameendFlag==0)
            game('n');
    }//GEN-LAST:event_jButtonNActionPerformed

    private void jButtonOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOActionPerformed
        if(gameendFlag==0)
            game('o');
    }//GEN-LAST:event_jButtonOActionPerformed

    private void jButtonPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPActionPerformed
        if(gameendFlag==0)
            game('p');
    }//GEN-LAST:event_jButtonPActionPerformed

    private void jButtonQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQActionPerformed
        if(gameendFlag==0)
            game('q');
    }//GEN-LAST:event_jButtonQActionPerformed

    private void jButtonRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRActionPerformed
        if(gameendFlag==0)
            game('r');
    }//GEN-LAST:event_jButtonRActionPerformed

    private void jButtonSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSActionPerformed
        if(gameendFlag==0)
            game('s');
    }//GEN-LAST:event_jButtonSActionPerformed

    private void jButtonTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTActionPerformed
        if(gameendFlag==0)
            game('t');
    }//GEN-LAST:event_jButtonTActionPerformed

    private void jButtonUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUActionPerformed
        if(gameendFlag==0)
            game('u');
    }//GEN-LAST:event_jButtonUActionPerformed

    private void jButtonVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVActionPerformed
        if(gameendFlag==0)
            game('v');
    }//GEN-LAST:event_jButtonVActionPerformed

    private void jButtonWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonWActionPerformed
        if(gameendFlag==0)
            game('w');
    }//GEN-LAST:event_jButtonWActionPerformed

    private void jButtonXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXActionPerformed
        if(gameendFlag==0)
            game('x');
    }//GEN-LAST:event_jButtonXActionPerformed

    private void jButtonYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonYActionPerformed
        if(gameendFlag==0)
            game('y');
    }//GEN-LAST:event_jButtonYActionPerformed

    private void jButtonZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonZActionPerformed
        if(gameendFlag==0)
            game('z');
    }//GEN-LAST:event_jButtonZActionPerformed
    public void initializeGame() throws FileNotFoundException {
        hg.readWords();
        guess = hg.randomWord();
        //System.out.println(guess);
        amountOfGuesses = 6;//How many times player can guess the word
        playerGuess = new char[guess.length];
        System.out.println("Welcome to game hang man");
        String s = "";
        for (i = 0; i < playerGuess.length; i++) {
            playerGuess[i] = '_';
            s+='_';
            s+=' ';
        }
        jTextFieldOutput.setText(s);
        tries = 0;
        System.out.println("Current guesses:");
        hg.printArray(playerGuess);
        jLabelNotification.setText(String.valueOf(amountOfGuesses - tries)+" tries left");
    }

    public void game(char ch) {
        
            boolean flag = false; //For checking if the guess is correct or wrong
            //System.out.println("Enter a letter");
            char input = ch;
            if (hg.guessWriteOrWrong(playerGuess, guess, input)) //Check if the guess is correct or wrong;
                flag = true;
            playerGuess = hg.matchLetter(playerGuess, guess, input); //Put the gussed letter in the player array
            System.out.println("Current guesses:");
            hg.printArray(playerGuess); //Print the player array
            String s = "";
            for (i = 0; i < playerGuess.length; i++) {
                s += playerGuess[i];
                s += ' ';
            }
            jTextFieldOutput.setText(s);
            if (flag) {
                System.out.println("Correct guess");
            } else {
                System.out.println("Wrong guess");
                tries++;
            }
            jLabelNotification.setText(String.valueOf(amountOfGuesses - tries)+" tries left");
            if (hg.isWordGuess(playerGuess, guess)) {
                System.out.println("You won the game");
                jLabelNotification.setText("You won the game");
                gameendFlag=1;
            } else if (!hg.isWordGuess(playerGuess, guess) && tries == amountOfGuesses) {
                System.out.println("You lost the game");
                jLabelNotification.setText("You lost the game");
                String answer=new String(guess);
                jLabelHint.setText(answer);
                gameendFlag=1;
            }
    }

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
            java.util.logging.Logger.getLogger(HangManGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HangManGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HangManGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HangManGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new HangManGame().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(HangManGame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonA;
    private javax.swing.JButton jButtonB;
    private javax.swing.JButton jButtonC;
    private javax.swing.JButton jButtonD;
    private javax.swing.JButton jButtonE;
    private javax.swing.JButton jButtonF;
    private javax.swing.JButton jButtonG;
    private javax.swing.JButton jButtonH;
    private javax.swing.JButton jButtonI;
    private javax.swing.JButton jButtonJ;
    private javax.swing.JButton jButtonK;
    private javax.swing.JButton jButtonL;
    private javax.swing.JButton jButtonM;
    private javax.swing.JButton jButtonN;
    private javax.swing.JButton jButtonO;
    private javax.swing.JButton jButtonP;
    private javax.swing.JButton jButtonQ;
    private javax.swing.JButton jButtonR;
    private javax.swing.JButton jButtonS;
    private javax.swing.JButton jButtonT;
    private javax.swing.JButton jButtonU;
    private javax.swing.JButton jButtonV;
    private javax.swing.JButton jButtonW;
    private javax.swing.JButton jButtonX;
    private javax.swing.JButton jButtonY;
    private javax.swing.JButton jButtonZ;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelHint;
    private javax.swing.JLabel jLabelNotification;
    private javax.swing.JTextField jTextFieldOutput;
    // End of variables declaration//GEN-END:variables
}
