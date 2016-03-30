package jogo.personagem.comport;

import jogo.ambiente.AccaoAmb;
import jogo.ambiente.EventoAmb;
import reaccao.ComportHierarq;
import reaccao.Comportamento;
import reaccao.Reaccao;

public class Inspeccionar extends ComportHierarq {
	public Inspeccionar(){
		super(new Comportamento[]{
			new Reaccao(EventoAmb.INIMIGO, AccaoAmb.APROXIMAR),
			new Reaccao(EventoAmb.RUIDO, AccaoAmb.PROCURAR)
		
		});
	}
}


