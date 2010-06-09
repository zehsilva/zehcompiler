import java.util.ArrayDeque;
import java.util.LinkedList;

//import Comando.comtype;


public class ComandoCorpo extends Comando{
	LinkedList<Comando> corpo=null;
	public ComandoCorpo(comtype tipo,ArrayDeque<Item> expcond,LinkedList<Comando> corpo){
		// este daqui serve para o while e para o foreach
		super(tipo,expcond);
		this.corpo=corpo;
	}
}
