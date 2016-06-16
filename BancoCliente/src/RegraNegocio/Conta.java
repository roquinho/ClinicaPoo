
package RegraNegocio;

/**
 *
 * @author manoel
 */
public class Conta {

   private Cliente cliente;
   private double saldo;
   private int senha;

      public Conta (Cliente cliente, double saldo, int senha) {
          this.cliente = cliente;
          this.saldo = saldo;
          this.senha = senha;
      }
      
      public Conta () {
          
      }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }
      


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
      
      
}
