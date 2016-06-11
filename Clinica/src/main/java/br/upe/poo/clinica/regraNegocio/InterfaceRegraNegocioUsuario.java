
package br.upe.poo.clinica.regraNegocio;

import br.upe.poo.clinica.entidades.Usuario;
import java.io.Serializable;

/**
 *
 * @author manoel
 */
public interface InterfaceRegraNegocioUsuario extends Serializable {
    
    public void cadastarUsuario(Usuario usuario)throws ExceptionRegraNegocioCadastrarUsuario;
    
    public Usuario filtrarUsuarioCpf(Long cpf)throws ExceptionRegraNegocioFiltrarUsuario;
    
    public void atualizarUsuario(Usuario usuario)throws ExceptionRegraNegocioAtualizarUsuario;
    
    public void deletarUsuario(Usuario usuario)throws ExceptionRegraNegocioDeletarUsuario;
}
