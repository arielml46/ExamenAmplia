/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Ariel
 */
 public class GestionadorPC<T> {

    private ArrayList<T> arrayT;
    private FactoryPC fabrica;

    public GestionadorPC() {
        arrayT = new ArrayList<>();
        fabrica = new FactoryPC();
    }

    public void guardarOS(String Os, String Ip) {
       
        arrayT.add((T) fabrica.getPc(Os, Ip));
        System.out.println("Os agregado");
    }
   
    public T buscarPorIp(String id) throws Exception {
        T aux = null;
        for (int i = 0; i < arrayT.size(); i++) {
            if (arrayT.get(i).equals(id)) {
                aux = arrayT.get(i);
            } else {
                throw new Exception("Esa IP no se ha encontrado");
            }
        }
        return aux;
    }
    
    
    public int size() {
        return arrayT.size();
    }

    public T regresaArray(int posc) {
        return arrayT.get(posc);
    }

    public ArrayList arreglo() {
        return arrayT;
    }
    public ArrayList<PC> arregloPersona(){
        return (ArrayList<PC>) arrayT;
    }

}   
