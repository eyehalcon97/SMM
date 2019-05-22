/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smm.moh.iu;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import smm.moh.graficos.Figura;
import smm.moh.graficos.MiElipse;
import smm.moh.graficos.MiLinea;
import smm.moh.graficos.MiRectangulo;
import smm.moh.graficos.Propiedades;


/**
/**
 *
 * @author eyehalcon97
 */
public class Lienzo2D extends javax.swing.JPanel {

    /**
     * Creates new form Lienzo2D
     */
    
    private Point2D pin = new Point2D.Double(-10, -10);
    private Point2D pout = new Point2D.Double(-10, -10);
    private Figura figura = new MiLinea(pin, pout);
    private Formas forma;
    private Figura figmod = null;
    private Propiedades propiedad = new Propiedades();
   
    List<Figura> Lista = new ArrayList();
    
    public Lienzo2D() {
        initComponents();
    }
    public Propiedades getPropiedad(){
        return propiedad;
    }
    public void setPropiedades(Propiedades propiedad){
        this.propiedad = propiedad;
    }
    
    public void paint(Graphics g){
        super.paint(g);
    Graphics2D g2d=(Graphics2D)g;
    pintar(g2d);
        
    }
    
    public void pintar(Graphics2D g2d){
        
            
     
        for(Figura s:Lista){
            
            Graphics2D nuevo;
            nuevo =s.getPropiedad().Graphics(g2d);
            g2d = nuevo;
            
                
            
            if(s.getPropiedad().getRelleno()){
               
            g2d.fill((Shape) s);
            g2d.draw((Shape) s);
            }else{
                g2d.draw((Shape) s);
            }
        }
        g2d = propiedad.Graphics(g2d);
            
                
            
            if(propiedad.getRelleno()){
               
            g2d.fill((Shape) figura);
            g2d.draw((Shape) figura);
            }else{
                g2d.draw((Shape) figura);
            }
    }
    public void paintfiguras(Graphics g){
        Graphics2D g2d=(Graphics2D)g;
        pintar(g2d);
    }
    public void setColor(Color color){
        this.propiedad.setColor(color);
        
        
    }
    public void setFormas(Formas forma){
        this.forma=forma;
    }
    public void setRelleno(){
        propiedad.setRelleno(!this.propiedad.getRelleno());
        
    }
    public void setAlisar(){
        propiedad.setAlisar(!this.propiedad.getAlisar());
       
    }
    
    public void setNumrelleno(int num){
        propiedad.setNumrelleno(num);
        
    }
    public void setTransparencia(){
        propiedad.setTransparencia(!this.propiedad.getTransparencia());
        
    }
    
    public void pintar(){
        
        Propiedades prop = new Propiedades(propiedad);
       
        double x, y;
        double w, h;
        if(null != forma)switch (forma) {
            case PUNTO:
                figura = new MiLinea(pin,pin,prop);
                break;
            case LINEA:
                figura = new MiLinea(pin,pout,prop);
                break;
            case RECTANGULO:
                if(pin.getX() > pout.getX()){
                x = pout.getX();
                w = pin.getX() - pout.getX();
                }else{
                    x = pin.getX();
                    w = pout.getX() - pin.getX();
                }
             
                if(pin.getY() > pout.getY()){
                    y = pout.getY();
                    h = pin.getY() - pout.getY();
                    }else{
                        y = pin.getY();
                    h = pout.getY() - pin.getY();
                }
                
                    figura = new MiRectangulo(x,y, w, h,prop);
                    
               
                
                break;
                
            case ELIPSE:
                if(pin.getX() > pout.getX()){
                x = pout.getX();
                w = pin.getX() - pout.getX();
                }else{
                    x = pin.getX();
                    w = pout.getX() - pin.getX();
                }
             
                if(pin.getY() > pout.getY()){
                    y = pout.getY();
                    h = pin.getY() - pout.getY();
                    }else{
                        y = pin.getY();
                    h = pout.getY() - pin.getY();
                }
                figura = new MiElipse(x,y, w, h,prop);
                break;
            default:
                break;
                
        }
        
        
           repaint();
    }
    
    
    private Figura getSelectedShape(Point2D p){
    for(Figura s:Lista){

       // System.out.println("");    
    if(((Shape)s).contains(p)){
        
        return s;
    }
    //MiLinea line= MiLineas; 
    //((MiLinea) s).contains(p);
         
    }
    
    return null;
    }
    private void actualizar(Figura forma,java.awt.event.MouseEvent evt){
        if(forma != null){
                forma.setLocation(evt.getPoint());
        }
    }
    
                          

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
          pout=new Point2D.Float(evt.getX(),evt.getY());
          
            if(forma == Formas.EDITAR){
                
                
                actualizar(figmod,evt);
               

            }
            
            pintar();
            
        //figmod = null;
    }//GEN-LAST:event_formMouseDragged

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
            
    }//GEN-LAST:event_formMouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
               pin=new Point2D.Float(evt.getX(),evt.getY());
               if(forma == Formas.EDITAR){
                   figmod = getSelectedShape(pin);
                   
            //editar();
            actualizar(figmod,evt);
            pin = new Point2D.Double(-10, -10);
                    pout = new Point2D.Double(-10, -10);
                    figura = new MiLinea(pin, pout);
            
            
                }else{
                   
               }
       pintar();
       
       
    }//GEN-LAST:event_formMousePressed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved

    }//GEN-LAST:event_formMouseMoved

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        // TODO add your handling code here:
        pout=new Point2D.Float(evt.getX(),evt.getY());
        if(forma == Formas.EDITAR ){
            if(figmod != null){
                    actualizar(figmod,evt);
                    figmod=null;
                    
                }
           // editar();
           
            
        }else{
        Lista.add(figura);
        
        
        }
        pintar();
       
    }//GEN-LAST:event_formMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
