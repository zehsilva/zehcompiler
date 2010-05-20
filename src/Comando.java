import java.util.ArrayDeque;


public class Comando {
	static enum comtype {IF,FOR,PRINT,WHILE,ATRIB,ENTRADA,NONE};
	comtype comando=comtype.NONE;
	String var="";
	public ArrayDeque<String> listaVar=new ArrayDeque<String>();
	public ArrayDeque<Item> expr1=new ArrayDeque<Item>();
	public ArrayDeque<Item> expr2=new ArrayDeque<Item>();
	public ArrayDeque<Item> expr3=new ArrayDeque<Item>();
	public Comando()
	{
		comando=comtype.NONE;
	}

}
