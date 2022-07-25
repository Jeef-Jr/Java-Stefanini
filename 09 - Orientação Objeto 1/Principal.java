package com.stefanini.aprendendo.aula;

public class Principal {
	
	public static void main(String[] args) {
		
		Carro bmw = new Carro();
		
		bmw.marca = "Bmw";
		bmw.modelo = "M3";
		bmw.quilometroPorLitro = 7.5;
		bmw.taxaAceleracao = 50;
		bmw.velocidadeMaxima = 280;
		
		bmw.acelerar();
		bmw.freiar();
		
		
	}

}
