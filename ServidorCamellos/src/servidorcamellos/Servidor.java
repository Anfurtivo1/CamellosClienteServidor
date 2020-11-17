/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorcamellos;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andres
 */
public class Servidor {
    DatagramPacket p;
    DatagramSocket s;
    byte buffer[] = new byte[256];
    
    public void ejecutarServidor(){
        System.out.println("Se va a iniciar el servidor");
            do {            
                try {
                p= new DatagramPacket(buffer,256);
                s= new DatagramSocket();
                s.receive(p);
                Hilo hilo = new Hilo(p);
                hilo.start();

            } catch (SocketException ex) {
                System.out.println("Error en "+ex);
            } catch (IOException ex) {
                System.out.println("Error en "+ex);
            }
        } while (true);
        
    }
}
