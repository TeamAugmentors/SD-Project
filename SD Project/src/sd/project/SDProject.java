/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd.project;

import JFrame.SmartAssistant;
import Model.TextToSpeech;
import marytts.modules.synthesis.Voice;

/**
 *
 * @author AST
 */
public class SDProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SmartAssistant sm = new SmartAssistant();
        sm.setVisible(true);
        
        
        TextToSpeech tts = new TextToSpeech();
        
        //printing available voices
        //Voice.getAvailableVoices().stream().forEach(System.out::println);
        
        //tts.setVoice("dfki-poppy-hsmm");
        //tts.speak("Welcome! I am Alice. Click next to proceed.", 2.0f, false, false);
    }
    
}
