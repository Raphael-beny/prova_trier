package business;

import java.util.List;

import entity.Veiculo;
import repository.VeiculoRepository;
import utils.FiltroDTO;

public class VeiculoBusiness {
	
	private VeiculoRepository veiculoRepository = new VeiculoRepository();
	
	private VagaBusiness vagaBusiness = new VagaBusiness();

	public void salvarVeiculo(Veiculo veiculo) {
		veiculoRepository.salvarVeiculo(veiculo);
	}
	
	public List<Veiculo> getListaVeiculo(FiltroDTO filtroDTO) {
		return veiculoRepository.getListaVeiculo(filtroDTO);
	}

	public void removerVeiculo(Veiculo veiculo) {
		veiculoRepository.removerVeiculo(veiculo);
	}

	public Veiculo getVeiculo(Integer idVeiculo) {
		return veiculoRepository.getVeiculo(idVeiculo);
	}

}
