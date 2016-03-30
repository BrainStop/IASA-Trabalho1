package jogo.personagem;
import jogo.ambiente.Ambiente;
import jogo.personagem.comport.ComportPersonagem;
import reaccao.Accao;
import reaccao.Estimulo;

public class Personagem {
	
	private Ambiente ambiente;
	private ComportPersonagem comport;
	
	public Personagem(Ambiente ambiente){
		this.ambiente = ambiente;	
		comport = new ComportPersonagem();
	}
	
	/**
	 * Passo de execução da personagem
	 */
	
	public void executar(){
		//percepcionar ambiente
		Estimulo estimulo = percepcionar();
		//Processar estimulo
		Accao accao = processar(estimulo);
		//Realizar acção
		actuar(accao);
		//Mostrar Personagem
		mostrar();
	}
	
	private Estimulo percepcionar(){
		return ambiente.obterEvento();
	}
	
	private Accao processar(Estimulo estimulo){
		return comport.activar(estimulo);
	}
	
	private void actuar(Accao accao){
		if(accao != null){
			accao.executar();
		}
	}
	
	private void mostrar(){
		System.out.printf("Estado : %s\n", comport.getEstado());
	}
	
	
}
