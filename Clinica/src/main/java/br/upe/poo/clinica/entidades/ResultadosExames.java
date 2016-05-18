package br.upe.poo.clinica.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ResultadosExames implements Serializable {
 
      private Pacientes paciente;
      private Long idResultadoExames;
      private Medicos medico;
      private Exames exame;

      public ResultadosExames() {
          
      }
      
      public ResultadosExames(Exames exame){
          this.exame = exame;
      }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.paciente);
        hash = 17 * hash + Objects.hashCode(this.idResultadoExames);
        hash = 17 * hash + Objects.hashCode(this.medico);
        hash = 17 * hash + Objects.hashCode(this.exame);
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
        final ResultadosExames other = (ResultadosExames) obj;
        if (!Objects.equals(this.paciente, other.paciente)) {
            return false;
        }
        if (!Objects.equals(this.idResultadoExames, other.idResultadoExames)) {
            return false;
        }
        if (!Objects.equals(this.medico, other.medico)) {
            return false;
        }
        if (!Objects.equals(this.exame, other.exame)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ResultadosExames{" + "paciente=" + paciente + ", idResultadoExames=" + idResultadoExames + ", medico=" + medico + ", exame=" + exame + '}';
    }

       @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return idResultadoExames;
    }

    public void setId(Long idResultadoExames) {
        this.idResultadoExames = idResultadoExames;
    }  
    
     @OneToOne(fetch = FetchType.EAGER) 
    public Exames getExame() {
        return exame;
    }

    public void setExame(Exames exame) {
        this.exame = exame;
    }
    
     @ManyToOne(fetch = FetchType.EAGER) 
    public Medicos getMedico() {
        return medico;
    }

    public void setMedico(Medicos medico) {
        this.medico = medico;
    }
       
    @ManyToOne(fetch = FetchType.EAGER)
    public Pacientes getPaciente() {
        return paciente;
    }

    public void setPaciente(Pacientes paciente) {
        this.paciente = paciente;
    }
    
}
