/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SnakeGame.music;

import com.sun.jmx.remote.internal.ClientNotifForwarder;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Lassassin
 */
public class MusicPlayer {

    public static MusicPlayer player = new MusicPlayer();
    public static Clip clip;

    private MusicPlayer() {
    }

    public static MusicPlayer getInstance() {
        return player;
    }

    public static void loadMusic(String filePath) {

        try {
            File musicPath = new File(filePath);

            AudioInputStream audioInput;

            audioInput = AudioSystem.getAudioInputStream(musicPath);
            clip = AudioSystem.getClip();
            clip.open(audioInput);

            System.out.println("initialized");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
    
    
    public static void loadMusic(File file) {

        try {
            File musicPath = file;

            AudioInputStream audioInput;

            audioInput = AudioSystem.getAudioInputStream(musicPath);
            clip = AudioSystem.getClip();
            clip.open(audioInput);

            System.out.println("initialized");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

}
