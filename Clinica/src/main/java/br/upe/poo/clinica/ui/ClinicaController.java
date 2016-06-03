
package br.upe.poo.clinica.ui;

import br.upe.poo.clinica.entidades.Pacientes;
import br.upe.poo.clinica.regraNegocio.Fachada;
import br.upe.poo.clinica.regraNegocio.ExceptionRegraNegocioPacienteBuscarPaciente;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Clinica")
public class ClinicaController {
    
    @Autowired
    private Fachada fachada;
    
    
    @RequestMapping("/paciente/add")
    public ResponseEntity<?> cadastrarPaciente(Pacientes paciente) {
        
        try {
           this.fachada.cadastrarPaciente(paciente);
        }catch(Exception e) {
            return new ResponseEntity<Exception>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/paciente/buscaCpf",produces = MediaType.APPLICATION_JSON_VALUE)
    public Pacientes buscarPacienteCpf(Long cpf) {
         Pacientes paciente = null;
        try {
            paciente = this.fachada.buscarPacienteCpf(cpf);
        } catch (ExceptionRegraNegocioPacienteBuscarPaciente ex) {
            Logger.getLogger(ClinicaController.class.getName()).log(Level.SEVERE, null, ex);
        }
       return paciente; 
    }
    @RequestMapping(value = "/paciente/buscaCpf/",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pacientes> buscarPacienteNome(String nome) {
        List<Pacientes> listaPaciente = null;
        try {
     listaPaciente =  this.fachada.buscarPacienteNome(nome);
        } catch (Exception e) {
            Logger.getLogger(ClinicaController.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaPaciente;
    }
        
    @RequestMapping("/paciente/atualizar")
    public ResponseEntity<?> atualizarPaciente(Pacientes paciente) {
        try {
            this.fachada.atualizarPaciente(paciente);
        } catch (Exception e) {
             return new ResponseEntity<Exception>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>(HttpStatus.OK);
    }
    @RequestMapping("/paciente/deletar")
    public ResponseEntity<?> deletarPaciente(Pacientes paciente) {
        try {
            this.fachada.deletarPaciente(paciente);
        } catch (Exception e) {
           return new ResponseEntity<Exception>(HttpStatus.BAD_REQUEST); 
        }
        return new ResponseEntity<String>(HttpStatus.OK);
        
    }

    public Fachada getFachada() {
        return fachada;
    }

    public void setFachada(Fachada fachada) {
        this.fachada = fachada;
    }
}
