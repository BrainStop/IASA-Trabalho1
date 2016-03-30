package maqest;

import java.util.HashMap;
import java.util.Map;

public class Estado<EV> {
	
	/**
	 * Nome do Estado
	 */
	private String nome;
	
	public String getNome(){
		return nome;	
	}
	
	/**
	 * tabela de transições de estado
	 */
	private Map<EV, Estado<EV>> transicoes;
	
	/**
	 * Construtor
	 */
	public Estado(String nome){
		this.nome = nome;
		transicoes = new HashMap<EV, Estado<EV>>();
	}
	
	
	/**
	 * 
	 * Processar evento
	 * @param evento EV
	 * @return Estado<EV> sucessor
	 */
	public Estado<EV> processar(EV evento){
		return transicoes.get(evento);
		
	}
	
	/**
	 * Definir transição
	 * @param evento EV
	 * @param estado Estado<EV> sucessr
	 * @return Estado<EV> actual
	 */
	
	public Estado<EV> trans(EV evento, Estado<EV> estado){
		transicoes.put(evento, estado);
		return this;
	}
	
	public String toString(){
		return nome;
		
	}
}
