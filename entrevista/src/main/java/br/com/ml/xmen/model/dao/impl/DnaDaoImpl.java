package br.com.ml.xmen.model.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.ml.xmen.model.dao.AbstractDao;
import br.com.ml.xmen.model.dao.entities.Dna;

@Repository
public class DnaDaoImpl extends AbstractDao<Dna, Long> {

	
	public DnaDaoImpl() {
		super(Dna.class);
	}
	public DnaDaoImpl(Class<Dna> entityClass) {
		super(entityClass);
	}

    @PersistenceContext
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
	
}
