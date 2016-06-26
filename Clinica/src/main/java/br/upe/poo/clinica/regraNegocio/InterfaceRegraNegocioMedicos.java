
package br.upe.poo.clinica.regraNegocio;

import br.upe.poo.clinica.entidades.Medicos;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author manoel
 */
public interface InterfaceRegraNegocioMedicos extends Serializable {
    
    public void cadastrarMedicos(Medicos medico)throws ExceptionRegraNegocioCadastrarMedicos;
    
    public Medicos buscarMedicoCpf(Long cpf)throws ExceptionRegraNegocioBuscarMedicos;
    
    public List<Medicos> buscarMedicoNome(String nome)throws ExceptionRegraNegocioBuscarMedicos;
    
    public List<Medicos> buscarMedicoEspecialidade(String especialidade)throws ExceptionRegraNegocioBuscarMedicos;
    
    public void atualizarMedico(Medicos medico)throws ExceptionRegraNegocioAtualizarMedicos;
    
    public void deletarMedico(Medicos medico)throws ExceptionRegraNegocioDeletarMedicos;

}
