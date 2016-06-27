
package br.upe.poo.clinica.regraNegocio;

import br.upe.poo.clinica.entidades.Pacientes;
import br.upe.poo.clinica.listarEntidades.ListarPacientes;
import br.upe.poo.clinica.persistencia.InterfaceRepositorioPacientes;
import java.util.ArrayList;
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
        if(paciente.getLoginNome()==null) {
            throw new ExceptionRegraNegocioPacientesCadastrar();
        }
        if(paciente.getSenha()==null) {
            throw new ExceptionRegraNegocioPacientesCadastrar();
        }
        if(irp.findByCpf(paciente.getCpf())!= null) {
            throw new ExceptionRegraNegocioPacientesCadastrar();
        }
        else {
            irp.save(paciente);
        }
    }

    @Override
    public ListarPacientes buscarPacienteCpf(Long cpf) throws ExceptionRegraNegocioPacienteBuscarPaciente {
        Pacientes paciente = null;
        
       if(cpf == null){
           throw new ExceptionRegraNegocioPacienteBuscarPaciente();
       }
       else {
           paciente = irp.findByCpf(cpf);
       }
        return new ListarPacientes(paciente);
    }

    @Override
    public List<Pacientes> buscarPacienteNome(String nome) throws ExceptionRegraNegocioPacienteBuscarPaciente {
        List<Pacientes> pacientes = null;
        //List<ListarPacientes> listarPacientes = new ArrayList<>();
        
        if(nome == null) {
          throw new ExceptionRegraNegocioPacienteBuscarPaciente();
        }
        else {
            pacientes = irp.findByNome(nome);
                     
             
        }        
        return  pacientes;
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
        if(paciente.getLoginNome()==null) {
            throw new ExceptionRegraNegocioAtualizarPacientes();
        }
        if(paciente.getSenha()==null) {
            throw new ExceptionRegraNegocioAtualizarPacientes();
        }
        if(irp.findByCpf(paciente.getCpf())== null) {
            throw new ExceptionRegraNegocioAtualizarPacientes();
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
       if(irp.findByCpf(paciente.getCpf())== null) {
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
