/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrame;


import Model.Game_TicTacToe.Move;
import Model.Game_TicTacToe.TicTacToeMethods;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author AST
 */
public class TicTacToe extends javax.swing.JFrame {

    private boolean playerTurn = true;
    private int playerScore = 0 , AIScore = 0;
    private char[][] board = new char[3][3];
    private int result;
    private char player,AI;
    int symbolFlag;
    TicTacToeMethods tic = new TicTacToeMethods();
    
    public TicTacToe() {
    initComponents();
    }
    
    public TicTacToe(String userName) {
        initComponents();
        //making the screen full screen
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        //setting according to the username
        jLabelUsername.setText(userName);
        
        //setting player and AI score of a session
        jLabelUserScore.setText(String.valueOf(playerScore));
        jLabelAIScore.setText(String.valueOf(AIScore));
        
        //setting up a new board
        board = tic.setUpBoard(board);
        
        //hiding all the jLabels or symbols
         clearBoard();
        
    }
    public TicTacToe(String userName,char player,char AI) {
        initComponents();
        //making the screen full screen
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.player=player;
        this.AI=AI;
        tic.setPlayer(player);
        tic.setAI(AI);
        //check the symbol of Ai and player
        if(player=='X')
            symbolFlag=1;
        else if(player=='O')
            symbolFlag=2;
        //setting according to the username
        jLabelUsername.setText(userName);
        
        //setting player and AI score of a session
        jLabelUserScore.setText(String.valueOf(playerScore));
        jLabelAIScore.setText(String.valueOf(AIScore));
        
        //setting up a new board
        board = tic.setUpBoard(board);
        
        //hiding all the jLabels or symbols
         clearBoard();
        
    }
    private void playerMove(int posX, int posY){
        //putting player's choice in the board
        board[posX][posY] = tic.getPlayer();
        
        //showing player's move on jframe
        int x = posX, y = posY;
            //Set player symbol
            if(symbolFlag==1){
            if(x==0 && y==0)
                jLabel1X.setVisible(true);
            if(x==0 && y==1)
                jLabel2X.setVisible(true);
            if(x==0 && y==2)
                jLabel3X.setVisible(true);
            if(x==1 && y==0)
                jLabel4X.setVisible(true);
            if(x==1 && y==1)
                jLabel5X.setVisible(true);
            if(x==1 && y==2)
                jLabel6X.setVisible(true);
            if(x==2 && y==0)
                jLabel7X.setVisible(true);
            if(x==2 && y==1)
                jLabel8X.setVisible(true);
            if(x==2 && y==2)
                jLabel9X.setVisible(true);
            }
            else if(symbolFlag==2){
                if(x==0 && y==0)
                jLabel1O.setVisible(true);
            if(x==0 && y==1)
                jLabel2O.setVisible(true);
            if(x==0 && y==2)
                jLabel3O.setVisible(true);
            if(x==1 && y==0)
                jLabel4O.setVisible(true);
            if(x==1 && y==1)
                jLabel5O.setVisible(true);
            if(x==1 && y==2)
                jLabel6O.setVisible(true);
            if(x==2 && y==0)
                jLabel7O.setVisible(true);
            if(x==2 && y==1)
                jLabel8O.setVisible(true);
            if(x==2 && y==2)
                jLabel9O.setVisible(true);
            }
            
         //------------------------------------------------
            
        //checking result after completing the move
        checkResult();
    }
    private void AIMove(){
        //finding best move for AI
        Move bestMove;
        bestMove = tic.findBestMove(board);
        
        //putting AI's move in the board
        board[bestMove.getRow()][bestMove.getCol()] = tic.getAI();
        
        //showing AI's move on jFrame
        int x = bestMove.getRow(), y = bestMove.getCol();
            if(symbolFlag==1){
            if(x==0 && y==0)
                jLabel1O.setVisible(true);
            if(x==0 && y==1)
                jLabel2O.setVisible(true);
            if(x==0 && y==2)
                jLabel3O.setVisible(true);
            if(x==1 && y==0)
                jLabel4O.setVisible(true);
            if(x==1 && y==1)
                jLabel5O.setVisible(true);
            if(x==1 && y==2)
                jLabel6O.setVisible(true);
            if(x==2 && y==0)
                jLabel7O.setVisible(true);
            if(x==2 && y==1)
                jLabel8O.setVisible(true);
            if(x==2 && y==2)
                jLabel9O.setVisible(true);
            }
            else if(symbolFlag==2){
            if(x==0 && y==0)
                jLabel1X.setVisible(true);
            if(x==0 && y==1)
                jLabel2X.setVisible(true);
            if(x==0 && y==2)
                jLabel3X.setVisible(true);
            if(x==1 && y==0)
                jLabel4X.setVisible(true);
            if(x==1 && y==1)
                jLabel5X.setVisible(true);
            if(x==1 && y==2)
                jLabel6X.setVisible(true);
            if(x==2 && y==0)
                jLabel7X.setVisible(true);
            if(x==2 && y==1)
                jLabel8X.setVisible(true);
            if(x==2 && y==2)
                jLabel9X.setVisible(true);
            }
            
         //------------------------------------------------
            
            
        //checking result after completing the move
        checkResult();
    }
    private void gameStart(int posX, int posY){
        
        //checking if there is any move left to make on the board
        if(tic.isMoveLeft(board)){
            
            //checking if it's the player's turn
            if(playerTurn){
                if(board[posX][posY]=='_'){
                    playerMove(posX,posY);
                    playerTurn = false;
                    
                    //turning off the ability to put another value for player
                    this.setEnabled(false);
                }
                
                //calling the game recursively for the AI to make it's move
                gameStart(0,0);
            }
            else{
                AIMove();
                playerTurn = true;
                
                //turning on the ability to put another move for the player
                this.setEnabled(true);
            }
        }
        else{
            //game ends
            JOptionPane.showMessageDialog(null,"Do you want another match?");
            System.exit(0);
        }
    }
    
