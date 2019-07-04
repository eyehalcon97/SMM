
import java.awt.image.BufferedImage;
import java.io.File;
import smm.moh.video.VideoListener;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.MediaPlayerEventListener;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eyehalcon97
 */
public class VentanaVideo extends VentanaMultimedia {

    /**
     * Creates new form VentanaVideo
     * 
     */

    
    private EmbeddedMediaPlayer video=null;
    private File fMedia;
    private javax.swing.JButton botonStop;
    private javax.swing.JButton botonPlay;
     /**
      * 
     * Contructor por defecto
     * 
     */
    public VentanaVideo() {
        super();
    }
    /**
     * 
     * Segundo constructor
     * @param frame: VentanaPrincipal a la que pertenece
     * @param f: Archivo que se reproduce
     * @param botonStop: boton de parar
     * @param botonPlay: boton de reproducir
     * 
     */
    public VentanaVideo(VentanaPrincipal frame,File f,javax.swing.JButton botonStop,javax.swing.JButton botonPlay) {
        super(frame);
        
        
        this.botonPlay=botonPlay;
        this.botonStop=botonStop;
        botonPlay.setEnabled(true);
        initComponents();
        fMedia = f;   
        EmbeddedMediaPlayerComponent aVisual = new EmbeddedMediaPlayerComponent();    
        jPanel1.add(aVisual,java.awt.BorderLayout.CENTER);    

        video = aVisual.getMediaPlayer();
        video.addMediaPlayerEventListener(new VideoListener(botonStop,botonPlay));
        
        
    }
    /**
    * 
    * Inicia la reproduccion por el principio o por donde se
    * haya pausado
    * 
    */
    public void play() {   
        if (video != null) {     
            if(video.isPlayable()){       //Si se estaba reproduciendo       
                video.play();     
            } else {
                
                video.playMedia(fMedia.getAbsolutePath());     
            }   
        }         
    } 
    /**
    * 
    * Pausa la reproduccion
    * 
    */
    @Override
    public void stop() {   
        if (video != null) {     
            if (video.isPlaying()) {       
                video.pause();     
            } else {       
                video.stop();     
            }   
        }         
    }
     /**
     * 
     * Establece el manejador de eventos de video
     * @param ml:el manejador que se asigna al video
     * 
     */
    public void addMediaPlayerEventListener(MediaPlayerEventListener ml) {  
        if (video != null) {     
            video.addMediaPlayerEventListener(ml);   
        } 
    } 

    @Override
    public BufferedImage getImagen(){
       
        return video.getSnapshot();
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // TODO add your handling code here:
                cuadro.actualizarControlador();
    }//GEN-LAST:event_formInternalFrameActivated
    /**
    * 
    * Consultor del boton Play
    * @return botonPlay: boton de reproducir
    * 
    */
    public javax.swing.JButton getBotonPlay(){
         if (video.isPlaying()) {
             botonPlay.setEnabled(false);
         }
        return botonPlay;
    }
    /**
    * 
    * Consultor del boton Stop
    * @return botonStop: boton de parar
    * 
    */
        public javax.swing.JButton getBotonStop(){
         if (video.isPlaying()) {
             botonStop.setEnabled(true);
         }
        return botonStop;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
