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
 * Mi clase figura
 */
public abstract class MiFigura {
    private String name=null;
    protected Color borde;
    protected boolean alisar;
    protected int grosor;
    protected RenderingHints render;        
    protected Stroke atributos = new BasicStroke(grosor);
    protected int numtrans=255;
    protected boolean discontinua=false;
    /**
    *
    * Contructor por defecto de la clase MiFigura
    * Inicializa todas las variables
    */
    public MiFigura(){
        render = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
       render.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
       this.borde=new Color(0,0,0,0);
        this.alisar=false;
        this.grosor=1;
        this.atributos = new BasicStroke(grosor);
        this.numtrans=255;
        this.discontinua=false;
        
        
    }
    /**
    *
    * Contructor de la clase MiFigura
    *   @param borde: Color del borde
    *   @param alisar: booleano de alisar
    *   @param grosor: grosor de la figura
    *   @param numtrans: numero de la transparencia
    *   @param discontinua: Selecciona el trazado
    * 
    */    
    public MiFigura(Color borde,boolean alisar,int grosor,int numtrans,boolean discontinua){
        render = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        render.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        
        this.borde=borde;
        this.alisar=alisar;

        this.grosor=grosor;
        this.atributos = new BasicStroke(grosor);
        this.numtrans=numtrans;
        this.discontinua=discontinua;
    }
    /**
    *
    * Constructor copia
    * @param aux: Segundo objeto del constructor
    * 
    */
    public MiFigura(MiFigura aux){
        render = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        render.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        
        this.borde = aux.getBorde();
        this.alisar = aux.getAlisar();
        this.grosor=aux.getGrosor();
        this.atributos= new BasicStroke(grosor);
        this.numtrans = aux.getNumtrans();
    }
    /**
    *
    * Modificador de Borde
    * @param color: el nuevo color del borde
    */
    public void setBorde(Color color){
       this.borde = color;
   }
    /**
    *
    * Modificador de Alisar
    * @param bool: el nuevo valor de alisar
    */
   public void setAlisar(boolean bool){
       this.alisar = bool;
   }
   /**
    *
    * Modificador de Numtrans
    * @param numtrans: el nuevo valor de transparencia
    */
   public void setNumtrans(int numtrans){
       this.numtrans = numtrans;
   }
    /**
    *
    * Colsultor de transparencia
    * @return numero de transparencia
    * 
    */
   public int getNumtrans(){
       return numtrans;
   }
    /**
    *
    * Colsultor de discontinua
    * @return booleano discontinua
    * 
    */
   public boolean getDiscontinua(){
       return discontinua;
   }
    /**
    *
    * Modificador de discontinua
    * @param discontinua: nuevo valor
    * 
    */
   public void setDiscontinua(boolean discontinua){
       this.discontinua=discontinua;
   }
   /**
    *
    * Modifica el color con la nueva transparencia
    * 
    */
   public void actualizartransparencia(){
            borde = new Color(borde.getRed(),borde.getGreen(),borde.getBlue(),numtrans);

   }
    /**
    *
    * Modificador del grosor
    * @param num: el valor del grosor
    */
   public void setGrosor(int num){
       this.grosor = num;
       atributos = new BasicStroke(grosor);
   }
    /**
    *
    * Colsultor de Borde
    * @return Color del borde
    * 
    */
   public Color getBorde(){
       return borde;
   }
    /**
    *
    * Colsultor de Alisar
    * @return boleano de alisar
    * 
    */
   public boolean getAlisar(){
       return alisar;
   }
    /**
    *
    * Colsultor de grosor
    * @return numero de grosor
    * 
    */
   public int getGrosor(){
       return grosor;
   }
    /**
    *
    * Posiciona la figura en la posicion 
    * seleccionada
    * @param pos: punto donde se posiciona
    * 
    */
    public abstract void setLocation(Point2D pos);
    /**
    *
    * Modificador del nombre de la figura
    * @param name: el nombre a modificar
    */
    public void setName(String name){
        this.name = name;
    }
    @Override
    /**
    *
    * Devuelve el nombre de la figura
    * 
    */
    public String toString(){
        return name;
    }
    /**
    *
    * Consultor de la localizacion de la
    * figura
    * @return Punto medio de la figura
    * 
    */
    public abstract Point2D getLocation();
    /**
    *
    * Dibuja la figura
    * @param g2d: graphics para dibujar la figura
    * 
    */
    public abstract void draw(Graphics2D g2d);
    /**
    *
    * dibuja el contorno de la figura
    * @param g2d: graphics para dibujar la figura
    * 
    */
    public abstract void drawSelected(Graphics2D g2d);
 
}

