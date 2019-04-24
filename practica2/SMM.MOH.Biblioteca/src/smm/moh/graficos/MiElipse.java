/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smm.moh.graficos;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
/*
 * @author eyehalcon97
 */
public class MiElipse extends Ellipse2D.Double{
    
    MiElipse(double x,double y,double h,double w){
        super(x,y,h,w);
    }
    public void setLocation(Point2D pos){
        double dx=pos.getX()-(this.width/2);
        double dy=pos.getY()-(this.height/2);
        this.x = dx;
        this.y = dy;       
    }
    
}