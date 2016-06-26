
package br.upe.poo.clinica.regraNegocio;

import br.upe.poo.clinica.entidades.Consultas;
import java.io.Serializable;

/**
 *
 * @author manoel
 */
public interface InterfaceRegraNegocioConsultas extends Serializable {
    
    public void agendarConsulta(Consultas consulta,Long PacienteCpf,Long MedicoCpf)throws ExceptionRegraNegocioAgendarConsultas;
    
    public Consultas filtrarConsultaCodigoConsulta(Long codigoConsulta)throws ExceptionRegraNegocioFiltrarConsultas; 
    
    public void atualizarConsulta(Consultas consulta)throws ExceptionRegraNegocioAtualizarConsultas;
    
    public void deletarConsultas(Long codigoConsulta)throws ExceptionRegraNegocioDeletarConsultas;
}
