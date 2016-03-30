package reaccao;

import java.util.HashMap;
import java.util.Map;

import maqest.Estado;
import maqest.MaquinaEstados;

public abstract class ComportMaqEst implements Comportamento{
	
	/**Maquina de estado */
	private MaquinaEstados<Estimulo> maqEst;
	public Estado<Estimulo> getEstado(){
		return maqEst.getEstado();
	}
	
	/** Comportamentos */
	private Map<Estado<Estimulo>, Comportamento> comportamentos;
	
	/** Constructor */
	public ComportMaqEst(){
		comportamentos = new HashMap<Estado<Estimulo>, Comportamento>();
		maqEst = iniciar();
	}
	
	/**
	 * Iniciar máquina de estados
	 * @return Máquina de estados
	 */
	protected abstract MaquinaEstados<Estimulo> iniciar();
	
	@Override
	public Accao activar(Estimulo estimulo){
		Comportamento comport = comportamentos.get(maqEst.getEstado());
		Accao accao = comport != null ? comport.activar(estimulo) : null;
		maqEst.processar(estimulo);
		return accao;
	}
	
	/**
	 * Definir comportamento
	 * @param estado Estado
	 * @param comport Comportamento associado ao estado
	 * @return Comportamento actual
	 */
	
	public ComportMaqEst comport(Estado<Estimulo> estado, Comportamento comport){
		comportamentos.put(estado, comport);
		return this;
		
	}
	
}
