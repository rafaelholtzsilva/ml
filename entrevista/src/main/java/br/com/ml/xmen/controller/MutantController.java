package br.com.ml.xmen.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ml.xmen.controller.json.DnaJson;
import br.com.ml.xmen.controller.json.StatisMutantJson;
import br.com.ml.xmen.service.MutantService;
import br.com.ml.xmen.service.StatisService;

@RestController
public class MutantController {

	private static Logger logger = LoggerFactory.getLogger(MutantController.class);

	private static ResponseEntity<Void> STATUS_FORBIDDEN = new ResponseEntity<Void>(HttpStatus.FORBIDDEN);

	private static ResponseEntity<Void> STATUS_OK = new ResponseEntity<Void>(HttpStatus.OK);

	@Autowired()
	private MutantService mutantService;

	@Autowired
	private StatisService statisService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index() {
		return "Hello";
	}

	@RequestMapping(value = "test", method = RequestMethod.GET)
	public ResponseEntity<Void> test() {
		return STATUS_OK;
	}

	@RequestMapping(value = "mutant", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> isMutant(@RequestBody DnaJson dnaParam) {
		boolean dnaIsNotnull = dnaParam != null && dnaParam.getDna() != null;
		logger.debug("isMutant {} ", dnaIsNotnull);
		boolean isMutant = false;
		if (dnaIsNotnull) {
			isMutant = mutantService.isMutantAndSave(dnaParam.getDna());
		}
		return isMutant ? STATUS_OK : STATUS_FORBIDDEN;
	}

	@RequestMapping(value = "statis", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public StatisMutantJson stats() {
		logger.debug("start stats");
		return statisService.statis();
	}

}
