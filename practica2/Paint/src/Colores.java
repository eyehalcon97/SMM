/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;



/**
 *
 * @author eyehalcon97
 */
public enum Colores {
    Azul("Azul", Color.BLUE),
    Amarillo("Amarillo", Color.YELLOW),
    Blanco("Blanco", Color.WHITE),
    Negro("Negro", Color.BLACK),
    Rojo("Rojo", Color.RED),
    Verde("Verde", Color.GREEN);
    

    private final String value;
    private final Color color;

    Colores(String value, Color color) {
        this.value = value;
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }
}