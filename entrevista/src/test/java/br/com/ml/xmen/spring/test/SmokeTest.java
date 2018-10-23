package br.com.ml.xmen.spring.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.ml.xmen.controller.MutantController;
import br.com.ml.xmen.controller.test.modal.HibernateTestConfiguration;
import br.com.ml.xmen.service.MutantService;
import br.com.ml.xmen.service.StatisService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {MutantController.class,MutantService.class,StatisService.class})
@ContextConfiguration(classes = { HibernateTestConfiguration.class })
public class SmokeTest {

    @Autowired
    private MutantController mutantController;

    @Test
    public void contexLoads() throws Exception {
        assertThat(mutantController).isNotNull();
    }
}