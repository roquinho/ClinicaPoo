
package br.upe.poo.clinica.regraNegocio;

import br.upe.poo.clinica.entidades.Consultas;
import br.upe.poo.clinica.entidades.Medicos;
import br.upe.poo.clinica.entidades.Pacientes;
import br.upe.poo.clinica.entidades.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FachadaImplementa implements Fachada {
    @Autowired
    private InterfaceRegraNegocioPacientes pacientes;
    @Autowired
    private InterfaceRegraNegocioMedicos medicos;
    @Autowired
    private InterfaceRegraNegocioUsuario usuarios;
    @Autowired
    private InterfaceRegraNegocioConsultas consultas;
      
        public FachadaImplementa() {
            
        }
    @Override
    public void cadastrarPaciente(Pacientes paciente) throws ExceptionRegraNegocioPacientesCadastrar {
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
    public List<Medicos> buscarMedicoEspecialidade(String especialidade) throws ExceptionRegraNegocioBuscarMedicos {
        return this.medicos.buscarMedicoEspecialidade(especialidade);
    }

    @Override
    public void atualizarMedico(Medicos medico) throws ExceptionRegraNegocioAtualizarMedicos {
        this.medicos.atualizarMedico(medico);
    }

    @Override
    public void deletarMedico(Medicos medico) throws ExceptionRegraNegocioDeletarMedicos {
        this.medicos.deletarMedico(medico);
    }

    @Override
    public void cadastarUsuario(Usuario usuario) throws ExceptionRegraNegocioCadastrarUsuario {
        this.usuarios.cadastarUsuario(usuario);
    }

    @Override
    public Usuario filtrarUsuarioCpf(Long cpf) throws ExceptionRegraNegocioFiltrarUsuario {
        return this.usuarios.filtrarUsuarioCpf(cpf);
    }

    @Override
    public void atualizarUsuario(Usuario usuario) throws ExceptionRegraNegocioAtualizarUsuario {
        this.usuarios.atualizarUsuario(usuario);
    }

    @Override
    public void deletarUsuario(Usuario usuario) throws ExceptionRegraNegocioDeletarUsuario {
        this.usuarios.deletarUsuario(usuario);
    }

    @Override
    public void agendarConsulta(Consultas consulta,Long pacienteCpf,Long medicoCpf) throws ExceptionRegraNegocioAgendarConsultas {
        this.consultas.agendarConsulta(consulta,pacienteCpf,medicoCpf);
    }

    @Override
    public Consultas filtrarConsultaCodigoConsulta(Long codigoConsulta) throws ExceptionRegraNegocioFiltrarConsultas {
        return this.consultas.filtrarConsultaCodigoConsulta(codigoConsulta);
    }

    @Override
    public void atualizarConsulta(Consultas consulta) throws ExceptionRegraNegocioAtualizarConsultas {
        this.consultas.atualizarConsulta(consulta);
    }

    @Override
    public void deletarConsultas(Long codigoConsulta) throws ExceptionRegraNegocioDeletarConsultas {
        this.consultas.deletarConsultas(codigoConsulta);
    }
    
}
