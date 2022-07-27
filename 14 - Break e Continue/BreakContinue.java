package com.stefanini.aprendendo.condicoes;

public class BreakContinue {

	
	public static void main(String[] args) {
		
		int count = 7;
		
		
		for(int i=1; i <= 7; i++) {
			
			if(i == 3) {
				System.out.println("Encerramos por aqui....");
				break;
			}else {
				System.out.println("Continuando..." + i);
				continue;
			}
			
			
			
		}
		
		
		
	}
	
	
}
