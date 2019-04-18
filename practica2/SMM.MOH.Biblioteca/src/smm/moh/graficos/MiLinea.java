/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smm.moh.graficos;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 *
 * @author eyehalcon97
 */
public class MiLinea extends Line2D.Double{

    
    
    
    public boolean isNear(Point2D p){
        return this.ptLineDist(p)<=2.0;
    }
    
    @Override
    public boolean contains(Point2D p) {        
                    System.out.println("gjgjgjgjgj");
        
        return isNear(p);
    }

    public void setLocation(Point2D pos){
        double dx=pos.getX()-this.getX1();
        double dy=pos.getY()-this.getY1();
        Point2D newp2 = new Point2D.Double(this.getX2()+dx,this.getY2()+dy);
        this.setLine(pos,newp2);
    }

}
