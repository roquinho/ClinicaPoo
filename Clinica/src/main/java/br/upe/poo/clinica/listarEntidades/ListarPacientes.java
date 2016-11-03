package br.upe.poo.clinica.listarEntidades;

import br.upe.poo.clinica.entidades.Pacientes;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


public class ListarPacientes implements Serializable {
	private String nome;
	private Date dataNascimento;
	private String sexo;
	private Long cpf;
	private String endereco;
	private String telefone;
	private String loginNome;
	private String senha;
	private List<ListarConsultas>consultas;
	private List<ListarExames>exames;
	
	 public ListarPacientes(Pacientes paciente) {
             this.cpf = paciente.getCpf();
             this.dataNascimento = paciente.getDataNascimento();
             this.endereco = paciente.getEndereco();
             this.loginNome = paciente.getLoginNome();
             this.nome = paciente.getNome();
             this.senha = paciente.getSenha();
             this.sexo = paciente.getSexo();
             this.telefone = paciente.getTelefone();
             this.consultas = new ArrayList<>();
             this.exames = new ArrayList<>();
             
		  for(int i = 0; i<paciente.getConsultas().size(); i++) {                      
                      ListarConsultas listaConsultas = new ListarConsultas(paciente.getConsultas().get(i));                      
                      this.consultas.add(listaConsultas);    }              
                   
                  for(int i = 0; i < paciente.getExames().size(); i++) {                     
                      ListarExames listaExames = new ListarExames(paciente.getExames().get(i));
                      this.exames.add(listaExames);
                  }
	 }
         
	 
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.nome);
        hash = 73 * hash + Objects.hashCode(this.dataNascimento);
        hash = 73 * hash + Objects.hashCode(this.sexo);
        hash = 73 * hash + Objects.hashCode(this.cpf);
        hash = 73 * hash + Objects.hashCode(this.endereco);
        hash = 73 * hash + Objects.hashCode(this.telefone);
        hash = 73 * hash + Objects.hashCode(this.loginNome);
        hash = 73 * hash + Objects.hashCode(this.senha);
        hash = 73 * hash + Objects.hashCode(this.consultas);
        hash = 73 * hash + Objects.hashCode(this.exames);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ListarPacientes other = (ListarPacientes) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.loginNome, other.loginNome)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.dataNascimento, other.dataNascimento)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.consultas, other.consultas)) {
            return false;
        }
        if (!Objects.equals(this.exames, other.exames)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pacientes{" + "nome=" + nome + ", dataNascimento=" + dataNascimento + ", sexo=" + sexo + ", cpf=" + cpf + ", endereco=" + endereco + ", telefone=" + telefone + ", loginNome=" + loginNome + ", senha=" + senha + ", consultas=" + consultas + ", exames=" + exames + '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLoginNome() {
        return loginNome;
    }

    public void setLoginNome(String loginNome) {
        this.loginNome = loginNome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<ListarConsultas> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<ListarConsultas> consultas) {
        this.consultas = consultas;
    }

    public List<ListarExames> getExames() {
        return exames;
    }

    public void setExames(List<ListarExames> exames) {
        this.exames = exames;
    }
           

}
