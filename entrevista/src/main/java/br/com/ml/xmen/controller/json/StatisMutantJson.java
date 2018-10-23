package br.com.ml.xmen.controller.json;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatisMutantJson {

    @JsonProperty("count_mutant_dna")
	private Integer countMuntant;

    @JsonProperty("count_human_dna")
	private Integer countHuman;

    @JsonProperty("ratio")
	private BigDecimal ratio;

	public Integer getCountMuntant() {
		return countMuntant;
	}

	public void setCountMuntant(Integer countMuntant) {
		this.countMuntant = countMuntant;
	}

	public Integer getCountHuman() {
		return countHuman;
	}

	public void setCountHuman(Integer countHuman) {
		this.countHuman = countHuman;
	}

	public BigDecimal getRatio() {
		return ratio;
	}

	public void setRatio(BigDecimal ratio) {
		this.ratio = ratio;
	}

}
