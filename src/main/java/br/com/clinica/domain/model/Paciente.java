package br.com.clinica.domain.model;

import javax.persistence.*;

/**
 * 
 * @author Renato Ferreira
 * https://www.linkedin.com/in/renatoredes/
 * https://github.com/renatoredes
 */

@DiscriminatorValue("Paciente")
@Entity
public class Paciente extends Pessoa{
	
	@Column(nullable = false ,name = "numero_carteira",  length=50)
	private String numeroCarteira;	

	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "covenio_id")
	private Convenio convenio;


	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "laudo_id")
	private LaudoMedico laudoMedico;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prontuario_id")
	private Prontuario prontuario;
	
	
	public String getNumeroCarteira() {
		return numeroCarteira;
	}


	public void setNumeroCarteira(String numeroCarteira) {
		this.numeroCarteira = numeroCarteira;
	}


	public Convenio getConvenio() {
		return convenio;
	}


	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((convenio == null) ? 0 : convenio.hashCode());
		result = prime * result + ((numeroCarteira == null) ? 0 : numeroCarteira.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		if (convenio == null) {
			if (other.convenio != null)
				return false;
		} else if (!convenio.equals(other.convenio))
			return false;
		if (numeroCarteira == null) {
			if (other.numeroCarteira != null)
				return false;
		} else if (!numeroCarteira.equals(other.numeroCarteira))
			return false;
		return true;
	}

	

}
