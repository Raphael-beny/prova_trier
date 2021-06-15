package bean;


import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import business.VagaBusiness;
import entity.Vaga;

@ViewScoped
@ManagedBean
public class VagaBean {
	
	private Vaga vaga;
	
	private VagaBusiness vagaBusiness = new VagaBusiness();
	
	private Integer idVaga;
	
	private String status;
	
	@PostConstruct
	public void atualizar() {
		
			if (idVaga == null) {
				iniciarNovaVaga();			
			} else {
				buscarVaga();
			}
			
		
	}
		
	private void iniciarNovaVaga() {
		vaga = new Vaga();
	}

	private void buscarVaga() {
		vaga = vagaBusiness.getVaga(idVaga);
	}

	public void salvar() {
		vagaBusiness.salvarVaga(vaga);
		iniciarNovaVaga();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Vaga salva com sucesso"));
	}
		
	
	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}

	public Integer getIdVaga() {
		return idVaga;
	}

	public void setIdVaga(Integer idVaga) {
		this.idVaga = idVaga;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
}
