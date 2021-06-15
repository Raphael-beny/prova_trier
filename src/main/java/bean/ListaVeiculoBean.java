package bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import business.VeiculoBusiness;
import entity.Veiculo;
import utils.FiltroDTO;

@ViewScoped
@ManagedBean
public class ListaVeiculoBean {
	
	private List<Veiculo> listaVeiculo;
		
	private FiltroDTO filtroDTO = new FiltroDTO();
	
	private VeiculoBusiness veiculoBusiness = new VeiculoBusiness();
	
	@PostConstruct
	public void inicializar() {
		consultarVeiculo();
	}
	
	public String cadastrarVeiculo() {
		return "veiculoCadastrar.xhtml?faces-redirect=true";
	}
			
	
	public void removerVeiculo(Veiculo veiculo) {
		veiculoBusiness.removerVeiculo(veiculo);
		consultarVeiculo();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Veiculo foi removido"));
	}
	
	
	public String editarVeiculo(Veiculo veiculo) {
		return "veiculoCadastrar?faces-redirect=true&idVeiculo=" + veiculo.getIdVeiculo();
	}
	
	public void consultarVeiculo() {
		listaVeiculo = veiculoBusiness.getListaVeiculo(filtroDTO);
	}
	
	
	public List<Veiculo> getListaVeiculo() {
		return listaVeiculo;
	}
	
	public void setListaVeiculo(List<Veiculo> listaVeiculo) {
		this.listaVeiculo = listaVeiculo;
	}
	
	
	
	public FiltroDTO getFiltroDTO() {
		return filtroDTO;
	}
	
	public void setFiltroDTO(FiltroDTO filtroDTO) {
		this.filtroDTO = filtroDTO;
	}
	
}
