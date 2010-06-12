import java.util.ArrayDeque;


public class ComandoSaida extends Comando {
	String janela;
	public ComandoSaida()
	{
		comando=comtype.PRINT;
		janela=null;
	}
	public ComandoSaida(String msg)
	{
		this();
		this.str=msg;
	}
	public ComandoSaida(String msg,String janela)
	{
		this(msg);
		this.janela=janela;
	}
	public ComandoSaida(String janela, ArrayDeque<Item> expr)
	{
		comando=comtype.PRINT;
		this.expr1=expr;
		this.str=null;
		this.janela=janela;
	}
	public ComandoSaida(ArrayDeque<Item> expr)
	{
		comando=comtype.PRINT;
		this.janela=null;
		this.str=null;
		this.expr1=expr;
	}
	public ComandoSaida(ArrayDeque<Item> expr,char tipoexp)
	{
		comando=comtype.PRINT;
		this.janela=null;
		this.str=null;
		this.expr1=expr;
		this.tipoExpr1=tipoexp;
	}
	public ComandoSaida(Object o)
	{
		this(o.toString());
	}
	public ComandoSaida(Object o, String janela)
	{
		this(o.toString(),janela);
	}

	
}
