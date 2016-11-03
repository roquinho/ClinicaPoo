
package br.upe.poo.clinica.regraNegocio;

import br.upe.poo.clinica.entidades.Exames;
import br.upe.poo.clinica.entidades.ResultadosExames;
import br.upe.poo.clinica.listarEntidades.ListarResultadosExames;
import br.upe.poo.clinica.persistencia.InterfaceExamesRepositorio;
import br.upe.poo.clinica.persistencia.InterfaceResultadosExamesRepositorio;
import javax.faces.lifecycle.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author manoel
 */
@Service
public class RegraNegocioResultadoExames implements InterfaceRegraNegocioResultadoExames {
    
    @Autowired
    private InterfaceResultadosExamesRepositorio irr;
    @Autowired
    private InterfaceExamesRepositorio ire;
    
   

    @Override
    public void gerarResultadoExames(ResultadosExames resultadoExames,Long codigoExame) throws ExceptionRegraNegocioResultadosExamesGerar {
        Exames exame = ire.findByCodigoExame(codigoExame);
        
        if(resultadoExames==null) {
            throw new ExceptionRegraNegocioResultadosExamesGerar();
        }
        if(exame== null) {
            throw new ExceptionRegraNegocioResultadosExamesGerar();
        }
        if(resultadoExames.getIdResultadoExames() == null) {
            throw new ExceptionRegraNegocioResultadosExamesGerar();
        }
        if(resultadoExames.getDiagnostico() == null) {
            throw new ExceptionRegraNegocioResultadosExamesGerar();
        }
        if(irr.findByIdResultadoExames(resultadoExames.getIdResultadoExames())!=null) {
            throw new ExceptionRegraNegocioResultadosExamesGerar();
        }
        else {
            resultadoExames.setExame(exame);
            irr.save(resultadoExames);
        }
    }

    @Override
    public ListarResultadosExames filtrarResultadoExame(Long idResultadoExames) throws ExceptionRegraNegocioResultadosExamesFiltrar {
       ListarResultadosExames listarResultadosExames = null; 
         if(idResultadoExames == null) {
             throw new ExceptionRegraNegocioResultadosExamesFiltrar();
         }
         else {
           ResultadosExames resultadosExames = irr.findByIdResultadoExames(idResultadoExames);
             if(resultadosExames!=null) {
                 listarResultadosExames = new ListarResultadosExames(resultadosExames);
             }
         }
         return listarResultadosExames;
    }

    @Override
    public void atualizarResultadoExame(ResultadosExames resultadosExames) throws ExceptionRegraNegocioResultadosExamesAtualizar {
        ResultadosExames novoResultadosExames = irr.findByIdResultadoExames(resultadosExames.getIdResultadoExames());
        
        if(novoResultadosExames==null) {
            throw new ExceptionRegraNegocioResultadosExamesAtualizar();
        }
        if(novoResultadosExames.getExame()== null) {
            throw new ExceptionRegraNegocioResultadosExamesAtualizar();
        }
        if(novoResultadosExames.getIdResultadoExames() == null) {
            throw new ExceptionRegraNegocioResultadosExamesAtualizar();
        }
        if(novoResultadosExames.getDiagnostico() == null) {
            throw new ExceptionRegraNegocioResultadosExamesAtualizar();
        }
        else {
            novoResultadosExames.setDiagnostico(resultadosExames.getDiagnostico());
            novoResultadosExames.setIdResultadoExames(resultadosExames.getIdResultadoExames());
            irr.save(novoResultadosExames);
        }
    }

    @Override
    public void deletarResultadoExame(Long idResultadoExames) throws ExceptionRegraNegocioResultadosExamesDeletar {
        if(idResultadoExames == null) {
            throw new ExceptionRegraNegocioResultadosExamesDeletar();
        }
        else {
            irr.delete(irr.findByIdResultadoExames(idResultadoExames));
        }
    }
    
}
