/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smm.moh.graficos;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;


/**
 *
 * @author eyehalcon97
 */
public abstract class MiRectangularShape extends MiFigura{
        protected boolean rellenado;
        protected Color relleno;
        protected Color degradado;
        protected boolean vertical;
        protected boolean horizontal;
        public MiRectangularShape(){
        super();
        rellenado = false;
        relleno = Color.BLACK;
        degradado = Color.WHITE;
        
        
        
        
    }
    public MiRectangularShape(Color Borde,boolean alisar,int grosor,boolean rellenado,Color relleno,int numtrans,Color degradado,boolean deghorizontal,boolean degvertical){
        super(Borde,alisar,grosor,numtrans);
        this.rellenado=rellenado;
        this.relleno=relleno;
        this.degradado=degradado;
        horizontal=deghorizontal;
        vertical=degvertical;
        
    }
    public MiRectangularShape(MiRectangularShape aux){
        super((MiFigura)aux);
        rellenado=aux.getRellenado();
        relleno=aux.getRelleno();
        degradado=aux.getDegradado();
        horizontal=aux.getHorizontal();
        vertical=aux.getVertical();
    }
    
     public boolean getRellenado(){
        return rellenado;
    }
    public void setRellenado(boolean rellenado){
        this.rellenado = rellenado;
    }
    public void setRelleno(Color relleno){
        this.relleno=relleno;
    }
    public Color getRelleno(){
        return relleno;
        
    }
    public boolean getHorizontal(){
        return horizontal;
    }
    public boolean getVertical(){
        return vertical;
    }
    public void setHorizontal(boolean horizontal){
        this.horizontal=horizontal;
    }
    public void setVertical(boolean vertical){
        this.vertical=vertical;
    }
    public Color getDegradado(){
        return degradado;
    }
    public void setDegradado(Color color){
        degradado= color;
    }
        @Override
    public void actualizartransparencia(){
        super.actualizartransparencia();

            relleno = new Color(relleno.getRed(),relleno.getGreen(),relleno.getBlue(),numtrans);
            
   }
    public Graphics2D actualizargradiente(Graphics2D g2d){
        if(horizontal){
                g2d.setPaint(new GradientPaint(200, 0, relleno, 200, 400, degradado));
            }
        if(vertical){
                g2d.setPaint(new GradientPaint(200, 0, relleno, 200, 400, degradado));
            }
        
            return g2d;
    }
    
    
        @Override
     public abstract void draw(Graphics2D g2d);
        @Override
    public abstract void drawSelected(Graphics2D g2d);
}
