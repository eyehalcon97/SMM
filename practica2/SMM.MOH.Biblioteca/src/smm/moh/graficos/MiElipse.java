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
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

/**
 *
 * @author eyehalcon97
 * Mi clase Elipse
 */

public class MiElipse extends MiRectangularShape{
    private Ellipse2D forma;
    /**
    *
    * Constructor de la clase rectangularShape
    * @param x: coordenada X
    * @param y: coordenada Y
    * @param h: alto de la figura
    * @param w: ancho de la figura
    * 
    */
    public MiElipse(double x,double y,double h,double w){
        super();
        this.forma = new Ellipse2D.Double(x, y, h, w);
        rellenado = false;
        relleno = Color.BLACK;

        
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
    * @param discontinua: Selecciona el trazado
    * 
    */
    public MiElipse(double x,double y,double h,double w,Color Borde,boolean alisar,int grosor,boolean rellenado,Color relleno,int numtrans,Color degradado,boolean deghorizontal,boolean degvertical,boolean discontinua){
        super(Borde,alisar,grosor,rellenado,relleno,numtrans,degradado, deghorizontal, degvertical,discontinua);
        this.forma = new Ellipse2D.Double(x, y, h, w);

    }
    /**
    *
    * Constructor copia
    * @param aux: Segundo objeto MiElipse
    * 
    */
    public MiElipse(MiElipse aux){
        super((MiRectangularShape)aux);
        forma = aux.getForma();
        rellenado=aux.getRellenado();
        relleno=aux.getRelleno();

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
        this.forma = new Ellipse2D.Double(dx, dy,forma.getWidth(), forma.getHeight());      
    }
    /**
    *
    * Consultor de la localizacion de la
    * figura
    * @return Punto medio de la figura
    * 
    */
    @Override
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
    public void setForma(Ellipse2D forma){
        this.forma = forma;
    }
            
    /**
    *
    *   Consultor de forma
    * @return la forma
    * 
    */
    public Ellipse2D getForma(){
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
        
         if(discontinua){
             System.out.println("hooo");
            float []dash={6f,2.0f,6.0f};
            g2d.setStroke(new BasicStroke(grosor,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,5.0f, dash, 0.0f));
        }
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
        float []dash={6f,2.0f,6.0f};
        g2d.setStroke(new BasicStroke(2,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,5.0f, dash, 0.0f));
        g2d.draw(forma.getBounds2D());
        
    }
}