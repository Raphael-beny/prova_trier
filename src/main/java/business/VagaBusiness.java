package business;

import java.util.List;

import entity.Vaga;
import repository.VagaRepository;
import utils.FiltroDTO2;

public class VagaBusiness {
	
	private VagaRepository vagaRepository = new VagaRepository();

	public void salvarVaga(Vaga vaga) {
		vagaRepository.salvarVaga(vaga);
	}
	
	public List<Vaga> getListaVaga(FiltroDTO2 filtroDTO2) {
		return vagaRepository.getListaVaga(filtroDTO2);
	}

	public void removerVaga(Vaga vaga) {
		vagaRepository.removerVaga(vaga);
	}

	public Vaga getVaga(Integer idVaga) {
		return vagaRepository.getVaga(idVaga);
	}
	
	public boolean verificaVagaDisponivel(int vagaSelecionada) {
		return vagaRepository.verificaVagaDisponivel(vagaSelecionada);
	}

	public Vaga buscarVagaPorCodigo(int vagaSelecionada) {
		return vagaRepository.buscarVagaPorCodigo(vagaSelecionada);
	}	

}
