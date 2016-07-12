/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;


/**
 *
 * @author Ariel
 */
public class Servidor2 {
    private ServerSocket serverSocket;
    private int port=10053;
    private boolean seguir;
    private static Scanner scanner = new Scanner(System.in); 
    private static int select = -1;
    private Windows w;
    private GNULinux g;
    private Mac m;
    private Impresiones i;

    public Servidor2(int port, Windows w, GNULinux g, Mac m) {
        this.port = port;
        this.w = w;
        this.g = g;
        this.m = m;
        this.i= i;
        seguir = true;
        
        inicializar_servidor();
    }


    private void inicializar_servidor() {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(Servidor2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    while(select != 0){
			
			try{
				System.out.println("Que Sistema Operativo se está conectando?:\n1.- Windows" +
						"\n2.- GNU Linux\n" +
						"3.- Macintosh\n" +
						"0.- Salir");
				
				select = Integer.parseInt(scanner.nextLine()); //recolector en consola
	
				
				switch(select){
				case 1: 
					get_respuestaWindows();
					System.out.println("Windows");
                                        
					break;
				case 2: 
					get_respuestaGNULinux();
					System.out.println("linux");
					break;
				case 3: 
					get_respuestaMac();
					System.out.println("mac");
					break;
                                        
				case 0: 
					System.out.println("Salió");
					break;
				default:
					System.out.println("Digite un número válido de los mencionados");
                                        break;
				}
				
				System.out.println("\n"); 
				
			}catch(Exception e){
				System.out.println("Error!");
			}
		}

    private String get_respuestaGNULinux(Socket server) {
        String respuesta = null;
        DataInputStream in;
        try {
            in = new DataInputStream(server.getInputStream());
            String leido = in.readUTF();
            System.out.println("Recibido: " + leido);
            respuesta=i.representacionG();
           
        } catch (Exception ex) {
            respuesta = null;
        }
        return respuesta;
    }
    
    private String get_respuestaWindows(Socket server) {
        String respuesta = null;
        DataInputStream in;
        try {
            in = new DataInputStream(server.getInputStream());
            String leido = in.readUTF();
            System.out.println("Recibido: " + leido);
            respuesta=i.representacionW();
           
        } catch (Exception ex) {
            respuesta = null;
        }
        return respuesta;
    }
    
    private String get_respuestaMac(Socket server) {
        String respuesta = null;
        DataInputStream in;
        try {
            in = new DataInputStream(server.getInputStream());
            String leido = in.readUTF();
            System.out.println("Recibido: " + leido);
            respuesta=i.representacionM();
           
        } catch (Exception ex) {
            respuesta = null;
        }
        return respuesta;
    }

    private void correr_con_throws() throws IOException {
        System.out.println("Esperando clientes en el puerto: "
                + serverSocket.getLocalPort() + "...");

        Socket server = serverSocket.accept();
        while (seguir) {
            String respuesta = get_respuesta(server);
            if (respuesta != null) {
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF(respuesta);
            } else {
                seguir = false;
            }
        }
        server.close();

    }

    public void correr() {
        try {
            correr_con_throws();
        } catch (IOException ex) {
            Logger.getLogger(Servidor2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void parar() {
        seguir = false;
    }

}
