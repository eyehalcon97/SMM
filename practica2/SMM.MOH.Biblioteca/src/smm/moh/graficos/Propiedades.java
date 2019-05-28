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

/**
 *
 * @author eyehalcon97
 */
public class Propiedades {
    private String Nombre;
    private Color Borde;
    private Color Relleno;
    private boolean relleno;
    private boolean alisar;
    private boolean transparencia;
    private int numrelleno;
    private RenderingHints render;        
    private Stroke atributos = new BasicStroke(numrelleno);
    
    public Propiedades(){
       render = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
       render.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
       this.Nombre = null;
       this.Borde=new Color(0,0,0,0);
       this.Relleno=new Color(0,0,0,0);
        this.relleno=false;
        this.alisar=false;
        this.transparencia=false;
        this.numrelleno=1;
        this.atributos = new BasicStroke(numrelleno);
        actualizartransparencia();
    }
    public Propiedades(String Nombre,Color Borde,Color Relleno,boolean relleno,boolean alisar,boolean transparencia,int numrelleno){
        render = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        render.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        this.Nombre=Nombre;
        this.Borde=Borde;
        this.Relleno=Relleno;
        this.relleno=relleno;
        this.alisar=alisar;
        this.transparencia=transparencia;
        this.numrelleno=numrelleno;
        this.atributos = new BasicStroke(numrelleno);
        actualizartransparencia();
    }
    public Propiedades(Propiedades propiedad){
        render = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        render.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        this.Nombre = propiedad.getNombre();
        this.Borde=propiedad.getBorde();
        this.Relleno=propiedad.getRelleno();
        this.relleno=propiedad.getRellenado();
        this.alisar=propiedad.getAlisar();
        this.transparencia=propiedad.getTransparencia();
        this.numrelleno=propiedad.getNumRelleno();
        this.atributos = new BasicStroke(numrelleno);
        actualizartransparencia();
    }
   public void setBorde(Color color){
       this.Borde = color;
   }
   public void setRelleno(Color color){
       this.Relleno = color;
   }
   public void setRelleno(boolean bool){
       this.relleno = bool;
   }
   public void setAlisar(boolean bool){
       this.alisar = bool;
   }
   public void setTransparencia(boolean bool){
      transparencia = bool;
      actualizartransparencia();
       
   }
   public void setNombre(String Nombre){
       this.Nombre = Nombre;
   }
   private void actualizartransparencia(){
       if(transparencia){
            Borde = new Color(Borde.getRed(),Borde.getGreen(),Borde.getBlue(),80);
            Relleno = new Color(Relleno.getRed(),Relleno.getGreen(),Relleno.getBlue(),80);
        }else{
            Borde = new Color(Borde.getRed(),Borde.getGreen(),Borde.getBlue());
            Relleno = new Color(Relleno.getRed(),Relleno.getGreen(),Relleno.getBlue());
        }
   }
   public void setNumrelleno(int num){
       this.numrelleno = num;
       atributos = new BasicStroke(numrelleno);
   }
   
   public Color getBorde(){
       return Borde;
   }
   public Color getRelleno(){
       return Relleno;
   }
   public boolean getRellenado(){
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
   
   public String getNombre(){
       return Nombre;
   }
       
   public Graphics2D Graphics(Graphics2D g2d){
       
        g2d.setColor(Borde);
       
    if(alisar){
        g2d.setRenderingHints(render);
    }
    
        g2d.setStroke(atributos);
    return g2d;
   }
}
