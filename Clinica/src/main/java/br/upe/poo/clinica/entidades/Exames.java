package br.upe.poo.clinica.entidades;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Exames implements Serializable {

    
        private Long idExame;
	private Date dataExame;
	private Date horaExame;
	private String tipoExame;
	private Pacientes paciente;
	private ResultadosExames resultadoExame;
	 
	 public Exames() {
		 
	 }
         
	 public Exames(String tipoExame,Date dataExame,Date horaExame,Pacientes paciente) {
                 this.tipoExame = tipoExame;
                 this.dataExame = dataExame;
                 this.horaExame = horaExame;
                 this.paciente = paciente;
	 }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.idExame);
        hash = 23 * hash + Objects.hashCode(this.dataExame);
        hash = 23 * hash + Objects.hashCode(this.horaExame);
        hash = 23 * hash + Objects.hashCode(this.tipoExame);
        hash = 23 * hash + Objects.hashCode(this.paciente);
        hash = 23 * hash + Objects.hashCode(this.resultadoExame);
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
        final Exames other = (Exames) obj;
        if (!Objects.equals(this.tipoExame, other.tipoExame)) {
            return false;
        }
        if (!Objects.equals(this.idExame, other.idExame)) {
            return false;
        }
        if (!Objects.equals(this.dataExame, other.dataExame)) {
            return false;
        }
        if (!Objects.equals(this.horaExame, other.horaExame)) {
            return false;
        }
        if (!Objects.equals(this.paciente, other.paciente)) {
            return false;
        }
        if (!Objects.equals(this.resultadoExame, other.resultadoExame)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Exames{" + "idExame=" + idExame + ", dataExame=" + dataExame + ", horaExame=" + horaExame + ", tipoExame=" + tipoExame + ", paciente=" + paciente + ", resultadoExame=" + resultadoExame + '}';
    }

         @Id
         @GeneratedValue(strategy = GenerationType.IDENTITY)
         public Long getIdExame() {
                 return idExame;
          }
         public void setIdExame(Long idExame) {
                this.idExame = idExame;
          }
         
	public Date getDataExame() {
		return dataExame;
	  }
	public void setDataExame(Date dataExame) {
		this.dataExame = dataExame;
	}
        
	public Date getHoraExame() {
		return horaExame;
	}
	public void setHoraExame(Date horaExame) {
		this.horaExame = horaExame;
	}
	public String getTipoExame() {
		return tipoExame;
	}
	public void setTipoExame(String tipoExame) {
		this.tipoExame = tipoExame;
	}
        @ManyToOne(fetch = FetchType.EAGER)
	public Pacientes getPaciente() {
		return paciente;
	}
	public void setPaciente(Pacientes paciente) {
		this.paciente = paciente;
	}
        @OneToOne(fetch = FetchType.EAGER,mappedBy = "exame")
	public ResultadosExames getResultadoExame() {
		return resultadoExame;
	}
	public void setResultadoExame(ResultadosExames resultadoExame) {
		this.resultadoExame = resultadoExame;
	}	

}
