import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;


public class SemanticActions {
	
	
	public static char testaVar(HashMap<String,Simbolo> tab,Token t) throws SemanticException
	{
		Simbolo s=null;
		if(!tab.containsKey(t.image))
			throw new SemanticException("Erro Semântico na linha: "+t.beginLine+"\n\t Variável '"+t.image+"' não declarada ");
		else
		{
			s=tab.get(t.image);
			s.setInicializada();
		}
		return s.getTipo();
	}
	public static char testaVarTipoInicializada(HashMap<String,Simbolo> tab,Token t) throws SemanticException
	{
		Simbolo s=null;
		if(!tab.containsKey(t.image))
			throw new SemanticException("Erro Semântico na linha: "+t.beginLine+"\n\t Variável '"+t.image+"' não declarada ");
		else
		{
			s=tab.get(t.image);
			if(!s.isInicializada())
				throw new SemanticException("Erro Semântico na linha: "+t.beginLine+"\n\t Variável '"+t.image+"' não inicializada ");
		}
		return s.getTipo();
	}
	public static void testaVarDcl(HashMap<String,Simbolo> tab,Token t) throws SemanticException
	{
		if(tab.containsKey(t.image))
			throw new SemanticException("Erro Semântico na linha: "+t.beginLine+"\n\t Variável '"+t.image+"' já foi declarada uma vez");
		else
			Simbolo.incInit();
	}
	public static void verificaTipoIncr(char tipo1,char tipo2,Token t) throws SemanticException
	{
		if(tipo1=='s'||tipo2=='s')
			throw new SemanticException("Erro Semântico na linha: "+t.beginLine+"\n\t Tipo errado na construção To ... Step ...");
	}
	public static void verificaTipoLista(char tipo1,char tipo2,Token t) throws SemanticException
	{
		if(tipo1!=tipo2)
			throw new SemanticException("Erro Semântico na linha: "+t.beginLine+"\n\t Lista deve ser homogênea");
	}
	public static void verificaInList(char tipo1,char tipo2,Token t) throws SemanticException
	{
		if(Character.isLowerCase(tipo2) || (Character.toLowerCase(tipo2)!=tipo1))
			throw new SemanticException("Erro Semântico na linha: "+t.beginLine+"\n\t O teste de pertinência só serve para elementos do mesmo tipo");
	}
	public static void verificaString(char tipo1,Token t) throws SemanticException
	{
		if(tipo1!='s' && Character.isLowerCase(tipo1))
			throw new SemanticException("Erro Semântico na linha: "+t.beginLine+"\n\t Este operação só deve ser para String ou Lista");
	}
	public static void verificaString(char tipo1,char tipo2, Token t) throws SemanticException
	{
		if((tipo1!='s' && Character.isLowerCase(tipo1))||(tipo2!='s' && Character.isLowerCase(tipo2)))
			throw new SemanticException("Erro Semântico na linha: "+t.beginLine+"\n\t Este operação só deve ser para String ou Lista");
	}
	public static void verificaConcat(char tipo1,char tipo2, Token t) throws SemanticException
	{
		verificaString(tipo1,tipo2,t);
		if(tipo1!=tipo2)
		{
			if((tipo1!='s'||tipo2!='C') && (tipo1 !='C' || tipo2!='s'))//string e lista de caracteres podem ser concatenadas
				throw new SemanticException("Erro Semântico na linha: "+t.beginLine+"\n\t A operação '.' só pode ser executada usando operandos do mesmo tipo");
		}
	}
	public static void verificaTipoAritmetica(char tipo1,char tipo2,Token t,String oper) throws SemanticException
	{
		if(tipo1=='s'||tipo2=='s'||Character.isUpperCase(tipo1)||Character.isUpperCase(tipo2))
			throw new SemanticException("Erro Semântico na linha: "+t.beginLine+"\n\t A operação "+oper+" não é permitida para este tipo");
	}
	public static void verificaTipoRelacional(char tipo1,char tipo2,Token t,String oper) throws SemanticException
	{
		if(tipo1=='s'||tipo2=='s'||Character.isUpperCase(tipo1)||Character.isUpperCase(tipo2))
		{
			verificaConcat(tipo1,tipo2,t);
			if(!("==".equals(oper)||"!=".equals(oper)))
				throw new SemanticException("Erro Semântico na linha: "+t.beginLine+"\n\t A operação "+oper+" não é permitida para este tipo");
		}
	}
	public static void verificaTipoAritmetica(char tipo1,char tipo2,Token t) throws SemanticException
	{
		if(tipo1=='s'||tipo2=='s'||Character.isUpperCase(tipo1)||Character.isUpperCase(tipo2))
			throw new SemanticException("Erro Semântico na linha: "+t.beginLine+"\n\t A operação não é permitida para este tipo");
	}
	public static void verificaTipoMod(char tipo1,char tipo2,Token t) throws SemanticException
	{
		verificaTipoAritmetica(tipo1,tipo2,t," 'mod' ");
		if(tipo1=='r'||tipo2=='r')
			throw new SemanticException("Erro Semântico na linha: "+t.beginLine+"\n\t A operação: "+tipo1+"%"+tipo2+" não existe");
	}
	public static void verificaTipoAtrib(char tipo1,char tipo2,Token t) throws SemanticException
	{
		if(tipo1=='r'||tipo2=='r');
			throw new SemanticException("Erro Semântico na linha: "+t.beginLine+"\n\t Este operação não é permitida para este tipo");
	}
	public static String verificaLadoDireito(char tipo1,char tipo2,Token t) throws SemanticException
	{
		String warning="";
		boolean erro=false;
		switch(tipo1)
		{
			case 'r':
				if(tipo2=='s'||Character.isUpperCase(tipo2))
					throw new SemanticException("Erro Semântico na linha: "+t.beginLine+"\n\t Não é possível atribuir String ou Lista a um Real");
				break;
			case 'i':
				if(tipo2=='s'||Character.isUpperCase(tipo2))
					throw new SemanticException("Erro Semântico na linha: "+t.beginLine+"\n\t Não é possível atribuir String ou Lista a um Inteiro");
				if(tipo2=='r')
					warning="Warning: Real será truncado na conversão para Int";
				break;
			case 'c':
				if(tipo2=='s'||Character.isUpperCase(tipo2))
					throw new SemanticException("Erro Semântico na linha: "+t.beginLine+"\n\t Não é possível atribuir String ou Lista a um Caracter");
				if(tipo2=='r'||tipo2=='i')
					warning="Warning: Real e Int nem sempre podem ser convertidos para Char. Real será truncado.";
				break;
			case 's':
				if(tipo2!='s' && tipo2!='C')
					erro=true;
				break;
			case 'C':
				if(tipo2!='s' && tipo2!='C')
					erro=true;
				break;
			case 'R':
				if(tipo2!='I' && tipo2!='C')
					erro=true;
				break;
			case 'I':
				if(tipo2!='R' && tipo2!='C')
					erro=true;
				break;
		}
		if(erro)
			throw new SemanticException("Erro Semântico na linha: "+t.beginLine+"\n\t Tipo não compatível de atribuição: "+tipo1+" <- "+tipo2);
		return warning;
	}
	public static void addItemLista(ArrayDeque<Item> lst,String valor,char tipo)
	{
		Item it=null;
		if('c'==tipo)
			it=new Item(tipo,valor.charAt(1));
		else
		{
			if('i'==tipo)
				it=new Item(tipo,Integer.parseInt(valor));
			else
			{
				if('r'==tipo)
					it=new Item(tipo,Double.parseDouble(valor));
				else
					it=new Item(tipo,valor);
			}
		}
		lst.offerLast(it);
	}
	public static void addItemLista(ArrayDeque<Item> lst,String valor,char tipo,Item.op ops)
	{
		Item it=null;
		if('c'==tipo)
			it=new Item(tipo,valor.charAt(1));
		else
		{
			if('i'==tipo)
				it=new Item(tipo,Integer.parseInt(valor));
			else
			{
				if('r'==tipo)
					it=new Item(tipo,Double.parseDouble(valor));
				else
					it=new Item(tipo,valor,ops);
			}
		}
		lst.offerLast(it);
	}
	public static void addItemLista(ArrayDeque<Item> lst,Object valor,char tipo)
	{
		Item it=new Item(tipo,valor);
		lst.offerLast(it);
	}
	
