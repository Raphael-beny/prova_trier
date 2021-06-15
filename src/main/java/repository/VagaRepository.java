package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import bean.VagaBean;
import entity.Vaga;
import utils.FiltroDTO2;
import utils.JPAUtil;

public class VagaRepository {
	
	private EntityManager entityManager;


	public void salvarVaga(Vaga vaga) {
		entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(vaga);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public boolean verificaVagaDisponivel(int vagaSelecionada) {
		entityManager = new JPAUtil().getEntityManager();
		String sql = "SELECT "
				+ "CASE WHEN COUNT(v) > 0 "
				+ "THEN true ELSE false END "
				+ "FROM Vaga v "
				+ "WHERE v.codigo = :vagaSelecionada "
		        + "AND v.status = 'Livre' ";
		Query query = entityManager.createQuery(sql);
		query.setParameter("vagaSelecionada", vagaSelecionada);
		boolean vagaDisponivel = (boolean) query.getSingleResult();
		entityManager.close();
		
		return vagaDisponivel;
	}
	
	public Vaga buscarVagaPorCodigo(int vagaSelecionada) {
		entityManager = new JPAUtil().getEntityManager();
		String sql = "SELECT v "
				+ "FROM Vaga v "
				+ "WHERE v.codigo = :vagaSelecionada ";
		Query query = entityManager.createQuery(sql);
		query.setParameter("vagaSelecionada", vagaSelecionada);
		
		return (Vaga) query.getSingleResult();
	}

	public List<Vaga> getListaVaga(FiltroDTO2 filtroDTO2) {
		entityManager = new JPAUtil().getEntityManager();
		String sql = getSqlListaVaga(filtroDTO2);
		Query query = entityManager.createQuery(sql);
		
		if (filtroDTO2.getCodigo() != null) {
			query.setParameter("codigo", filtroDTO2.getCodigo());
		}
		if (filtroDTO2.getStatus() != null) {
			query.setParameter("status", filtroDTO2.getStatus());
		}
		
		List<Vaga> listaVaga = query.getResultList();

		entityManager.close();
		return listaVaga;
	}

	private String getSqlListaVaga(FiltroDTO2 filtroDTO2) {
		String sql = "SELECT p FROM Vaga p WHERE 1=1 ";
		if (filtroDTO2.getCodigo() != null) {
			sql += " AND p.codigo = :codigo ";
		}
		if (filtroDTO2.getStatus() != null) {
			sql += " AND p.status = :status ";
		}
		return sql;
	}

	

	public void removerVaga(Vaga vaga) {
		entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.remove(entityManager.find(Vaga.class, vaga.getIdVaga()));
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	

	
	public Vaga getVaga(Integer idVaga) {
		entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();
		Vaga vaga = entityManager.find(Vaga.class, idVaga);
		entityManager.close();
		return vaga;
	}


}