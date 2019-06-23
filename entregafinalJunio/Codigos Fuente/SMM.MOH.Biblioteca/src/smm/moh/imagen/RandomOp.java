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
 * Mi clase random
 */
public class RandomOp extends BufferedImageOpAdapter{   
    

     /**
    * Applica el filtro de random
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
        double random= Math.random();
        for (int x = 0; x < src.getWidth(); x++) {        
            for (int y = 0; y < src.getHeight(); y++) {
                pixel = it.next();
                if (pixel.sample.length > 1){
                    //Calculamos la media del pixel y la mutiplicamos por un numero aleatorio
                    float Red = pixel.sample[0];
                    float Green = pixel.sample[1];
                    float Blue = pixel.sample[2];
                
                    float media = (Red+Green+Blue)/3;
                    Red = (int)((Red+(media*random))%255);
                    Blue = (int)((Blue+(media*random))%255);
                    Green = (int)((Green+(media*random))%255);
                    
                    pixel.sample[0] = (int) Red;
                    pixel.sample[1] = (int) Green;
                    pixel.sample[2] = (int) Blue;
                
                    destRaster.setPixel(pixel.col, pixel.row, pixel.sample);
                }      
            } 
        }
        return dest;
    }
 
 
}
