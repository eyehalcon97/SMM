/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smm.moh.iu;

import java.awt.Color;
import smm.moh.iu.Lienzo2D;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import smm.moh.graficos.MiFigura;

/**
 *
 * @author eyehalcon97
 * Lienzo con imagenes dentro de el
 * 
 */
public class LienzoImagen2D extends Lienzo2D{
    private BufferedImage img=null;
    private float brillo=0;
    private String filtro="Seleccione";
    private String espectro="Seleccione";
    private Point centro = null;
     /**
    * Constructor por defecto
    */
    public LienzoImagen2D(){
        super();
    }
    /**
    * Constructor de LienzoImagen2D
    * @param vertical: tamaño vertical del lienzo
    * @param horizontal: tamaño horizontal del lienzo
    * Creara un Lienzo en blanco a partir de un rectangulo
    */
    public LienzoImagen2D(int vertical,int horizontal){
        
        super(vertical,horizontal);
        
        img = new BufferedImage(vertical,horizontal,BufferedImage.TYPE_INT_RGB);
        img.createGraphics().setPaint(Color.white);
         img.createGraphics().fill(new Rectangle2D.Float(0.0f, 0.0f, img.getWidth(), img.getHeight()));
         centro = new Point(img.getHeight()/2, img.getWidth()/2);
         
    }
    /**
    * Modificador de brillo
    * @param brillo: el nuevo brillo
    */
    public void setBrillo(float brillo){
        this.brillo =  brillo;
    }
    /**
    * Modificador de filtro
    * @param filtro: el nuevo filtro
    */

    public void setFiltro(String filtro){
        this.filtro = filtro;
    }
    /**
    * Modificador de espectro
    * @param espectro: el nuevo espectro
    */
    public void setEspectro(String espectro){
        this.espectro =espectro;
    }
    /**
    * Consultor de brillo
    * @return valor del brillo
    * 
    */
    public float getBrillo(){
        return brillo;
    }
    /**
    * Consultor de Filtro
    * @return valor del filtro
    * 
    */
    public String getFiltro(){
        return filtro;
    }
    /**
    * Consultor de Espectro
    * @return Valor del espectro
    * 
    */
    public String getEspectro(){
        return espectro;
    }
    /**
    * Consultor de Imagen
    * @param imagen: booleano que indica si queremos
    * que nos devulvan los objetos dibujados dentro del lienzo
    * dichos objetos pasan a ser parte de la imagen y se borran de 
    * la lista
    * @return Imagen que contiene el lienzo
    */
    public BufferedImage getImagen(boolean imagen){
            Graphics g = img.getGraphics();
            Graphics2D g2d=(Graphics2D)g;
            if(imagen){
                for(MiFigura s:Lista){
                s.draw(g2d);
                }
                this.Lista.clear();
            }
            return img;
    }
    /**
    * Modificador de Imagen
    * @param img: la nueva imagen
    * Se introduce una nueva imagen y se cambia 
    * los valores del tamaño del lienzo
    */
    public void setImagen(BufferedImage img){
        this.img = img;
        if(this.img != null){
            horizontal=img.getWidth();
            vertical = img.getHeight();
        }
    }
    /**
    * Metodo para repintar el componente
    * @param g: el graphics necesario para pintar
    * 
    */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(img !=null){
            g.drawImage(img, 0, 0, this);
        }
    }
    /**
    * 
    * Consultor del Punto centro de la imagen
    * @return punto dentro de la imagen
    * 
    */
    public Point getPoint(){
        return centro;
    }
}
