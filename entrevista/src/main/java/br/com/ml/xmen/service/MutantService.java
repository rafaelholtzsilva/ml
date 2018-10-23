package br.com.ml.xmen.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.google.gson.Gson;

import br.com.ml.xmen.model.dao.entities.Dna;
import br.com.ml.xmen.model.dao.impl.DnaDaoImpl;

@Service()
@Transactional
public class MutantService {

	private static final Pattern HORIZONTAL = Pattern.compile("(C{4,}|A{4,}|G{4,}|T{4,})");

	private static final String VERTICAL_OBLIQUE = "A$A$A$A|T$T$T$T|C$C$C$C|G$G$G$G";

	private static Logger logger = LoggerFactory.getLogger(MutantService.class);

	@Autowired
	private DnaDaoImpl dnaDaoImpl;

	@Autowired
	StatisService statisService;

	public boolean isMutantAndSave(String[] dna) {
		boolean isMutant = false;
		if (dna != null) {
			isMutant = isMutant(dna);
			saveDna(dna, isMutant);
		}
		return isMutant;
	}

	public boolean isMutant(String[] dna) {
		for (String string : dna) {
			Matcher m = HORIZONTAL.matcher(string);
			if (m.find()) {
				return true;
			}
		}

		// matriz n:n -- size = n
		int size = dna.length;

		String regex = VERTICAL_OBLIQUE.replaceAll("\\$", Strings.repeat(".", size - 1)) + '|'
				+ VERTICAL_OBLIQUE.replaceAll("\\$", Strings.repeat(".", size));

		logger.debug("regex VERTICAL_OBLIQUE {}", regex);
		String dnsString = String.join("", dna);

		return Pattern.compile(regex).matcher(dnsString).find();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void saveDna(String[] dna, boolean isMutant) {

		Dna dnaEntity = new Dna();
		Gson gson = new Gson();
		dnaEntity.setDna(gson.toJson(dna));
		dnaEntity.setMutant(isMutant);
		dnaDaoImpl.create(dnaEntity);
		statisService.increment(isMutant);
		
	}

}
