
package br.upe.poo.clinica.persistencia;

import br.upe.poo.clinica.entidades.Consultas;
import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface InterfaceConsultasRepositorio extends CrudRepository<Consultas, Long> {
    
    public List<Consultas> findByDiaConsulta(Date diaConsulta);
    
    public Consultas findByCpfPaciente(Long cpf);
    
    public Consultas findByCpfMedicos(Long cpf);
}
