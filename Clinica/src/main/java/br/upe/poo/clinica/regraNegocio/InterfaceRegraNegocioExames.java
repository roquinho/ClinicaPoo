
package br.upe.poo.clinica.regraNegocio;

import br.upe.poo.clinica.entidades.Exames;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author manoel
 */
public interface InterfaceRegraNegocioExames extends Serializable {
    
    public void agendarExame(Exames exame,Long pacienteCpf,Long codigoConsulta)throws ExceptionRegraNegocioAgendarExame;
    
    public Exames filtrarExameCodigo(Long codigoExame)throws ExceptionRegraNegocioFiltrarExame;
    
    public List<Exames> filtrarTipoExame(String tipoExame)throws ExceptionRegraNegocioFiltrarExame;
    
    public void atualizarExame(Exames exame)throws ExceptionRegraNegocioAtualizarExames;
    
    public void deletarExame(Long codigoExame)throws ExceptionRegraNegocioDeletarExames;
}
