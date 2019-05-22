/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smm.moh.graficos;


import java.awt.geom.Point2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author eyehalcon97
 */
public class MiRectangulo extends Rectangle2D.Double{
    private Propiedades propiedad;
    public MiRectangulo(double x,double y,double h,double w){
        super(x,y,h,w);
        propiedad = new Propiedades();
    }
    public MiRectangulo(double x,double y,double h,double w,Propiedades propiedad){
        super(x,y,h,w);
        propiedad = this.propiedad;
    }
    public void setLocation(Point2D pos){
        double dx=pos.getX()-(this.width/2);
        double dy=pos.getY()-(this.height/2);
        this.x = dx;
        this.y = dy;       
    }
    public void setPropiedad(Propiedades propiedad){
        this.propiedad=propiedad;
    }
    public Propiedades getPropiedad(){
        return propiedad;
    }
        
}
