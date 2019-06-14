
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import smm.moh.graficos.MiFigura;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eyehalcon97
 * Mi clase Mi lista de figuras
 */
public class MiLista extends AbstractListModel{

    private ArrayList<MiFigura> lista = new ArrayList<>();

    /**
    *
    * 
    * Consultor de size
    * Devuelve el tamaño de mi lista
    */
    @Override
    public int getSize() {
        return lista.size();
    }
    /**
    *
    * 
    * Consultor de elementos
    * @param index: devuelve el elemento seleccionado
    */
    @Override
    public MiFigura getElementAt(int index) {
        MiFigura p = lista.get(index);
        return p;
    }
    /**
    *
    * Añade elementos a la lista
    * @param p: elemento que se añade
    */
    public void addFigura(MiFigura p){
        lista.add(p);
        this.fireIntervalAdded(this, getSize(), getSize()+1);
    }
    /**
    *
    * Elimina de la lista un elemento
    * @param index: numero de el elemento a borrar
    */
    public void eliminarFigura(int index){
        lista.remove(index);
        this.fireIntervalRemoved(index, getSize(), getSize()+1);
    }

    
  
}