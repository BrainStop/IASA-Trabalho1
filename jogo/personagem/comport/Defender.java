package jogo.personagem.comport;

import jogo.ambiente.AccaoAmb;
import jogo.ambiente.EventoAmb;
import reaccao.ComportHierarq;
import reaccao.Comportamento;
import reaccao.Reaccao;

public class Defender extends ComportHierarq{
	public Defender(){
		super(new Comportamento[]{
			new Reaccao(EventoAmb.INIMIGO, AccaoAmb.DEFENDER)
		});
	}
}


