/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smm.moh.graficos;


import java.awt.Color;
import java.awt.geom.Point2D;

import java.awt.geom.Rectangle2D;

/**
 *
 * @author eyehalcon97
 */
public class MiRectangulo extends MiFigura{
    private Rectangle2D forma;
    private boolean rellenado;
    private Color relleno;
    
    public MiRectangulo(double x,double y,double h,double w){
        super();
        this.forma = new Rectangle2D.Double(x, y, h, w);
        this.rellenado=false;
        this.relleno=Color.BLACK;
        
    }
    public MiRectangulo(double x,double y,double h,double w,Color Borde,boolean alisar,boolean transparencia,int grosor,boolean rellenado,Color relleno){
        super(Borde,alisar,transparencia,grosor);
        this.forma = new Rectangle2D.Double(x, y, h, w);
        this.rellenado=rellenado;
        this.relleno = relleno;
    }
    public MiRectangulo(MiRectangulo aux){
        super((MiFigura)aux);
        forma = aux.getForma();
        rellenado=aux.getRellenado();
        relleno=aux.getRelleno();
    }
    
    public void setLocation(Point2D pos){
        double dx=pos.getX()-(forma.getWidth()/2);
        double dy=pos.getY()-(forma.getHeight()/2);
        this.forma = new Rectangle2D.Double(dx, dy,forma.getHeight(), forma.getWidth());
        
    }
    
    public void setForma(Rectangle2D forma){
        this.forma=forma;
    }
    
    public Rectangle2D getForma(){
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
        
}
