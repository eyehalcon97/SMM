
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
 */
public class MiLista extends AbstractListModel{

    private ArrayList<MiFigura> lista = new ArrayList<>();
    

    @Override
    public int getSize() {
        return lista.size();
    }

    @Override
    public MiFigura getElementAt(int index) {
        MiFigura p = lista.get(index);
        return p;
    }
    public void addFigura(MiFigura p){
        lista.add(p);
        this.fireIntervalAdded(this, getSize(), getSize()+1);
    }
    public void eliminarFigura(int index0){
        lista.remove(index0);
        this.fireIntervalRemoved(index0, getSize(), getSize()+1);
    }
    public MiFigura getFigura(int index){
        return lista.get(index);
    }
    
  
}