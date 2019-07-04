
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
    * Applica el filtro Random (Componente a componente)
    * dicho filtro consiste en utilizar un numero aleatorio, dicho
    * numero se multiplica por 3.5 se le suma al valor del pixel,
    * @param src: imagen de origen
    * @param dest: imagen de destino
    * @return Nueva imagen con el filtro aplicado
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
                   //aplicamos el cambio del valor random
                for(int i=0;i<3;i++){
                     pixel[i] =(int)((pixel[i]+(random))*3.5)%255;
                }
                



                //Aplicamos el cambio
                destRaster.setPixel(x,y, pixel);
                
            }      
        } 
        return dest;
    }
 
 
}
