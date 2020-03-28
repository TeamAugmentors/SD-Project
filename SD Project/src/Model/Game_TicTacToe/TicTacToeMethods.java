/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Game_TicTacToe;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class TicTacToeMethods {

    //player and Ai's symbols
    private char player , AI;

    //setting up a fresh board
    public char[][] setUpBoard(char[][] board) {
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j] = '_';
            }
        }
        return board;
    }

    public char getPlayer() {
        return player;
    }

    public void setPlayer(char player) {
        this.player = player;
    }

    public char getAI() {
        return AI;
    }

    public void setAI(char AI) {
        this.AI = AI;
    }
    
    //printing the board
    public void printBoard(char[][] board){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    //checking if any move is left or not
    public boolean isMoveLeft(char[][] board){
        for(int i=0; i<3 ;i++){
            for(int j=0; j<3 ;j++){
                if(board[i][j] == '_')
                    return true;
            }
        }
        return false;
    }
    
    public int evaluate(char[][] board){
        
        //checking rows for victory
        for(int i=0; i<3 ;i++){
            if(board[i][0]==board[i][1] && board[i][1]==board[i][2])
            {
                if(board[i][0] == player)
                    return 10;
                else if(board[i][0] == AI)
                    return -10;
            }
        }
        
        //checking colomns for victory
        for(int i=0; i<3 ;i++){
            if(board[0][i]==board[1][i] && board[1][i]==board[2][i])
            {
                if(board[0][i] == player)
                    return 10;
                else if(board[0][i] == AI)
                    return -10;
            }
        }
        
        //checking diagonals for victory
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2])
        {
            if(board[1][1] == player)
                return 10;
            else if(board[1][1] == AI)
                return -10;
        }
        if(board[0][2] == board[1][1] && board[1][1] == board[2][0])
        {
            if(board[1][1] == player)
                return 10;
            else if(board[1][1] == AI)
                return -10;
        }
        
        //if no one wins
        return 0;
    }
    
    //minimax algorithm, finding all possible moves and returns values
    public int minimax(char[][] board, int depth , boolean isMax){
        int score = evaluate(board);
        
        //if maximizer wins
        if(score == 10)
            return score;
        
        //if minimizer wins
        if(score == -10)
            return score;
        
        //if its a tie
        if(isMoveLeft(board) == false)
            return 0;
        
        //maximizer's move
        if(isMax){
            
            //just a large negative value stored in best
            int best = -1000;
            
            for(int i=0; i<3 ; i++){
                for(int j=0; j<3 ; j++){
                    
                    //checking if the cell is empty or not and finding the move for optimum value
                    if(board[i][j] == '_'){
                        //checking if player puts value here
                        board[i][j] = player;
                        
                        //finding maximum value
                        best = max( best, minimax(board, depth+1 , !isMax) );
                        
                        //undoing the move
                        board[i][j] = '_';
                    }
                }
            }
            return best;
        }
        //minimizer's move
        else{
            //just a large positive value stored in best
            int best = 1000;
            
            for(int i=0; i<3 ; i++){
                for(int j=0; j<3 ; j++){
                    
                    //checking if the cell is empty or not and finding the move 
                    //for optimum value
                    
                    if(board[i][j] == '_'){
                        //checking if AI puts value here
                        board[i][j] = AI;
                        
                        //finding minimum value
                        best = min( best, minimax(board, depth+1 , !isMax) );
                        
                        //undoing the move
                        board[i][j] = '_';
                    }
                }
            }
            return best;
        }
    }
    
    //finding the best move
    public Move findBestMove(char[][] board){
        
        //just a large value to keep the track of best value gained
        int best = 1000;
        Move bestMove = new Move(-1,-1);
        
        //traversing all possible outcomes for minimax and return optimal value
        for(int i=0; i<3 ;i++){
            for(int j=0; j<3 ;j++){
                
                //checking if the cell is empty or not and finding the move 
                //for optimum value among all possible moves
                if(board[i][j] == '_')
                {
                    board[i][j] = AI;
                    
                    //evaluating score for this move
                    int moveValue = minimax(board, 0 , true);
                    
                    //undoing the move
                    board[i][j] = '_' ;
                    
                    //updating value of best move
                    if(moveValue < best){
                        bestMove.setRow(i);
                        bestMove.setCol(j);
                        best = moveValue;
                    }
                }
            }
        }
        return bestMove;
    }
}
