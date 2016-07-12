/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Ariel
 */
public class PcMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Windows w= new Windows("localhost");
      GNULinux g= new GNULinux("localhost");
      Mac m= new Mac("localhost");
        // TODO code application logic here
    }
    
        w.simular_conversacion();
        g.simular_conversacion();
        m.simular_conversacion();
    }       
    
}
