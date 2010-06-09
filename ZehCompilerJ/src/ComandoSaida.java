
public class ComandoSaida extends Comando {
	String janela;
	public ComandoSaida()
	{
		comando=comtype.PRINT;
		janela="";
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
	public ComandoSaida(Object o)
	{
		this(o.toString());
	}
	public ComandoSaida(Object o, String janela)
	{
		this(o.toString(),janela);
	}
}
