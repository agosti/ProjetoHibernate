package br.edu.unoesc.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.TypedQuery;

import br.edu.unoesc.modelo.Aluno;
import br.edu.unoesc.modelo.MinhaEntidade;

public class AlunoDAO<T extends MinhaEntidade> 
       extends HibernateDAO<T> {

	public List<Aluno> buscarPorData(LocalDate inicio, LocalDate fim) {
		super.conectar();
		try {
			TypedQuery<Aluno> query = 
					em.createNamedQuery(Aluno.FILTRA_POR_DATA, Aluno.class);
			query.setParameter(1, Date.valueOf(inicio));
			query.setParameter(2, Date.valueOf(fim));
			return query.getResultList();	
		} finally {
			super.finalizar();
		}
	}
	
	
}
