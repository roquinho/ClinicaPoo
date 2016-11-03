package br.upe.poo.clinica.listarEntidades;

import br.upe.poo.clinica.entidades.Medicos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ListarMedicos implements Serializable {
    
	private String nome;
	private Long cpf;
	private String endereco;
	private Long telefone;
	private String loginNome;
	private String senha;
	private Long crm;
        private String especialidade;
	private List<ListarConsultas>consultas;
	
	 public ListarMedicos(Medicos medicos) {
	         this.cpf = medicos.getCpf();
                 this.crm = medicos.getCrm();
                 this.endereco = medicos.getEndereco();
                 this.especialidade = medicos.getEspecialidade();
                 this.loginNome = medicos.getLoginNome();
                 this.nome = medicos.getNome();
                 this.senha = medicos.getSenha();
                 this.telefone = medicos.getTelefone();
                 this.consultas = new ArrayList<>();
                    for(int i = 0; i< medicos.getConsultas().size();i++) {
                        ListarConsultas listarConsultas = new ListarConsultas(medicos.getConsultas().get(i));                         
                          this.consultas.add(listarConsultas);
                    }
                         
                         
	 }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.nome);
        hash = 59 * hash + Objects.hashCode(this.cpf);
        hash = 59 * hash + Objects.hashCode(this.endereco);
        hash = 59 * hash + Objects.hashCode(this.telefone);
        hash = 59 * hash + Objects.hashCode(this.loginNome);
        hash = 59 * hash + Objects.hashCode(this.senha);
        hash = 59 * hash + Objects.hashCode(this.crm);
        hash = 59 * hash + Objects.hashCode(this.especialidade);
        hash = 59 * hash + Objects.hashCode(this.consultas);
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
        final ListarMedicos other = (ListarMedicos) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.loginNome, other.loginNome)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.especialidade, other.especialidade)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.crm, other.crm)) {
            return false;
        }
        if (!Objects.equals(this.consultas, other.consultas)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Medicos{" + "nome=" + nome + ", cpf=" + cpf + ", endereco=" + endereco + ", telefone=" + telefone + ", loginNome=" + loginNome + ", senha=" + senha + ", crm=" + crm + ", especialidade=" + especialidade + ", consultas=" + consultas + '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
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

    public Long getCrm() {
        return crm;
    }

    public void setCrm(Long crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public List<ListarConsultas> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<ListarConsultas> consultas) {
        this.consultas = consultas;
    }
    
        
}
