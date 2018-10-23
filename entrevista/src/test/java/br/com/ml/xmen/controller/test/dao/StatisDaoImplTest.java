package br.com.ml.xmen.controller.test.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.ml.xmen.controller.test.modal.HibernateTestConfiguration;
import br.com.ml.xmen.model.dao.entities.DnaTypeEnum;
import br.com.ml.xmen.model.dao.entities.Statis;
import br.com.ml.xmen.model.dao.impl.StatisDaoImpl;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { HibernateTestConfiguration.class })
@SpringBootTest(classes = StatisDaoImpl.class)
public class StatisDaoImplTest {

	@Autowired
	private StatisDaoImpl statisDaoImpl;
	
	@Test
	@Transactional()
	public void incremet(){
		Statis statis = statisDaoImpl.find(DnaTypeEnum.MUTANT.getId());
		Assert.assertNotNull("not numm statis", statis);
		statisDaoImpl.increment(1);
		statisDaoImpl.getEntityManager().refresh(statis);
		Assert.assertEquals(Integer.valueOf(1),statis.getCount());	
	}

	
}
