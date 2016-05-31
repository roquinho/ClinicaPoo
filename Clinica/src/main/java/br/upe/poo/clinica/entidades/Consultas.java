package br.upe.poo.clinica.entidades;


import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Consultas implements Serializable {
    
        private Long numeroConsulta;
	private Date diaConsulta;
	private Date horaConsulta;
	private Pacientes paciente;
	private boolean situacaoConsulta;
	private DadosConsultas dadosConsulta;
	private Medicos medico;
        private List<Exames> exames;
	
            public Consultas() {
                
            }
	    public Consultas(Pacientes paciente,Date diaConsulta,Date horaConsulta,Medicos medico) {
                this.diaConsulta = diaConsulta;
	    	this.horaConsulta = horaConsulta;
	    	this.paciente = paciente;
                this.medico = medico;	    		  
	    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.numeroConsulta);
        hash = 79 * hash + Objects.hashCode(this.diaConsulta);
        hash = 79 * hash + Objects.hashCode(this.horaConsulta);
        hash = 79 * hash + Objects.hashCode(this.paciente);
        hash = 79 * hash + (this.situacaoConsulta ? 1 : 0);
        hash = 79 * hash + Objects.hashCode(this.dadosConsulta);
        hash = 79 * hash + Objects.hashCode(this.medico);
        hash = 79 * hash + Objects.hashCode(this.exames);
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
        final Consultas other = (Consultas) obj;
        if (this.situacaoConsulta != other.situacaoConsulta) {
            return false;
        }
        if (!Objects.equals(this.numeroConsulta, other.numeroConsulta)) {
            return false;
        }
        if (!Objects.equals(this.diaConsulta, other.diaConsulta)) {
            return false;
        }
        if (!Objects.equals(this.horaConsulta, other.horaConsulta)) {
            return false;
        }
        if (!Objects.equals(this.paciente, other.paciente)) {
            return false;
        }
        if (!Objects.equals(this.dadosConsulta, other.dadosConsulta)) {
            return false;
        }
        if (!Objects.equals(this.medico, other.medico)) {
            return false;
        }
        if (!Objects.equals(this.exames, other.exames)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Consultas{" + "numeroConsulta=" + numeroConsulta + ", diaConsulta=" + diaConsulta + ", horaConsulta=" + horaConsulta + ", paciente=" + paciente + ", situacaoConsulta=" + situacaoConsulta + ", dadosConsulta=" + dadosConsulta + ", medico=" + medico + ", exames=" + exames + '}';
    }   
                @Id
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                public Long getNumeroConsulta() {
                    return numeroConsulta;
                 }

                public void setNumeroConsulta(Long numeroConsulta) {
                    this.numeroConsulta = numeroConsulta;
                 }
                 
                @Temporal(TemporalType.DATE)
  		public Date getDiaConsulta() {
			return diaConsulta;
		}
		public void setDiaConsulta(Date diaConsulta) {
			this.diaConsulta = diaConsulta;
		}
                
                @Temporal(TemporalType.DATE)
		public Date getHoraConsulta() {
			return horaConsulta;
		}
		public void setHoraConsulta(Date horaConsulta) {
			this.horaConsulta = horaConsulta;
		}
                @ManyToOne(fetch = FetchType.EAGER)
		public Pacientes getPaciente() {
			return paciente;
		}
		public void setPaciente(Pacientes paciente) {
			this.paciente = paciente;
		}
		public boolean getSituacaoConsulta() {
			return situacaoConsulta;
		}
		public void setSituacaoConsulta(boolean situacaoConsulta) {
			this.situacaoConsulta = situacaoConsulta;
		}
                @OneToOne(fetch = FetchType.EAGER,mappedBy = "consulta")              
		public DadosConsultas getDadosConsulta() {
			return dadosConsulta;
		}
		public void setDadosConsulta(DadosConsultas dadosConsulta) {
			this.dadosConsulta = dadosConsulta;
		}
                @ManyToOne(fetch = FetchType.EAGER)
		public Medicos getMedico() {
			return medico;
		}
		public void setMedico(Medicos medico) {
			this.medico = medico;
		}
                @OneToMany(fetch = FetchType.EAGER)
                public List<Exames> getExames() {
                       return exames;
                }
                public void setExames(List<Exames> exames) {
                       this.exames = exames;
                }
	    

}
