package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import entity.Veiculo;
import utils.FiltroDTO;
import utils.JPAUtil;

public class VeiculoRepository {
	
	private EntityManager entityManager;

	public void salvarVeiculo(Veiculo veiculo) {
		entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(veiculo);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public List<Veiculo> getListaVeiculo(FiltroDTO filtroDTO) {
		entityManager = new JPAUtil().getEntityManager();
		String sql = getSqlListaVeiculo(filtroDTO);
		Query query = entityManager.createQuery(sql);
		
		if (filtroDTO.getModelo() != null) {
			query.setParameter("modelo", filtroDTO.getModelo());
		}
		
		if (filtroDTO.getPlaca() != null) {
			query.setParameter("placa", filtroDTO.getPlaca());
		}
		
		if (filtroDTO.getCodigoVaga() != null) {
			query.setParameter("codigoVaga", filtroDTO.getCodigoVaga());
		}
		
		
		List<Veiculo> listaVeiculo = query.getResultList();

		entityManager.close();
		return listaVeiculo;
	}

	private String getSqlListaVeiculo(FiltroDTO filtroDTO) {
		String sql = "SELECT p "
				   + "FROM Veiculo p "
				   + "WHERE 1=1 ";
		if (filtroDTO.getModelo() != null) {
			sql += " AND lower(p.modelo) LIKE ('%'||:modelo||'%') ";
		}
		
		if (filtroDTO.getPlaca() != null) {
			sql += " AND lower(p.placa) LIKE ('%'||:placa||'%') ";
		}
		
		if (filtroDTO.getCodigoVaga() != null) {
			sql += " AND p.vaga.codigo = :codigoVaga ";
		}
		
		return sql;
	}

	

	public void removerVeiculo(Veiculo veiculo) {
		entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.remove(entityManager.find(Veiculo.class, veiculo.getIdVeiculo()));
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	

	
	public Veiculo getVeiculo(Integer idVeiculo) {
		entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();
		Veiculo veiculo = entityManager.find(Veiculo.class, idVeiculo);
		entityManager.close();
		return veiculo;
	}

	

}