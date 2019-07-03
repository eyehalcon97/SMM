





/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author eyehalcon97
 * Clase que gestiona las ventanas internas
 */
public class VentanaLienzo extends VentanaInterna {

    /**
     * Creates new form VentanaInterna
     */
    private int vertical=100;
    private int horizontal=100;
    /**
    *
    * Constructor por defecto
    */
    public VentanaLienzo() {
        initComponents();
    }
    /**
    *
    * Constructor
    * @param cuadro: Ventana a la que pertenece
    * @param vertical: tamaño del lienzo vertical
    * @param horizontal: tamaño del lienzo horizontal
    */
    public VentanaLienzo(VentanaPrincipal cuadro,int vertical,int horizontal){
        super(cuadro);
        this.vertical=vertical;
        this.horizontal=horizontal;
        
        initComponents();
        actualizardesplazable();
    }
    /**
    *
    * Consultor de vertical
    * @return El valor del vertical
    * 
    */
    public int getVertical(){
        return vertical;
    }
    /**
    *
    * Consultor de Horizontal
    * @return El valor de la horizontal
    * 
    */
    public int getHorizontal(){
        return horizontal;
    }
    /**
    *
    * Consultor del lienzo
    * @return Lienzo
    * 
    */
    public smm.moh.iu.LienzoImagen2D getLienzoImagen(){
        return lienzoImagen2D1;
    }
    
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lienzoImagen2D1 = new smm.moh.iu.LienzoImagen2D(vertical,horizontal);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setAutoscrolls(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
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

        jScrollPane1.setAutoscrolls(true);

        lienzoImagen2D1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lienzoImagen2D1MouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lienzoImagen2D1MouseMoved(evt);
            }
        });
        lienzoImagen2D1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lienzoImagen2D1MouseEntered(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lienzoImagen2D1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout lienzoImagen2D1Layout = new javax.swing.GroupLayout(lienzoImagen2D1);
        lienzoImagen2D1.setLayout(lienzoImagen2D1Layout);
        lienzoImagen2D1Layout.setHorizontalGroup(
            lienzoImagen2D1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        lienzoImagen2D1Layout.setVerticalGroup(
            lienzoImagen2D1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(lienzoImagen2D1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // TODO add your handling code here:
        actualizardesplazable();
        
        cuadro.actualizarframe();
        
        
        
    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        // TODO add your handling code here:
        cuadro.actualizarframe();
        
    }//GEN-LAST:event_formInternalFrameClosed

    private void lienzoImagen2D1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lienzoImagen2D1MouseReleased
        // TODO add your handling code here:
        int figura = cuadro.figuraactual();
        cuadro.actualizarframe();
        cuadro.Seleccionarfigura(figura);
        
    }//GEN-LAST:event_lienzoImagen2D1MouseReleased

    private void lienzoImagen2D1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lienzoImagen2D1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lienzoImagen2D1MouseEntered

    private void lienzoImagen2D1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lienzoImagen2D1MouseMoved
        // TODO add your handling code here:
        cuadro.actualizarpuntero(evt.getX(), evt.getY());
    }//GEN-LAST:event_lienzoImagen2D1MouseMoved

    private void lienzoImagen2D1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lienzoImagen2D1MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_lienzoImagen2D1MouseDragged
    /**
    *
    * Actualiza el tamaño de los desplazables de la ventana al tamaño del lienzo
    * 
    */
    public void actualizardesplazable(){
        
        javax.swing.GroupLayout lienzoImagen2D1Layout = new javax.swing.GroupLayout(lienzoImagen2D1);
        lienzoImagen2D1.setLayout(lienzoImagen2D1Layout);
        lienzoImagen2D1Layout.setHorizontalGroup(
            lienzoImagen2D1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, lienzoImagen2D1.getImagen(false).getWidth(), Short.MAX_VALUE)
        );
        lienzoImagen2D1Layout.setVerticalGroup(
            lienzoImagen2D1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, lienzoImagen2D1.getImagen(false).getHeight(), Short.MAX_VALUE)
        );
    
        
        jScrollPane1.setViewportView(lienzoImagen2D1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        pack();
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private smm.moh.iu.LienzoImagen2D lienzoImagen2D1;
    // End of variables declaration//GEN-END:variables
}
