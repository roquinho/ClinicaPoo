
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
        ListarPacientes listaPacientes = null;
        
       if(cpf == null){
           throw new ExceptionRegraNegocioPacienteBuscarPaciente();
       }
       else {
          Pacientes paciente = irp.findByCpf(cpf);
            if(paciente!=null) {
             listaPacientes = new ListarPacientes(paciente);  
            }
       }
        return listaPacientes; 
    }

    @Override
    public List<ListarPacientes> buscarPacienteNome(String nome) throws ExceptionRegraNegocioPacienteBuscarPaciente {
      List<ListarPacientes> listarPacientes = new ArrayList<>();
       
        if(nome == null) {
          throw new ExceptionRegraNegocioPacienteBuscarPaciente();
        }
        else {
           List<Pacientes> pacientes = irp.findByNome(nome);
            if(pacientes!=null) {
                for(int i = 0; i<pacientes.size(); i++) {
                 ListarPacientes paciente = new ListarPacientes(pacientes.get(i));
                   listarPacientes.add(paciente);
                }              
                       }
            }
        return  listarPacientes;
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
