
package br.upe.poo.clinica.regraNegocio;

import br.upe.poo.clinica.entidades.DadosConsultas;
import java.io.Serializable;

/**
 *
 * @author manoel
 */
public interface InterfaceRegraNegocioDadosConsulta extends Serializable {
    
    public void gerarDadosConsulta(DadosConsultas dadosConsulta,Long codigoConsulta)throws ExceptionRegraNegocioDadosConsultasGerar;
    
    public DadosConsultas filtrarDadosConsulta(Long idDadosConsulta)throws ExceptionRegraNegocioDadosConsultasFiltrar;
    
    public void atualizarDadosConsulta(DadosConsultas dadosConsultas)throws ExceptionRegraNegocioDadosConsultasAtualizar;
    
    public void deletarDadosConsulta(Long idDadosConsulta)throws ExceptionRegraNegocioDadosConsultasDeletar;
}
