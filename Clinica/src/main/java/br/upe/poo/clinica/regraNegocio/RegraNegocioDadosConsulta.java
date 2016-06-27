
package br.upe.poo.clinica.regraNegocio;

import br.upe.poo.clinica.entidades.Consultas;
import br.upe.poo.clinica.entidades.DadosConsultas;
import br.upe.poo.clinica.listarEntidades.ListarDadosConsultas;
import br.upe.poo.clinica.persistencia.InterfaceConsultasRepositorio;
import br.upe.poo.clinica.persistencia.InterfaceDadosConsultasRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author manoel
 */
@Service
public class RegraNegocioDadosConsulta implements InterfaceRegraNegocioDadosConsulta {
    
    @Autowired
    private InterfaceDadosConsultasRepositorio ird;
    @Autowired
    private InterfaceConsultasRepositorio irc;
    
    public RegraNegocioDadosConsulta() {        
    }

    @Override
    public void gerarDadosConsulta(DadosConsultas dadosConsulta,Long codigoConsulta) throws ExceptionRegraNegocioDadosConsultasGerar {
        Consultas consulta = irc.findByCodigoConsulta(codigoConsulta);
        
        if(dadosConsulta == null) {
            throw new ExceptionRegraNegocioDadosConsultasGerar();
        }
        if(consulta == null) {
            throw new ExceptionRegraNegocioDadosConsultasGerar();
        }
        if(dadosConsulta.getIdDadosConsulta()== null) {
            throw new ExceptionRegraNegocioDadosConsultasGerar();
        }
        if(dadosConsulta.getInicioConsulta()==null) {
            throw new ExceptionRegraNegocioDadosConsultasGerar();
        }
        if(dadosConsulta.getFimConsulta()==null) {
            throw new ExceptionRegraNegocioDadosConsultasGerar();
        }
        if(dadosConsulta.getObservacoes()==null) {
            throw new ExceptionRegraNegocioDadosConsultasGerar();
        }
        if(ird.findByIdDadosConsulta(dadosConsulta.getIdDadosConsulta())!=null) {
            throw new ExceptionRegraNegocioDadosConsultasGerar();
        }
        else {
            dadosConsulta.setConsulta(consulta);
            ird.save(dadosConsulta);
        }
    }

    @Override
    public ListarDadosConsultas filtrarDadosConsulta(Long idDadosConsulta) throws ExceptionRegraNegocioDadosConsultasFiltrar {
        DadosConsultas dadosConsultas = null;
         if(idDadosConsulta == null) {
             throw new ExceptionRegraNegocioDadosConsultasFiltrar();
         }
         else {
             dadosConsultas = ird.findByIdDadosConsulta(idDadosConsulta);
         }
         return new ListarDadosConsultas(dadosConsultas);
    }

    @Override
    public void atualizarDadosConsulta(DadosConsultas dadosConsultas) throws ExceptionRegraNegocioDadosConsultasAtualizar {
        DadosConsultas novosDadosConsulta = ird.findByIdDadosConsulta(dadosConsultas.getIdDadosConsulta());
        
        if(novosDadosConsulta == null) {
            throw new ExceptionRegraNegocioDadosConsultasAtualizar();
        }
        if(novosDadosConsulta.getConsulta() == null) {
            throw new ExceptionRegraNegocioDadosConsultasAtualizar();
        }
        if(novosDadosConsulta.getIdDadosConsulta()== null) {
            throw new ExceptionRegraNegocioDadosConsultasAtualizar();
        }
        if(novosDadosConsulta.getInicioConsulta()==null) {
            throw new ExceptionRegraNegocioDadosConsultasAtualizar();
        }
        if(novosDadosConsulta.getFimConsulta()==null) {
            throw new ExceptionRegraNegocioDadosConsultasAtualizar();
        }
        if(novosDadosConsulta.getObservacoes()==null) {
            throw new ExceptionRegraNegocioDadosConsultasAtualizar();
        }
        else {
            novosDadosConsulta.setFimConsulta(dadosConsultas.getFimConsulta());
            novosDadosConsulta.setInicioConsulta(dadosConsultas.getInicioConsulta());
            novosDadosConsulta.setObservacoes(dadosConsultas.getObservacoes());
            ird.save(novosDadosConsulta);
        }
    }

    @Override
    public void deletarDadosConsulta(Long idDadosConsulta) throws ExceptionRegraNegocioDadosConsultasDeletar {
        if(idDadosConsulta == null) {
            throw new ExceptionRegraNegocioDadosConsultasDeletar();
        }
        else {
            ird.delete(ird.findByIdDadosConsulta(idDadosConsulta));
        }
    }

    public InterfaceDadosConsultasRepositorio getIrd() {
        return ird;
    }

    public void setIrd(InterfaceDadosConsultasRepositorio ird) {
        this.ird = ird;
    }

    public InterfaceConsultasRepositorio getIrc() {
        return irc;
    }

    public void setIrc(InterfaceConsultasRepositorio irc) {
        this.irc = irc;
    }
    
}
