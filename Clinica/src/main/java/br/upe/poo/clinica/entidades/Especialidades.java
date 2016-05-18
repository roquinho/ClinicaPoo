package br.upe.poo.clinica.entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Especialidades implements Serializable {
	private String areaMedicina;
	private List<Medicos>medicosAreaMedicina;
	private List<Exames>examesPossiveis;
        private Long numeroIdEspecialidade;
	  
	   public Especialidades() {
		   
	   }
	   public Especialidades(String areaMedicina,List<Medicos>listaMedicos,List<Exames>listaExames) {		   
                   this.medicosAreaMedicina = listaMedicos;
                   this.examesPossiveis = listaExames;
                   this.areaMedicina = areaMedicina;
 	   }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.areaMedicina);
        hash = 59 * hash + Objects.hashCode(this.medicosAreaMedicina);
        hash = 59 * hash + Objects.hashCode(this.examesPossiveis);
        hash = 59 * hash + Objects.hashCode(this.numeroIdEspecialidade);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Especialidades other = (Especialidades) obj;
        if (!Objects.equals(this.areaMedicina, other.areaMedicina)) {
            return false;
        }
        if (!Objects.equals(this.medicosAreaMedicina, other.medicosAreaMedicina)) {
            return false;
        }
        if (!Objects.equals(this.examesPossiveis, other.examesPossiveis)) {
            return false;
        }
        if (!Objects.equals(this.numeroIdEspecialidade, other.numeroIdEspecialidade)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Especialidades{" + "areaMedicina=" + areaMedicina + ", medicosAreaMedicina=" + medicosAreaMedicina + ", examesPossiveis=" + examesPossiveis + ", numeroIdEspecialidade=" + numeroIdEspecialidade + '}';
    }

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public Long getNumeroIdEspecialidade() {
                return numeroIdEspecialidade;
        }
        public void setNumeroIdEspecialidade(Long numeroIdEspecialidade) {
               this.numeroIdEspecialidade = numeroIdEspecialidade;
        }          
	public String getAreaMedicina() {
		return areaMedicina;
	}
	public void setAreaMedicina(String areaMedicina) {
		this.areaMedicina = areaMedicina;
	}
        @ManyToMany(fetch = FetchType.EAGER)
	public List<Medicos> getMedicosAreaMedicina() {
		return medicosAreaMedicina;
	}
	public void setMedicosAreaMedicina(List<Medicos> medicosAreaMedicina) {
		this.medicosAreaMedicina = medicosAreaMedicina;
	}
        @OneToMany(fetch = FetchType.EAGER,mappedBy = "Exames")
	public List<Exames> getExamesPossiveis() {
		return examesPossiveis;
	}
	public void setExamesPossiveis(List<Exames> examesPossiveis) {
		this.examesPossiveis = examesPossiveis;
	}
      
}
  
