
package br.upe.poo.clinica.persistencia;

import br.upe.poo.clinica.entidades.ResultadosExames;
import org.springframework.data.repository.CrudRepository;

public interface InterfaceResultadosExamesRepositorio extends CrudRepository<ResultadosExames, Long>{
    
}
