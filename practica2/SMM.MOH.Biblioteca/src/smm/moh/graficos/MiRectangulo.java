/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smm.moh.graficos;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Point2D;

import java.awt.geom.Rectangle2D;

/**
 *
 * @author eyehalcon97
 */
public class MiRectangulo extends MiRectangularShape{
    private Rectangle2D forma;

    
    public MiRectangulo(double x,double y,double h,double w){
        super();
        this.forma = new Rectangle2D.Double(x, y, h, w);
        actualizartransparencia();
        
        
    }
    public MiRectangulo(double x,double y,double h,double w,Color Borde,boolean alisar,boolean transparencia,int grosor,boolean rellenado,Color relleno){
        super(Borde,alisar,transparencia,grosor,rellenado,relleno);
        
        this.forma = new Rectangle2D.Double(x, y, h, w);
        
        actualizartransparencia();

    }
    public MiRectangulo(MiRectangulo aux){
        super((MiRectangularShape)aux);
        forma = aux.getForma();
        actualizartransparencia();
    }
    
    @Override
    public void setLocation(Point2D pos){
        double dx=pos.getX()-(forma.getWidth()/2);
        double dy=pos.getY()-(forma.getHeight()/2);
        this.forma = new Rectangle2D.Double(dx, dy,forma.getWidth(), forma.getHeight());
    }
    public Point2D getLocation(){
        double dx=forma.getX()+(forma.getWidth()/2);
        double dy=forma.getY()+(forma.getHeight()/2);
        Point2D punto = new Point2D.Double(dx, dy);
        return punto;
    }
    
    public void setForma(Rectangle2D forma){
        this.forma=forma;
    }
    
    public Rectangle2D getForma(){
        return forma;
    }
    
    
    @Override
    public void draw(Graphics2D g2d){
        if(alisar){
            g2d.setRenderingHints(render);
        }
        g2d.setStroke(atributos);
        if(rellenado){
                g2d.setColor(relleno);
                g2d.fill((Shape) (forma));
                
        }
        g2d.setColor(borde);
        g2d.draw((Shape) (forma));
        
        
    }
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
