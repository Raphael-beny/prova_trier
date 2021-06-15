package bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import business.VagaBusiness;
import entity.Vaga;
import utils.FiltroDTO2;

@ViewScoped
@ManagedBean
public class ListaVagaBean {
	
	private List<Vaga> listaVaga;
		
	private FiltroDTO2 filtroDTO2 = new FiltroDTO2();
	
	private VagaBusiness vagaBusiness = new VagaBusiness();
	
	@PostConstruct
	public void inicializar() {
		consultarVaga();
	}
	
	public String cadastrarVaga() {
		return "vagaCadastrar.xhtml?faces-redirect=true";
	}
	
	public String atualizarVaga() {
		return "vincularVaga.xhtml?faces-redirect=true";
	}
	
	
	public List<Vaga> getListaVaga() {
		return listaVaga;
	}
	
	public void setListaVaga(List<Vaga> listaVaga) {
		this.listaVaga = listaVaga;
	}
	
	public void consultarVaga() {
		listaVaga = vagaBusiness.getListaVaga(filtroDTO2);
	}
	
	
	public FiltroDTO2 getFiltroDTO2() {
		return filtroDTO2;
	}
	
	public void setFiltroDTO2(FiltroDTO2 filtroDTO2) {
		this.filtroDTO2 = filtroDTO2;
	}
	
}
