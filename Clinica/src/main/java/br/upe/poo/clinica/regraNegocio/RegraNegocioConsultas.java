
package br.upe.poo.clinica.regraNegocio;

import br.upe.poo.clinica.entidades.Consultas;
import br.upe.poo.clinica.entidades.Medicos;
import br.upe.poo.clinica.entidades.Pacientes;
import br.upe.poo.clinica.listarEntidades.ListarConsultas;
import br.upe.poo.clinica.persistencia.InterfaceConsultasRepositorio;
import br.upe.poo.clinica.persistencia.InterfaceMedicosRepositorio;
import br.upe.poo.clinica.persistencia.InterfaceRepositorioPacientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author manoel
 */
@Service
public class RegraNegocioConsultas implements InterfaceRegraNegocioConsultas {
    
    @Autowired
    private InterfaceConsultasRepositorio irc;
    @Autowired
    private InterfaceRepositorioPacientes irp;
    @Autowired
    private InterfaceMedicosRepositorio irm;
    
    public RegraNegocioConsultas() {        
    }

    @Override
    public void agendarConsulta(Consultas consulta,Long PacienteCpf,Long MedicoCpf) throws ExceptionRegraNegocioAgendarConsultas {
        
       Pacientes paciente = irp.findByCpf(PacienteCpf);
       Medicos medico = irm.findByCpf(MedicoCpf);
            
        if(consulta == null) {
            throw new ExceptionRegraNegocioAgendarConsultas();
        }
        if(paciente == null) {
            throw new ExceptionRegraNegocioAgendarConsultas();
        }
        if(medico == null) {
            throw new ExceptionRegraNegocioAgendarConsultas();
        }
        if(consulta.getDiaConsulta()==null) {
            throw new ExceptionRegraNegocioAgendarConsultas();
        }
        if(consulta.getHoraConsulta()==null) {
            throw new ExceptionRegraNegocioAgendarConsultas();
        }
        if(consulta.getCodigoConsulta() == null) {
            throw new ExceptionRegraNegocioAgendarConsultas();
        }
       if(irc.findByCodigoConsulta(consulta.getCodigoConsulta())!=null) {
            throw new ExceptionRegraNegocioAgendarConsultas();
        }
        else {
            
               consulta.setPaciente(paciente);
               consulta.setMedico(medico);
               irc.save(consulta);     
        }
                
    }

    @Override
    public ListarConsultas filtrarConsultaCodigoConsulta(Long codigoConsulta) throws ExceptionRegraNegocioFiltrarConsultas {
        Consultas consultas = null;
        
        if(codigoConsulta == null) {
            throw new ExceptionRegraNegocioFiltrarConsultas();
        }
        else {
            consultas = irc.findByCodigoConsulta(codigoConsulta);
        }       
        return new ListarConsultas(consultas);
    }

    @Override
    public void atualizarConsulta(Consultas consulta) throws ExceptionRegraNegocioAtualizarConsultas {
        Consultas Novaconsulta = irc.findByCodigoConsulta(consulta.getCodigoConsulta());
    
        if(Novaconsulta == null) {
            throw new ExceptionRegraNegocioAtualizarConsultas();
        }
        if(Novaconsulta.getPaciente()== null) {
            throw new ExceptionRegraNegocioAtualizarConsultas();
        }
        if(Novaconsulta.getMedico() == null) {
            throw new ExceptionRegraNegocioAtualizarConsultas();
        }
        if(Novaconsulta.getDiaConsulta()==null) {
            throw new ExceptionRegraNegocioAtualizarConsultas();
        }
        if(Novaconsulta.getHoraConsulta()==null) {
            throw new ExceptionRegraNegocioAtualizarConsultas();
        }
        if(Novaconsulta.getCodigoConsulta()==null) {
            throw new ExceptionRegraNegocioAtualizarConsultas();
        }
        else {
            Novaconsulta.setDiaConsulta(consulta.getDiaConsulta());
            Novaconsulta.setHoraConsulta(consulta.getHoraConsulta());
            Novaconsulta.setSituacaoConsulta(consulta.isSituacaoConsulta());
             irc.save(Novaconsulta);
        }
        
    }

    @Override
    public void deletarConsultas(Long codigoConsulta) throws ExceptionRegraNegocioDeletarConsultas {  
                
            irc.delete(irc.findByCodigoConsulta(codigoConsulta));
        
    }
    
    
    public InterfaceConsultasRepositorio getIrc() {
        return irc;
    }

    public void setIrc(InterfaceConsultasRepositorio irc) {
        this.irc = irc;
    }

    public InterfaceRepositorioPacientes getIrp() {
        return irp;
    }

    public void setIrp(InterfaceRepositorioPacientes irp) {
        this.irp = irp;
    }

    public InterfaceMedicosRepositorio getIrm() {
        return irm;
    }

    public void setIrm(InterfaceMedicosRepositorio irm) {
        this.irm = irm;
    }
    
    
}
