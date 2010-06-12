import java.util.ArrayDeque;


public class Comando {
	static enum comtype {IF,FOR,PRINT,WHILE,ATRIB,ENTRADA,NONE,DECL};
	comtype comando=comtype.NONE;
	String str=null;
	
	
	public ArrayDeque<Item> expr1=null;
	char tipoExpr1='_';
	
	public Comando()
	{
		comando=comtype.NONE;
	}
	public Comando(String var)
	{
		comando=comtype.ATRIB;
		str=var;
	}
	public Comando(comtype tipo,ArrayDeque<Item> exp)
	{ 
		comando=tipo;
		this.expr1=exp;
	}
	public Comando(String var,ArrayDeque<Item> exp)
	/** este daqui serve para o comando de atribuicao
	**/
	{ 
		comando=comtype.ATRIB;
		this.str=var;
		this.expr1=exp;
	}
	public Comando(String var,ArrayDeque<Item> exp,char tipoexp)
	/** este daqui serve para o comando de atribuicao
	**/
	{ 
		comando=comtype.ATRIB;
		this.str=var;
		this.expr1=exp;
		this.tipoExpr1=tipoexp;
	}
	public void setExpr(ArrayDeque<Item> exp)
	{
		this.expr1=exp;
	}
	public String toString()
	{
		return this.comando+"-"+this.tipoExpr1+"-"+this.expr1 ;
	}
	
}
