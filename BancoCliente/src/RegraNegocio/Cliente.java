
package RegraNegocio;

/**
 *
 * @author manoel
 */
public class Cliente {
   
    private String nome;
    private Conta conta;
    private String cpf;
    
      public Cliente(String nome , String cpf,Conta conta) {
          this.cpf = cpf;
          this.nome = nome;
          this.conta = conta;
      }
      
      public Cliente(){
          
      }
      
      public void fazerTransferencia(double valorTransferencia, Conta conta) {
      
        this.conta.setSaldo(this.conta.getSaldo()-valorTransferencia);
        conta.setSaldo(conta.getSaldo()+valorTransferencia);       
      }
      
      public void pagamento(double valorPagamento) {
        this.conta.setSaldo(this.conta.getSaldo() - valorPagamento);
      }
      
      public void depositar(double valorDeposito) {      
        this.conta.setSaldo(this.conta.getSaldo() + valorDeposito);
      }
      
      
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
              
    
}
