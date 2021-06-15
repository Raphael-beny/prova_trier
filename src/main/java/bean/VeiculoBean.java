package bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import business.VagaBusiness;
import business.VeiculoBusiness;
import entity.Vaga;
import entity.Veiculo;

@ViewScoped
@ManagedBean
public class VeiculoBean {
	
	private Veiculo veiculo;
	
	private VeiculoBusiness veiculoBusiness = new VeiculoBusiness();
	
	private VagaBusiness vagaBusiness = new VagaBusiness();
		
	private Integer idVeiculo;
	
	private int vagaSelecionada;
	
	@PostConstruct
	public void inicializar() {
		if (idVeiculo == null) {
			iniciarNovoVeiculo();			
		} else {
			buscarVeiculo();
		}
	}

	private void iniciarNovoVeiculo() {
		veiculo = new Veiculo();
	}

	private void buscarVeiculo() {
		veiculo = veiculoBusiness.getVeiculo(idVeiculo);
	}

	public void salvar() {
		if (vagaBusiness.verificaVagaDisponivel(vagaSelecionada)) {
			Vaga vaga = vagaBusiness.buscarVagaPorCodigo(vagaSelecionada);
			vaga.setStatus("Ocupada");
			veiculo.setVaga(vaga);
			
			vagaBusiness.salvarVaga(vaga);
			veiculoBusiness.salvarVeiculo(veiculo);
			iniciarNovoVeiculo();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Veiculo salvo com sucesso"));			
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Vaga informada não existe cadastrada ou está ocupada"));
		}
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Integer getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(Integer idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
	
	public int getVagaSelecionada() {
		return vagaSelecionada;
	}
	
	public void setVagaSelecionada(int vagaSelecionada) {
		this.vagaSelecionada = vagaSelecionada;
	}
}
