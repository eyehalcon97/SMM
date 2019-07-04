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
 * Mi clase Linea
 */
public class MiLinea extends MiFigura{
    private Line2D forma;
    /**
    *
    *   Contructor por defecto
    * @param pd: primer punto
    * @param pd1: segundo punto
    */
    public MiLinea(Point2D pd, Point2D pd1){
        super();
        forma = new Line2D.Double(pd, pd1);

    }
    /**
    *
    *   Contructor por defecto
    * @param pd: primer punto
    * @param pd1: segundo punto
    * @param Borde: Color del borde
    * @param alisar: bool de alisar
    * @param grosor: numero de grosor
    * @param numtrans: numero de transparencia
    * @param discontinua: Selecciona el trazado
    * 
    */
    public MiLinea(Point2D pd, Point2D pd1,Color Borde,boolean alisar,int grosor,int numtrans,boolean discontinua){
        super(Borde,alisar,grosor,numtrans,discontinua);
        forma = new Line2D.Double(pd, pd1);

    }
    /**
    *
    * Constructor copia
    * @param aux: Segundo objeto del constructor
    * 
    */
    public MiLinea(MiLinea aux){
        super((MiFigura)aux);
        forma=aux.getForma();

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
        double dx=pos.getX()-forma.getX1();
        double dy=pos.getY()-forma.getY1();
        Point2D newp2 = new Point2D.Double(forma.getX2()+dx,forma.getY2()+dy);
        forma.setLine(pos,newp2);
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
        return forma.getP1();
    }
        
    /**
    *
    *   Modificador de la forma
    *   @param forma: la nueva forma
    */
    public void setForma(Line2D forma){
        this.forma=forma;
    }
        
    /**
    *
    *   Consultor de forma
    * @return devuelve forma
    */
    public Line2D getForma(){
        return forma;
    }
    /**
    *
    * Devuelve true si es un punto
    * @return valor booleano
    * 
    */

    public boolean EsPunto(){
        boolean resultado=false;
        if(forma.getP1()==forma.getP2()){
            resultado=true;
        }
        return resultado;
    }


    /**
    *
    * Devuelve true si es una linea
    * @return valor booleano
    */

    public boolean EsLinea(){
        boolean resultado=false;
        if(forma.getP1()!=forma.getP2()){
            resultado=true;
        }
        return resultado;
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
        if(alisar){
            g2d.setRenderingHints(render);
        }
        g2d.setStroke(atributos);
        
         if(discontinua){
             System.out.println("hooo");
            float []dash={6f,2.0f,6.0f};
            g2d.setStroke(new BasicStroke(grosor,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,5.0f, dash, 0.0f));
        }
        g2d.setColor(getBorde());
        g2d.draw((Shape)forma);
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
