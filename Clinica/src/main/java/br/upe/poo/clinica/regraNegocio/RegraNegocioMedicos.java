
package br.upe.poo.clinica.regraNegocio;

import br.upe.poo.clinica.entidades.Medicos;
import br.upe.poo.clinica.listarEntidades.ListarMedicos;
import br.upe.poo.clinica.persistencia.InterfaceMedicosRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author manoel
 */
@Service
public class RegraNegocioMedicos implements InterfaceRegraNegocioMedicos {
    
    @Autowired
    private InterfaceMedicosRepositorio irm;
     
      public RegraNegocioMedicos() {
          
      }
    @Override
    public void cadastrarMedicos(Medicos medico) throws ExceptionRegraNegocioCadastrarMedicos {
        if(medico==null) {
            throw new ExceptionRegraNegocioCadastrarMedicos();
        }
        if(medico.getNome()==null) {
            throw new ExceptionRegraNegocioCadastrarMedicos();
        }
        if(medico.getCpf()==null) {
            throw new ExceptionRegraNegocioCadastrarMedicos();
        }
        if(medico.getCrm()==null) {
            throw new ExceptionRegraNegocioCadastrarMedicos();
        }
        if(medico.getEspecialidade()==null) {
            throw new ExceptionRegraNegocioCadastrarMedicos();
        }
        if(irm.findByCpf(medico.getCpf())!=null) {
            throw new ExceptionRegraNegocioCadastrarMedicos();
        }
        else {
            irm.save(medico);
        }
    }

    @Override
    public ListarMedicos buscarMedicoCpf(Long cpf) throws ExceptionRegraNegocioBuscarMedicos {
        Medicos medico = null;
        if(cpf==null) {
            throw new ExceptionRegraNegocioBuscarMedicos();
        }
        else {
            medico = irm.findByCpf(cpf);
        }
       return new ListarMedicos(medico);
    }

    @Override
    public List<Medicos> buscarMedicoNome(String nome) throws ExceptionRegraNegocioBuscarMedicos {
        List<Medicos> medicos = null;
         if(nome==null) {
             throw new ExceptionRegraNegocioBuscarMedicos();
         }
         else {
          medicos = irm.findByNome(nome);
    }
         return medicos;
    }
    
    @Override
    public List<Medicos> buscarMedicoEspecialidade(String especialidade) throws ExceptionRegraNegocioBuscarMedicos {
      List<Medicos> medicos = null;
         if(especialidade==null) {
             throw new ExceptionRegraNegocioBuscarMedicos();
         }
         else {
          medicos = irm.findByEspecialidade(especialidade);
    }
         return medicos;
    }

    @Override
    public void atualizarMedico(Medicos medico) throws ExceptionRegraNegocioAtualizarMedicos {
                if(medico==null) {
            throw new ExceptionRegraNegocioAtualizarMedicos();
        }
        if(medico.getNome()==null) {
            throw new ExceptionRegraNegocioAtualizarMedicos();
        }
        if(medico.getCpf()==null) {
            throw new ExceptionRegraNegocioAtualizarMedicos();
        }
        if(medico.getCrm()==null) {
            throw new ExceptionRegraNegocioAtualizarMedicos();
        }
        if(medico.getEspecialidade()==null) {
            throw new ExceptionRegraNegocioAtualizarMedicos();
        }
        if(irm.findByCpf(medico.getCpf())==null) {
            throw new ExceptionRegraNegocioAtualizarMedicos();
        }
        else {
            irm.save(medico);
        }
    }

    @Override
    public void deletarMedico(Medicos medico) throws ExceptionRegraNegocioDeletarMedicos {
        if(medico == null) {
            throw new ExceptionRegraNegocioDeletarMedicos();
        }
        if(irm.findByCpf(medico.getCpf())==null) {
            throw new ExceptionRegraNegocioDeletarMedicos();
        }
        else {
            irm.delete(medico);
        }
    }

    public InterfaceMedicosRepositorio getIrm() {
        return irm;
    }

    public void setIrm(InterfaceMedicosRepositorio irm) {
        this.irm = irm;
    }

    
}
