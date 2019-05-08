/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smm.moh.iu;

import smm.moh.iu.Lienzo2D;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author eyehalcon97
 */
public class LienzoImagen2D extends Lienzo2D{
    private BufferedImage img;
    public void setImage(BufferedImage img){
        this.img = img;
        if(img != null){
            setPreferredSize(new Dimension(img.getWidth(),img.getHeight()));
        }
    }
    public BufferedImage getImagen(){
        
            BufferedImage img2;
            img2 = img;
            Graphics g = img2.getGraphics();
            super.paintfiguras(g);        
            return img2;
        
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(img !=null){
            g.drawImage(img, 0, 0, this);
        }
    }
}
