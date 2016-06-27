
package br.upe.poo.clinica.regraNegocio;

import br.upe.poo.clinica.entidades.ResultadosExames;
import br.upe.poo.clinica.listarEntidades.ListarResultadosExames;
import java.io.Serializable;

/**
 *
 * @author manoel
 */
public interface InterfaceRegraNegocioResultadoExames extends Serializable {
    
    public void gerarResultadoExames(ResultadosExames resultadoExames,Long codigoExame)throws ExceptionRegraNegocioResultadosExamesGerar;
    
    public ListarResultadosExames filtrarResultadoExame(Long idResultadoExames)throws ExceptionRegraNegocioResultadosExamesFiltrar;
    
    public void atualizarResultadoExame(ResultadosExames resultadosExames)throws ExceptionRegraNegocioResultadosExamesAtualizar;
    
    public void deletarResultadoExame(Long idResultadoExames)throws ExceptionRegraNegocioResultadosExamesDeletar;
}
