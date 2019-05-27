
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import smm.moh.graficos.Figura;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eyehalcon97
 */
public class MiLista extends AbstractListModel{

    private ArrayList<Figura> lista = new ArrayList<>();

    @Override
    public int getSize() {
        return lista.size();
    }

    @Override
    public Figura getElementAt(int index) {
        Figura p = lista.get(index);
        return p;
    }
    public void addFigura(Figura p){
        lista.add(p);
        this.fireIntervalAdded(this, getSize(), getSize()+1);
    }
    public void eliminarFigura(int index0){
        lista.remove(index0);
        this.fireIntervalRemoved(index0, getSize(), getSize()+1);
    }
    public Figura getPersona(int index){
        return lista.get(index);
    }
  
}