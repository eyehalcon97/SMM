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

        WritableRaster destRaster = dest.getRaster();
        float pixel[]=null;
        for (int x = 0; x < src.getWidth(); x++) {       
            for (int y = 0; y < src.getHeight(); y++) {
                pixel = src.getRaster().getPixel(x, y, pixel);
                //Calculamos la media
                float media = (pixel[0]+pixel[1]+pixel[2])/3;
                //Establecemos el 255 como valor maximo
                //Si es mayor que umbral ponemos el pixel a 255, en caso
                //contrario lo pone a 0
                if(media > umbral){ 
                    pixel[0] =255;
                    pixel[1] = 255;
                    pixel[2] = 255;
                }else{
                    pixel[0] = 0;
                    pixel[1] = 0;
                    pixel[2] = 0;
                }

                //Aplicamos el cambio
                destRaster.setPixel(x,y, pixel);
                
            }      
        } 
        
        return dest;
    }
 
 
}