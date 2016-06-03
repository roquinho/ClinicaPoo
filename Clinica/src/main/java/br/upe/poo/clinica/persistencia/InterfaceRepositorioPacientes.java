
package br.upe.poo.clinica.persistencia;

import br.upe.poo.clinica.entidades.Pacientes;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface InterfaceRepositorioPacientes extends CrudRepository<Pacientes,Long> {

   
    
    public Pacientes findByCpf(Long cpf);
    
    public List<Pacientes> findByNome(String nome);
    
    
}
