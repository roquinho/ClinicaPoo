
package br.upe.poo.clinica.regraNegocio;

import br.upe.poo.clinica.entidades.Consultas;
import br.upe.poo.clinica.entidades.Exames;
import br.upe.poo.clinica.entidades.Pacientes;
import br.upe.poo.clinica.listarEntidades.ListarExames;
import br.upe.poo.clinica.persistencia.InterfaceConsultasRepositorio;
import br.upe.poo.clinica.persistencia.InterfaceExamesRepositorio;
import br.upe.poo.clinica.persistencia.InterfaceRepositorioPacientes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author manoel
 */
@Service
public class RegraNegocioExames implements InterfaceRegraNegocioExames {
    
    @Autowired
    private InterfaceExamesRepositorio ire;
    @Autowired
    private InterfaceConsultasRepositorio irc;
    @Autowired
    private InterfaceRepositorioPacientes irp;
    
    public RegraNegocioExames () {          
      }
      
    @Override
    public void agendarExame(Exames exame,Long pacienteCpf,Long codigoConsulta) throws ExceptionRegraNegocioAgendarExame {
        
        Pacientes paciente = irp.findByCpf(pacienteCpf);
        Consultas consulta = irc.findByCodigoConsulta(codigoConsulta);
        
        if(exame == null) {
            throw new ExceptionRegraNegocioAgendarExame();
        }
        if(paciente == null) {
            throw new ExceptionRegraNegocioAgendarExame();
        }
        if(consulta == null) {
            throw new ExceptionRegraNegocioAgendarExame();
        }
        if(exame.getCodigoExame()== null) {
            throw new ExceptionRegraNegocioAgendarExame();
        }
        if(exame.getDataExame()==null) {
            throw new ExceptionRegraNegocioAgendarExame();
        }
        if(exame.getHoraExame()== null) {
            throw new ExceptionRegraNegocioAgendarExame();
        }
        if(exame.getTipoExame()== null) {
            throw new ExceptionRegraNegocioAgendarExame();
        }
        if(ire.findByCodigoExame(exame.getCodigoExame())!=null) {
            throw new ExceptionRegraNegocioAgendarExame();
        }
        else {
            exame.setPaciente(paciente);
            exame.setConsulta(consulta);
            ire.save(exame);
        }
        }

    @Override
    public ListarExames filtrarExameCodigo(Long codigoExame) throws ExceptionRegraNegocioFiltrarExame {
        Exames exame = null;
        
        if(codigoExame == null) {
            throw new ExceptionRegraNegocioFiltrarExame();
        }
        else {
            exame = ire.findByCodigoExame(codigoExame);
        }
        return new ListarExames(exame);
    }
    
    @Override
    public List<Exames> filtrarTipoExame(String tipoExame) throws ExceptionRegraNegocioFiltrarExame {
        List<Exames> exames = null;
        
        if(tipoExame == null) {
            throw new ExceptionRegraNegocioFiltrarExame();
        }
        else {
            exames = ire.findByTipoExame(tipoExame);
        }
        return exames;
    }

    @Override
    public void atualizarExame(Exames exame) throws ExceptionRegraNegocioAtualizarExames {
        Exames NovoExame = ire.findByCodigoExame(exame.getCodigoExame());
        
        if(NovoExame == null) {
            throw new ExceptionRegraNegocioAtualizarExames();
        }
        if(NovoExame.getPaciente() == null) {
            throw new ExceptionRegraNegocioAtualizarExames();
        }
        if(NovoExame.getConsulta() == null) {
            throw new ExceptionRegraNegocioAtualizarExames();
        }
        if(NovoExame.getCodigoExame()== null) {
            throw new ExceptionRegraNegocioAtualizarExames();
        }
        if(NovoExame.getDataExame()==null) {
            throw new ExceptionRegraNegocioAtualizarExames();
        }
        if(NovoExame.getHoraExame()== null) {
            throw new ExceptionRegraNegocioAtualizarExames();
        }
        if(NovoExame.getTipoExame()== null) {
            throw new ExceptionRegraNegocioAtualizarExames();
        }
        else {
            NovoExame.setCodigoExame(exame.getCodigoExame());
            NovoExame.setDataExame(exame.getDataExame());
            NovoExame.setHoraExame(exame.getHoraExame());
            NovoExame.setTipoExame(exame.getTipoExame());
            ire.save(NovoExame);
        }
    }

    @Override
    public void deletarExame(Long codigoExame) throws ExceptionRegraNegocioDeletarExames {
        if(codigoExame == null) {
            throw new ExceptionRegraNegocioDeletarExames();
        }
        else {
            ire.delete(ire.findByCodigoExame(codigoExame));
        }
    }

    public InterfaceExamesRepositorio getIre() {
        return ire;
    }

    public void setIre(InterfaceExamesRepositorio ire) {
        this.ire = ire;
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

    
}
