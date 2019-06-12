/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smm.moh.graficos;

import java.awt.Color;
import java.awt.Graphics2D;


/**
 *
 * @author eyehalcon97
 */
public abstract class MiRectangularShape extends MiFigura{
        protected boolean rellenado;
        protected Color relleno;
        
        public MiRectangularShape(){
        super();
        rellenado = false;
        relleno = Color.BLACK;
        actualizartransparencia();
        
    }
    public MiRectangularShape(Color Borde,boolean alisar,boolean transparencia,int grosor,boolean rellenado,Color relleno){
        super(Borde,alisar,transparencia,grosor);
        this.rellenado=rellenado;
        this.relleno=relleno;
        actualizartransparencia();
    }
    public MiRectangularShape(MiRectangularShape aux){
        super((MiFigura)aux);
        rellenado=aux.getRellenado();
        relleno=aux.getRelleno();
        actualizartransparencia();
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
        @Override
    public void actualizartransparencia(){
        super.actualizartransparencia();
       if(transparencia){
            relleno = new Color(relleno.getRed(),relleno.getGreen(),relleno.getBlue(),80);
        }else{
            relleno = new Color(relleno.getRed(),relleno.getGreen(),relleno.getBlue());
        }
   }
    
    
        @Override
     public abstract void draw(Graphics2D g2d);
        @Override
    public abstract void drawSelected(Graphics2D g2d);
}
