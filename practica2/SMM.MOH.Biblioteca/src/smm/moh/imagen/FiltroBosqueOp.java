
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
 * Mi clase FiltroBosqueOp
 * 
 */
public class FiltroBosqueOp extends BufferedImageOpAdapter{   
    

    /**
    * Applica el filtro de Bosque
    * dicho filtro consiste en coger el componente con el numero mas alto, y si ese
    * componente es distintio de Green, se intercambian entre ellos, de esta manera 
    * hacemos que la imagen se vea un poco mas verdosa, excepto tanto los tonos 
    * oscuros como claros que apenas notaremos la diferencia.
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
        WritableRaster destRaster = dest.getRaster();
        float pixel[]=null;
        for (int x = 0; x < src.getWidth(); x++) {       
            for (int y = 0; y < src.getHeight(); y++) {
                pixel = src.getRaster().getPixel(x, y, pixel);
                //Calculamos el valor maximo
                float maximo = pixel[0];
                float maximo2 = Math.max(pixel[1], pixel[2]);
                //Cambiamos el valor mas alto por el valor del pixel Green
                if(maximo >maximo2){
                    pixel[0]=pixel[1];
                    pixel[1]=maximo;
                }else{
                    if(maximo2 > pixel[1]){
                        pixel[2] = pixel[1];
                        pixel[1] = maximo2;
                    }
                }

                //Aplicamos el cambio
                destRaster.setPixel(x,y, pixel);
                
            }      
        } 
        return dest;
    }
 
 
}