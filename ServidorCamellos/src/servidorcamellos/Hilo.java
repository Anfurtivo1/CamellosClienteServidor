/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorcamellos;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andres
 */
public class Hilo extends Thread{
    private DatagramPacket p;
    
     Hilo(DatagramPacket p) {
        this.p=p;
    }
    
    @Override
    public void run(){
        InetAddress ip;
        byte buffer[] = new byte[256];
        byte buffer2[] = new byte[256];
        int longitud;
        int puerto;
        String mensaje;
        
        try {
            DatagramSocket s = new DatagramSocket();
            ip=p.getAddress();
            buffer=p.getData();
            longitud=p.getLength();
            puerto=p.getPort();
            mensaje= new String(buffer,0,longitud);
            buffer2=mensaje.getBytes();
            DatagramPacket p2=new DatagramPacket(buffer2,mensaje.length(),ip,puerto);
            s.send(p);
        } catch (SocketException ex) {
            System.out.println("Error en "+ex);
        } catch (IOException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    
    
}
