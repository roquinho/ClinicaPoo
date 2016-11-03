
package br.upe.poo.clinica.regraNegocio;

import br.upe.poo.clinica.entidades.Consultas;
import br.upe.poo.clinica.entidades.Exames;
import br.upe.poo.clinica.entidades.Pacientes;
import br.upe.poo.clinica.listarEntidades.ListarExames;
import br.upe.poo.clinica.persistencia.InterfaceConsultasRepositorio;
import br.upe.poo.clinica.persistencia.InterfaceExamesRepositorio;
import br.upe.poo.clinica.persistencia.InterfaceRepositorioPacientes;
import java.util.ArrayList;
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
        ListarExames listarExames = null;
        
        if(codigoExame == null) {
            throw new ExceptionRegraNegocioFiltrarExame();
        }
        else {
            Exames exame = ire.findByCodigoExame(codigoExame);
             if(exame!=null) {
                listarExames = new ListarExames(exame);
             }
        }
        return listarExames;
    }
    
    @Override
    public List<ListarExames> filtrarTipoExame(String tipoExame) throws ExceptionRegraNegocioFiltrarExame {
        List<ListarExames> listarExames = new ArrayList<>();
        
        if(tipoExame == null) {
            throw new ExceptionRegraNegocioFiltrarExame();
        }
        else {
            List<Exames> exame = ire.findByTipoExame(tipoExame);
             if(exame!=null) {
                for(int i= 0; i<exame.size(); i++) {
                  ListarExames exames = new ListarExames(exame.get(i));
                   listarExames.add(exames);
                } 
             }
        }
        return listarExames;
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
        if(this.ire.findByCodigoExame(codigoExame)==null) {
            throw new ExceptionRegraNegocioDeletarExames();
        }
        else {
            this.ire.delete(codigoExame);
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
