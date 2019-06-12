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
    protected Color borde;
    protected boolean alisar;
    private int grosor;
    protected RenderingHints render;        
    protected Stroke atributos = new BasicStroke(grosor);
    protected int numtrans=100;
    public MiFigura(){
        render = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
       render.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
       this.borde=new Color(0,0,0,0);
        this.alisar=false;
        this.grosor=1;
        this.atributos = new BasicStroke(grosor);
        this.numtrans=100;
        
        
    }
    public MiFigura(Color borde,boolean alisar,int grosor,int numtrans){
        render = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        render.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        
        this.borde=borde;
        this.alisar=alisar;

        this.grosor=grosor;
        this.atributos = new BasicStroke(grosor);
        this.numtrans=numtrans;
        
    }
    public MiFigura(MiFigura aux){
        render = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        render.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        
        this.borde = aux.getBorde();
        this.alisar = aux.getAlisar();
        this.grosor=aux.getGrosor();
        this.atributos= new BasicStroke(grosor);
        this.numtrans = aux.getNumtrans();
    }
    public void setBorde(Color color){
       this.borde = color;
   }
   
   public void setAlisar(boolean bool){
       this.alisar = bool;
   }

   public void setNumtrans(int numtrans){
       this.numtrans = numtrans;
   }
   public int getNumtrans(){
       return numtrans;
   }
   public void actualizartransparencia(){
            borde = new Color(borde.getRed(),borde.getGreen(),borde.getBlue(),numtrans);

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

   public int getGrosor(){
       return grosor;
   }
       
    public abstract void setLocation(Point2D pos);
    public void setName(String name){
        this.name = name;
    }
    @Override
    public String toString(){
        return name;
    }
    public abstract Point2D getLocation();
    public abstract void draw(Graphics2D g2d);
    public abstract void drawSelected(Graphics2D g2d);
 
}

