package br.com.ml.xmen.model.dao.entities;

public enum DnaTypeEnum {

	MUTANT(1), HUMAN(2);

	DnaTypeEnum(Integer id) {
		this.id = id;
	}

	private Integer id;

	public Integer getId() {
		return id;
	}
}
