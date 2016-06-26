
package br.upe.poo.clinica.regraNegocio;

import br.upe.poo.clinica.entidades.Consultas;
import br.upe.poo.clinica.entidades.Exames;
import br.upe.poo.clinica.entidades.Medicos;
import br.upe.poo.clinica.entidades.Pacientes;
import br.upe.poo.clinica.entidades.Usuario;
import java.io.Serializable;
import java.util.List;

public interface Fachada extends Serializable {
    
    public void cadastrarPaciente(Pacientes paciente)throws ExceptionRegraNegocioPacientesCadastrar;
    
    public Pacientes buscarPacienteCpf(Long cpf)throws ExceptionRegraNegocioPacienteBuscarPaciente;
    
    public List<Pacientes> buscarPacienteNome(String nome)throws ExceptionRegraNegocioPacienteBuscarPaciente;
    
    public void atualizarPaciente(Pacientes paciente)throws ExceptionRegraNegocioAtualizarPacientes;
    
    public void deletarPaciente(Pacientes paciente)throws ExceptionRegraNegocioDeletarPacientes;
    
    
    
    public void cadastrarMedicos(Medicos medico)throws ExceptionRegraNegocioCadastrarMedicos;
    
    public Medicos buscarMedicoCpf(Long cpf)throws ExceptionRegraNegocioBuscarMedicos;
    
    public List<Medicos> buscarMedicoNome(String nome)throws ExceptionRegraNegocioBuscarMedicos;
    
    public List<Medicos> buscarMedicoEspecialidade(String especialidade)throws ExceptionRegraNegocioBuscarMedicos;
    
    public void atualizarMedico(Medicos medico)throws ExceptionRegraNegocioAtualizarMedicos;
    
    public void deletarMedico(Medicos medico)throws ExceptionRegraNegocioDeletarMedicos;
    
    
    
    public void cadastarUsuario(Usuario usuario)throws ExceptionRegraNegocioCadastrarUsuario;
    
    public Usuario filtrarUsuarioCpf(Long cpf)throws ExceptionRegraNegocioFiltrarUsuario;
    
    public void atualizarUsuario(Usuario usuario)throws ExceptionRegraNegocioAtualizarUsuario;
    
    public void deletarUsuario(Usuario usuario)throws ExceptionRegraNegocioDeletarUsuario;
    


    public void agendarConsulta(Consultas consulta,Long pacienteCpf,Long medicoCpf)throws ExceptionRegraNegocioAgendarConsultas;
    
    public Consultas filtrarConsultaCodigoConsulta(Long codigoConsulta)throws ExceptionRegraNegocioFiltrarConsultas;
    
    public void atualizarConsulta(Consultas consulta)throws ExceptionRegraNegocioAtualizarConsultas;
    
    public void deletarConsultas(Long codigoConsulta)throws ExceptionRegraNegocioDeletarConsultas;
    
    
    
    
    public void agendarExame(Exames exame,Long pacienteCpf,Long codigoConsulta)throws ExceptionRegraNegocioAgendarExame;
    
    public Exames filtrarExameCodigo(Long codigoExame)throws ExceptionRegraNegocioFiltrarExame;
    
    public List<Exames> filtrarTipoExame(String tipoExame)throws ExceptionRegraNegocioFiltrarExame;
    
    public void atualizarExame(Exames exame)throws ExceptionRegraNegocioAtualizarExames;
    
    public void deletarExame(Long codigoExame)throws ExceptionRegraNegocioDeletarExames;

}