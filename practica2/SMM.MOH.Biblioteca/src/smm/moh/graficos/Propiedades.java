/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smm.moh.graficos;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.RenderingHints;
import java.awt.Stroke;

/**
 *
 * @author eyehalcon97
 */
public class Propiedades {
    private Color color;
    private boolean relleno;
    private boolean alisar;
    private boolean transparencia;
    private int numrelleno;
    private RenderingHints render;        
    private Stroke atributos = new BasicStroke(numrelleno);
    
    public Propiedades(){
       render = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
       render.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
       this.color=Color.BLACK;
        this.relleno=false;
        this.alisar=false;
        this.transparencia=false;
        this.numrelleno=1;
        this.atributos = new BasicStroke(numrelleno);
    }
    public Propiedades(Color color,boolean relleno,boolean alisar,boolean transparencia,int numrelleno){
        render = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        render.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        this.color=color;
        this.relleno=relleno;
        this.alisar=alisar;
        this.transparencia=transparencia;
        this.numrelleno=numrelleno;
        this.atributos = new BasicStroke(numrelleno);
    }
    public Propiedades(Propiedades propiedad){
        render = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        render.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        this.color=propiedad.getColor();
        this.relleno=propiedad.getRelleno();
        this.alisar=propiedad.getAlisar();
        this.transparencia=propiedad.getTransparencia();
        this.numrelleno=propiedad.getNumRelleno();
        this.atributos = new BasicStroke(numrelleno);
    }
   public void setColor(Color color){
       this.color = color;
   }
   public void setRelleno(boolean bool){
       this.relleno = bool;
   }
   public void setAlisar(boolean bool){
       this.alisar = bool;
   }
   public void setTransparencia(boolean bool){
      transparencia = bool;
       if(transparencia){
            color = new Color(color.getRed(),color.getGreen(),color.getBlue(),80);
        }else{
            color = new Color(color.getRed(),color.getGreen(),color.getBlue());
        }
   }
   public void setNumrelleno(int num){
       this.numrelleno = num;
       atributos = new BasicStroke(numrelleno);
   }
   
   public Color getColor(){
       return color;
   }
   public boolean getRelleno(){
       return relleno;
   }
   public boolean getAlisar(){
       return alisar;
   }
   public boolean getTransparencia(){
       return transparencia;
   }
   public int getNumRelleno(){
       return numrelleno;
   }
   
}
