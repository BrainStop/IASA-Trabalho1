package jogo.personagem.comport;

import jogo.ambiente.AccaoAmb;
import jogo.ambiente.EventoAmb;
import reaccao.ComportHierarq;
import reaccao.Comportamento;
import reaccao.Reaccao;

public class Combater extends ComportHierarq{
	public Combater(){
		super(new Comportamento[]{
			new Reaccao(EventoAmb.INIMIGO, AccaoAmb.ATACAR),
			new Reaccao(EventoAmb.DERROTA, AccaoAmb.INICIAR)
		});
	}
}


