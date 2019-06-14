/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smm.moh.imagen;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import sm.image.BufferedImageOpAdapter;
import sm.image.BufferedImagePixelIterator;

/**
 *
 * @author eyehalcon97
 * Mi clase umbral
 */

public class UmbralizacionOp extends BufferedImageOpAdapter{   
    private int umbral;
     /**
    * Constructor por defecto
    * @param umbral: numero del umbral
    * 
    */
    public UmbralizacionOp(int umbral) {     
        this.umbral = umbral;
    } 
    /**
    * Applica el filtro de umbralizacion
    * @param src: imagen de origen
    * @param dest: imagen de destino
    */
    public BufferedImage filter(BufferedImage src, BufferedImage dest)
    {
        if (src == null)
            throw new NullPointerException("src image is null");

        
        if (dest == null)
            dest = createCompatibleDestImage(src, null);

        BufferedImagePixelIterator.PixelData pixel;
        WritableRaster destRaster = dest.getRaster();
        BufferedImagePixelIterator it = new BufferedImagePixelIterator(src);
        //Calculamos la media
        for (int x = 0; x < src.getWidth(); x++) {        
            for (int y = 0; y < src.getHeight(); y++) {
                pixel = it.next();
                if (pixel.sample.length > 1){

                    float numero = (pixel.sample[0] + pixel.sample[1] + pixel.sample[2])/3;
                    //Si es mayor que el umbral lo establecemos en 255, si no en 0
                    if(numero >umbral){
                       pixel.sample[0] = 255;
                        pixel.sample[1] = 255;
                        pixel.sample[2] = 255;
                    }else{
                        pixel.sample[0] = 0;
                        pixel.sample[1] = 0;
                        pixel.sample[2] = 0;
                    }
                    destRaster.setPixel(pixel.col, pixel.row, pixel.sample);
                }      
            } 
        }
        return dest;
    }
 
 
}