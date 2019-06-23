/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smm.moh.iu;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import smm.moh.graficos.MiElipse;
import smm.moh.graficos.MiFigura;
import smm.moh.graficos.MiLinea;
import smm.moh.graficos.MiRectangulo;
import smm.moh.graficos.MiString;




/**
/**
 *
 * @author eyehalcon97
 * Clase lienzo
 */
public class Lienzo2D extends javax.swing.JPanel {

    /**
     * Creates new form Lienzo2D
     */
    
    private Point2D pin = new Point2D.Double(-10, -10);
    private Point2D pout = new Point2D.Double(-10, -10);
    private MiFigura figura = new MiLinea(pin,pin);
    private Formas forma =null;
    private MiFigura figmod = null;
    private Color borde = Color.BLACK;
    private Color relleno = Color.black;
    private boolean rellenado=false;
    private boolean EDITAR=false;
    private boolean alisar=false;
    private int grosor =1;
    private int rectangulos=1;
    private int elipses=1;
    private int puntos=1;
    private int lineas=1;
    private int strings=1;
    protected int vertical=0;
    protected int horizontal=0;
    private boolean deghorizontal=false;
    private boolean degvertical=false;
    private boolean discontinua=false;
    private int numtrans=255;
    private Color degradado=Color.WHITE;
    private String string=null;
    List<MiFigura> Lista = new ArrayList();
    Graphics2D g2d;

    /**
    * 
    * Constructor por defecto
    * 
    */
    public Lienzo2D(){
        initComponents();
    }
    /**
    * 
    * Constructor
    * @param vertical: tamaño del lienzo vertical
    * @param horizontal:tamaño del lienzo horizontal
    * 
    */
    public Lienzo2D(int vertical,int horizontal) {
        initComponents();
        this.vertical=vertical;
        this.horizontal=horizontal;
        
    }
    /**
    * 
    * Consultor de vertical
    * 
    */
    public int getVertical(){
        return vertical;
    }
    /**
    * 
    * Consultor de horizontal
    * 
    */
    public int getHorizontal(){
        return horizontal;
    }
    /**
    * 
    * Consultor de discontinua de trazo
    * 
    */
    public boolean getDiscontinua(){
        return discontinua;
    }
    /**
    * 
    * Modificador de discontinua del trazo
    * 
    */
    public void setDiscontinua(boolean discontinua){
        this.discontinua=discontinua;
    }
    /**
    * 
    * Metodo para pintar el componente
    * @param  g: graphics para pintarlo
    * Recorre el vector de las figuras y pinta
    * todas ellas, si una esta seleccionada para 
    * editar, dibuja su contorno
    * 
    */
    public void paint(Graphics g){
        super.paint(g);
        g2d=(Graphics2D)g;
        g2d.clipRect(0,0,horizontal,vertical);
        figura.draw(g2d);
        
        
        for(MiFigura s:Lista){
            s.draw(g2d);
            if(EDITAR){
                figmod.drawSelected(g2d);
            }
        }
        
        
    }
    /**
    * 
    * Modificador de Borde
    * @param color: el nuevo color del borde
    * 
    */
    public void setBorde(Color color){
        borde = color;
    }
    /**
    * 
    * Consultor de Borde
    * 
    */
    public Color getBorde(){
        return borde;
    }
    /**
    * 
    * Modificador de degradado vertical
    * @param degvertical: activa o desactiva el degradado
    * Solo puede haber un tipo de degradado por lo
    * que desactiva el otro degradado
    * 
    */
    public void setdegvertical(boolean degvertical){
        this.degvertical = degvertical;
        if(degvertical){
            deghorizontal=false;
        }
    }
    /**
    * 
    * Modificador de degradado horizontal
    * @param deghorizontal: activa o desactiva el degradado
    * Solo puede haber un tipo de degradado por lo
    * que desactiva el otro degradado
    */
    public void setdeghorizontal(boolean deghorizontal){
        this.deghorizontal = deghorizontal;
        if(deghorizontal){
            degvertical=false;
        }
    }
    /**
    * 
    * Consultor de degradado vertical
    * 
    */
    public boolean getdegvertical(){
        return degvertical;
    }
    /**
    * 
    * Consultor de degradado horizontal
    * 
    */
    public boolean getdeghorizontal(){
        return deghorizontal;
    }
    /**
    * 
    * Modificador del Relleno
    * @param color: color del relleno
    * 
    */
    public void setRelleno(Color color){
        relleno = color;
    }
    /**
    * 
    * Consultor de Relleno
    * 
    */
    public Color getRelleno(){
        return relleno;
    }
    /**
    * 
    * Consultor de la lista de figuras
    *
    */
    public List<MiFigura> GetLista(){
        return Lista;
    }
    /**
    * 
    * Modificador de la lista de figuras
    * @param lista: la nueva lista
    *
    */
    public void setLista(List<MiFigura> lista){
        this.Lista = lista;
    }
    /**
    * 
    * Modificador de la lista de figuras
    * @param forma: la nueva forma
    *
    */
    public void setFormas(Formas forma){
        EDITAR = false;
        this.forma=forma;
    }
    /**
    * 
    * Consultor de forma
    * 
    */
    public Formas getForma(){
        return forma;
    }
    /**
    * 
    * Consultor de forma
    * 
    */
    public void setRellenado(boolean rellenado){
        this.rellenado = rellenado;
    }
    /**
    * 
    * Consultor de Rellenado
    * 
    */
    public boolean getRellenado(){
        return rellenado;
    }
    /**
    * 
    * Modificador del degradado
    * @param degradado: el nuevo color del degradado
    *
    */
    public void setDegradado(Color degradado){
        this.degradado=degradado;
    }
    /**
    * 
    * Consultor de degradado
    * 
    */
    public Color getDegradado(){
        return degradado;
    }
    /**
    * 
    * Modificador de alisar
    * @param alisar: el nuevo alisar
    *
    */
    public void setAlisar(boolean alisar){
       this.alisar=alisar;
    }
    /**
    * 
    * Consultor de Alisar
    * 
    */
    public boolean getAlisar(){
        return alisar;
    }
    /**
    * 
    * Modificador de la variable string
    * @param string: string a modificar
    */
    public void setString(String string){
        this.string = string;
       
    }
    /**
    *
    * Consultor de la variable string
    * 
    */
    public String getString(){
        return string;
    }
    /**
    * 
    * Modificador del numero de transparencia
    * @param numtrans: nuevo numero de transparencia
    *
    */
    public void setNumtrans(int numtrans){
       this.numtrans = numtrans;
   }
    /**
    * 
    * Consultor de numero transparencia
    * 
    */
   public int getNumtrans(){
       return numtrans;
   }
    /**
    * 
    * Modificador del grosor
    * @param grosor: numero de nuevo grosor
    *
    */
    public void setGrosor(int grosor){
        this.grosor=grosor;
        
    }
    /**
    * 
    * Consultor del grosor
    * 
    */
    public int getGrosor(){
        return grosor;
    }

