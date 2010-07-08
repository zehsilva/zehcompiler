import java.util.ArrayDeque;
import java.util.LinkedList;

//import Comando.comtype;


public class ComandoCorpo extends Comando{
	LinkedList<Comando> corpo=null;
	String varFor="";//variavel q serve somente para o foreach
	public ComandoCorpo(comtype tipo,ArrayDeque<Item> expcond,LinkedList<Comando> corpo){
		// este daqui serve para o if (heranca)
		comando=tipo;
		this.expr1=expcond;
		this.corpo=corpo;
	}
	public ComandoCorpo(ArrayDeque<Item> expcond,LinkedList<Comando> corpo){
		// este daqui serve para o while
		comtype tipo=comtype.WHILE;
		comando=tipo;
		this.expr1=expcond;
		this.corpo=corpo;
	}
	public ComandoCorpo(ArrayDeque<Item> expcond,String v,LinkedList<Comando> corpo){
		//este serve para o for
		comtype tipo=comtype.FOR;
		comando=tipo;
		varFor=v;
		this.expr1=expcond;
		this.corpo=corpo;;
	}
}
