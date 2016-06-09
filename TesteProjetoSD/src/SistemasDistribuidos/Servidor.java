
package SistemasDistribuidos;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author manoel
 */
public class Servidor {
    
       public Servidor() {
       }
      public static void main(String[] args) {
        
    try {
           ServerSocket servidor = new ServerSocket(1234);
           System.out.println("escutando na porta 1234");  
       while(true) {
           
            Socket cliente = servidor.accept();
            System.out.println("recebeu o cliente "+ cliente.getInetAddress().getHostAddress());
            
             ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
              saida.flush();
              saida.writeUTF("mensagem devolvida ao cliente");
              saida.close();
        
       }
    }catch(Exception e) {
        System.out.println(e.getMessage());
    }
                
      }     

       
       
}