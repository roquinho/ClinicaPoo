
package br.upe.poo.clinica.ui;

import br.upe.poo.clinica.entidades.Consultas;
import br.upe.poo.clinica.entidades.Medicos;
import br.upe.poo.clinica.entidades.Pacientes;
import br.upe.poo.clinica.entidades.Usuario;
import br.upe.poo.clinica.regraNegocio.ExceptionRegraNegocioFiltrarConsultas;
import br.upe.poo.clinica.regraNegocio.Fachada;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Clinica")
public class ClinicaController {
    
    @Autowired
    private Fachada fachada;
    
    @RequestMapping("/paciente/add")
    public ResponseEntity<?> cadastrarPaciente(@RequestBody Pacientes paciente) {
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
        } catch (Exception ex) {
            Logger.getLogger(ClinicaController.class.getName()).log(Level.SEVERE, null, ex);
        }
       return paciente;
    }
    @RequestMapping(value = "/paciente/buscaNome",produces = MediaType.APPLICATION_JSON_VALUE)
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
    public ResponseEntity<?> atualizarPaciente(@RequestBody Pacientes paciente) {
        try {
            this.fachada.atualizarPaciente(paciente);
        } catch (Exception e) {
             return new ResponseEntity<Exception>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>(HttpStatus.OK);
    }
    @RequestMapping("/paciente/deletar")
    public ResponseEntity<?> deletarPaciente(@RequestBody Pacientes paciente) {
        try {
            this.fachada.deletarPaciente(paciente);
        } catch (Exception e) {
           return new ResponseEntity<Exception>(HttpStatus.BAD_REQUEST); 
        }
        return new ResponseEntity<String>(HttpStatus.OK);
        
    }
    //controller de medicos------------------------------------------------------
    
    @RequestMapping("/medico/add")
    public ResponseEntity<?> cadastrarMedico(@RequestBody Medicos medico) {
        try {
            this.fachada.cadastrarMedicos(medico);
        } catch (Exception e) {
            return new ResponseEntity<Exception>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>(HttpStatus.OK);
    }
    @RequestMapping(value = "/medico/buscaCpf",produces = MediaType.APPLICATION_JSON_VALUE)
    public Medicos buscarMedicoCpf(Long cpf) { 
        Medicos medico = null;
        try {
            medico = this.fachada.buscarMedicoCpf(cpf);
        } catch (Exception ex) {
            Logger.getLogger(ClinicaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medico;
    }
    @RequestMapping(value = "/medico/buscaNome",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Medicos> buscarMedicoNome(String nome) {
        List<Medicos> medicos = null;
        try {
            medicos = this.fachada.buscarMedicoNome(nome);
        } catch (Exception ex) {
            Logger.getLogger(ClinicaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medicos;
    }
    
    @RequestMapping(value = "/medico/buscaEspecialidade",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Medicos> buscarMedicoEspecialidade(String especialidade) {
       List<Medicos> medicos = null;
        try {
           medicos =  this.fachada.buscarMedicoEspecialidade(especialidade);
        } catch (Exception ex) {
            Logger.getLogger(ClinicaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medicos; 
    }
    
    @RequestMapping("/medico/atualizar")
    public ResponseEntity<?> atualizarMedico(@RequestBody Medicos medico) {
        try {
            this.fachada.atualizarMedico(medico);
        } catch (Exception e) {
             return new ResponseEntity<Exception>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>(HttpStatus.OK);
    }
    
    @RequestMapping("/medico/deletar")
    public ResponseEntity<?> deletarMedico(@RequestBody Medicos medico) {
        try {
            this.fachada.deletarMedico(medico);
        } catch (Exception e) {
           return new ResponseEntity<Exception>(HttpStatus.BAD_REQUEST); 
        }
        return new ResponseEntity<String>(HttpStatus.OK);
        
    }
    
    //Contrloller dos usuarios---------------------------
    
    @RequestMapping("/usuario/add")
    public ResponseEntity<?> cadastrarUsuario(@RequestBody Usuario usuario) {
        try {
            this.fachada.cadastarUsuario(usuario);
        } catch (Exception e) {
            return new ResponseEntity<Exception>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/usuario/buscaCpf",produces = MediaType.APPLICATION_JSON_VALUE)
    public Usuario filtrarUsuarioCpf(Long cpf) { 
        Usuario usuario = null;
        try {
            usuario = this.fachada.filtrarUsuarioCpf(cpf);
        } catch (Exception ex) {
            Logger.getLogger(ClinicaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

    @RequestMapping("/usuario/atualizar")
    public ResponseEntity<?> atualizarUsuario(@RequestBody Usuario usuario) {
        try {
            this.fachada.atualizarUsuario(usuario);
        } catch (Exception e) {
             return new ResponseEntity<Exception>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>(HttpStatus.OK);
    }
    
    @RequestMapping("/usuario/deletar")
    public ResponseEntity<?> deletarUsuario(@RequestBody Usuario usuario) {
        try {
            this.fachada.deletarUsuario(usuario);
        } catch (Exception e) {
           return new ResponseEntity<Exception>(HttpStatus.BAD_REQUEST); 
        }
        return new ResponseEntity<String>(HttpStatus.OK);
        
    }
    
    @RequestMapping("/consulta/agendar")
    public ResponseEntity<?> agendarConsulta(@RequestBody Consultas consulta, @RequestParam Long pacienteCpf, @RequestParam Long medicoCpf) {
        try {System.out.println(consulta.getCodigoConsulta());
            this.fachada.agendarConsulta(consulta,pacienteCpf,medicoCpf);
            System.out.println(medicoCpf);
        } catch (Exception ex) {
            System.out.println("erro"+medicoCpf); 
            return new ResponseEntity<Exception>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/consulta/filtrarCodigo",produces = MediaType.APPLICATION_JSON_VALUE)
    public Consultas filtrarConsultaCodigoConsulta(Long codigoConsulta) {
        Consultas consultas = null;
        try {
            consultas = this.fachada.filtrarConsultaCodigoConsulta(codigoConsulta);
        } catch (ExceptionRegraNegocioFiltrarConsultas ex) {
            Logger.getLogger(ClinicaController.class.getName()).log(Level.SEVERE, null, ex);
        }
         return consultas;
    }
    
    @RequestMapping("/consulta/atualizar")
    public ResponseEntity<?> atualizarConsulta(@RequestBody Consultas consulta) {
        try {
            this.fachada.atualizarConsulta(consulta);
        } catch (Exception ex) {
            return new ResponseEntity<Exception>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>(HttpStatus.OK);
    }
    
    @RequestMapping("/consulta/deletar")
    public ResponseEntity<?> deletarConsulta(@RequestParam Long codigoConsulta) {
        try {
            this.fachada.deletarConsultas(codigoConsulta);
        } catch (Exception ex) {
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
