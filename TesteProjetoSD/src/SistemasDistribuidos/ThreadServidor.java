
package SistemasDistribuidos;

import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author manoel
 */
public class ThreadServidor extends Thread{
     private Socket cliente;
    public ThreadServidor(Socket cliente) {
        this.cliente = cliente;
    }
    
    public void run () {
      try{  
              
      }catch(Exception e) {
        System.out.println(e.getMessage());
    }
    }
}
