package com.stefanini.aprendendo.aula;

public class Vetor {
	
	public static void main(String[] args) {
		
		int[] notas = new int[] {0, 1, 10, 40, 20};
		
//		notas[posicao] = value
		
	
		for(int i = 0; i < notas.length; i ++) {
			System.out.println(notas[i]);
		}
		
		
		String[] carros = new String[] {"Bmw M4", "Lamborghini Huracan"};
		
//		Usando Foreach
		
		for(String carro: carros) {
			System.out.println(carro);
		}
		
		
	}

}
