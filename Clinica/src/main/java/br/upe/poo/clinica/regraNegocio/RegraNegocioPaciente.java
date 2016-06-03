
package br.upe.poo.clinica.regraNegocio;

import br.upe.poo.clinica.entidades.Pacientes;
import br.upe.poo.clinica.persistencia.InterfaceRepositorioPacientes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegraNegocioPaciente implements InterfaceRegraNegocioPacientes{
    @Autowired
    private InterfaceRepositorioPacientes irp;
    
      public RegraNegocioPaciente() {
      }
    
    @Override
    public void cadastrarPaciente(Pacientes paciente)throws ExceptionRegraNegocioPacientesCadastrar {
        if(paciente == null) {
            throw new ExceptionRegraNegocioPacientesCadastrar();
        }
        if(paciente.getNome()== null) {
            throw new ExceptionRegraNegocioPacientesCadastrar();
        }
        if(paciente.getCpf()==null) {
            throw new ExceptionRegraNegocioPacientesCadastrar();
        }
        if(paciente.getCpf()>11) {
            throw new ExceptionRegraNegocioPacientesCadastrar();
        }
        if(paciente.getCpf()<11) {
            throw new ExceptionRegraNegocioPacientesCadastrar();
        }
        if(paciente.getLoginNome()==null) {
            throw new ExceptionRegraNegocioPacientesCadastrar();
        }
        if(paciente.getSenha()==null) {
            throw new ExceptionRegraNegocioPacientesCadastrar();
        }
        if(paciente.getSenha().length()<5) {
            throw new ExceptionRegraNegocioPacientesCadastrar();
        }           
        if(paciente.equals(irp.findByCpf(paciente.getCpf()))) {
            throw new ExceptionRegraNegocioPacientesCadastrar();
        }
        else {
            irp.save(paciente);
        }
    }

    @Override
    public Pacientes buscarPacienteCpf(Long cpf) throws ExceptionRegraNegocioPacienteBuscarPaciente {
        Pacientes paciente = null;
        
       if(cpf == null){
           throw new ExceptionRegraNegocioPacienteBuscarPaciente();
       }
       if(cpf>11) {
           throw new ExceptionRegraNegocioPacienteBuscarPaciente();
       }
       if(cpf<11) {
           throw new ExceptionRegraNegocioPacienteBuscarPaciente();
       }
       else {
           paciente = irp.findByCpf(cpf);
       }
        return paciente;
    }

    @Override
    public List<Pacientes> buscarPacienteNome(String nome) throws ExceptionRegraNegocioPacienteBuscarPaciente {
          List<Pacientes> listaPacientes = null;
        if(nome == null) {
          throw new ExceptionRegraNegocioPacienteBuscarPaciente();
        }
        else {
            listaPacientes = irp.findByNome(nome);
        }        
        return listaPacientes;
    }

    @Override
    public void atualizarPaciente(Pacientes paciente)throws ExceptionRegraNegocioAtualizarPacientes{
       if(paciente == null) {
            throw new ExceptionRegraNegocioAtualizarPacientes();
        }
        if(paciente.getNome()== null) {
            throw new ExceptionRegraNegocioAtualizarPacientes();
        }
        if(paciente.getCpf()==null) {
            throw new ExceptionRegraNegocioAtualizarPacientes();
        }
        if(paciente.getCpf()>11) {
            throw new ExceptionRegraNegocioAtualizarPacientes();
        }
        if(paciente.getCpf()<11) {
            throw new ExceptionRegraNegocioAtualizarPacientes();
        }
        if(paciente.getLoginNome()==null) {
            throw new ExceptionRegraNegocioAtualizarPacientes();
        }
        if(paciente.getSenha()==null) {
            throw new ExceptionRegraNegocioAtualizarPacientes();
        }
        if(paciente.getSenha().length()<5) {
            throw new ExceptionRegraNegocioAtualizarPacientes();
        } 
        if(paciente.equals(irp.findByCpf(paciente.getCpf())) == false) {
            throw  new ExceptionRegraNegocioAtualizarPacientes();
        }
        else {
            irp.save(paciente);
        }
 
    }

    @Override
    public void deletarPaciente(Pacientes paciente)throws ExceptionRegraNegocioDeletarPacientes{
       if(paciente == null) {
           throw new ExceptionRegraNegocioDeletarPacientes();
       }
       if(paciente.equals(irp.findByCpf(paciente.getCpf()))==false) {
           throw new ExceptionRegraNegocioDeletarPacientes();       
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
