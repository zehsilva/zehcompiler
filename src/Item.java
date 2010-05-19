import java.util.*;
public class Item {
	public char tipo;
	public String valor;
	public char valorchar;
	public Object valorobj;
	public double valordouble;
	public int valorint;
	public ArrayDeque<Item> valorlst;
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
	public Item(char t,ArrayDeque<Item> s)
	{
		tipo=t;
		valorlst=s;
		valor=s.toString();
	}
	public Item(char t,Object o)
	{
		tipo=t;
		valorobj=o;
		valor=o.toString();
	}
	public Item(char t,char o)
	{
		
		tipo=t;
		valorchar=o;
		valor=o+"";
	}
	public Item(char t,double o)
	{
		tipo=t;
		valordouble=o;
		valor=o+"";
	}
	public Item(char t,int o)
	{
		tipo=t;
		valorint=o;
		valor=o+"";
	}
	public String getValor()
	{
		return this.valor;
	}
	public double getValorDouble()
	{
		return this.valordouble;
	}
	public char getValorChar()
	{
		return this.valorchar;
	}
	public int getValorInt()
	{
		return this.valorint;
	}
	public ArrayDeque<Item> getValorList()
	{
		return this.valorlst;
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
	public boolean isNum()
	{
		return (this.tipo=='i'||this.tipo=='r');
	}
	public boolean isChar()
	{
		return this.tipo=='c';
	}
	public boolean isString()
	{
		return this.tipo=='s';
	}
	public boolean isList()
	{
		return Character.isUpperCase(this.tipo);
	}
	public boolean isVar()
	{
		return this.tipo=='v';
	}
	public String toString()
	{
		return this.valor;
	}
}
