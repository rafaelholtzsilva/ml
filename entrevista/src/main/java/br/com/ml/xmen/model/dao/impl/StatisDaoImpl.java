package br.com.ml.xmen.model.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.ml.xmen.model.dao.AbstractDao;
import br.com.ml.xmen.model.dao.entities.DnaTypeEnum;
import br.com.ml.xmen.model.dao.entities.Statis;

@Repository
public class StatisDaoImpl extends AbstractDao<Statis, Integer> {

	public StatisDaoImpl() {

		super(Statis.class);
	}

	public StatisDaoImpl(Class<Statis> entityClass) {
		super(entityClass);
	}

	@PersistenceContext
	private EntityManager em;

	@Override
	public EntityManager getEntityManager() {
		return em;
	}

	public void increment(Integer id) {
		Query query = getEntityManager().createNativeQuery("update STATIS a set a.COUNT = a.COUNT + 1 where id = :id ");
		query.setParameter("id", id);
		query.executeUpdate();
	}

	@EventListener(ApplicationReadyEvent.class)
	@Transactional
	public void postConstructInit() {
		create(new Statis(DnaTypeEnum.MUTANT.getId(), 0));
		create(new Statis(DnaTypeEnum.HUMAN.getId(), 0));
	}

}
