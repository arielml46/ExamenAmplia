/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.Validador;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ariel
 */
public class Mac implements PC{
    
  private String Os="Macintosh Operative System";
  private String Ip="";
  private int port= 10053;
  private String serverName;
  private String name;
  Socket client;
  private static Scanner scanner = new Scanner(System.in); 
private Validador v;
   

 public Mac(String Os, int port, String serverName) {
    
    this.Os=Os;
    this.port = port;
    this.serverName = serverName;
    this.v= v;
 }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }


    Mac(String Os, String Ip) {
       
    }

    public String getIp() {
        return Ip;
    }

    public void setIp(String Ip) {
        this.Ip = Ip;
    }
 
    public String getOs() {
        return Os;
    }

    public void setOs(String Os) {
        this.Os = Os;
    }
    
    private void conectar(){
             
        System.out.println("Digite la ip de su pc, tenga en cuenta que no sobrepasa el dígito 255");
      int select = Integer.parseInt(scanner.nextLine());
        if(select>255){
            //Ip=Integer.parseInt(select);
            //getIp().v.math();
      System.out.println("La ip digitada no es correcta");
    }
    
      System.out.println("Conectado a " + serverName + " en el puerto " + port);
      try
      {
         client = new Socket(serverName, port);
         
         System.out.println("La dirección remota obtenida es " 
		 + client.getRemoteSocketAddress());
                }catch(IOException e)
                {
                   e.printStackTrace();
                }
    }
    
    private void _hablar(String texto) throws IOException{
        OutputStream outToServer = client.getOutputStream();
        DataOutputStream out = new DataOutputStream(outToServer);
        out.writeUTF(texto);
    }
    
    public void hablar(){
        Random rand = new Random();
        String[] textos = new String[]{"Ping", "Ping"};
        int seleccionado = rand.nextInt(2);
        try {
            _hablar(textos[seleccionado]);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    private void _escuchar() throws IOException{
         InputStream inFromServer = client.getInputStream();
         DataInputStream in = new DataInputStream(inFromServer);
         System.out.println("Escuchando: "+in.readUTF());
    }
    
    public void escuchar(){
        try {
            _escuchar();
        } catch (IOException ex) {
            Logger.getLogger(Mac.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cerrar(){ 
        try {
            client.close();
        } catch (IOException ex) {
            Logger.getLogger(Mac.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public void simular_conversacion(){
        for(int x=0; x<2; x++){
            hablar();
            escuchar();
        }
    
    }
}