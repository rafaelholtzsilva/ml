package br.com.ml.xmen.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import br.com.ml.xmen.controller.test.modal.HibernateTestConfiguration;
import br.com.ml.xmen.service.MutantService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MutantService.class)
@ContextConfiguration(classes = { HibernateTestConfiguration.class })
public class MutantServiceTest {

	@Autowired()
	MutantService mutantService;

	@Test
	public void contextLoads() {
		Assert.isNull(null, "start config");
		org.junit.Assert.assertNotNull("teste inject bean", mutantService);
	}

	@Test
	public void contextMutantHorizontal() {
		String[] dnaHorizontal = { "XTGCAA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		org.junit.Assert.assertTrue("", mutantService.isMutant(dnaHorizontal));
	}

	@Test
	public void dnaMutantVertical() {
		String[] dnaVertical = { "XTGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CXCCTA", "TCACTG" };
		org.junit.Assert.assertTrue("", mutantService.isMutant(dnaVertical));
	}

	@Test
	public void dnaMutantOblicue() {
		String[] dnaOblicue = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		org.junit.Assert.assertTrue("", mutantService.isMutant(dnaOblicue));
	}

	@Test
	public void notMutant() {
		String[] dnaFalse = { "XTGCXA", "CAGTGC", "TTATGT", "AGAAGG", "XCCCTA", "TCACTG" };
		org.junit.Assert.assertFalse("", mutantService.isMutant(dnaFalse));
	}

	@Test
	public void notMutantErrorDna() {
		String[] dnaFalse = { "XXXXX", "XXXXX", "XXXXX", "XXXXX", "XXXXX", "XXXXX" };
		org.junit.Assert.assertFalse("", mutantService.isMutant(dnaFalse));
	}
	
	
/*
	@Test
	public void notMutantNull() {
		org.junit.Assert.assertFalse("", mutantService.isMutant(null));
	}
*/
}
