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
            botonPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/stop24x24.png")));
            botonPlay.setVisible(false);
            botonStop.setVisible(true);
        }     
        if (event.getType() == LineEvent.Type.STOP) {  
            botonPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/play24x24.png")));
            botonStop.setVisible(false);
            botonPlay.setVisible(true);
        }                 

    } 

}