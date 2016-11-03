package br.upe.poo.clinica.listarEntidades;

import br.upe.poo.clinica.entidades.Exames;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class ListarExames implements Serializable {
   
        private Long idExame;
        private Long codigoExame;
	private Date dataExame;
	private Date horaExame;
	private String tipoExame;
	private Long paciente;
	private ListarResultadosExames resultadoExame;
	private Long consulta; 
        
	 public ListarExames(Exames exame) {
	         this.codigoExame = exame.getCodigoExame();
                 this.dataExame = exame.getDataExame();
                 this.horaExame = exame.getDataExame();
                 this.idExame = exame.getIdExame();
                 this.tipoExame = exame.getTipoExame();
                 this.consulta = exame.getConsulta().getCodigoConsulta();
                 this.paciente = exame.getPaciente().getCpf();
                 
                    if(exame.getResultadoExame()!=null) {
                        ListarResultadosExames listarResultadosExame = new ListarResultadosExames(exame.getResultadoExame());
                        this.resultadoExame = listarResultadosExame;
                    }
	 }
         
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.idExame);
        hash = 59 * hash + Objects.hashCode(this.codigoExame);
        hash = 59 * hash + Objects.hashCode(this.dataExame);
        hash = 59 * hash + Objects.hashCode(this.horaExame);
        hash = 59 * hash + Objects.hashCode(this.tipoExame);
        hash = 59 * hash + Objects.hashCode(this.paciente);
        hash = 59 * hash + Objects.hashCode(this.resultadoExame);
        hash = 59 * hash + Objects.hashCode(this.consulta);
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
        final ListarExames other = (ListarExames) obj;
        if (!Objects.equals(this.tipoExame, other.tipoExame)) {
            return false;
        }
        if (!Objects.equals(this.idExame, other.idExame)) {
            return false;
        }
        if (!Objects.equals(this.codigoExame, other.codigoExame)) {
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
        if (!Objects.equals(this.consulta, other.consulta)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Exames{" + "idExame=" + idExame + ", codigoExame=" + codigoExame + ", dataExame=" + dataExame + ", horaExame=" + horaExame + ", tipoExame=" + tipoExame + ", paciente=" + paciente + ", resultadoExame=" + resultadoExame + ", consulta=" + consulta + '}';
    }

    public Long getIdExame() {
        return idExame;
    }

    public void setIdExame(Long idExame) {
        this.idExame = idExame;
    }

    public Long getCodigoExame() {
        return codigoExame;
    }

    public void setCodigoExame(Long codigoExame) {
        this.codigoExame = codigoExame;
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

    public Long getPaciente() {
        return paciente;
    }

    public void setPaciente(Long paciente) {
        this.paciente = paciente;
    }

    public ListarResultadosExames getResultadoExame() {
        return resultadoExame;
    }

    public void setResultadoExame(ListarResultadosExames resultadoExame) {
        this.resultadoExame = resultadoExame;
    }

    public Long getConsulta() {
        return consulta;
    }

    public void setConsulta(Long consulta) {
        this.consulta = consulta;
    }

    
    }