    //checking result of the current board
    private void checkResult(){
        
        //evaluating the board at current state
        result = tic.evaluate(board);
        
        //if the player wins
        if(result == 10){
            JOptionPane.showMessageDialog(null, jLabelUsername.getText()+" wins");
            
            //updating player score
            playerScore++;
            jLabelUserScore.setText(String.valueOf(playerScore));
            
            //reseting game
            resetGame();
        }        
        
        //if AI wins
        else if(result == -10){
            JOptionPane.showMessageDialog(null,"AI wins");
            
            //updating AI score
            AIScore++;
            jLabelAIScore.setText(String.valueOf(AIScore));
            
            //reseting game
            resetGame();
        }
        
        //if there is no move left to make in the board
        else if(!tic.isMoveLeft(board)){
            
            JOptionPane.showMessageDialog(null,"TIE GAME!");
            this.setEnabled(true);
        }
        
    }
    
    //clearing the board by hiding the jLabels
    private void clearBoard(){
        jLabel1X.setVisible(false);
        jLabel1O.setVisible(false);
        jLabel2X.setVisible(false);
        jLabel2O.setVisible(false);
        jLabel3X.setVisible(false);
        jLabel3O.setVisible(false);
        jLabel4X.setVisible(false);
        jLabel4O.setVisible(false);
        jLabel5X.setVisible(false);
        jLabel5O.setVisible(false);
        jLabel6X.setVisible(false);
        jLabel6O.setVisible(false);
        jLabel7X.setVisible(false);
        jLabel7O.setVisible(false);
        jLabel8X.setVisible(false);
        jLabel8O.setVisible(false);
        jLabel9X.setVisible(false);
        jLabel9O.setVisible(false);
    }
    
