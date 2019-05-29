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
import smm.moh.graficos.MiElipse;
import smm.moh.graficos.MiFigura;
import smm.moh.graficos.MiLinea;
import smm.moh.graficos.MiRectangulo;



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
    private MiFigura figura = new MiLinea(pin, pout);
    private Formas forma =null;
    private MiFigura figmod = null;
    private Color borde = Color.BLACK;
    private Color relleno = Color.black;
    private boolean rellenado=false;
    private boolean EDITAR=false;
    private boolean alisar=false;
    private boolean transparencia=false;
    private int grosor =1;
    private int rectangulos=1;
    private int elipses=1;
    private int puntos=1;
    private int lineas=1;
    List<MiFigura> Lista = new ArrayList();
    
    public Lienzo2D() {
        initComponents();
    }

    
    public void paint(Graphics g){
        super.paint(g);
    Graphics2D g2d=(Graphics2D)g;
    pintar(g2d);
        
    }
    
    public void pintar(Graphics2D g2d){
        
            
     
        for(MiFigura s:Lista){
            
            Graphics2D nuevo;
            nuevo = s.Graphics(g2d);
            
            g2d = nuevo;
            
                
            
            if(s instanceof MiRectangulo){
                if(((MiRectangulo)s).getRellenado()==true){
                    g2d.setColor(((MiRectangulo)s).getRelleno());
                g2d.fill((Shape) ((MiRectangulo) s).getForma());
                g2d.setColor(((MiRectangulo)s).getBorde());
                g2d.draw((Shape) ((MiRectangulo) s).getForma());
            }
            else{
                    g2d.setColor(((MiRectangulo)s).getBorde());
                g2d.draw((Shape) ((MiRectangulo) s).getForma());
            }
            }
            if(s instanceof MiElipse){
                if(((MiElipse)s).getRellenado()==true){
                    g2d.setColor(((MiElipse)s).getRelleno());
                g2d.fill((Shape) ((MiElipse) s).getForma());
                g2d.setColor(((MiElipse)s).getBorde());
                g2d.draw((Shape) ((MiElipse) s).getForma());
            }
            else{
                    g2d.setColor(((MiElipse)s).getBorde());
                g2d.draw((Shape) ((MiElipse) s).getForma());
            }
            }
            if(s instanceof MiLinea){
                g2d.setColor(((MiLinea)s).getBorde());
                g2d.draw((Shape) ((MiLinea) s).getForma());
            }
        
            
                
        }  
            
    }
    public void paintfiguras(Graphics g){
        Graphics2D g2d=(Graphics2D)g;
        pintar(g2d);
    }
    public void setBorde(Color color){
        borde = color;
    }
    public Color getBorde(){
        return borde;
    }
    public void setRelleno(Color color){
        relleno = color;
    }
    public Color getRelleno(){
        return relleno;
    }
    public List<MiFigura> GetLista(){
        return Lista;
    }
    public void setFormas(Formas forma){
        this.forma=forma;
    }
    public Formas getForma(){
        return forma;
    }
    public void setRellenado(){
        rellenado = !rellenado;
    }
    public boolean getRellenado(){
        return rellenado;
    }
    public void setAlisar(){
       alisar=!alisar;
    }
    public boolean getAlisar(){
        return alisar;
    }
    
    public void setGrosor(int grosor){
        this.grosor=grosor;
        
    }
    public int getGrosor(){
        return grosor;
    }
    public void setTransparencia(){
        transparencia=!transparencia;
    }
    public boolean getTransparencia(){
        return transparencia;
    }
    
    public void setEditar(String seleccionada){
        EDITAR=true;
        figmod = getSelectedShape(seleccionada);
    }
    
    public void pintar(){
        
        
       
        double x, y;
        double w, h;
        if(null != forma)switch (forma) {
            case PUNTO:
                figura = new MiLinea(pin,pin,borde,alisar,transparencia,grosor);
                
                figura.setName("punto: " + puntos);
                break;
            case LINEA:
                figura = new MiLinea(pin,pout,borde,alisar,transparencia,grosor);
                figura.setName("linea: " + lineas);
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
                
                    figura = new MiRectangulo(x,y, w, h,borde,alisar,transparencia,grosor,rellenado,relleno);
                    figura.setName("Rectangulo: " + rectangulos);
               
                
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
                figura = new MiElipse(x,y, w, h,borde,alisar,transparencia,grosor,rellenado,relleno);
                figura.setName("Elipse: " + elipses);
                break;
            default:
                break;
                
        }
        
        
           repaint();
    }
    
    
    private MiFigura getSelectedShape(String Seleccionada){
    for(MiFigura s:Lista){
        System.out.println(Seleccionada);
        System.out.println("uno");
        System.out.println(((MiFigura)s).toString());
       // System.out.println("");    
    if((((MiFigura)s).toString()).equals(Seleccionada)){
        System.out.println("entro");
        return s;
    }
    //MiLinea line= MiLineas; 
    //((MiLinea) s).contains(p);
         
    }
    
    return null;
    }
    private void actualizar(MiFigura forma,java.awt.event.MouseEvent evt){
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
          
            if(EDITAR){
                
                
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
               if(EDITAR){
                   
                   
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
        if(EDITAR ){
            if(figmod != null){
                    actualizar(figmod,evt);
                    figmod=null;
                    
                }
           // editar();
           
            
        }else{
        Lista.add(figura);
        if(figura instanceof MiLinea){
            if(((MiLinea)figura).EsPunto()==true){
                puntos++;
            }
            else{
                lineas++;
            }
        }
        if(figura instanceof MiRectangulo){
            rectangulos++;
        }
        if(figura instanceof MiElipse){
            elipses++;
        }
        
        }
        pintar();
       
    }//GEN-LAST:event_formMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
