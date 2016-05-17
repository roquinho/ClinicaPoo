
package br.upe.poo.clinica.regraNegocio;

import br.upe.poo.clinica.entidades.Pacientes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FachadaImplementa implements Fachada {
    @Autowired
    private InterfaceRegraNegocioPacientes pacientes;

    @Override
    public void cadastrarPaciente(Pacientes paciente) throws RegraNegocioPacientesCadastrarException {
       pacientes.cadastrarPaciente(paciente);
    }

    @Override
    public Pacientes buscarPacienteCpf(Long cpf) throws RegraNegocioPacienteBuscarPacienteException {
        return pacientes.buscarPacienteCpf(cpf);
    }

    @Override
    public List<Pacientes> buscarPacienteNome(String nome) throws RegraNegocioPacienteBuscarPacienteException {
       return pacientes.buscarPacienteNome(nome);
    }

    @Override
    public void atualizarPaciente(Pacientes paciente) throws RegraNegocioAtualizarPacientesException {
        pacientes.atualizarPaciente(paciente);
    }

    @Override
    public void deletarPaciente(Pacientes paciente) throws RegraNegocioDeletarPacientesException {
        pacientes.deletarPaciente(paciente);
    }
    
}
