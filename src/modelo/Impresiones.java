/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.text.DecimalFormat;

/**
 *
 * @author Ariel
 */
public class Impresiones {
    
    private Servidor ser;
    private Windows w;
    private Mac m;
    private GNULinux g;
    
    
    public Impresiones()
    {
        ser= new Servidor();
        DecimalFormat formatea = new DecimalFormat("###,###.##");
    }

    public Impresiones(Servidor ser, Windows w, Mac m, GNULinux g) {
        this.ser = ser;
        this.w = w;
        this.m = m;
        this.g = g;
    }
    
    public void representacionW(String ip)
            
    {
        System.outprintln(formatea.format(ip));
    }
    
    public void representacionG(String ip)
            
    {
        System.outprintln(formatea.format(ip));
    }
    

 
    
    public String substring(int beginIndex, int endIndex, String Ip)
    {
        System.out.println(w.getIp().substring(1,2,3,5,6,7,9,11));
   
    }
