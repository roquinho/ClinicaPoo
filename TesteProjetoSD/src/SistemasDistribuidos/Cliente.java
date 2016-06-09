
package SistemasDistribuidos;

import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author manoel
 */
public class Cliente {
     
       public Cliente() {
           
       }
    public static void main(String[] args) {
        
    
   try {
         Socket cliente = new Socket("localhost", 1234);
         System.out.println("conectou com servidor");
 
              ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
              String recebeuServidor = entrada.readUTF();
              System.out.println(recebeuServidor);
              entrada.close();
              cliente.close();
         
    }catch (Exception e) {
        System.out.println(e.getMessage());
    }
   
    }

}
