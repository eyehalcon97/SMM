/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smm.moh.graficos;

import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
/*
 * @author eyehalcon97
 */
public class MiElipse extends MiFigura{
    private Ellipse2D forma;
    private boolean rellenado;
    private Color relleno;
    public MiElipse(double x,double y,double h,double w){
        super();
        this.forma = new Ellipse2D.Double(x, y, h, w);
        rellenado = false;
        relleno = Color.BLACK;
        
    }
    public MiElipse(double x,double y,double h,double w,Color Borde,boolean alisar,boolean transparencia,int grosor,boolean rellenado,Color relleno){
        super(Borde,alisar,transparencia,grosor);
        this.forma = new Ellipse2D.Double(x, y, h, w);
        this.rellenado=rellenado;
        this.relleno=relleno;
    }
    public MiElipse(MiElipse aux){
        super((MiFigura)aux);
        forma = aux.getForma();
        rellenado=aux.getRellenado();
        relleno=aux.getRelleno();
    }
    
    public void setLocation(Point2D pos){
        double dx=pos.getX()-(forma.getWidth()/2);
        double dy=pos.getY()-(forma.getHeight()/2);
        this.forma = new Ellipse2D.Double(dx, dy, forma.getHeight(),forma.getWidth());       
    }
    public void setForma(Ellipse2D forma){
        this.forma = forma;
    }
    public Ellipse2D getForma(){
        return forma;
    }
    public boolean getRellenado(){
        return rellenado;
    }
    public void getRellenado(boolean rellenado){
        this.rellenado = rellenado;
    }
    public void setRelleno(Color relleno){
        this.relleno=relleno;
    }
    public Color getRelleno(){
        return relleno;
        
    }
        
    
}