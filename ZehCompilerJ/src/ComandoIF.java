import java.util.ArrayDeque;
import java.util.LinkedList;

public class ComandoIF extends ComandoCorpo {
	LinkedList<Comando> corpoelse=null;
	public ComandoIF(ArrayDeque<Item> exp,LinkedList<Comando> corpo)
	{//este construtor serve para if
		super(comtype.IF,exp,corpo);
		
	}
	public ComandoIF(ArrayDeque<Item> exp,LinkedList<Comando> corpo,LinkedList<Comando> corpo2)
	{//este construtor serve para if
		super(comtype.IF,exp,corpo);
		this.corpoelse=corpo2;
	}
	public void setCorpoElse(LinkedList<Comando> corpo2)
	{
		this.corpoelse=corpo2;
	}
	public void setCorpo(LinkedList<Comando> corpo2)
	{
		this.corpo=corpo2;
	}
	
}
