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
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import java.awt.geom.Rectangle2D;

/**
 *
 * @author eyehalcon97
 */
public class MiString extends MiFigura{
    private Line2D forma;
    private String string=null;

    
    public MiString(double x,double y,String string){
        super();
        
        this.forma = new Line2D.Double(x, y,x,y);
        this.string = string;
        actualizartransparencia();
        
        
    }
    public MiString(double x,double y,Color Borde,boolean alisar,boolean transparencia,int grosor,String string){
        super(Borde,alisar,transparencia,grosor);
        this.forma = new Line2D.Double(x, y,x,y);
        this.string = string;
        actualizartransparencia();

    }
    public MiString(MiString aux){
        super((MiFigura)aux);
        forma = aux.getForma();
        string = aux.getString();
        actualizartransparencia();
    }
     public boolean isNear(Point2D p){
        return forma.ptLineDist(p)<=2.0;
    }
    
    
    public boolean contains(Point2D p) {        
        return isNear(p);
    }
    public void setLocation(Point2D pos){
        double dx=pos.getX()-forma.getX1();
        double dy=pos.getY()-forma.getY1();
        Point2D newp2 = new Point2D.Double(forma.getX2()+dx,forma.getY2()+dy);
        forma.setLine(pos,newp2);
        
    }
    
    public void setForma(Line2D forma){
        this.forma=forma;
    }
    
    public Line2D getForma(){
        return forma;
    }
    public void setString(String string){
        this.string=string;
    }
    public String getString(){
        return string;
    }
    
    
    @Override
    public void draw(Graphics2D g2d){
        if(alisar){
            g2d.setRenderingHints(render);
        }
        g2d.setStroke(atributos);

        g2d.setColor(borde);

        g2d.drawString(string,(int) forma.getP1().getX(),(int)forma.getP1().getY());
        
        
    }
    @Override
    public void actualizartransparencia(){
        super.actualizartransparencia();

   }
    
        @Override
    public void drawSelected(Graphics2D g2d) {
        g2d.setColor(new Color(0,0,0,80));
        
        int contador = string.length();
        Point2D p1= new Point2D.Double(forma.getX1(),forma.getY1()+5);
        Point2D p2 = new Point2D.Double(forma.getX2()+(contador*7),forma.getY2()+5);
        Line2D linea= new Line2D.Double(p1,p2);
        
       
        float []dash={6f,2.0f,6.0f};
        g2d.setStroke(new BasicStroke(2,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,5.0f, dash, 0.0f));
         g2d.draw(linea);
    }
        
    
        
}
