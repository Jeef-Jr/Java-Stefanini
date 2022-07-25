package com.stefanini.aprendendo.aula;

public class Principal {
	
	public static void main(String[] args) {
		
		Carro bmw = new Carro();
		
		bmw.setMarca("BMW");
		bmw.setModelo("M3");;
		bmw.setQuilometroPorLitro(7.5);;
//		bmw.taxaAceleracao = 50;
		bmw.setVelocidadeMaxima(280);
		
		bmw.acelerar();
		bmw.freiar();
		
		
		Carro mercedez = new Carro("Mercedez", "C3");
		
		System.out.println(mercedez.getModelo());
		
		System.out.println(bmw.calcularTaxaAceleracao(bmw.getVelocidadeMaxima(), 0, 10, 0));
	}

}
