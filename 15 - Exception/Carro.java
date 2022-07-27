package com.stefanini.aprendendo.aula;

public class Carro {
	
	public Carro() {}

	private String marca;
	private String modelo;
	private int velocidadeMaxima;
	private int taxaAceleracao;
	private double quilometroPorLitro;
	
	
	public Carro(String marca, String modelo) {
	
		this.setMarca(marca);
		this.setModelo(modelo);
		
	}
	
	public void acelerar() {
		System.out.println("Acelerando...");
	}
	
	public void freiar() {
		System.out.println("Freiando...");
	}
	
	public double calcularTaxaAceleracao(double velocidadeFinal, double velocidadeInicial, double tempoFinal, double tempoInicial) {
		return (velocidadeFinal - velocidadeInicial) / (tempoFinal - tempoInicial) * 3.6;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getVelocidadeMaxima() {
		return velocidadeMaxima;
	}

	public void setVelocidadeMaxima(int velocidadeMaxima) throws NegocioException {
		
		if(velocidadeMaxima <= 0) {
			throw new NegocioException("Valor inválido!");
		}else {
			this.velocidadeMaxima = velocidadeMaxima;
		}
		
		
	}

	public int getTaxaAceleracao() {
		return taxaAceleracao;
	}

	public void setTaxaAceleracao(int taxaAceleracao) {
		this.taxaAceleracao = taxaAceleracao;
	}

	public double getQuilometroPorLitro() {
		return quilometroPorLitro;
	}

	public void setQuilometroPorLitro(double quilometroPorLitro) {
		this.quilometroPorLitro = quilometroPorLitro;
	}

	
	
	
	
}
