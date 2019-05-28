/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smm.moh.graficos;

import java.awt.geom.Point2D;

/**
 *
 * @author eyehalcon97
 */
public interface Figura {
    public Propiedades getPropiedad();
    public void setPropiedad(Propiedades propiedad);
    public void setLocation(Point2D pos);
    public String toString();
    
}
