
package br.upe.poo.clinica.regraNegocio;

import br.upe.poo.clinica.entidades.Medicos;
import br.upe.poo.clinica.entidades.Pacientes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FachadaImplementa implements Fachada {
    @Autowired
    private InterfaceRegraNegocioPacientes pacientes;
    @Autowired
    private InterfaceRegraNegocioMedicos medicos;
      
        public FachadaImplementa() {
            
        }
    @Override
    public void cadastrarPaciente(Pacientes paciente) throws ExceptionRegraNegocioPacientesCadastrar {
        System.out.println("entrou na fachada");
       this.pacientes.cadastrarPaciente(paciente);
    }

    @Override
    public Pacientes buscarPacienteCpf(Long cpf) throws ExceptionRegraNegocioPacienteBuscarPaciente {
        return this.pacientes.buscarPacienteCpf(cpf);
    }

    @Override
    public List<Pacientes> buscarPacienteNome(String nome) throws ExceptionRegraNegocioPacienteBuscarPaciente {
       return this.pacientes.buscarPacienteNome(nome);
    }

    @Override
    public void atualizarPaciente(Pacientes paciente) throws ExceptionRegraNegocioAtualizarPacientes {
        this.pacientes.atualizarPaciente(paciente);
    }

    @Override
    public void deletarPaciente(Pacientes paciente) throws ExceptionRegraNegocioDeletarPacientes {
        this.pacientes.deletarPaciente(paciente);
    }

    @Override
    public void cadastrarMedicos(Medicos medico) throws ExceptionRegraNegocioCadastrarMedicos {
        this.medicos.cadastrarMedicos(medico);
    }

    @Override
    public Medicos buscarMedicoCpf(Long cpf) throws ExceptionRegraNegocioBuscarMedicos {
        return this.medicos.buscarMedicoCpf(cpf);
    }

    @Override
    public List<Medicos> buscarMedicoNome(String nome) throws ExceptionRegraNegocioBuscarMedicos {
        return this.medicos.buscarMedicoNome(nome);
    }

    @Override
    public void atualizarMedico(Medicos medico) throws ExceptionRegraNegocioAtualizarMedicos {
        this.medicos.atualizarMedico(medico);
    }

    @Override
    public void deletarMedico(Medicos medico) throws ExceptionRegraNegocioDeletarMedicos {
        this.medicos.deletarMedico(medico);
    }
    
    
}
