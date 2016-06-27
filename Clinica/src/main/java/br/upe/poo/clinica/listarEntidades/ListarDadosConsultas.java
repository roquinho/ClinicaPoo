package br.upe.poo.clinica.listarEntidades;

import br.upe.poo.clinica.entidades.DadosConsultas;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class ListarDadosConsultas implements Serializable {
  private Date inicioConsulta;
  private Date fimConsulta;
  private Long consulta;
  private Long idDadosConsulta;
  private String observacoes;
  
    public ListarDadosConsultas(DadosConsultas dadosConsultas) {
        this.fimConsulta = dadosConsultas.getFimConsulta();
        this.idDadosConsulta = dadosConsultas.getIdDadosConsulta();
        this.inicioConsulta = dadosConsultas.getInicioConsulta();
        this.observacoes = dadosConsultas.getObservacoes();
        this.consulta = dadosConsultas.getConsulta().getCodigoConsulta();
    }
    
    public ListarDadosConsultas(Date inicioConsulta,Date fimConsulta,String observacoes) {
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
        final ListarDadosConsultas other = (ListarDadosConsultas) obj;
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

    public Date getInicioConsulta() {
        return inicioConsulta;
    }

    public void setInicioConsulta(Date inicioConsulta) {
        this.inicioConsulta = inicioConsulta;
    }

    public Date getFimConsulta() {
        return fimConsulta;
    }

    public void setFimConsulta(Date fimConsulta) {
        this.fimConsulta = fimConsulta;
    }

    public Long getConsulta() {
        return consulta;
    }

    public void setConsulta(Long consulta) {
        this.consulta = consulta;
    }

    public Long getIdDadosConsulta() {
        return idDadosConsulta;
    }

    public void setIdDadosConsulta(Long idDadosConsulta) {
        this.idDadosConsulta = idDadosConsulta;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    
}
