
package br.upe.poo.clinica.persistencia;

import br.upe.poo.clinica.entidades.Medicos;
import org.springframework.data.repository.CrudRepository;


public interface InterfaceMedicosRepositorio extends CrudRepository<Medicos, Long>{
    
}
