package jogo;

import jogo.ambiente.Ambiente;
import jogo.ambiente.EventoAmb;
import jogo.personagem.Personagem;
public class Jogo {

	private static Ambiente ambiente = new Ambiente();
	private static Personagem personagem = new Personagem(ambiente);
	
	public static void main(String[] args) {
			executarJogo();
	}
	
	private static void executarJogo(){
		do{
			personagem.executar();
			ambiente.evoluir();			
		}while(ambiente.obterEvento() != EventoAmb.TERMINAR);
		
	}
	

}
