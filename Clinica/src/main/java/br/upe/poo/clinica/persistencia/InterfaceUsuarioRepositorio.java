
package br.upe.poo.clinica.persistencia;

import br.upe.poo.clinica.entidades.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface InterfaceUsuarioRepositorio extends CrudRepository<Usuario, Long>{
    
}
