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
    @Override   
    public void update(LineEvent event) {     
        if (event.getType() == LineEvent.Type.START) {           
        }     
        if (event.getType() == LineEvent.Type.STOP) {     
        }                 
        if (event.getType() == LineEvent.Type.CLOSE) {     
        }   
    } 
}