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
 * Mi clase sepia
 * 
 */



public class SepiaOp extends BufferedImageOpAdapter
{
    /**
    * Applica el filtro de Sepia
    * dicho filtro consisteen multiplicar cada componente del pixel por
    * un valor en concreto y su suma, guardarla en cada una de los componentes
    * correspondientes
    * @param src: imagen de origen
    * @param dest: imagen de destino
    */
    @Override
     public BufferedImage filter(BufferedImage src, BufferedImage dest){       
        if (src == null) {        
            throw new NullPointerException("src image is null");
            }
                  
              
        if (dest == null) {        
            dest = createCompatibleDestImage(src, null);
            }      

        WritableRaster destRaster = dest.getRaster();
        float pixel[]=null;
        for (int x = 0; x < src.getWidth(); x++) {       
            for (int y = 0; y < src.getHeight(); y++) {
                pixel = src.getRaster().getPixel(x, y, pixel);
                //Aplicamos la matriz de la Sepia
                float Red = pixel[0] * 0.393f + pixel[1] * 0.769f + pixel[2] * 0.189f;
                float Green = pixel[0] * 0.349f + pixel[1] * 0.686f + pixel[2] * 0.168f;
                float Blue = pixel[0] * 0.272f + pixel[1] * 0.534f + pixel[2] * 0.131f;        
                //Establecemos el 255 como valor maximo
                if(Red > 255.0f){ 
                    Red =255;
                }
                if(Blue > 255.0f){
                    Blue =255;
                }
                if(Green > 255.0f){
                    Green =255;
                }
                pixel[0] = (int) Red;
                pixel[1] = (int) Green;
                pixel[2] = (int) Blue;
                //Aplicamos el cambio
                destRaster.setPixel(x,y, pixel);
                
            }      
        } 
        
        return dest;  
     } 
    
    
    
}