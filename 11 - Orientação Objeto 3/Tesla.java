package com.stefanini.aprendendo.aula;

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
	
	
	
}