    //restarting game
    private void resetGame(){
        //setting up a new board
        board = tic.setUpBoard(board);
        
        //hiding all the jLabels or symbols
         clearBoard();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBar = new javax.swing.JPanel();
        jLabelExit = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1X = new javax.swing.JLabel();
        jLabel1O = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2X = new javax.swing.JLabel();
        jLabel2O = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3X = new javax.swing.JLabel();
        jLabel3O = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4X = new javax.swing.JLabel();
        jLabel4O = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5X = new javax.swing.JLabel();
        jLabel5O = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6X = new javax.swing.JLabel();
        jLabel6O = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7X = new javax.swing.JLabel();
        jLabel7O = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8X = new javax.swing.JLabel();
        jLabel8O = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel9X = new javax.swing.JLabel();
        jLabel9O = new javax.swing.JLabel();
        jLabelAIScore = new javax.swing.JLabel();
        jLabelUserScore = new javax.swing.JLabel();
        jLabelScore = new javax.swing.JLabel();
        jLabelAI = new javax.swing.JLabel();
        jLabelUsername = new javax.swing.JLabel();
        jLabelBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanelBar.setBackground(new java.awt.Color(51, 51, 51));

        jLabelExit.setFont(new java.awt.Font("Viner Hand ITC", 1, 48)); // NOI18N
        jLabelExit.setForeground(new java.awt.Color(255, 255, 255));
        jLabelExit.setText("X");
        jLabelExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelExitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelBarLayout = new javax.swing.GroupLayout(jPanelBar);
        jPanelBar.setLayout(jPanelBarLayout);
        jPanelBarLayout.setHorizontalGroup(
            jPanelBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBarLayout.createSequentialGroup()
                .addContainerGap(1867, Short.MAX_VALUE)
                .addComponent(jLabelExit)
                .addGap(19, 19, 19))
        );
        jPanelBarLayout.setVerticalGroup(
            jPanelBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelExit, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        getContentPane().add(jPanelBar);
        jPanelBar.setBounds(0, 0, 1920, 80);

        jPanel1.setOpaque(false);
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jLabel1X.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/Alice_tictactoeX.gif"))); // NOI18N

        jLabel1O.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/alice_tictactoeO.gif"))); // NOI18N
        jLabel1O.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1OMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1X, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1O)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1X)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1O)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(520, 170, 300, 280);

        jPanel2.setOpaque(false);
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        jLabel2X.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/Alice_tictactoeX.gif"))); // NOI18N

        jLabel2O.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/alice_tictactoeO.gif"))); // NOI18N
        jLabel2O.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2OMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2O)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel2X, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2O)
                        .addComponent(jLabel2X))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(830, 170, 300, 280);

        jPanel3.setOpaque(false);
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

        jLabel3X.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/Alice_tictactoeX.gif"))); // NOI18N

        jLabel3O.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/alice_tictactoeO.gif"))); // NOI18N
        jLabel3O.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3OMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel3X, javax.swing.GroupLayout.PREFERRED_SIZE, 280, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addComponent(jLabel3O, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(7, 7, 7)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addComponent(jLabel3X, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(8, 8, 8)))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addComponent(jLabel3O, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(8, 8, 8)))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(1140, 170, 300, 280);

        jPanel4.setOpaque(false);
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        jLabel4X.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/Alice_tictactoeX.gif"))); // NOI18N

        jLabel4O.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/alice_tictactoeO.gif"))); // NOI18N
        jLabel4O.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4OMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel4X, javax.swing.GroupLayout.PREFERRED_SIZE, 280, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addComponent(jLabel4O, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(7, 7, 7)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addComponent(jLabel4X, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(8, 8, 8)))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addComponent(jLabel4O, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(8, 8, 8)))
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(530, 470, 280, 280);

        jPanel5.setOpaque(false);
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });

        jLabel5X.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/Alice_tictactoeX.gif"))); // NOI18N

        jLabel5O.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/alice_tictactoeO.gif"))); // NOI18N
        jLabel5O.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5OMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel5X, javax.swing.GroupLayout.PREFERRED_SIZE, 280, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addComponent(jLabel5O, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(7, 7, 7)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addComponent(jLabel5X, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(8, 8, 8)))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addComponent(jLabel5O, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(8, 8, 8)))
        );

        getContentPane().add(jPanel5);
        jPanel5.setBounds(840, 470, 300, 280);

        jPanel6.setOpaque(false);
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });

        jLabel6X.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/Alice_tictactoeX.gif"))); // NOI18N

        jLabel6O.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/alice_tictactoeO.gif"))); // NOI18N
        jLabel6O.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6OMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel6X, javax.swing.GroupLayout.PREFERRED_SIZE, 280, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addComponent(jLabel6O, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(7, 7, 7)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addComponent(jLabel6X, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(8, 8, 8)))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addComponent(jLabel6O, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(8, 8, 8)))
        );

        getContentPane().add(jPanel6);
        jPanel6.setBounds(1140, 470, 280, 280);

        jPanel7.setOpaque(false);
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
        });

        jLabel7X.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/Alice_tictactoeX.gif"))); // NOI18N

        jLabel7O.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/alice_tictactoeO.gif"))); // NOI18N
        jLabel7O.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7OMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel7X, javax.swing.GroupLayout.PREFERRED_SIZE, 280, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addComponent(jLabel7O, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(7, 7, 7)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addComponent(jLabel7X, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(8, 8, 8)))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addComponent(jLabel7O, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(8, 8, 8)))
        );

        getContentPane().add(jPanel7);
        jPanel7.setBounds(530, 780, 280, 280);

        jPanel8.setOpaque(false);
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
        });

        jLabel8X.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/Alice_tictactoeX.gif"))); // NOI18N

        jLabel8O.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/alice_tictactoeO.gif"))); // NOI18N
        jLabel8O.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8OMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel8X, javax.swing.GroupLayout.PREFERRED_SIZE, 280, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addComponent(jLabel8O, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(7, 7, 7)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addComponent(jLabel8X, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(8, 8, 8)))
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addComponent(jLabel8O, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(8, 8, 8)))
        );

        getContentPane().add(jPanel8);
        jPanel8.setBounds(840, 780, 300, 280);

        jPanel9.setOpaque(false);
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
        });

        jLabel9X.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/Alice_tictactoeX.gif"))); // NOI18N

        jLabel9O.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/alice_tictactoeO.gif"))); // NOI18N
        jLabel9O.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9OMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel9X, javax.swing.GroupLayout.PREFERRED_SIZE, 280, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addComponent(jLabel9O, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(7, 7, 7)))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addComponent(jLabel9X, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(8, 8, 8)))
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addComponent(jLabel9O, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(8, 8, 8)))
        );

        getContentPane().add(jPanel9);
        jPanel9.setBounds(1140, 780, 280, 280);

        jLabelAIScore.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); // NOI18N
        jLabelAIScore.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAIScore.setText("0");
        getContentPane().add(jLabelAIScore);
        jLabelAIScore.setBounds(300, 510, 140, 40);

        jLabelUserScore.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); // NOI18N
        jLabelUserScore.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUserScore.setText("0");
        getContentPane().add(jLabelUserScore);
        jLabelUserScore.setBounds(300, 420, 140, 40);

        jLabelScore.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); // NOI18N
        jLabelScore.setForeground(new java.awt.Color(255, 255, 255));
        jLabelScore.setText("Score");
        getContentPane().add(jLabelScore);
        jLabelScore.setBounds(180, 260, 140, 60);

        jLabelAI.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); // NOI18N
        jLabelAI.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAI.setText("ALICE");
        getContentPane().add(jLabelAI);
        jLabelAI.setBounds(60, 510, 150, 40);

        jLabelUsername.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); // NOI18N
        jLabelUsername.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabelUsername);
        jLabelUsername.setBounds(60, 420, 150, 40);

        jLabelBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Images/Alice_tictactoeBoard.gif"))); // NOI18N
        getContentPane().add(jLabelBackground);
        jLabelBackground.setBounds(0, 64, 1920, 1100);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseClicked
        dispose();
    }//GEN-LAST:event_jLabelExitMouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        gameStart(0,2);
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        gameStart(1,0);
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        gameStart(1,1);
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        gameStart(1,2);
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        gameStart(2,0);
    }//GEN-LAST:event_jPanel7MouseClicked

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
        gameStart(2,1);
    }//GEN-LAST:event_jPanel8MouseClicked

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
        gameStart(2,2);
    }//GEN-LAST:event_jPanel9MouseClicked

    private void jLabel3OMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3OMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3OMouseClicked

    private void jLabel4OMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4OMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4OMouseClicked

    private void jLabel5OMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5OMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5OMouseClicked

    private void jLabel6OMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6OMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6OMouseClicked

    private void jLabel7OMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7OMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7OMouseClicked

    private void jLabel8OMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8OMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8OMouseClicked

    private void jLabel9OMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9OMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9OMouseClicked

    private void jLabel1OMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1OMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1OMouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        gameStart(0,0);
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jLabel2OMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2OMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2OMouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        gameStart(0,1);
    }//GEN-LAST:event_jPanel2MouseClicked

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
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicTacToe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1O;
    private javax.swing.JLabel jLabel1X;
    private javax.swing.JLabel jLabel2O;
    private javax.swing.JLabel jLabel2X;
    private javax.swing.JLabel jLabel3O;
    private javax.swing.JLabel jLabel3X;
    private javax.swing.JLabel jLabel4O;
    private javax.swing.JLabel jLabel4X;
    private javax.swing.JLabel jLabel5O;
    private javax.swing.JLabel jLabel5X;
    private javax.swing.JLabel jLabel6O;
    private javax.swing.JLabel jLabel6X;
    private javax.swing.JLabel jLabel7O;
    private javax.swing.JLabel jLabel7X;
    private javax.swing.JLabel jLabel8O;
    private javax.swing.JLabel jLabel8X;
    private javax.swing.JLabel jLabel9O;
    private javax.swing.JLabel jLabel9X;
    private javax.swing.JLabel jLabelAI;
    private javax.swing.JLabel jLabelAIScore;
    private javax.swing.JLabel jLabelBackground;
    private javax.swing.JLabel jLabelExit;
    private javax.swing.JLabel jLabelScore;
    private javax.swing.JLabel jLabelUserScore;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelBar;
    // End of variables declaration//GEN-END:variables
}
