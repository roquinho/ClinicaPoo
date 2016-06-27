package br.upe.poo.clinica.listarEntidades;

import br.upe.poo.clinica.entidades.ResultadosExames;
import java.io.Serializable;
import java.util.Objects;


public class ListarResultadosExames implements Serializable {
 
      private Long idResultadoExames;
      private Long exame;
      private String diagnostico;

      public ListarResultadosExames(ResultadosExames resultadosExames) {
          this.diagnostico = resultadosExames.getDiagnostico();
          this.idResultadoExames = resultadosExames.getIdResultadoExames();
          this.exame = resultadosExames.getExame().getCodigoExame();
      }

      
      public ListarResultadosExames(String diagnostico) {
          this.diagnostico = diagnostico;
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
        final ListarResultadosExames other = (ListarResultadosExames) obj;
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

    public Long getIdResultadoExames() {
        return idResultadoExames;
    }

    public void setIdResultadoExames(Long idResultadoExames) {
        this.idResultadoExames = idResultadoExames;
    }

    public Long getExame() {
        return exame;
    }

    public void setExame(Long exame) {
        this.exame = exame;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    
   }
