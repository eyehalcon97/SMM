/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smm.moh.graficos;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;


/**
 *
 * @author eyehalcon97
 */
public class MiString extends MiFigura{
    private Line2D forma;
    private String string=null;

    /**
    *   Constructor por defecto
    * @param x: coordenada X
    * @param y: corredenada Y
    * @param string: String que debe de escribir
    * 
    */
    public MiString(double x,double y,String string){
        super();
        
        this.forma = new Line2D.Double(x, y,x,y);
        this.string = string;
        
        
        
    }
    /**
    *
    *   Contructor por defecto
    * @param x: coordenada x
    * @param y: coordenada y
    * @param string: String que contiene
    * @param Borde: Color del borde
    * @param alisar: bool de alisar
    * @param grosor: numero de grosor
    * @param numtrans: numero de transparencia
    */
    public MiString(double x,double y,Color Borde,boolean alisar,int grosor,String string,int numtrans,boolean discontinua){
        super(Borde,alisar,grosor,numtrans,discontinua);
        this.forma = new Line2D.Double(x, y,x,y);
        this.string = string;

    }
    /**
    *
    * Constructor copia
    * 
    */
    public MiString(MiString aux){
        super((MiFigura)aux);
        forma = aux.getForma();
        string = aux.getString();

    }

    /**
    *
    * Posiciona la figura en la posicion 
    * seleccionada
    * @param pos: punto donde se posiciona
    * 
    */
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
    * 
    */
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
    */   
    public Line2D getForma(){
        return forma;
    }
    /**
    *
    *   Modificador de string
    * @param string: string que lo contiene
    */   
    public void setString(String string){
        this.string=string;
    }
    /**
    *
    *   Consultor de string
    */   
    public String getString(){
        return string;
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

        g2d.setColor(borde);

        g2d.drawString(string,(int) forma.getP1().getX(),(int)forma.getP1().getY());
        
        
    }
    /**
    *
    *   Actualiza el color con las transparencia
    */
    @Override
    public void actualizartransparencia(){
        super.actualizartransparencia();

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
        
        int contador = string.length();
        Point2D p1= new Point2D.Double(forma.getX1(),forma.getY1()+5);
        Point2D p2 = new Point2D.Double(forma.getX2()+(contador*7),forma.getY2()+5);
        Line2D linea= new Line2D.Double(p1,p2);
        
       
        float []dash={6f,2.0f,6.0f};
        g2d.setStroke(new BasicStroke(2,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,5.0f, dash, 0.0f));
         g2d.draw(linea);
    }
        
    
        
}
