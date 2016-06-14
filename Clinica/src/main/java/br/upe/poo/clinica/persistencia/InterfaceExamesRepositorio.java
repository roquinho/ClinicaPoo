
package br.upe.poo.clinica.persistencia;

import br.upe.poo.clinica.entidades.Exames;
import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface InterfaceExamesRepositorio extends CrudRepository<Exames, Long>{
    
    public List<Exames> findByDiaExames(Date diaExame);
    
    public Exames findByCpfPaciente(Long cpf);
}
