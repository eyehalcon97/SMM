/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smm.moh.graficos;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Point2D;

import java.awt.geom.Rectangle2D;

/**
 *
 * @author eyehalcon97
 * Mi clase rectangulo
 */
public class MiRectangulo extends MiRectangularShape{
    private Rectangle2D forma;

    /**
    *
    * Constructor de la clase rectangularShape
    * @param x: coordenada X
    * @param y: coordenada Y
    * @param h: alto de la figura
    * @param w: ancho de la figura
    * 
    */
    public MiRectangulo(double x,double y,double h,double w){
        super();
        this.forma = new Rectangle2D.Double(x, y, h, w);
        actualizartransparencia();
        
        
    }
    /**
    *
    * Constructor de la clase rectangularShape
    * @param x: coordenada X
    * @param y: coordenada Y
    * @param h: alto de la figura
    * @param w: ancho de la figura
    * @param Borde: Selecciona el borde
    * @param alisar: Selecciona el alisar
    * @param grosor: Selecciona el grosor
    * @param relleno: Selecciona el relleno
    * @param numtrans: Selecciona la transparencia
    * @param degradado: Selecciona el degradado
    * @param deghorizontal: Selecciona el tipo de degradado
    * @param degvertical: Selecciona el tipo de degradado
    * @param rellenado: selecciona si esta rellenado
    * 
    */
    public MiRectangulo(double x,double y,double h,double w,Color Borde,boolean alisar,int grosor,boolean rellenado,Color relleno,int numtrans,Color degradado,boolean deghorizontal,boolean degvertical){
        super(Borde,alisar,grosor,rellenado,relleno,numtrans,degradado,deghorizontal,degvertical);
        
        this.forma = new Rectangle2D.Double(x, y, h, w);
        
        actualizartransparencia();

    }
    /**
    *
    * Constructor copia
    * 
    */
    public MiRectangulo(MiRectangulo aux){
        super((MiRectangularShape)aux);
        forma = aux.getForma();
        actualizartransparencia();
    }
    /**
    *
    * Posiciona la figura en la posicion 
    * seleccionada
    * @param pos: punto donde se posiciona
    * 
    */
    @Override
    public void setLocation(Point2D pos){
        double dx=pos.getX()-(forma.getWidth()/2);
        double dy=pos.getY()-(forma.getHeight()/2);
        this.forma = new Rectangle2D.Double(dx, dy,forma.getWidth(), forma.getHeight());
    }
    /**
    *
    * Consultor de la localizacion de la
    * figura
    * 
    */
    public Point2D getLocation(){
        double dx=forma.getX()+(forma.getWidth()/2);
        double dy=forma.getY()+(forma.getHeight()/2);
        Point2D punto = new Point2D.Double(dx, dy);
        return punto;
    }
    /**
    *
    *   Modificador de la forma
    *   @param forma: la nueva forma
    */
    public void setForma(Rectangle2D forma){
        this.forma=forma;
    }
    /**
    *
    *   Consultor de forma
    */  
    public Rectangle2D getForma(){
        return forma;
    }
    
    /**
    *
    * Dibuja la figura
    * @param g2d: graphics para dibujar la figura
    * 
    */
    @Override
    public void draw(Graphics2D g2d){
        actualizartransparencia();
        GradientPaint grad = null;
        
        
        
            
        if(alisar){
            g2d.setRenderingHints(render);
        }
        g2d.setStroke(atributos);
        if(rellenado){
            if(horizontal){
                grad = new GradientPaint((float)forma.getX(),(float)forma.getY(), relleno, (float)(forma.getCenterX()), (float)forma.getY(),
                degradado);
                g2d.setPaint(grad);
            }else{
                if(vertical){
                    grad = new GradientPaint((float)forma.getX(),(float)forma.getY(), relleno,(float)forma.getX() ,(float)forma.getCenterY() ,
                    degradado);
                    g2d.setPaint(grad);
                }else{
                    g2d.setColor(relleno);
                }
            }
                
                g2d.fill((Shape) (forma));
                
        }
        g2d.setColor(borde);
        g2d.draw((Shape) (forma));
        
        
    }
    /**
    *
    * dibuja el contorno de la figura
    * @param g2d: graphics para dibujar la figura
    * 
    */    
        @Override
    public void drawSelected(Graphics2D g2d) {
        g2d.setColor(new Color(0,0,0,80));
        Rectangle2D aux=forma.getBounds2D();
        Rectangle2D rectangulo =  new Rectangle2D.Double(aux.getX()-10,aux.getY()-10,aux.getWidth()+20,aux.getHeight()+20);
        
       
        float []dash={6f,2.0f,6.0f};
        g2d.setStroke(new BasicStroke(2,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,5.0f, dash, 0.0f));
         g2d.draw(rectangulo);
    }

        
    
        
}
