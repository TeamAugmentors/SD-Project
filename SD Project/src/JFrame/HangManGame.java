/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrame;

import Model.Game_HangMan.HangManMethods;
import Model.TextToSpeech;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import sd.project.MyConnection;

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
    TextToSpeech tts = new TextToSpeech();
    String name = "";
    String email = "";
    int i, score;
    char[] guess;
    int amountOfGuesses;//How many times player can guess the word
    char[] playerGuess;
    int tries, gameendFlag = 0;

    public HangManGame() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initializeGame();
    }

    public HangManGame(String userName) {
        initComponents();
        //Read user email ID from file
        File file = new File("resources/Status/id.txt");
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(file));
            String line;
            try {
                if ((line = bfr.readLine()) != null) {
                       email=line;
                }
            } catch (IOException ex) {
                Logger.getLogger(HangManGame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HangManGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        name = userName;
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
        jLabel_scoreShow = new javax.swing.JLabel();
        jButtonResetGame = new javax.swing.JButton();
        jLabel_score = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabelExit = new javax.swing.JLabel();
        jLabel_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jButtonB.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonB.setForeground(new java.awt.Color(128, 34, 102));
        jButtonB.setText("B");
        jButtonB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonB);
        jButtonB.setBounds(140, 250, 70, 60);

        jButtonA.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonA.setForeground(new java.awt.Color(128, 34, 102));
        jButtonA.setText("A");
        jButtonA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonA);
        jButtonA.setBounds(50, 250, 70, 60);

        jButtonD.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonD.setForeground(new java.awt.Color(128, 34, 102));
        jButtonD.setText("D");
        jButtonD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonD);
        jButtonD.setBounds(320, 250, 70, 60);

        jButtonC.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonC.setForeground(new java.awt.Color(128, 34, 102));
        jButtonC.setText("C");
        jButtonC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonC);
        jButtonC.setBounds(230, 250, 70, 60);

        jButtonF.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonF.setForeground(new java.awt.Color(128, 34, 102));
        jButtonF.setText("F");
        jButtonF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonF);
        jButtonF.setBounds(500, 250, 70, 60);

        jButtonE.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonE.setForeground(new java.awt.Color(128, 34, 102));
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
        jButtonH.setForeground(new java.awt.Color(128, 34, 102));
        jButtonH.setText("H");
        jButtonH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonH);
        jButtonH.setBounds(680, 250, 70, 60);

        jButtonG.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonG.setForeground(new java.awt.Color(128, 34, 102));
        jButtonG.setText("G");
        jButtonG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonG);
        jButtonG.setBounds(590, 250, 70, 60);

        jButtonJ.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonJ.setForeground(new java.awt.Color(128, 34, 102));
        jButtonJ.setText("J");
        jButtonJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonJActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonJ);
        jButtonJ.setBounds(140, 330, 70, 60);

        jButtonI.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonI.setForeground(new java.awt.Color(128, 34, 102));
        jButtonI.setText("I");
        jButtonI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonI);
        jButtonI.setBounds(50, 330, 70, 60);

        jButtonL.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonL.setForeground(new java.awt.Color(128, 34, 102));
        jButtonL.setText("L");
        jButtonL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonL);
        jButtonL.setBounds(320, 330, 70, 60);

        jButtonK.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonK.setForeground(new java.awt.Color(128, 34, 102));
        jButtonK.setText("K");
        jButtonK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonKActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonK);
        jButtonK.setBounds(230, 330, 70, 60);

        jButtonN.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonN.setForeground(new java.awt.Color(128, 34, 102));
        jButtonN.setText("N");
        jButtonN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonN);
        jButtonN.setBounds(500, 330, 70, 60);

        jButtonM.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonM.setForeground(new java.awt.Color(128, 34, 102));
        jButtonM.setText("M");
        jButtonM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonM);
        jButtonM.setBounds(410, 330, 70, 60);

        jButtonP.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonP.setForeground(new java.awt.Color(128, 34, 102));
        jButtonP.setText("P");
        jButtonP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonP);
        jButtonP.setBounds(680, 330, 70, 60);

        jButtonO.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonO.setForeground(new java.awt.Color(128, 34, 102));
        jButtonO.setText("O");
        jButtonO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonO);
        jButtonO.setBounds(590, 330, 70, 60);

        jButtonR.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonR.setForeground(new java.awt.Color(128, 34, 102));
        jButtonR.setText("R");
        jButtonR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonR);
        jButtonR.setBounds(140, 410, 70, 60);

        jButtonQ.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonQ.setForeground(new java.awt.Color(128, 34, 102));
        jButtonQ.setText("Q");
        jButtonQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonQ);
        jButtonQ.setBounds(50, 410, 70, 60);

        jButtonT.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonT.setForeground(new java.awt.Color(128, 34, 102));
        jButtonT.setText("T");
        jButtonT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonT);
        jButtonT.setBounds(320, 410, 70, 60);

        jButtonS.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonS.setForeground(new java.awt.Color(128, 34, 102));
        jButtonS.setText("S");
        jButtonS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonS);
        jButtonS.setBounds(230, 410, 70, 60);

        jButtonV.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonV.setForeground(new java.awt.Color(128, 34, 102));
        jButtonV.setText("V");
        jButtonV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonV);
        jButtonV.setBounds(500, 410, 70, 60);

        jButtonU.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonU.setForeground(new java.awt.Color(128, 34, 102));
        jButtonU.setText("U");
        jButtonU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonU);
        jButtonU.setBounds(410, 410, 70, 60);

        jButtonX.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonX.setForeground(new java.awt.Color(128, 34, 102));
        jButtonX.setText("X");
        jButtonX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonX);
        jButtonX.setBounds(680, 410, 70, 60);

        jButtonW.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonW.setForeground(new java.awt.Color(128, 34, 102));
        jButtonW.setText("W");
        jButtonW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonWActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonW);
        jButtonW.setBounds(590, 410, 70, 60);

        jButtonY.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonY.setForeground(new java.awt.Color(128, 34, 102));
        jButtonY.setText("Y");
        jButtonY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonYActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonY);
        jButtonY.setBounds(320, 490, 70, 60);

        jButtonZ.setFont(new java.awt.Font("Unispace", 3, 20)); // NOI18N
        jButtonZ.setForeground(new java.awt.Color(128, 34, 102));
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
        jLabel1.setForeground(new java.awt.Color(128, 34, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Guess The Word");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(270, 40, 280, 40);

        jLabelNotification.setFont(new java.awt.Font("Unispace", 3, 18)); // NOI18N
        jLabelNotification.setForeground(new java.awt.Color(128, 34, 102));
        jLabelNotification.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabelNotification);
        jLabelNotification.setBounds(310, 170, 220, 30);

        jLabelHint.setFont(new java.awt.Font("Unispace", 3, 26)); // NOI18N
        jLabelHint.setForeground(new java.awt.Color(128, 34, 102));
        getContentPane().add(jLabelHint);
        jLabelHint.setBounds(50, 730, 450, 40);

        jLabel_scoreShow.setFont(new java.awt.Font("Unispace", 3, 26)); // NOI18N
        jLabel_scoreShow.setForeground(new java.awt.Color(128, 34, 102));
        jLabel_scoreShow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel_scoreShow);
        jLabel_scoreShow.setBounds(180, 780, 180, 50);

        jButtonResetGame.setFont(new java.awt.Font("Unispace", 3, 24)); // NOI18N
        jButtonResetGame.setForeground(new java.awt.Color(128, 34, 102));
        jButtonResetGame.setText("Reset");
        jButtonResetGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetGameActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonResetGame);
        jButtonResetGame.setBounds(850, 920, 120, 50);

        jLabel_score.setFont(new java.awt.Font("Unispace", 2, 26)); // NOI18N
        jLabel_score.setForeground(new java.awt.Color(128, 34, 102));
        jLabel_score.setToolTipText("");
        getContentPane().add(jLabel_score);
        jLabel_score.setBounds(50, 780, 120, 50);

        jButton1.setFont(new java.awt.Font("Unispace", 3, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(128, 34, 102));
        jButton1.setText("EXIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(1060, 920, 120, 50);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(null);

        jLabelExit.setFont(new java.awt.Font("Trebuchet MS", 0, 40)); // NOI18N
        jLabelExit.setForeground(new java.awt.Color(255, 255, 255));
        jLabelExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelExit.setText("X");
        jLabelExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelExitMouseClicked(evt);
            }
        });
        jLabelExit.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jLabelExitPropertyChange(evt);
            }
        });
        jPanel2.add(jLabelExit);
        jLabelExit.setBounds(1890, 0, 27, 40);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 1920, 40);

        jLabel_background.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/hangmanArt.png"))); // NOI18N
        getContentPane().add(jLabel_background);
        jLabel_background.setBounds(0, 0, 1920, 1080);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBActionPerformed
        if (gameendFlag == 0) {
            game('b');
        }
    }//GEN-LAST:event_jButtonBActionPerformed

    private void jButtonMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMActionPerformed
        if (gameendFlag == 0) {
            game('m');
        }
    }//GEN-LAST:event_jButtonMActionPerformed

    private void jButtonAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAActionPerformed
        if (gameendFlag == 0) {
            game('a');
        }
    }//GEN-LAST:event_jButtonAActionPerformed

    private void jButtonCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCActionPerformed
        if (gameendFlag == 0) {
            game('c');
        }
    }//GEN-LAST:event_jButtonCActionPerformed

    private void jButtonDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDActionPerformed
        if (gameendFlag == 0) {
            game('d');
        }
    }//GEN-LAST:event_jButtonDActionPerformed

    private void jButtonEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEActionPerformed
        if (gameendFlag == 0) {
            game('e');
        }
    }//GEN-LAST:event_jButtonEActionPerformed

    private void jButtonFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFActionPerformed
        if (gameendFlag == 0) {
            game('f');
        }
    }//GEN-LAST:event_jButtonFActionPerformed

    private void jButtonGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGActionPerformed
        if (gameendFlag == 0) {
            game('g');
        }
    }//GEN-LAST:event_jButtonGActionPerformed

    private void jButtonHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHActionPerformed
        if (gameendFlag == 0) {
            game('h');
        }
    }//GEN-LAST:event_jButtonHActionPerformed

    private void jButtonIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIActionPerformed
        if (gameendFlag == 0) {
            game('i');
        }
    }//GEN-LAST:event_jButtonIActionPerformed

    private void jButtonJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonJActionPerformed
        if (gameendFlag == 0) {
            game('j');
        }
    }//GEN-LAST:event_jButtonJActionPerformed

    private void jButtonKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonKActionPerformed
        if (gameendFlag == 0) {
            game('k');
        }
    }//GEN-LAST:event_jButtonKActionPerformed

    private void jButtonLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLActionPerformed
        if (gameendFlag == 0) {
            game('l');
        }
    }//GEN-LAST:event_jButtonLActionPerformed

    private void jButtonNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNActionPerformed
        if (gameendFlag == 0) {
            game('n');
        }
    }//GEN-LAST:event_jButtonNActionPerformed

    private void jButtonOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOActionPerformed
        if (gameendFlag == 0) {
            game('o');
        }
    }//GEN-LAST:event_jButtonOActionPerformed

    private void jButtonPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPActionPerformed
        if (gameendFlag == 0) {
            game('p');
        }
    }//GEN-LAST:event_jButtonPActionPerformed

    private void jButtonQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQActionPerformed
        if (gameendFlag == 0) {
            game('q');
        }
    }//GEN-LAST:event_jButtonQActionPerformed

    private void jButtonRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRActionPerformed
        if (gameendFlag == 0) {
            game('r');
        }
    }//GEN-LAST:event_jButtonRActionPerformed

    private void jButtonSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSActionPerformed
        if (gameendFlag == 0) {
            game('s');
        }
    }//GEN-LAST:event_jButtonSActionPerformed

    private void jButtonTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTActionPerformed
        if (gameendFlag == 0) {
            game('t');
        }
    }//GEN-LAST:event_jButtonTActionPerformed

    private void jButtonUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUActionPerformed
        if (gameendFlag == 0) {
            game('u');
        }
    }//GEN-LAST:event_jButtonUActionPerformed

    private void jButtonVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVActionPerformed
        if (gameendFlag == 0) {
            game('v');
        }
    }//GEN-LAST:event_jButtonVActionPerformed

    private void jButtonWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonWActionPerformed
        if (gameendFlag == 0) {
            game('w');
        }
    }//GEN-LAST:event_jButtonWActionPerformed

    private void jButtonXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXActionPerformed
        if (gameendFlag == 0) {
            game('x');
        }
    }//GEN-LAST:event_jButtonXActionPerformed

    private void jButtonYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonYActionPerformed
        if (gameendFlag == 0) {
            game('y');
        }
    }//GEN-LAST:event_jButtonYActionPerformed

    private void jButtonZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonZActionPerformed
        if (gameendFlag == 0) {
            game('z');
        }
    }//GEN-LAST:event_jButtonZActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PreparedStatement ps;
        String sql = "UPDATE userinfo SET hangman=? WHERE email = ?";
        try {
            ps = MyConnection.getConnection().prepareStatement(sql);
            ps.setString(8,String.valueOf(score));
        } catch (SQLException ex) {
            Logger.getLogger(HangManGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
        new UserScreen(name).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabelExitPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jLabelExitPropertyChange
        //System.exit(0);
    }//GEN-LAST:event_jLabelExitPropertyChange

    private void jLabelExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabelExitMouseClicked

    private void jButtonResetGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetGameActionPerformed
        score = 0;
        resetGame();
    }//GEN-LAST:event_jButtonResetGameActionPerformed

    public void initializeGame() {
        hg.readWords();
        guess = hg.randomWord();
        //System.out.println(guess);
        amountOfGuesses = 6;//How many times player can guess the word
        playerGuess = new char[guess.length];
        System.out.println("Welcome to game hang man");
        String s = "";
        for (i = 0; i < playerGuess.length; i++) {
            playerGuess[i] = '_';
            s += '_';
            s += ' ';
        }
        jTextFieldOutput.setText(s);
        tries = 0;
        score = guess.length * 2;
        System.out.println("Current guesses:");
        hg.printArray(playerGuess);
        jLabelNotification.setText(String.valueOf(amountOfGuesses - tries) + " tries left");
    }

    void resetGame() {
        hg.readWords();
        guess = hg.randomWord();
        //System.out.println(guess);
        amountOfGuesses = 6;//How many times player can guess the word
        playerGuess = new char[guess.length];
        System.out.println("Welcome to game hang man");
        String s = "";
        for (i = 0; i < playerGuess.length; i++) {
            playerGuess[i] = '_';
            s += '_';
            s += ' ';
        }
        jTextFieldOutput.setText(s);
        tries = 0;
        score += guess.length * 2;
        gameendFlag = 0;
        System.out.println("Current guesses:");
        hg.printArray(playerGuess);
        jLabelNotification.setText(String.valueOf(amountOfGuesses - tries) + " tries left");
        jLabelHint.setText(null);
        jLabel_scoreShow.setText(null);
        jLabel_score.setText(null);

    }

    public void game(char ch) {

        boolean flag = false; //For checking if the guess is correct or wrong
        //System.out.println("Enter a letter");
        char input = ch;
        if (hg.guessWriteOrWrong(playerGuess, guess, input)) //Check if the guess is correct or wrong;
        {
            flag = true;
        }
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
        jLabelNotification.setText(String.valueOf(amountOfGuesses - tries) + " tries left");
        if (hg.isWordGuess(playerGuess, guess)) {
            System.out.println("You won the game");
            jLabelNotification.setText("You won the game");
            tts.setVoice("dfki-poppy-hsmm");
            tts.speak("You won the game", 2.0f, false, false);
            jLabel_scoreShow.setText(String.valueOf(score));
            jLabel_score.setText("Score: ");
            gameendFlag = 1;
            resetGame();

        } else if (!hg.isWordGuess(playerGuess, guess) && tries == amountOfGuesses) {
            System.out.println("You lost the game");
            jLabelNotification.setText("You lost the game");
            tts.setVoice("dfki-poppy-hsmm");
            tts.speak("You lost the game", 2.0f, false, false);
            String answer = new String(guess);
            jLabelHint.setText("The word was: " + answer);
            jLabel_scoreShow.setText("0");
            jLabel_score.setText("Score: ");
            gameendFlag = 1;
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

                new HangManGame().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
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
    private javax.swing.JButton jButtonResetGame;
    private javax.swing.JButton jButtonS;
    private javax.swing.JButton jButtonT;
    private javax.swing.JButton jButtonU;
    private javax.swing.JButton jButtonV;
    private javax.swing.JButton jButtonW;
    private javax.swing.JButton jButtonX;
    private javax.swing.JButton jButtonY;
    private javax.swing.JButton jButtonZ;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelExit;
    private javax.swing.JLabel jLabelHint;
    private javax.swing.JLabel jLabelNotification;
    private javax.swing.JLabel jLabel_background;
    private javax.swing.JLabel jLabel_score;
    private javax.swing.JLabel jLabel_scoreShow;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldOutput;
    // End of variables declaration//GEN-END:variables
}
