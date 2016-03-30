package jogo.ambiente;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ambiente {
	
	/**Evento pendente*/
	private EventoAmb evento;
	
	private Map<String, EventoAmb> eventos;
	
	/**Interface com consola */
	private Scanner sc = new Scanner(System.in);
	
	/**
	 * Constructor
	 */
	public Ambiente(){
		eventos = new HashMap<String, EventoAmb>();
		eventos.put("s", EventoAmb.SILENCIO);
		eventos.put("r", EventoAmb.RUIDO);
		eventos.put("i", EventoAmb.INIMIGO);
		eventos.put("f", EventoAmb.FUGA);
		eventos.put("v", EventoAmb.VITORIA);
		eventos.put("d", EventoAmb.DERROTA);
		eventos.put("t", EventoAmb.TERMINAR);
		
	}
	
	/**
	 * Evoluir ambiente
	 */
	public void evoluir(){
		gerarEvento();
		mostrar();
	}

	/**
	 * Gerar evento do ambiente
	 * @return Evento do ambiente
	 */
	public EventoAmb gerarEvento(){
		//obter comando
		System.out.print("\nEvento?");
		String comando = sc.next();
		
		//Gerar evento a partir do comando
		evento = eventos.get(comando);
		return evento;
	}
	
	public EventoAmb obterEvento(){
		return evento;
	}
	
	public void executarAccao(AccaoAmb accao){
		accao.executar();
	}
	
	private void mostrar() {
		if(evento!=null)
			System.out.printf("Evento: %s\n", evento);
		
	}
	
	
}
