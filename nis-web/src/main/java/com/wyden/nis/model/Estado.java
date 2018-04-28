package com.wyden.nis.model;

public enum Estado {

	S (1), N (0);
	
	public int estadoBoolean;
	
    Estado(int valor) {
        estadoBoolean = valor;
    }
}
