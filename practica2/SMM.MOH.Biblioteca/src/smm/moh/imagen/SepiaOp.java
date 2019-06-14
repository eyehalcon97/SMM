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
 * Mi clase sepia
 */



public class SepiaOp extends BufferedImageOpAdapter
{
    /**
    * Matriz de la Sepia
    */
    private final float[][] matrix = new float[][]
    {
        {
            0.393f, 0.769f, 0.189f
        }, 
        {
            0.349f, 0.686f, 0.168f
        }, 
        {
            0.272f, 0.534f, 0.131f
        }
    };

    /**
    * Applica el filtro de Sepia
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

        BufferedImagePixelIterator.PixelData pixel;
        WritableRaster destRaster = dest.getRaster();
        BufferedImagePixelIterator it = new BufferedImagePixelIterator(src);
        
        for (int x = 0; x < src.getWidth(); x++) {        
            for (int y = 0; y < src.getHeight(); y++) {
                pixel = it.next();
                
                    // Aplicamos la matriz a los diferentes valores del pixel
                    float Red = pixel.sample[0] * this.matrix[0][0] + pixel.sample[1] * this.matrix[0][1] + pixel.sample[2] * this.matrix[0][2];
                    float Green = pixel.sample[0] * this.matrix[1][0] + pixel.sample[1] * this.matrix[1][1] + pixel.sample[2] * this.matrix[1][2];
                    float Blue = pixel.sample[0] * this.matrix[2][0] + pixel.sample[1] * this.matrix[2][1] + pixel.sample[2] * this.matrix[2][2];
                
                    if(Red > 255.0f){
                        Red =255;
                    }
                    if(Blue > 255.0f){
                        Blue =255;
                    }
                    if(Green > 255.0f){
                        Green =255;
                    }
                    pixel.sample[0] = (int) Red;
                    pixel.sample[1] = (int) Green;
                    pixel.sample[2] = (int) Blue;
                
                    destRaster.setPixel(pixel.col, pixel.row, pixel.sample);
                }      
            } 
        
        return dest;
    }
}