	public static void addItemLista(ArrayDeque<Item> lst,ArrayDeque<Item> valor,char tipo)
	{
		Item it=null;
		if(valor.size()>1)
			it=new Item(tipo,valor);
		if(valor.size()==1)
			it=new Item(tipo,valor.getFirst());
		lst.offerLast(it);
	}
	public static Item execOper(Item oper,Item var1, Item var2,char tipoA)
	{
		Item res=new Item();
		if(oper.getValor().equals("not"))
			;
		else
		{
			double valor1=0;int valor2=0;String valor3="";
			if(var1.isString() && var2.isString())
			{
				valor3=var1+""+var2;
				res=new Item('s',valor3);
			}else
			{
				if(var1.isList()||var2.isList())
				{
					ArrayDeque<Item> valorlst=new ArrayDeque<Item>();
					valorlst.addAll(var2.getValorList());
					valorlst.addAll(var1.getValorList());
					res=new Item(tipoA,valor3);
				}else
				{
					if(var1.isReal()||var2.isReal()||tipoA=='r')
					{
						valor1=0;
						if(oper.getValor().equals("+"))
							valor1=var1.getValorDouble()+var2.getValorDouble();
						if(oper.getValor().equals("*"))
							valor1=var1.getValorDouble()*var2.getValorDouble();
						if(oper.getValor().equals("/"))
							valor1=var2.getValorDouble()/var1.getValorDouble();
						if(oper.getValor().equals("-"))
							valor1=var2.getValorDouble()-var1.getValorDouble();
						res=new Item('r',valor1);
					}
					else
					{
						if(oper.getValor().equals("+"))
							valor2=var1.getValorInt()+var2.getValorInt();
						if(oper.getValor().equals("*"))
							valor2=var1.getValorInt()*var2.getValorInt();
						if(oper.getValor().equals("/"))
							valor2=var2.getValorInt()/var1.getValorInt();
						if(oper.getValor().equals("-"))
							valor2=var2.getValorInt()-var1.getValorInt();
						if(oper.getValor().equals("%"))
							valor2=var2.getValorInt()%var1.getValorInt();
						res=new Item('i',valor2);
					}
				}
			}
		}
		System.out.println(var2+""+oper+""+var1+" = "+res);
		return res;
	}
	public static int execNot(int v)
	{
		if(v==0)
			return 1;
		return 0;
	}
	public static Item execOper1(Item oper,Item var1, Item var2,char tipoA)
	{
		Item res=new Item();
		int valint=0;
		double valor1=0;String valor3="";
		boolean val1=false;
		ArrayDeque<Item> valorlst=new ArrayDeque<Item>();
		
		switch(oper.oper)
		{
		
			case AND:
				if(var2.getValorInt()==0 || var1.getValorInt()==0)
					valor1=0;
				else
					valor1=1;
				valint=(int)valor1;
				val1=true;
				break;
			case NAND:
				if(var2.getValorInt()==0 || var1.getValorInt()==0)
					valor1=1;
				else
					valor1=0;
				valint=(int)valor1;
				val1=true;
				break;
			case OR:
				if(var2.getValorInt()!=0 || var1.getValorInt()!=0)
					valor1=1;
				else
					valor1=0;
				valint=(int)valor1;
				val1=true;
				break;
			case NOR:
				if(var2.getValorInt()!=0 || var1.getValorInt()!=0)
					valor1=0;
				else
					valor1=1;
				valint=(int)valor1;
				val1=true;
				break;
			case XOR:
				if( (var2.getValorInt()==var1.getValorInt() && var2.getValorInt()==0)
					|| (var2.getValorInt()!=0 && var1.getValorInt()!=0) )
					valor1=0;
				else
					valor1=1;
				valint=(int)valor1;
				val1=true;
				break;
			case GT:
				//System.out.println(var2.getValorInt() +">"+ var1.getValorInt()+"="+(var2.getValorInt() > var1.getValorInt())); 
				if(var2.getValorDouble() > var1.getValorDouble())
					valor1=1;
				else
					valor1=0;
				valint=(int)valor1;
				val1=true;
				break;
			case LS:
				//System.out.println(var2.getValorInt() +"<"+ var1.getValorInt()+"="+(var2.getValorInt() > var1.getValorInt())); 
				if(var2.getValorDouble() < var1.getValorDouble())
					valor1=1;
				else
					valor1=0;
				valint=(int)valor1;
				val1=true;
				break;
			case GTEQ:
				//System.out.println(var2.getValorInt() +">="+ var1.getValorInt()+"="+(var2.getValorInt() > var1.getValorInt())); 
				if(var2.getValorDouble() >= var1.getValorDouble())
					valor1=1;
				else
					valor1=0;
				valint=(int)valor1;
				val1=true;
				break;
			case LSEQ:
				//System.out.println(var2.getValorInt() +"<="+ var1.getValorInt()+"="+(var2.getValorInt() > var1.getValorInt())); 
				if(var2.getValorDouble() <= var1.getValorDouble())
					valor1=1;
				else
					valor1=0;
				valint=(int)valor1;
				val1=true;
				break;
			case EQ:
				//System.out.println(var2.getValorInt() +"=="+ var1.getValorInt()+"="+(var2.getValorInt() > var1.getValorInt())); 
				if(Double.compare(var2.getValorDouble(),var1.getValorDouble())==0)
					valor1=1;
				else
					valor1=0;
				valint=(int)valor1;
				val1=true;
				break;
			case DIFF:
				//System.out.println(var2.getValorInt() +"!="+ var1.getValorInt()+"="+(var2.getValorInt() > var1.getValorInt())); 
				if(Double.compare(var2.getValorDouble(),var1.getValorDouble())!=0)
					valor1=1;
				else
					valor1=0;
				valint=(int)valor1;
				val1=true;
				break;
			case MOD:
				valint=var2.getValorInt()%var1.getValorInt();
				valor1=(double)valint;
			case MULT:
				valor1=var1.getValorDouble()*var2.getValorDouble();
				valint=var1.getValorInt()*var2.getValorInt();
				val1=true;
				break;
			case DIV:
				valor1=var2.getValorDouble()/var1.getValorDouble();
				valint=var2.getValorInt()/var1.getValorInt();
				val1=true;
				break;
			case ADD:
				valor1=var1.getValorDouble()+var2.getValorDouble();
				valint=var1.getValorInt()+var2.getValorInt();
				val1=true;
				break;
			case SUB:
				valor1=var2.getValorDouble()-var1.getValorDouble();
				valint=var2.getValorInt()-var1.getValorInt();
				val1=true;
				break;
			case EXP:
				valor1=Math.pow(var2.getValorDouble(), var1.getValorDouble());
				valint=(int)Math.pow(var2.getValorInt(),var1.getValorInt());
				val1=true;
				break;
			case CONCAT:
				//System.out.println(var2+""+oper+""+var1+" = "+res);
				if(var1.isString() && var2.isString())
				{
					//System.out.println("String Concat");
					valor3=var2.valor+""+var1.valor;
					res=new Item('s',valor3);
					//System.out.println("String Concat: var1 "+var1.valor+" var2 "+var2.valor);
				}else
				{
					if(var1.isList()||var2.isList())
					{
						valorlst.addAll(var2.getValorList());
						valorlst.addAll(var1.getValorList());
						res=new Item(tipoA,valorlst);
					}
				}
				break;
		}
		if(val1)
		{
			if(var1.isReal()||var2.isReal())
				tipoA='r';
			else
			{
				if(var1.isInt() && var2.isInt())
					tipoA='i';
			}
			
			res=new Item(tipoA,valor1);
			res.valorint=valint;
		}
		
		System.out.println(var2+" "+oper.oper+" "+var1+" = "+res);
		return res;
	}
	public static int otimizaExp(ArrayDeque<Item> lst,char tipoA)
	{
		ArrayDeque<Item> stk=new ArrayDeque<Item>();
		Item it1,it2,it3;
		boolean cont=true;
		
		while(cont)
		{
			it1=lst.pollFirst();
			//System.out.println("lst = "+lst);
			try{
				if(it1.isOper())
				{
					System.out.println(it1+" "+it1.oper);
					it2=stk.pollLast();
					switch(it1.oper)
					{
						case DOLLAR:
							it2.tipo='s';
							stk.offerLast(it2);
							break;
						case ARROBA:
							it2.valordouble=Double.parseDouble(it2.valor);
							it2.tipo='r';
							stk.offerLast(it2);
							break;
						default:
							it3=stk.pollLast();
							stk.offerLast(execOper1(it1,it2,it3,tipoA));
							break;
					}
				}else
				{
					//System.out.println("nop: "+ it1);
					if(it1.isVar())
						cont=false;
					stk.offerLast(it1);
				}
				it1=null;
			}catch(Exception E)
			{
				cont=false;
			}
		}
		
		stk.addAll(lst);
		lst.clear();
		lst.addAll(stk);
		
		return 1;
	}
	public static void addCmdAtrib(LinkedList<Comando> cmdlst, String var, ArrayDeque<Item> value)
	{
		Comando cmd=new Comando(var,value);
		cmdlst.add(cmd);
	}
	public static void addCmdLoop(LinkedList<Comando> cmdlst, ArrayDeque<Item> expr, LinkedList<Comando> corpo,Comando.comtype tipo)
	{
		ComandoCorpo cmd=new ComandoCorpo(tipo,expr,corpo);
		cmdlst.add(cmd);
	}
	public static void addCmdIf(LinkedList<Comando> cmdlst, ArrayDeque<Item> expr, LinkedList<Comando> corpo)
	{
		ComandoIF cmd=new ComandoIF(expr,corpo);
		cmdlst.add(cmd);
	}
	public static void addCmdIfElse(LinkedList<Comando> cmdlst, ArrayDeque<Item> expr, LinkedList<Comando> corpo, LinkedList<Comando> corpo2)
	{
		ComandoIF cmd=new ComandoIF(expr,corpo,corpo2);
		cmdlst.add(cmd);
	}
	public static int tamanhoMaxPilha(ArrayDeque<Item> expr, int tamAnt)
	{
		int t=0,t2=0;
		int nant=0;
		ArrayList<Item> al;
		
		//Collections.reverse(al=new ArrayList<Item>(expr));
		//System.out.println("rev = "+al);
		//System.out.print("[ ");
		for(Item i: expr )
		{
			//System.out.print(i);
			if(i.isOper())
			{
				
				
				switch(i.oper)
				{
					case ARROBA:
						t2=2;
						break;
					case DOLLAR:
						t2=3;
						break;
					case EXP:
						t2=1;
						break;
					case CONCAT:
						t2=6;
						break;
					default:
						t2=0;
						break;
				}
				if((t+t2)>tamAnt)
					tamAnt=t+t2;
				t-=2;
			}else
			{
				t+=2;
			}
			if(t>tamAnt)
				tamAnt=t;
			//System.out.print(" ");
		}
		
		if(t>tamAnt)
			tamAnt=t;
		//System.out.print("] ");
		System.out.println("tamStack= "+tamAnt+"\n");
		return tamAnt;
	}
}
