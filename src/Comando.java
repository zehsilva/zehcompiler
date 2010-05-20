import java.util.ArrayDeque;
import java.util.LinkedList;

public class Comando {
	static enum comtype {IF,FOR,PRINT,WHILE,ATRIB,ENTRADA,NONE};
	comtype comando=comtype.NONE;
	String var="";
	public ArrayDeque<String> listaVar=new ArrayDeque<String>();
	public ArrayDeque<Item> expr1=new ArrayDeque<Item>();
	public ArrayDeque<Item> expr2=new ArrayDeque<Item>();
	//public ArrayDeque<Item> expr3=new ArrayDeque<Item>();
	LinkedList<Comando> corpo=new LinkedList<Comando>();
	public Comando()
	{
		comando=comtype.NONE;
	}
}
