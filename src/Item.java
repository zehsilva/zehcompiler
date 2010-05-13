import java.util.*;
public class Item {
	public char tipo;
	public String valor;
	public Object valor2;
	public ArrayList<Item> valorlst;
	public Item()
	{
		this.valor="";
		this.tipo='o';
	}
	public Item(char t,String s)
	{
		tipo=t;
		valor=s;
	}
	public Item(char t,ArrayList<Item> s)
	{
		tipo=t;
		valorlst=s;
	}
	public Item(char t,Object o)
	{
		tipo=t;
		valor2=o;
		valor=o.toString();
	}
	public String getValor()
	{
		return this.valor;
	}
	public char getTipo()
	{
		return this.tipo;
	}
	public void setValor(String s)
	{
		this.valor=s;
	}
	public void setTipo(char t)
	{
		this.tipo=t;
	}
	public boolean isOper()
	{
		return this.tipo=='o';
	}
}
