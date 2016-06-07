
package br.upe.poo.clinica.persistencia;

import br.upe.poo.clinica.entidades.Medicos;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface InterfaceMedicosRepositorio extends CrudRepository<Medicos, Long>{
    
    public Medicos findByCpf(Long cpf);
    
    public List<Medicos>findByNome(String nome);
    
    public List<Medicos>findByEspecialidade(String especialidade);
}
