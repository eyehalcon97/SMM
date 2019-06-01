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

/**
 *
 * @author eyehalcon97
 */
public class MiLinea extends MiFigura{
    private Line2D forma;
    
    public MiLinea(Point2D pd, Point2D pd1){
        super();
        forma = new Line2D.Double(pd, pd1);
        actualizartransparencia();
    }
    public MiLinea(Point2D pd, Point2D pd1,Color Borde,boolean alisar,boolean transparencia,int grosor){
        super(Borde,alisar,transparencia,grosor);
        forma = new Line2D.Double(pd, pd1);
        actualizartransparencia();
    }
    public MiLinea(MiLinea aux){
        super((MiFigura)aux);
        forma=aux.getForma();
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

    public boolean EsPunto(){
        boolean resultado=false;
        if(forma.getP1()==forma.getP2()){
            resultado=true;
        }
        return resultado;
    }
    public boolean EsLinea(){
        boolean resultado=false;
        if(forma.getP1()!=forma.getP2()){
            resultado=true;
        }
        return resultado;
    }
    public void draw(Graphics2D g2d){
        g2d.setStroke(atributos);
        g2d.setColor(getBorde());
        g2d.draw((Shape)forma);
    }

    @Override
    public void drawSelected(Graphics2D g2d) {
        g2d.draw(forma.getBounds2D());
    }
}
