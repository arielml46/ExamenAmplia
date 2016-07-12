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
public class FactoryPC {
    
    private PC pc;
    
    public PC getPc(String Os, String Ip)
    {
        switch(Ip)
        {
            case "Windows":
            pc= new Windows(Os, Ip);      
                    break;
                    
            case "GNULinux":
            pc= new GNULinux(Os, Ip);   
                  break;          
                            
            case "Mac":
            pc= new Mac(Os, Ip);
            break;
          
        }
        return pc;
    }
}


