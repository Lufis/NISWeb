package com.wyden.nis.model;

public enum Situacao {

	S(1), N(0);

	public int situacaoBoolean;

	Situacao(int valor) {
		situacaoBoolean = valor;
	}
}
