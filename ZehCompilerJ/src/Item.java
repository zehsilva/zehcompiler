import java.util.*;
public class Item {
	public char tipo;
	public String valor;
	public char valorchar;
	public Object valorobj;
	public double valordouble;
	public int valorint;
	static enum op{ADD,SUB,MULT,DIV,MOD,CONCAT,EXP,NOT,AND,NAND,XOR,OR,NOR,DOLLAR,ARROBA,MAIOR,MENOR,GT,LS,GTEQ,LSEQ,EQ,DIFF,IN,NONE};
	op oper=op.NONE;
	public ArrayDeque<Item> valorlst=new ArrayDeque<Item>();
	public Item()
	{
		this.valor="";
		this.tipo='o';
		oper=op.NONE;
	}
	public Item(char t,String s)
	{
		tipo=t;
		
		valor=s;
		if(t=='s')
		{
			if(s.charAt(0)=='"' && s.charAt(s.length()-1)=='"' )
			{
				valor=s.substring(1, s.length()-1);
			}
			stringToList(valor);
			System.out.println("str = "+valor+"; list item: "+this.valorlst);
		}
	}
	public Item(char t,String s,op oper)
	{
		tipo=t;
		
		valor=s;
		if(t=='s')
		{
			valor=s.split("\"")[1];
			stringToList(valor);
		}
		this.oper=oper;
	}
	public void stringToList(String s)
	{
		int i;
		try{
		for(i=0;i<s.length();i++)
			valorlst.offer(new Item('c',s.charAt(i)));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
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
		valorint=(int)o;
		valor=o+"";
	}
	public Item(char t,int o)
	{
		tipo=t;
		valorint=o;
		valordouble=(double)o;
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
		return (this.tipo=='i'||this.tipo=='r'||this.tipo=='n');
	}
	public boolean isReal()
	{
		return (this.tipo=='r'||this.tipo=='n');
	}
	public boolean isInt()
	{
		return (this.tipo=='i');
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
