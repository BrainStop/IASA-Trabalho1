package jogo.personagem.comport;

import jogo.ambiente.EventoAmb;
import maqest.Estado;
import maqest.MaquinaEstados;
import reaccao.ComportMaqEst;
import reaccao.Estimulo;

public class ComportPersonagem extends ComportMaqEst{
	
	@Override
	protected MaquinaEstados<Estimulo> iniciar(){
		//definir estados
		Estado<Estimulo> patrulha = new Estado<Estimulo>("Patrulha");
		Estado<Estimulo> inspeccao = new Estado<Estimulo>("Inspecção");
		Estado<Estimulo> defesa = new Estado<Estimulo>("Defesa");
		Estado<Estimulo> combate = new Estado<Estimulo>("Combate");
		
		//definir transições
		patrulha
			.trans(EventoAmb.INIMIGO, defesa)
			.trans(EventoAmb.RUIDO, inspeccao);
		
		inspeccao
			.trans(EventoAmb.INIMIGO, defesa)
			.trans(EventoAmb.SILENCIO, patrulha);
		
		defesa
			.trans(EventoAmb.FUGA, inspeccao)
			.trans(EventoAmb.INIMIGO, combate);
		
		combate
			.trans(EventoAmb.INIMIGO, combate)
			.trans(EventoAmb.FUGA, patrulha)
			.trans(EventoAmb.VITORIA, patrulha)
			.trans(EventoAmb.DERROTA, patrulha);

		//definir comportamentos
		comport(patrulha, new Patrulhar());
		comport(inspeccao, new Inspeccionar());
		comport(defesa, new Defender());
		comport(combate, new Combater());
		
		return new MaquinaEstados<Estimulo>(patrulha);
	}
}
