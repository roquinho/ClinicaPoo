
package br.upe.poo.clinica.regraNegocio;

import br.upe.poo.clinica.entidades.Medicos;
import br.upe.poo.clinica.listarEntidades.ListarMedicos;
import br.upe.poo.clinica.persistencia.InterfaceMedicosRepositorio;
import java.util.ArrayList;
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
        ListarMedicos listarMedicos = null;
        if(cpf==null) {
           throw new ExceptionRegraNegocioBuscarMedicos();
        }
        else {
           Medicos medico = irm.findByCpf(cpf);
             if(medico!=null) {
                listarMedicos = new ListarMedicos(medico);
             }
        }
      return listarMedicos;
    }

    @Override
    public List<ListarMedicos> buscarMedicoNome(String nome) throws ExceptionRegraNegocioBuscarMedicos {        
        List<ListarMedicos> listarMedicos = new ArrayList<>();
        
         if(nome==null) {
             throw new ExceptionRegraNegocioBuscarMedicos();
         }
         else {
           List<Medicos> medico = irm.findByNome(nome);
             if(medico!=null) {
                 for(int i = 0; i<medico.size(); i++) {
                   ListarMedicos medicos = new ListarMedicos(medico.get(i));
                    listarMedicos.add(medicos);
                 }
             }
          
    }
         return listarMedicos;
    }
    
    @Override
    public List<ListarMedicos> buscarMedicoEspecialidade(String especialidade) throws ExceptionRegraNegocioBuscarMedicos {
      List<ListarMedicos> listarMedicos = new ArrayList<>();
      
         if(especialidade==null) {
             throw new ExceptionRegraNegocioBuscarMedicos();
         }
         else {
         List<Medicos> medico = irm.findByEspecialidade(especialidade);
          if(medico!=null) {
                 for(int i = 0; i<medico.size(); i++) {
                   ListarMedicos medicos = new ListarMedicos(medico.get(i));
                     listarMedicos.add(medicos);
            
                           }
          }
         }
         return listarMedicos;
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
            this.irm.delete(medico);
        }
    }

    public InterfaceMedicosRepositorio getIrm() {
        return irm;
    }

    public void setIrm(InterfaceMedicosRepositorio irm) {
        this.irm = irm;
    }

    
}
