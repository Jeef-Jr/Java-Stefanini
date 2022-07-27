package com.stefanini.aprendendo.entidades;

import com.stefanini.aprendendo.aula.Carro;

public class Tesla extends Carro {

	private boolean dirigirSozinho;
	
	
	@Override
	public double calcularTaxaAceleracao(double velocidadeFinal, double velocidadeInicia, double tempoFinal,
			double tempoInicial) {
		// TODO Auto-generated method stub
		return (velocidadeFinal * velocidadeInicia) - (tempoFinal + tempoInicial);
	}

	public boolean isDirigirSozinho() {
		return dirigirSozinho;
	}

	public void setDirigirSozinho(boolean dirigirSozinho) {
		this.dirigirSozinho = dirigirSozinho;
	}

	@Override
	public void piscarAlerta() {
		System.out.println("Tesla piscando alerta!");
		
	}
	
	
	
}
