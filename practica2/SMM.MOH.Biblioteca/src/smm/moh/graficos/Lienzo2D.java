/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smm.moh.graficos;

import java.awt.BasicStroke;
import smm.moh.iu.Formas;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

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
    private Shape figura = new Line2D.Double(pin, pout);
    private Color color = new Color(0,0,0,0);
    private Formas forma;
    private Shape figmod = null;
    private boolean relleno = false;
    private boolean alisar = false;
    private boolean transparencia = false;
    private int numrelleno = 1;
   
    List<Shape> vShape = new ArrayList();
    private RenderingHints render;
    private Stroke atributos = new BasicStroke(numrelleno);
    
    public Lienzo2D() {
        initComponents();
    }
    
    public void paint(Graphics g){
        super.paint(g);
    Graphics2D g2d=(Graphics2D)g;
    pintar(g2d);
        
    }
    
    public void pintar(Graphics2D g2d){
        g2d.setColor(color);
    
    if(alisar){
        g2d.setRenderingHints(render);
    }
    
        g2d.setStroke(atributos);
    
    
    if(relleno){
            g2d.fill(figura);
            g2d.draw(figura);
        }else{
            g2d.draw(figura);
        }
    
        for(Shape s:vShape){
            if(relleno){
            g2d.fill(s);
            g2d.draw(s);
            }else{
                g2d.draw(s);
            }
        }
    }
    public void paintfiguras(Graphics g){
        Graphics2D g2d=(Graphics2D)g;
        pintar(g2d);
    }
    public void setColor(Color color){
        this.color = color;
        pintar();
        
    }
    public void setFormas(Formas forma){
        this.forma=forma;
    }
    public void setRelleno(){
        relleno = !relleno;
        pintar();
    }
    public void setAlisar(){
       alisar = !alisar;
       pintar();
    }
    
    public void setNumrelleno(int num){
        numrelleno = num;
        pintar();
    }
    public void setTransparencia(){
        transparencia = !transparencia;
        pintar();
    }
    
    public void pintar(){
        
        if(transparencia){
            
            color = new Color(color.getRed(),color.getGreen(),color.getBlue(),80);
            
        }else{
            color = new Color(color.getRed(),color.getGreen(),color.getBlue());
        }

        double x, y;
        double w, h;
        if(null != forma)switch (forma) {
            case PUNTO:
                figura = new MiLinea(pin,pin);
                break;
            case LINEA:
                figura = new MiLinea(pin,pout);
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
                
                    figura = new Rectangle((int)x,(int) y,(int) w,(int) h);
                    
               
                
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
                figura = new MiElipse(x,y, w, h);
                break;
            default:
                break;
                
        }
        
        if(alisar){
            
            render = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            render.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        }
        
            atributos = new BasicStroke(numrelleno);
        
           repaint();
    }
    
    
    private Shape getSelectedShape(Point2D p){
    for(Shape s:vShape){

       // System.out.println("");    
    if(s.contains(p)){
        
        return s;
    }
    //MiLinea line= MiLineas; 
    //((MiLinea) s).contains(p);
         
    }
    
    return null;
    }
    private void actualizar(Shape forma,java.awt.event.MouseEvent evt){
        if(forma != null){
            if(forma.getClass().getName() == Rectangle.class.getName()){
                ((Rectangle) forma).setLocation(evt.getPoint());
            }
            if(forma.getClass().getName() == MiElipse.class.getName()){
                ((MiElipse) forma).setLocation(evt.getPoint());
            }
            if(forma.getClass().getName() == MiLinea.class.getName()){
                ((MiLinea) forma).setLocation(evt.getPoint());   
            }
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
                    figura = new Line2D.Double(pin, pout);
            
            
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
        vShape.add(figura);
        
        }
        pintar();
       
    }//GEN-LAST:event_formMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
