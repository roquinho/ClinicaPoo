
package br.upe.poo.clinica.regraNegocio;

import br.upe.poo.clinica.entidades.Pacientes;
import java.io.Serializable;
import java.util.List;

public interface Fachada extends Serializable {
    
    public void cadastrarPaciente(Pacientes paciente)throws ExceptionRegraNegocioPacientesCadastrar;
    
    public Pacientes buscarPacienteCpf(Long cpf)throws ExceptionRegraNegocioPacienteBuscarPaciente;
    
    public List<Pacientes> buscarPacienteNome(String nome)throws ExceptionRegraNegocioPacienteBuscarPaciente;
    
    public void atualizarPaciente(Pacientes paciente)throws ExceptionRegraNegocioAtualizarPacientes;
    
    public void deletarPaciente(Pacientes paciente)throws ExceptionRegraNegocioDeletarPacientes;
    
}