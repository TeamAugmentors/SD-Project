/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd.project;

import JFrame.SmartAssistant;
import application.TextToSpeech;

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
        
        //tts.setVoice("cmu-slt-hsmm");
        //tts.speak("Welcome to the Application! Please click the button below to proceed.", 1.0f, false, false);
    }
    
}
