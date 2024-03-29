
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import java.awt.BorderLayout;

import java.awt.Dimension;

import java.awt.image.BufferedImage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eyehalcon97
 */
public class VentanaInternaCamara extends VentanaMultimedia {

    /**
     * Creates new form VentanaInternaCamara
     */

    private Webcam camara = null; 
    /**
    * 
    * Constructor
    * @param frame: VentanaPrincipal al que pertenece
    * 
    */
    public VentanaInternaCamara(VentanaPrincipal frame) {   
        super(frame);
        inicializar();
    }
    /**
    * 
    * Inicializa la camara y el panel de ella
    * 
    */
    public void inicializar(){
        initComponents();   
        camara = Webcam.getDefault();   
        Dimension resoluciones[] = camara.getViewSizes(); 
        Dimension maxRes = resoluciones[resoluciones.length-1]; 
        camara.setViewSize(maxRes); 
        if (camara != null) {               
            WebcamPanel areaVisual = new WebcamPanel(camara);  
            if (areaVisual!= null) {       
               jPanel1.add(areaVisual,BorderLayout.CENTER);                      
                pack();  
            }
        }
    }
    /**
    * 
    * Constructor por defecto
    * 
    */
    public VentanaInternaCamara(){
        inicializar();
    }
    /**
    * 
    * Funcion que permite no crear el panel si el dispositivo
    * no tiene camara
    * 
    */
    public static VentanaInternaCamara getInstance(){   
        VentanaInternaCamara v = new VentanaInternaCamara();   
        return (v.camara!=null?v:null); 
    }
    @Override
    public void stop(){
        cuadro.nuevaCam();
        camara.close();
        this.setVisible(false);
    }
    @Override
    public BufferedImage getImagen(){
        return camara.getImage();
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
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // TODO add your handling code here:
        stop();
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
