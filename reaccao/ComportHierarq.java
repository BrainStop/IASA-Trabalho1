package reaccao;

public class ComportHierarq implements Comportamento {
	
	private Comportamento[] comportamentos;
	
	public ComportHierarq(Comportamento[] comportamentos){
		this.comportamentos = comportamentos;
	}
	
	public Accao activar(Estimulo estimulo){
		for(Comportamento comportamento : comportamentos){
			Accao accao = comportamento.activar(estimulo);
			if(accao!=null){
				return accao;
			}
		}
		return null;
			
	}
}
