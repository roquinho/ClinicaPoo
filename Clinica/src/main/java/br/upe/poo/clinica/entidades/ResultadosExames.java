package br.upe.poo.clinica.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ResultadosExames implements Serializable {
 
      private Long idResultadoExames;
      private Exames exame;
      private String diagnostico;

      public ResultadosExames() {
          
      }      
      public ResultadosExames(Exames exame){
          this.exame = exame;
      }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.idResultadoExames);
        hash = 17 * hash + Objects.hashCode(this.exame);
        hash = 17 * hash + Objects.hashCode(this.diagnostico);
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
        if (!Objects.equals(this.diagnostico, other.diagnostico)) {
            return false;
        }
        if (!Objects.equals(this.idResultadoExames, other.idResultadoExames)) {
            return false;
        }
        if (!Objects.equals(this.exame, other.exame)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ResultadosExames{" + "idResultadoExames=" + idResultadoExames + ", exame=" + exame + ", diagnostico=" + diagnostico + '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getIdResultadoExames() {
        return idResultadoExames;
    }

    public void setIdResultadoExames(Long idResultadoExames) {
        this.idResultadoExames = idResultadoExames;
    }
    @OneToOne(fetch = FetchType.EAGER) 
    public Exames getExame() {
        return exame;
    }

    public void setExame(Exames exame) {
        this.exame = exame;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    
    
}
