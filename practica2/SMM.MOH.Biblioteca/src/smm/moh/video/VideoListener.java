/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smm.moh.video;

import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerEventAdapter;

/**
 *
 * @author eyehalcon97
 * Mi clase manejadora de eventos de video
 */
public class VideoListener extends MediaPlayerEventAdapter {
    javax.swing.JButton botonStop;
    javax.swing.JButton botonPlay;
    /**
    *
    *   Constructor
    *   @param botonPlay: boton de Play
    *   @param botonStop: boton de Stop
    *
    */
    public VideoListener(javax.swing.JButton botonStop,javax.swing.JButton botonPlay){
        this.botonPlay=botonPlay;
        this.botonStop=botonStop;
    }
    public void playing(MediaPlayer mediaPlayer) {     
        botonStop.setEnabled(true);    
        botonPlay.setEnabled(false);   
    }            
    public void paused(MediaPlayer mediaPlayer) {     
        botonStop.setEnabled(false);     
        botonPlay.setEnabled(true);   
    }            
    public void finished(MediaPlayer mediaPlayer) {     
        this.paused(mediaPlayer);   
    } 
}