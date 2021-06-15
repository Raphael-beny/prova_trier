package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Vaga", schema = "public")
@PrimaryKeyJoinColumn(name = "idVaga")
public class Vaga {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idVaga", unique = true, nullable = false)
	private Integer idVaga;
	
	@Column(name = "codigo")
	private Integer codigo;
	
	@Column(name = "status")
	private String status = "Livre";
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Vaga other = (Vaga) obj;
		if (codigo == null) {
			if (other.codigo != null)
					return false;
			} else if (!codigo.equals(other.codigo))
				return false;
			if (codigo == null) {
				if (other.codigo != null)
					return false;
			} else if (!codigo.equals(other.codigo))
				return false;
			if (status == null) {
				if (other.status != null)
					return false;
			} else if (!status.equals(other.status))
				return false;
			return true;
	}
	
	public Integer getIdVaga() {
		return idVaga;
	}
	
	public void setIdVaga(Integer idVaga) {
		this.idVaga = idVaga;
	}
	

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
		

}
