
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smm.moh.imagen;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import sm.image.BufferedImageOpAdapter;


/**
 *
 * @author eyehalcon97
 * Mi clase random
 */
public class RandomOp extends BufferedImageOpAdapter{   
    

    /**
     * 
    * Applica el filtro Randmo
    * dicho filtro consiste en utilizar un numero aleatorio, dicho
    * numero se multiplica por la media de los tres componentes del pixel y se 
    * le suma al valor del comoponente en cuestion
    * @param src: imagen de origen
    * @param dest: imagen de destino
    * 
    */
    @Override
    public BufferedImage filter(BufferedImage src, BufferedImage dest)
    {
        if (src == null)
            throw new NullPointerException("src image is null");

        
        if (dest == null)
            dest = createCompatibleDestImage(src, null);
        double random = Math.random();
        WritableRaster destRaster = dest.getRaster();
        float pixel[]=null;
        for (int x = 0; x < src.getWidth(); x++) {       
            for (int y = 0; y < src.getHeight(); y++) {
                pixel = src.getRaster().getPixel(x, y, pixel);
                //Calculamos la media del valor del pixel
                float media = (pixel[0]+pixel[1]+pixel[2])/3;
                //aplicamos el cambio del valor random
                pixel[0] =(int)(pixel[0]+(media*random))%255;
                pixel[1] =(int)(pixel[1]+(media*random))%255;
                pixel[2] =(int)(pixel[2]+(media*random))%255;
                   


                //Aplicamos el cambio
                destRaster.setPixel(x,y, pixel);
                
            }      
        } 
        return dest;
    }
 
 
}
