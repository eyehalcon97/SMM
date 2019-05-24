/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smm.moh.iu;

import java.awt.Color;
import smm.moh.iu.Lienzo2D;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author eyehalcon97
 */
public class LienzoImagen2D extends Lienzo2D{
    private BufferedImage img=null;
    private float brillo=0;
    private int rotacion=0;
    private String filtro="Seleccione";
    private String espectro="Seleccione";
    public void setImage(BufferedImage img){
        this.img = img;
        if(img != null){
            setPreferredSize(new Dimension(img.getWidth(),img.getHeight()));
        }
        Lista.clear();
    }
    public void setBrillo(float brillo){
        this.brillo =  brillo;
    }
    public void setRotacion(int rotacion){
        this.rotacion=rotacion;
    }
    public void setFiltro(String filtro){
        this.filtro = filtro;
    }
    public void setEspectro(String espectro){
        this.espectro =espectro;
    }
    public float getBrillo(){
        return brillo;
    }
    public int getRotacion(){
        return rotacion;
    }
    public String getFiltro(){
        return filtro;
    }
    public String getEspectro(){
        return espectro;
    }
    public BufferedImage getImagen(){
        
            
            Graphics g = img.getGraphics();
            
            super.paintfiguras(g);
            
            return img;
            
        
    }
    public void setImagen(BufferedImage img){
        this.img =img;
        
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(img !=null){
            g.drawImage(img, 0, 0, this);
        }
    }
}
