package com.stefanini.aprendendo.aula;

public class Principal {
	
	public static void main(String[] args) {
		
		Carro bmw = new Carro();
		
		bmw.setMarca("BMW");
		bmw.setModelo("M3");;
		bmw.setQuilometroPorLitro(7.5);;
//		bmw.taxaAceleracao = 50;
		
		try {
			bmw.setVelocidadeMaxima(0);
		}catch(NegocioException e){
			System.out.println(e);
		}finally {
			System.out.println("Passou aqui!");
		}
		
		bmw.acelerar();
		bmw.freiar();
		
		Tesla tesla = new Tesla();
		
		tesla.setDirigirSozinho(true);
		
		
		
		
		
		
		Carro mercedez = new Carro("Mercedez", "C3");
		
		System.out.println(mercedez.getModelo());
		
		System.out.println(bmw.calcularTaxaAceleracao(bmw.getVelocidadeMaxima(), 0, 10, 0));
	}

}
