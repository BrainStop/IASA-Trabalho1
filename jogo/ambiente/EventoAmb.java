package jogo.ambiente;

import reaccao.Estimulo;

public enum EventoAmb implements Estimulo {
	SILENCIO,
	RUIDO,
	INIMIGO,
	FUGA, 
	VITORIA,
	DERROTA,
	TERMINAR;
}
