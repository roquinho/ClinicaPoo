package br.upe.poo.clinica.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class DadosConsultas implements Serializable {
  private Date inicioConsulta;
  private Date fimConsulta;
  private Consultas consulta;
  private Long idDadosConsulta;
  private String observacoes;
  
    public DadosConsultas() {
        
    }
    
    public DadosConsultas(Date inicioConsulta,Date fimConsulta,String observacoes) {
        this.observacoes = observacoes; 
        this.inicioConsulta = inicioConsulta;
        this.fimConsulta = fimConsulta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.inicioConsulta);
        hash = 53 * hash + Objects.hashCode(this.fimConsulta);
        hash = 53 * hash + Objects.hashCode(this.consulta);
        hash = 53 * hash + Objects.hashCode(this.idDadosConsulta);
        hash = 53 * hash + Objects.hashCode(this.observacoes);
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
        final DadosConsultas other = (DadosConsultas) obj;
        if (!Objects.equals(this.observacoes, other.observacoes)) {
            return false;
        }
        if (!Objects.equals(this.inicioConsulta, other.inicioConsulta)) {
            return false;
        }
        if (!Objects.equals(this.fimConsulta, other.fimConsulta)) {
            return false;
        }
        if (!Objects.equals(this.consulta, other.consulta)) {
            return false;
        }
        if (!Objects.equals(this.idDadosConsulta, other.idDadosConsulta)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DadosConsultas{" + "inicioConsulta=" + inicioConsulta + ", fimConsulta=" + fimConsulta + ", consulta=" + consulta + ", idDadosConsulta=" + idDadosConsulta + ", observacoes=" + observacoes + '}';
    }
    
    @Id
    public Long getIdDadosConsulta() {
        return idDadosConsulta;
    }

    public void setIdDadosConsulta(Long idDadosConsulta) {
        this.idDadosConsulta = idDadosConsulta;
    }
  
    @OneToOne(fetch = FetchType.EAGER)
    public Consultas getConsulta() {
        return consulta;
    }

    public void setConsulta(Consultas consulta) {
        this.consulta = consulta;
    }
  @Temporal(TemporalType.DATE) 
  public Date getInicioConsulta() {
      return this.inicioConsulta;
  }
  public void setInicioConsulta(Date inicioConsulta) {
      this.inicioConsulta = inicioConsulta;
  }
  @Temporal(TemporalType.DATE)
  public Date getFimConsulta() {
      return this.fimConsulta;
  }
  public void setFimConsulta(Date fimConsulta) {
      this.fimConsulta = fimConsulta;
  }

  public String getObservacoes() {
        return observacoes;
    }

  public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
  
}
