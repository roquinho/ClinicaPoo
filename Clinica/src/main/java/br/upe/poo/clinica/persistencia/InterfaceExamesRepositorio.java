
package br.upe.poo.clinica.persistencia;

import br.upe.poo.clinica.entidades.Exames;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface InterfaceExamesRepositorio extends CrudRepository<Exames, Long>{
    
    public Exames findByCodigoExame(Long codigoExame);
    
    public List<Exames> findByTipoExame(String tipoExame);
}
