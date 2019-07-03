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
 * Mi clase manejadora de eventos de audio
 * 
 */
public class ManejadorAudio implements LineListener {   
    
    private javax.swing.JButton botonPlay=null;
    private javax.swing.JButton botonStop=null;
    private javax.swing.JButton botonRecord=null;
    /**
    *
    *   Constructor
    *   @param botonPlay: boton de Play
    *   @param botonStop: boton de Stop
    *   @param botonRecord: boton de grabacion
    */
    public ManejadorAudio(javax.swing.JButton botonPlay,javax.swing.JButton botonStop,javax.swing.JButton botonRecord){
        this.botonPlay=botonPlay;
        this.botonStop=botonStop;
        this.botonRecord=botonRecord;
    }
    /**
    *
    *   actualiza y manda eventos del audio en
    *   funcion de como avanza
    *   @param event: Linea de eventos a la que actualiza
    */
    public void update(LineEvent event) {     
        if (event.getType() == LineEvent.Type.START) {   
            
            botonPlay.setEnabled(false);
            botonStop.setEnabled(true);
            botonRecord.setEnabled(false);
        }     
        if (event.getType() == LineEvent.Type.STOP) {  
            
            botonStop.setEnabled(false);
            botonPlay.setEnabled(true);
            botonRecord.setEnabled(true);
        }          
        if (event.getType() == LineEvent.Type.CLOSE){ 
            
            botonStop.setEnabled(false);
            botonPlay.setEnabled(true);
            botonRecord.setEnabled(true);
        }    

    } 

}