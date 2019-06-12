/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smm.moh.audio;

import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

/**
 *
 * @author eyehalcon97
 */
public class ManejadorAudio implements LineListener {   
    
    private javax.swing.JButton botonPlay;
    private javax.swing.JButton botonStop;
    
    public ManejadorAudio(javax.swing.JButton botonPlay,javax.swing.JButton botonStop){
        this.botonPlay=botonPlay;
    }
    public void update(LineEvent event) {     
        if (event.getType() == LineEvent.Type.START) {   
            
            botonPlay.setEnabled(false);
            botonStop.setEnabled(true);
        }     
        if (event.getType() == LineEvent.Type.STOP) {  
            
            botonStop.setEnabled(false);
            botonPlay.setEnabled(true);
        }          
        if (event.getType() == LineEvent.Type.CLOSE){ 
            
            botonStop.setEnabled(false);
            botonPlay.setEnabled(true);
        }    

    } 

}