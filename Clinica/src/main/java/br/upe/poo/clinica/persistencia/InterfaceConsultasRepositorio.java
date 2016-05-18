
package br.upe.poo.clinica.persistencia;

import br.upe.poo.clinica.entidades.Consultas;
import org.springframework.data.repository.CrudRepository;


public interface InterfaceConsultasRepositorio extends CrudRepository<Consultas, Long> {
    
    
}
