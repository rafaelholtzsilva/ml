package br.com.ml.xmen.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ml.xmen.controller.json.StatisMutantJson;
import br.com.ml.xmen.model.dao.entities.DnaTypeEnum;
import br.com.ml.xmen.model.dao.impl.StatisDaoImpl;

@Service()
public class StatisService {

	private static Logger logger = LoggerFactory.getLogger(StatisService.class);

	@Autowired
	private StatisDaoImpl statisDaoImpl;

	public void increment(boolean isMutant) {
		Integer id = isMutant ? DnaTypeEnum.MUTANT.getId() : DnaTypeEnum.HUMAN.getId();
		statisDaoImpl.increment(id);
	}

	public StatisMutantJson statis() {
		StatisMutantJson statisMutant = new StatisMutantJson();
		statisMutant.setCountHuman(statisDaoImpl.find(DnaTypeEnum.HUMAN.getId()).getCount());
		statisMutant.setCountMuntant(statisDaoImpl.find(DnaTypeEnum.MUTANT.getId()).getCount());
		statisMutant.setRatio(calculateRatio(statisMutant));
		return statisMutant;
	}

	public BigDecimal calculateRatio(StatisMutantJson statis) {

		logger.debug("statis human {}  mutant {}", statis.getCountHuman(), statis.getCountMuntant());

		long human = Optional.ofNullable(statis.getCountHuman()).orElse(0);
		long mutant = Optional.ofNullable(statis.getCountMuntant()).orElse(0);

		if (human == 0 && mutant == 0) {
			return BigDecimal.ONE;
		}
		if (human == 0) {
			return BigDecimal.valueOf(mutant);
		}
		if (mutant == 0) {
			return BigDecimal.ZERO;
		}

		return BigDecimal.valueOf(mutant).divide(BigDecimal.valueOf(human), 2, RoundingMode.HALF_EVEN);
	}

}