    /**
    * 
    * Modificador de Editar
    * @param seleccionada: valor de la nueva Editar
    * pone Editar a true para que se vea la figura 
    * a editar
    *
    */
    public void setEditar(int seleccionada){
        EDITAR=true;
        figmod = Lista.get(seleccionada);
        repaint();
    }
     /**
    * 
    * Metodo que pinta una figura sobre el lienzo
    * 
    *
    */
    public void pintar(){
        
        
       
        double x, y;
        double w, h;
        if(null != forma)switch (forma) {
            case PUNTO:
                figura = new MiLinea(pin,pin,borde,alisar,grosor,numtrans,discontinua);
                
                figura.setName("punto: " + puntos);
                break;
            case LINEA:
                figura = new MiLinea(pin,pout,borde,alisar,grosor,numtrans,discontinua);
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
                    
                    figura = new MiRectangulo(x,y, w, h,borde,alisar,grosor,rellenado,relleno,numtrans,degradado,deghorizontal,degvertical,discontinua);
                    
                    figura.setName("Rectangulo: " + rectangulos);
               
                
                break;
            case STRING:
                if(string !=null){
                figura = new MiString(pin.getX(),pin.getY(),borde,alisar,grosor,string,numtrans,discontinua);
                figura.setName("String: " + strings);
                }

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
                figura = new MiElipse(x,y, w, h,borde,alisar,grosor,rellenado,relleno,numtrans,degradado,deghorizontal,degvertical,discontinua);
                figura.setName("Elipse: " + elipses);
                break;
            default:
                break;
              
        }
        
        
           repaint();
    }
    
  
     /**
    * Metodo para mover la figura por el lienzo
    * @param forma: la figura que movemos
    * @param evt: el evento del mouse donde se movera
    *
    */
    
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

    }//GEN-LAST:event_formMouseDragged

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
            
    }//GEN-LAST:event_formMouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
               pin=new Point2D.Float(evt.getX(),evt.getY());
               if(EDITAR){
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
                    
                    
                }
           
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
        if(figura instanceof MiString){
            strings++;
        }
        }
        pintar();
        repaint();
       
    }//GEN-LAST:event_formMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
