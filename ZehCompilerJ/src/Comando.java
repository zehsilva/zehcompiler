import java.util.ArrayDeque;
import java.util.LinkedList;

public class Comando {
	static enum comtype {IF,FOR,PRINT,WHILE,ATRIB,ENTRADA,NONE};
	comtype comando=comtype.NONE;
	String var="";
	public ArrayDeque<String> listaVar=new ArrayDeque<String>();
	public ArrayDeque<Item> expr1=new ArrayDeque<Item>();
	
	public Comando()
	{ 
		comando=comtype.NONE;
	}
	public Comando(comtype tipo,String var,ArrayDeque exp)
	{ 
		comando=tipo;
		this.var=var;
		this.expr1=exp;
	}
}
