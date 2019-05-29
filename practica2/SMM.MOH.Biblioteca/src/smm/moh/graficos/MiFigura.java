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
import java.awt.Stroke;
import java.awt.geom.Point2D;

/**
 *
 * @author eyehalcon97
 */
public abstract class MiFigura {
    private String name=null;
    private Color Borde;
    private boolean alisar;
    private boolean transparencia;
    private int grosor;
    private RenderingHints render;        
    private Stroke atributos = new BasicStroke(grosor);
    public MiFigura(){
        render = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
       render.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
       this.Borde=new Color(0,0,0,0);
        this.alisar=false;
        this.transparencia=false;
        this.grosor=1;
        this.atributos = new BasicStroke(grosor);
        actualizartransparencia();
        
    }
    public MiFigura(Color Borde,boolean alisar,boolean transparencia,int grosor){
        render = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        render.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        
        this.Borde=Borde;
        this.alisar=alisar;
        this.transparencia=transparencia;
        this.grosor=grosor;
        this.atributos = new BasicStroke(grosor);
        actualizartransparencia();
    }
    public MiFigura(MiFigura aux){
        render = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        render.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        
        this.Borde = aux.getBorde();
        this.alisar = aux.getAlisar();
        this.transparencia=aux.getTransparencia();
        this.grosor=aux.getgrosor();
        this.atributos= new BasicStroke(grosor);
        actualizartransparencia();
    }
    public void setBorde(Color color){
       this.Borde = color;
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
            Borde = new Color(Borde.getRed(),Borde.getGreen(),Borde.getBlue(),80);
        }else{
            Borde = new Color(Borde.getRed(),Borde.getGreen(),Borde.getBlue());
        }
   }
   public void setgrosor(int num){
       this.grosor = num;
       atributos = new BasicStroke(grosor);
   }
   
   public Color getBorde(){
       return Borde;
   }

   public boolean getAlisar(){
       return alisar;
   }
   public boolean getTransparencia(){
       return transparencia;
   }
   public int getgrosor(){
       return grosor;
   }
       
   public Graphics2D Graphics(Graphics2D g2d){
       
        g2d.setColor(Borde);
       
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
}

