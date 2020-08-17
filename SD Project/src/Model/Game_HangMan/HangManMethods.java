/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Game_HangMan;

/**
 *
 * @author Atiqur Rahman
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HangManMethods {

    Random random=new Random();
    ArrayList<String> words = new ArrayList<String>();
    public void readWords() throws FileNotFoundException {
        File file = new File("resources/Hangman/Words.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        try {
            while ((st = br.readLine()) != null) {
                words.add(st);
            }
        } catch (IOException ex) {
            Logger.getLogger(HangMan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public char[] randomWord()
    {
        char[] randomWordGuess=words.get(random.nextInt(words.size())).toCharArray();
        return randomWordGuess;
    }
    public void printArray(char[] word)
    {
        for(int i=0;i<word.length;i++)
            System.out.print(word[i]+" ");
        System.out.println("");
    }
    public char[] matchLetter(char[] playerWord,char[] randomWord,char input)
    {
        for(int i=0;i<randomWord.length;i++)
        {
            if(randomWord[i]==input && playerWord[i]=='_'){
                playerWord[i]=input;
            }
        }
        return playerWord;
    }
    public boolean isWordGuess(char[] playerWord,char[] randomWord)
    {
        boolean flag=true;
        for(int i=0;i<randomWord.length;i++)
        {
            if(playerWord[i]!=randomWord[i])
            {
                flag=false;
                break;
            }
        }
        return flag;
    }
    public boolean guessWriteOrWrong(char[] playerWord,char[] randomWord,char input)
    {
        boolean flag=false;
        for(int i=0;i<randomWord.length;i++)
        {
            if(randomWord[i]==input && playerWord[i]=='_'){
                flag=true;
                break;
            }
        }
        return flag;
    }

    private static class HangMan {

        public HangMan() {
        }
    }
}
