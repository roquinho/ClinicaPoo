package br.upe.poo.clinica.entidades;


import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
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
        private Long codigoConsulta;
        private boolean situacaoConsulta;
	private Date diaConsulta;
	private Date horaConsulta;
	private Pacientes paciente;
	private DadosConsultas dadosConsulta;
	private Medicos medico;
        private List<Exames> exames;
	
            public Consultas() {
                
            }
	    public Consultas(Date diaConsulta,Date horaConsulta,Long codigoConsulta) {
                this.diaConsulta = diaConsulta;
	    	this.horaConsulta = horaConsulta;
                this.codigoConsulta = codigoConsulta;
                        
	    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.numeroConsulta);
        hash = 43 * hash + Objects.hashCode(this.codigoConsulta);
        hash = 43 * hash + (this.situacaoConsulta ? 1 : 0);
        hash = 43 * hash + Objects.hashCode(this.diaConsulta);
        hash = 43 * hash + Objects.hashCode(this.horaConsulta);
        hash = 43 * hash + Objects.hashCode(this.paciente);
        hash = 43 * hash + Objects.hashCode(this.dadosConsulta);
        hash = 43 * hash + Objects.hashCode(this.medico);
        hash = 43 * hash + Objects.hashCode(this.exames);
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
        if (!Objects.equals(this.codigoConsulta, other.codigoConsulta)) {
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

                public Long getCodigoConsulta() {
                        return codigoConsulta;
                }

                public void setCodigoConsulta(Long codigoConsulta) {
                        this.codigoConsulta = codigoConsulta;
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
                @OneToOne(fetch = FetchType.EAGER,mappedBy = "consulta")              
		public DadosConsultas getDadosConsulta() {
			return dadosConsulta;
		}
		public void setDadosConsulta(DadosConsultas dadosConsulta) {
			this.dadosConsulta = dadosConsulta;
		}
                public boolean isSituacaoConsulta() {
                        return situacaoConsulta;
                }

                public void setSituacaoConsulta(boolean situacaoConsulta) {
                        this.situacaoConsulta = situacaoConsulta;
                }
                @ManyToOne(fetch = FetchType.EAGER)
		public Medicos getMedico() {
			return medico;
		}
		public void setMedico(Medicos medico) {
			this.medico = medico;
		}
                @OneToMany(fetch = FetchType.EAGER,mappedBy = "consulta",cascade = CascadeType.REMOVE)
                public List<Exames> getExames() {
                       return exames;
                }
                public void setExames(List<Exames> exames) {
                       this.exames = exames;
                }
	    
}
