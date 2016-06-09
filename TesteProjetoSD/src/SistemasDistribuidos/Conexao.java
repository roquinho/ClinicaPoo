
package SistemasDistribuidos;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import oracle.jrockit.jfr.tools.ConCatRepository;

/**
 *
 * @author manoel
 */
public class Conexao {
   
    private ServerSocket servidor;
    private Socket cliente;
     
     public void conectar(int porta) throws IOException {
         
           this.servidor = new ServerSocket(porta);
           System.out.println("escutando na porta "+porta);  
       while(true) {           
            this.cliente = servidor.accept();
            System.out.println("recebeu o cliente "+ cliente.getInetAddress().getHostAddress());
                 
       }
     }
     
     public void retornarCliente() throws IOException {
         
         ObjectOutputStream saida = new ObjectOutputStream(this.cliente.getOutputStream());
              saida.flush();
              saida.writeUTF("mensagem devolvida ao cliente");
              saida.close();
     }
     
     public void clienteConectar(String ip , int porta ) throws IOException {
         this.cliente = new Socket(ip,porta);
          System.out.println("conectou com servidor");
          
     }
}