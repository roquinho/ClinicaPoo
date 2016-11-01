package br.upe.poo.clinica.entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Medicos implements Serializable {
    
	private String nome;
	private Long cpf;
	private String endereco;
	private Long telefone;
	private String loginNome;
	private String senha;
	private Long crm;
        private String especialidade;
	private List<Consultas>consultas;
	
	 public Medicos() {
		 
	 }
	 public Medicos(String nome,String senha,String endereco,Long telefone,String login,Long crm,String especialidade) {
		 this.endereco = endereco;
		 this.nome = nome;
		 this.telefone = telefone;
		 this.senha = senha;
		 this.loginNome = login;
		 this.crm = crm;
                 this.especialidade = especialidade;
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
        final Medicos other = (Medicos) obj;
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
    
        @Id
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	} 
         
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
               
        @OneToMany(fetch = FetchType.EAGER,mappedBy="medico",cascade = CascadeType.REMOVE)
	public List<Consultas> getConsultas() {
		return consultas;
	}
	public void setConsultas(List<Consultas> consultas) {
		this.consultas = consultas;
	}
		
}
