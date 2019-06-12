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
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
/*
 * @author eyehalcon97
 */
public class MiElipse extends MiRectangularShape{
    private Ellipse2D forma;
    public MiElipse(double x,double y,double h,double w){
        super();
        this.forma = new Ellipse2D.Double(x, y, h, w);
        rellenado = false;
        relleno = Color.BLACK;

        
    }
    public MiElipse(double x,double y,double h,double w,Color Borde,boolean alisar,int grosor,boolean rellenado,Color relleno,int numtrans,Color degradado,boolean deghorizontal,boolean degvertical){
        super(Borde,alisar,grosor,rellenado,relleno,numtrans,degradado, deghorizontal, degvertical);
        this.forma = new Ellipse2D.Double(x, y, h, w);

    }
    public MiElipse(MiElipse aux){
        super((MiRectangularShape)aux);
        forma = aux.getForma();
        rellenado=aux.getRellenado();
        relleno=aux.getRelleno();

    }
    
    @Override
    public void setLocation(Point2D pos){
        double dx=pos.getX()-(forma.getWidth()/2);
        double dy=pos.getY()-(forma.getHeight()/2);
        this.forma = new Ellipse2D.Double(dx, dy,forma.getWidth(), forma.getHeight());      
    }
    @Override
    public Point2D getLocation(){
        double dx=forma.getX()+(forma.getWidth()/2);
        double dy=forma.getY()+(forma.getHeight()/2);
        Point2D punto = new Point2D.Double(dx, dy);
        return punto;
    }
    public void setForma(Ellipse2D forma){
        this.forma = forma;
    }
    public Ellipse2D getForma(){
        return forma;
    }
 
    @Override
    public void draw(Graphics2D g2d){
        actualizartransparencia();
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
        float []dash={6f,2.0f,6.0f};
        g2d.setStroke(new BasicStroke(2,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,5.0f, dash, 0.0f));
        g2d.draw(forma.getBounds2D());
        
    }
}