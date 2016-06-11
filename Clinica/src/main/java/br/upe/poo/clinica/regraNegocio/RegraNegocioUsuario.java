
package br.upe.poo.clinica.regraNegocio;

import br.upe.poo.clinica.entidades.Usuario;
import br.upe.poo.clinica.persistencia.InterfaceUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author manoel
 */
@Service
public class RegraNegocioUsuario implements InterfaceRegraNegocioUsuario{

    @Autowired
    private InterfaceUsuarioRepositorio iru;
    
    public RegraNegocioUsuario() {
        
    }
    
    @Override
    public void cadastarUsuario(Usuario usuario) throws ExceptionRegraNegocioCadastrarUsuario {
        if(usuario == null) {
            throw new ExceptionRegraNegocioCadastrarUsuario();
        }
        if(usuario.getNome()==null) {
            throw new ExceptionRegraNegocioCadastrarUsuario();
        }
        if(usuario.getCpf()==null) {
            throw new ExceptionRegraNegocioCadastrarUsuario();
        }
        if(usuario.getLogin()== null) {
            throw new ExceptionRegraNegocioCadastrarUsuario();
        }
        if(usuario.getSenha() == null) {
            throw new ExceptionRegraNegocioCadastrarUsuario();
        }
        if(iru.findByCpf(usuario.getCpf())!=null) {
            throw new ExceptionRegraNegocioCadastrarUsuario();
        }
        else {
            iru.save(usuario);
        }
     }

    @Override
    public Usuario filtrarUsuarioCpf(Long cpf) throws ExceptionRegraNegocioFiltrarUsuario {
     Usuario usuario = null;
     
        if(cpf == null) {
            throw new ExceptionRegraNegocioFiltrarUsuario();
        }
        else {
            usuario = iru.findByCpf(cpf);
        }
        return usuario;
    }

    @Override
    public void atualizarUsuario(Usuario usuario) throws ExceptionRegraNegocioAtualizarUsuario {
                if(usuario == null) {
            throw new ExceptionRegraNegocioAtualizarUsuario();
        }
        if(usuario.getNome()==null) {
            throw new ExceptionRegraNegocioAtualizarUsuario();
        }
        if(usuario.getCpf()==null) {
            throw new ExceptionRegraNegocioAtualizarUsuario();
        }
        if(usuario.getLogin()== null) {
            throw new ExceptionRegraNegocioAtualizarUsuario();
        }
        if(usuario.getSenha() == null) {
            throw new ExceptionRegraNegocioAtualizarUsuario();
        }
        if(iru.findByCpf(usuario.getCpf())==null) {
            throw new ExceptionRegraNegocioAtualizarUsuario();
        }
        else {
            iru.save(usuario);
        }
    }

    @Override
    public void deletarUsuario(Usuario usuario) throws ExceptionRegraNegocioDeletarUsuario {
        if(usuario == null) {
            throw  new ExceptionRegraNegocioDeletarUsuario();
        }
        if(iru.findByCpf(usuario.getCpf())==null) {
            throw new ExceptionRegraNegocioDeletarUsuario();
        }
        else {
            iru.delete(usuario);
        }
    }

    public InterfaceUsuarioRepositorio getIru() {
        return iru;
    }

    public void setIru(InterfaceUsuarioRepositorio iru) {
        this.iru = iru;
    }
    
    
}
