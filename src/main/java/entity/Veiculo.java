package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import java.util.Date;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Veiculo", schema = "public")
@PrimaryKeyJoinColumn(name = "idVeiculo")
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idVeiculo", unique = true, nullable = false)
	private Integer idVeiculo;
	
	@Column(name = "modelo")
	private String modelo;
	
	@Column(name = "placa")
	private String placa;
	
	@Column(name = "dataEntrada")
	@Temporal(TemporalType.DATE)
	private Date dataEntrada;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idVaga", referencedColumnName = "idVaga")
	private Vaga vaga;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataEntrada == null) ? 0 : dataEntrada.hashCode());
		result = prime * result + ((vaga == null) ? 0 : vaga.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		if (dataEntrada == null) {
			if (other.dataEntrada != null)
					return false;
			} else if (!dataEntrada.equals(other.dataEntrada))
				return false;
			if (vaga == null) {
				if (other.vaga != null)
					return false;
			} else if (!vaga.equals(other.vaga))
				return false;
			if (modelo == null) {
				if (other.modelo != null)
					return false;
			} else if (!modelo.equals(other.modelo))
				return false;
			if (placa == null) {
				if (other.placa != null)
					return false;
			} else if (!placa.equals(other.placa))
				return false;
			return true;
	}
	
	public Integer getIdVeiculo() {
		return idVeiculo;
	}
	
	public void setIdVeiculo(Integer idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
	

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public Vaga getVaga() {
		return vaga;
	}
	
	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}
	
}
