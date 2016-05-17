
package br.upe.poo.clinica.persistencia;

import br.upe.poo.clinica.entidades.Exames;
import org.springframework.data.repository.CrudRepository;


public interface InterfaceExamesRepositorio extends CrudRepository<Exames, Long>{
    
}
