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
 * Mi clase negativo
 */
public class NegativoOp extends BufferedImageOpAdapter
{

    /**
    * Applica el filtro de negativo
    * dicho filtro consiste en restar 255(maximo) al valor de cada componente
    * para ello sacamos el pixel y lo descomponemos
    * @param src: imagen de origen
    * @param dest: imagen de destino
    */
    @Override
    public BufferedImage filter(BufferedImage src, BufferedImage dest)
    {
        if (src == null)
            throw new NullPointerException("src image is null");

        
        if (dest == null)
            dest = createCompatibleDestImage(src, null);

        WritableRaster destRaster = dest.getRaster();
        float pixel[]=null;
        for (int x = 0; x < src.getWidth(); x++) {       
            for (int y = 0; y < src.getHeight(); y++) {
                pixel = src.getRaster().getPixel(x, y, pixel);

                    pixel[0] =255-pixel[0];
                    pixel[1] = 255-pixel[1];
                    pixel[2] = 255-pixel[2];


                //Aplicamos el cambio
                destRaster.setPixel(x,y, pixel);
                
            }      
        } 
        return dest;
    }
}