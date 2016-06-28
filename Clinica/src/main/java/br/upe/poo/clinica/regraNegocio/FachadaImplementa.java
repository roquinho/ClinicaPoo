
package br.upe.poo.clinica.regraNegocio;

import br.upe.poo.clinica.entidades.Consultas;
import br.upe.poo.clinica.entidades.DadosConsultas;
import br.upe.poo.clinica.entidades.Exames;
import br.upe.poo.clinica.entidades.Medicos;
import br.upe.poo.clinica.entidades.Pacientes;
import br.upe.poo.clinica.entidades.ResultadosExames;
import br.upe.poo.clinica.entidades.Usuario;
import br.upe.poo.clinica.listarEntidades.ListarConsultas;
import br.upe.poo.clinica.listarEntidades.ListarDadosConsultas;
import br.upe.poo.clinica.listarEntidades.ListarExames;
import br.upe.poo.clinica.listarEntidades.ListarMedicos;
import br.upe.poo.clinica.listarEntidades.ListarPacientes;
import br.upe.poo.clinica.listarEntidades.ListarResultadosExames;
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
    @Autowired
    private InterfaceRegraNegocioExames exames;
    @Autowired
    private InterfaceRegraNegocioDadosConsulta dadosConsulta;
    @Autowired
    private InterfaceRegraNegocioResultadoExames resultadoExames;
      
        public FachadaImplementa() {
            
        }
    @Override
    public void cadastrarPaciente(Pacientes paciente) throws ExceptionRegraNegocioPacientesCadastrar {
       this.pacientes.cadastrarPaciente(paciente);
    }

    @Override
    public ListarPacientes buscarPacienteCpf(Long cpf) throws ExceptionRegraNegocioPacienteBuscarPaciente {
        return this.pacientes.buscarPacienteCpf(cpf);
    }

    @Override
    public List<ListarPacientes> buscarPacienteNome(String nome) throws ExceptionRegraNegocioPacienteBuscarPaciente {
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
    public ListarMedicos buscarMedicoCpf(Long cpf) throws ExceptionRegraNegocioBuscarMedicos {
        return this.medicos.buscarMedicoCpf(cpf);
    }

    @Override
    public List<ListarMedicos> buscarMedicoNome(String nome) throws ExceptionRegraNegocioBuscarMedicos {
        return this.medicos.buscarMedicoNome(nome);
    }
    
    @Override
    public List<ListarMedicos> buscarMedicoEspecialidade(String especialidade) throws ExceptionRegraNegocioBuscarMedicos {
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
    public ListarConsultas filtrarConsultaCodigoConsulta(Long codigoConsulta) throws ExceptionRegraNegocioFiltrarConsultas {
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

    @Override
    public void agendarExame(Exames exame, Long pacienteCpf, Long codigoConsulta) throws ExceptionRegraNegocioAgendarExame {
        this.exames.agendarExame(exame, pacienteCpf, codigoConsulta);
    }

    @Override
    public ListarExames filtrarExameCodigo(Long codigoExame) throws ExceptionRegraNegocioFiltrarExame {
        return this.exames.filtrarExameCodigo(codigoExame);
    }

    @Override
    public void atualizarExame(Exames exame) throws ExceptionRegraNegocioAtualizarExames {
        this.exames.atualizarExame(exame);
    }

    @Override
    public void deletarExame(Long codigoExame) throws ExceptionRegraNegocioDeletarExames {
        this.exames.deletarExame(codigoExame);
    }

    @Override
    public List<ListarExames> filtrarTipoExame(String tipoExame) throws ExceptionRegraNegocioFiltrarExame {
        return this.exames.filtrarTipoExame(tipoExame);
    }

    @Override
    public void gerarDadosConsulta(DadosConsultas dadosConsulta, Long codigoConsulta) throws ExceptionRegraNegocioDadosConsultasGerar {
        this.dadosConsulta.gerarDadosConsulta(dadosConsulta, codigoConsulta);
    }

    @Override
    public ListarDadosConsultas filtrarDadosConsulta(Long idDadosConsulta) throws ExceptionRegraNegocioDadosConsultasFiltrar {
        return this.dadosConsulta.filtrarDadosConsulta(idDadosConsulta);
    }

    @Override
    public void atualizarDadosConsulta(DadosConsultas dadosConsultas) throws ExceptionRegraNegocioDadosConsultasAtualizar {
        this.dadosConsulta.atualizarDadosConsulta(dadosConsultas);
    }

    @Override
    public void deletarDadosConsulta(Long idDadosConsulta) throws ExceptionRegraNegocioDadosConsultasDeletar {
        this.dadosConsulta.deletarDadosConsulta(idDadosConsulta);
    }

    @Override
    public void gerarResultadoExames(ResultadosExames resultadoExames, Long codigoExame) throws ExceptionRegraNegocioResultadosExamesGerar {
        this.resultadoExames.gerarResultadoExames(resultadoExames, codigoExame);
    }

    @Override
    public ListarResultadosExames filtrarResultadoExame(Long idResultadoExames) throws ExceptionRegraNegocioResultadosExamesFiltrar {
        return this.resultadoExames.filtrarResultadoExame(idResultadoExames);
    }

    @Override
    public void atualizarResultadoExame(ResultadosExames resultadosExames) throws ExceptionRegraNegocioResultadosExamesAtualizar {
        this.resultadoExames.atualizarResultadoExame(resultadosExames);
    }

    @Override
    public void deletarResultadoExame(Long idResultadoExames) throws ExceptionRegraNegocioResultadosExamesDeletar {
        this.resultadoExames.deletarResultadoExame(idResultadoExames);
    }
    
}
