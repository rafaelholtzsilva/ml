package br.com.ml.xmen.controller.json;

import java.util.Arrays;

public class DnaJson {

	private String[] dna;

	public String[] getDna() {
		return dna;
	}

	public void setDna(String[] dna) {
		this.dna = dna;
	}

	@Override
	public String toString() {
		return "DnaParam [dna=" + Arrays.toString(dna) + "]";
	}
}
