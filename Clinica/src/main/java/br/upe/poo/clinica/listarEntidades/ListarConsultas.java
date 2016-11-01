package br.upe.poo.clinica.listarEntidades;


import br.upe.poo.clinica.entidades.Consultas;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ListarConsultas implements Serializable {
    
        private Long numeroConsulta;
        private Long codigoConsulta;
        private boolean situacaoConsulta;
	private Date diaConsulta;
	private Date horaConsulta;
	private Long paciente;
	private Long  dadosConsulta;
	private Long medico;
        private List<ListarExames> exames;
	
            public ListarConsultas(Consultas consulta) {
                this.codigoConsulta = consulta.getCodigoConsulta();
                this.diaConsulta = consulta.getDiaConsulta();
                this.horaConsulta = consulta.getHoraConsulta();
                this.numeroConsulta = consulta.getNumeroConsulta();
                this.situacaoConsulta = consulta.isSituacaoConsulta();
                this.medico = consulta.getMedico().getCpf();
                this.paciente = consulta.getPaciente().getCpf();
                
                    for(int i = 0; i < consulta.getExames().size(); i++) {
                        ListarExames listarExames = new ListarExames(consulta.getExames().get(i));
                        this.exames = new ArrayList<>();
                        this.exames.add(listarExames);
                    }
                if(consulta.getDadosConsulta()!=null) {
                    ListarDadosConsultas listarDadosConsulta = new ListarDadosConsultas(consulta.getDadosConsulta());
                    this.exames = new ArrayList<>();
                    this.dadosConsulta = listarDadosConsulta.getIdDadosConsulta();
                }
                
            }
	    public ListarConsultas(Date diaConsulta,Date horaConsulta,Long codigoConsulta) {
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
        final ListarConsultas other = (ListarConsultas) obj;
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

    public Long getNumeroConsulta() {
        return numeroConsulta;
    }

    public void setNumeroConsulta(Long numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    public Long getCodigoConsulta() {
        return codigoConsulta;
    }

    public void setCodigoConsulta(Long codigoConsulta) {
        this.codigoConsulta = codigoConsulta;
    }

    public boolean isSituacaoConsulta() {
        return situacaoConsulta;
    }

    public void setSituacaoConsulta(boolean situacaoConsulta) {
        this.situacaoConsulta = situacaoConsulta;
    }

    public Date getDiaConsulta() {
        return diaConsulta;
    }

    public void setDiaConsulta(Date diaConsulta) {
        this.diaConsulta = diaConsulta;
    }

    public Date getHoraConsulta() {
        return horaConsulta;
    }

    public void setHoraConsulta(Date horaConsulta) {
        this.horaConsulta = horaConsulta;
    }

    public Long getPaciente() {
        return paciente;
    }

    public void setPaciente(Long paciente) {
        this.paciente = paciente;
    }

    public Long getMedico() {
        return medico;
    }

    public void setMedico(Long medico) {
        this.medico = medico;
    }

    public Long getDadosConsulta() {
        return dadosConsulta;
    }

    public void setDadosConsulta(Long dadosConsulta) {
        this.dadosConsulta = dadosConsulta;
    }

    public List<ListarExames> getExames() {
        return exames;
    }

    public void setExames(List<ListarExames> exames) {
        this.exames = exames;
    }

    
    
}