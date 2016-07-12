/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author Ariel
 */
public class Validador {
    
    private final static String IpPattern="/^(([1-9]?[0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5]).){3}([1-9]?[0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$/"; 


public boolean validarIp(String Ip)
{
    Pattern pat= Pattern.compile(IpPattern, Pattern.CASE_INSENSITIVE);
    Matcher mat = pat.matcher(Ip);
        return mat.find();    

 

}
}