/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smm.moh.graficos;

import java.awt.BasicStroke;
import java.awt.Color;

import java.awt.Graphics2D;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
/*
 * @author eyehalcon97
 */
public class MiElipse extends MiFigura{
    private Ellipse2D forma;
    private boolean rellenado;
    private Color relleno;
    public MiElipse(double x,double y,double h,double w){
        super();
        this.forma = new Ellipse2D.Double(x, y, h, w);
        rellenado = false;
        relleno = Color.BLACK;
        actualizartransparencia();
        
    }
    public MiElipse(double x,double y,double h,double w,Color Borde,boolean alisar,boolean transparencia,int grosor,boolean rellenado,Color relleno){
        super(Borde,alisar,transparencia,grosor);
        this.forma = new Ellipse2D.Double(x, y, h, w);
        this.rellenado=rellenado;
        this.relleno=relleno;
        actualizartransparencia();
    }
    public MiElipse(MiElipse aux){
        super((MiFigura)aux);
        forma = aux.getForma();
        rellenado=aux.getRellenado();
        relleno=aux.getRelleno();
        actualizartransparencia();
    }
    
    public void setLocation(Point2D pos){
        double dx=pos.getX()-(forma.getWidth()/2);
        double dy=pos.getY()-(forma.getHeight()/2);
        this.forma = new Ellipse2D.Double(dx, dy,forma.getWidth(), forma.getHeight());      
    }
    public void setForma(Ellipse2D forma){
        this.forma = forma;
    }
    public Ellipse2D getForma(){
        return forma;
    }
    public boolean getRellenado(){
        return rellenado;
    }
    public void getRellenado(boolean rellenado){
        this.rellenado = rellenado;
    }
    public void setRelleno(Color relleno){
        this.relleno=relleno;
    }
    public Color getRelleno(){
        return relleno;
        
    }
    public void draw(Graphics2D g2d){
        g2d.setStroke(atributos);
        if(getRellenado()==true){
            g2d.setColor(relleno);
            g2d.fill((Shape) (forma));
        }
        else{
            g2d.setColor(getBorde());
            g2d.draw((Shape)forma);
        }
    }
    public void actualizartransparencia(){
       super.actualizartransparencia();
       if(transparencia){
            relleno = new Color(relleno.getRed(),relleno.getGreen(),relleno.getBlue(),80);
        }else{
            relleno = new Color(relleno.getRed(),relleno.getGreen(),relleno.getBlue());
        }
   }
    @Override
    public void drawSelected(Graphics2D g2d) {
        g2d.setColor(new Color(0,0,0,80));
        float []dash={6f,2.0f,6.0f};
        g2d.setStroke(new BasicStroke(super.getGrosor(),BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,5.0f, dash, 0.0f));
        g2d.draw(forma.getBounds2D());
        
        
    }
        
    
}