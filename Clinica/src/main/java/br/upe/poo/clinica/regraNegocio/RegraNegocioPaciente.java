
package br.upe.poo.clinica.regraNegocio;

import br.upe.poo.clinica.entidades.Pacientes;
import br.upe.poo.clinica.persistencia.InterfaceRepositorioPacientes;
import java.util.List;


public class RegraNegocioPaciente implements InterfaceRegraNegocioPacientes{
    
    private InterfaceRepositorioPacientes irp;
    
    
    @Override
    public void cadastrarPaciente(Pacientes paciente)throws RegraNegocioPacientesCadastrarException {
        if(paciente == null) {
            throw new RegraNegocioPacientesCadastrarException();
        }
        if(paciente.getNome()== null) {
            throw new RegraNegocioPacientesCadastrarException();
        }
        if(paciente.getCpf()==null) {
            throw new RegraNegocioPacientesCadastrarException();
        }
        if(paciente.getCpf()>11) {
            throw new RegraNegocioPacientesCadastrarException();
        }
        if(paciente.getCpf()<11) {
            throw new RegraNegocioPacientesCadastrarException();
        }
        if(paciente.getLoginNome()==null) {
            throw new RegraNegocioPacientesCadastrarException();
        }
        if(paciente.getSenha()==null) {
            throw new RegraNegocioPacientesCadastrarException();
        }
        if(paciente.getSenha().length()<5) {
            throw new RegraNegocioPacientesCadastrarException();
        }           
        if(paciente.equals(irp.findByCpf(paciente.getCpf()))) {
            throw new RegraNegocioPacientesCadastrarException();
        }
        else {
            irp.save(paciente);
        }
    }

    @Override
    public Pacientes buscarPacienteCpf(Long cpf) throws RegraNegocioPacienteBuscarPacienteException {
        Pacientes paciente = null;
        
       if(cpf == null){
           throw new RegraNegocioPacienteBuscarPacienteException();
       }
       if(cpf>11) {
           throw new RegraNegocioPacienteBuscarPacienteException();
       }
       if(cpf<11) {
           throw new RegraNegocioPacienteBuscarPacienteException();
       }
       else {
           paciente = irp.findByCpf(cpf);
       }
        return paciente;
    }

    @Override
    public List<Pacientes> buscarPacienteNome(String nome) throws RegraNegocioPacienteBuscarPacienteException {
          List<Pacientes> listaPacientes = null;
        if(nome == null) {
          throw new RegraNegocioPacienteBuscarPacienteException();
        }
        else {
            listaPacientes = irp.findByNome(nome);
        }        
        return listaPacientes;
    }

    @Override
    public void atualizarPaciente(Pacientes paciente)throws RegraNegocioAtualizarPacientesException{
       if(paciente == null) {
            throw new RegraNegocioAtualizarPacientesException();
        }
        if(paciente.getNome()== null) {
            throw new RegraNegocioAtualizarPacientesException();
        }
        if(paciente.getCpf()==null) {
            throw new RegraNegocioAtualizarPacientesException();
        }
        if(paciente.getCpf()>11) {
            throw new RegraNegocioAtualizarPacientesException();
        }
        if(paciente.getCpf()<11) {
            throw new RegraNegocioAtualizarPacientesException();
        }
        if(paciente.getLoginNome()==null) {
            throw new RegraNegocioAtualizarPacientesException();
        }
        if(paciente.getSenha()==null) {
            throw new RegraNegocioAtualizarPacientesException();
        }
        if(paciente.getSenha().length()<5) {
            throw new RegraNegocioAtualizarPacientesException();
        } 
        if(paciente.equals(irp.findByCpf(paciente.getCpf())) == false) {
            throw  new RegraNegocioAtualizarPacientesException();
        }
        else {
            irp.save(paciente);
        }
 
    }

    @Override
    public void deletarPaciente(Pacientes paciente)throws RegraNegocioDeletarPacientesException{
       if(paciente == null) {
           throw new RegraNegocioDeletarPacientesException();
       }
       if(paciente.equals(irp.findByCpf(paciente.getCpf()))==false) {
           throw new RegraNegocioDeletarPacientesException();       
       }
       else {
          irp.delete(paciente);
       }
       
    } 
    public InterfaceRepositorioPacientes getIrp() {
        return irp;
    }

    public void setIrp(InterfaceRepositorioPacientes irp) {
        this.irp = irp;
    }
}
