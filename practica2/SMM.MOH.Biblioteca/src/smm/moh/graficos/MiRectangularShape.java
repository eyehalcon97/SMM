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
 * Mi clase Mi rectangularShape
 * reune los atributos y las funciones de MiRectangulo
 * y MiElipse
 */
public abstract class MiRectangularShape extends MiFigura{
        protected boolean rellenado;
        protected Color relleno;
        protected Color degradado;
        protected boolean vertical;
        protected boolean horizontal;
        
    /**
     *Contructor por defecto
     */
    public MiRectangularShape(){
        super();
        rellenado = false;
        relleno = Color.BLACK;
        degradado = Color.WHITE;
    }
    /**
    *
    * Constructor de la clase rectangularShape
    * @param Borde: Selecciona el borde
    * @param alisar: Selecciona el alisar
    * @param grosor: Selecciona el grosor
    * @param relleno: Selecciona el relleno
    * @param numtrans: Selecciona la transparencia
    * @param degradado: Selecciona el degradado
    * @param deghorizontal: Selecciona el tipo de degradado
    * @param degvertical: Selecciona el tipo de degradado
    * @param discontinua: Selecciona el trazado
    * @param rellenado: Selecciona el rellenado
    * 
    */
    public MiRectangularShape(Color Borde,boolean alisar,int grosor,boolean rellenado,Color relleno,int numtrans,Color degradado,boolean deghorizontal,boolean degvertical,boolean discontinua){
        super(Borde,alisar,grosor,numtrans,discontinua);
        this.rellenado=rellenado;
        this.relleno=relleno;
        this.degradado=degradado;
        horizontal=deghorizontal;
        vertical=degvertical;
        
    }
    /**
    *
    * Constructor copia
    * @param aux: Segundo objeto del constructor
    * 
    */
    public MiRectangularShape(MiRectangularShape aux){
        super((MiFigura)aux);
        rellenado=aux.getRellenado();
        relleno=aux.getRelleno();
        degradado=aux.getDegradado();
        horizontal=aux.getHorizontal();
        vertical=aux.getVertical();
    }
    /**
    *
    *   Consultor de rellenado
    * Devuelve true si esta relleando
    * @return booleano de rellenado
    */
     public boolean getRellenado(){
        return rellenado;
    }
    /**
    *
    *   Modificador de rellenado
    *   @param rellenado: el nuevo rellenado
    */
    public void setRellenado(boolean rellenado){
        this.rellenado = rellenado;
    }
    /**
    *
    *   Modificador de relleno
    *   @param relleno: el color de relleno
    */
    public void setRelleno(Color relleno){
        this.relleno=relleno;
    }
    /**
    *
    *   Consultor de relleno
    * @return color de relleno
    */
    public Color getRelleno(){
        return relleno;
        
    }
    /**
    *
    *   Consultor de horizontal
    * @return bool degradado horizontal
    * 
    */
    public boolean getHorizontal(){
        return horizontal;
    }
    /**
    *
    *   Consultor de vertical
    * @return bool degradado vertical
    * 
    */
    public boolean getVertical(){
        return vertical;
    }
    /**
    *
    *   Modificador de horizontal
    *   @param horizontal: bool a introducir
    * 
    */
    public void setHorizontal(boolean horizontal){
        this.horizontal=horizontal;
        if(horizontal ==true){
            vertical=false;
        }
    }
    /**
    *
    *   Modificador de vertical
    *   @param vertical: bool a introducir
    * 
    */
    public void setVertical(boolean vertical){
        this.vertical=vertical;
        if(vertical ==true){
            horizontal = false;
        }
    }
    /**
    *
    *   Consultor de degradado
    * @return color de degradado
    * 
    */
    public Color getDegradado(){
        return degradado;
    }
    /**
    *
    *   Modificador de degradado
    *   @param color: color de degradado
    * 
    */
    public void setDegradado(Color color){
        degradado= color;
    }
        
    /**
    *
    *   Actualiza el color con las transparencia
    */
    @Override
    public void actualizartransparencia(){
        super.actualizartransparencia();

            relleno = new Color(relleno.getRed(),relleno.getGreen(),relleno.getBlue(),numtrans);
            degradado = new Color(degradado.getRed(),degradado.getGreen(),degradado.getBlue(),numtrans);
   }

    /**
    *
    * Dibuja la figura
    * @param g2d: graphics para dibujar la figura
    * 
    */    
        @Override
     public abstract void draw(Graphics2D g2d);
    /**
    *
    * dibuja el contorno de la figura
    * @param g2d: graphics para dibujar la figura
    * 
    */  
        @Override
    public abstract void drawSelected(Graphics2D g2d);
}
