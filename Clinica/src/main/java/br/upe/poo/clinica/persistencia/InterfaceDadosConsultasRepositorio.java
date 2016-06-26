
package br.upe.poo.clinica.persistencia;

import br.upe.poo.clinica.entidades.DadosConsultas;
import org.springframework.data.repository.CrudRepository;


public interface InterfaceDadosConsultasRepositorio extends CrudRepository<DadosConsultas,Long> {
    
    public DadosConsultas findByIdDadosConsulta(Long idDadosConsulta);
}