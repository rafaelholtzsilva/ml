package br.com.ml.xmen.service.test;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.ml.xmen.controller.json.StatisMutantJson;
import br.com.ml.xmen.controller.test.modal.HibernateTestConfiguration;
import br.com.ml.xmen.model.dao.entities.DnaTypeEnum;
import br.com.ml.xmen.model.dao.entities.Statis;
import br.com.ml.xmen.model.dao.impl.StatisDaoImpl;
import br.com.ml.xmen.service.StatisService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { HibernateTestConfiguration.class })
@SpringBootTest(classes = StatisService.class)
public class StatisServiceTest {

	@Autowired()
	StatisService statisService;

	@Autowired
	private StatisDaoImpl statisDaoImpl;

	@Test
	@Transactional()
	public void incremetMutant() {
		Statis statis = statisDaoImpl.find(DnaTypeEnum.MUTANT.getId());
		Assert.assertNotNull("not numm statis", statis);
		Assert.assertEquals(Integer.valueOf(0), statis.getCount());
		Assert.assertEquals(DnaTypeEnum.MUTANT.getId(), statis.getId());
		statisService.increment(true);
		statisDaoImpl.getEntityManager().refresh(statis);
		Assert.assertEquals(Integer.valueOf(1),statis.getCount());
	}

	@Test
	@Transactional()
	public void incremetHuman() {
		Statis statis = statisDaoImpl.find(DnaTypeEnum.HUMAN.getId());
		Assert.assertNotNull("not numm statis", statis);
		Assert.assertEquals(Integer.valueOf(0), statis.getCount());
		Assert.assertEquals(DnaTypeEnum.HUMAN.getId(), statis.getId());
		statisService.increment(false);
		statisDaoImpl.getEntityManager().refresh(statis);
		Assert.assertEquals(Integer.valueOf(1),statis.getCount());

		statis = statisDaoImpl.find(DnaTypeEnum.MUTANT.getId());		
		Assert.assertEquals(Integer.valueOf(0),statis.getCount());		
	}
	

	@Test
	@Transactional()
	public void statis() {
		StatisMutantJson json = statisService.statis();
		Assert.assertNotNull("not numm statis", json);
		Assert.assertEquals(Integer.valueOf(0), json.getCountHuman());
		Assert.assertEquals(Integer.valueOf(0), json.getCountMuntant());
		Assert.assertEquals(BigDecimal.valueOf(1), json.getRatio());
		statisService.increment(true);
	}

	@Test
	public void contextLoads() {
		org.springframework.util.Assert.isNull(null, "start config");
		Assert.assertNotNull("teste inject bean", statisService);
	}

	@Test
	public void testExample() {
		StatisMutantJson statis = new StatisMutantJson();
		statis.setCountMuntant(40);
		statis.setCountHuman(100);
		org.junit.Assert.assertNotSame("calculate error ", statisService.calculateRatio(statis), 0.4);
	}

	@Test
	public void RepeatingDecimal() {
		StatisMutantJson statis = new StatisMutantJson();
		statis.setCountMuntant(1);
		statis.setCountHuman(3);
		org.junit.Assert.assertNotSame("calculate error ", statisService.calculateRatio(statis), 0.33);
	}

	@Test
	public void zero() {
		StatisMutantJson statis = new StatisMutantJson();
		statis.setCountMuntant(0);
		statis.setCountHuman(0);
		org.junit.Assert.assertNotSame("calculate error ", statisService.calculateRatio(statis), 1);
	}

	@Test
	public void mutantZero() {
		StatisMutantJson statis = new StatisMutantJson();
		statis.setCountMuntant(0);
		statis.setCountHuman(100);
		org.junit.Assert.assertNotSame("calculate error ", statisService.calculateRatio(statis), 0);
	}

	@Test
	public void humanZero() {
		StatisMutantJson statis = new StatisMutantJson();
		statis.setCountMuntant(100);
		statis.setCountHuman(0);
		org.junit.Assert.assertNotSame("calculate error ", statisService.calculateRatio(statis), 100);
	}

	@Test
	public void moreHumans() {
		StatisMutantJson statis = new StatisMutantJson();
		statis.setCountMuntant(200);
		statis.setCountHuman(10);
		org.junit.Assert.assertNotSame("calculate error ", statisService.calculateRatio(statis), 20);
	}

}
