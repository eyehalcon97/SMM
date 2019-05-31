/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smm.moh.graficos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Point2D;

/**
 *
 * @author eyehalcon97
 */
public abstract class MiFigura {
    private String name=null;
    private Color borde;
    private boolean alisar;
    private boolean transparencia;
    private int grosor;
    private RenderingHints render;        
    private Stroke atributos = new BasicStroke(grosor);
    public MiFigura(){
        render = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
       render.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
       this.borde=new Color(0,0,0,0);
        this.alisar=false;
        this.transparencia=false;
        this.grosor=1;
        this.atributos = new BasicStroke(grosor);
        actualizartransparencia();
        
    }
    public MiFigura(Color borde,boolean alisar,boolean transparencia,int grosor){
        render = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        render.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        
        this.borde=borde;
        this.alisar=alisar;
        this.transparencia=transparencia;
        this.grosor=grosor;
        this.atributos = new BasicStroke(grosor);
        actualizartransparencia();
    }
    public MiFigura(MiFigura aux){
        render = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        render.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        
        this.borde = aux.getBorde();
        this.alisar = aux.getAlisar();
        this.transparencia=aux.getTransparencia();
        this.grosor=aux.getGrosor();
        this.atributos= new BasicStroke(grosor);
        actualizartransparencia();
    }
    public void setBorde(Color color){
       this.borde = color;
   }
   
   public void setAlisar(boolean bool){
       this.alisar = bool;
   }
   public void setTransparencia(boolean bool){
      transparencia = bool;
      actualizartransparencia();
       
   }
   private void actualizartransparencia(){
       if(transparencia){
            borde = new Color(borde.getRed(),borde.getGreen(),borde.getBlue(),80);
        }else{
            borde = new Color(borde.getRed(),borde.getGreen(),borde.getBlue());
        }
   }
   public void setGrosor(int num){
       this.grosor = num;
       atributos = new BasicStroke(grosor);
   }
   
   public Color getBorde(){
       return borde;
   }

   public boolean getAlisar(){
       return alisar;
   }
   public boolean getTransparencia(){
       return transparencia;
   }
   public int getGrosor(){
       return grosor;
   }
       
   public Graphics2D Graphics(Graphics2D g2d){
       
        g2d.setColor(borde);
       
    if(alisar){
        g2d.setRenderingHints(render);
    }
    
        g2d.setStroke(atributos);
    return g2d;
    }
    public abstract void setLocation(Point2D pos);
    public void setName(String name){
        this.name = name;
    }
    public String toString(){
        return name;
    }
    public abstract void draw(Graphics2D g2d);
}

