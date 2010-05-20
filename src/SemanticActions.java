import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.HashMap;
public class SemanticActions {
	
	
	public static char testaVar(HashMap<String,Simbolo> tab,Token t) throws SemanticException
	{
		Simbolo s=null;
		if(!tab.containsKey(t.image))
			throw new SemanticException("Erro Sem�ntico na linha: "+t.beginLine+"\n\t Vari�vel '"+t.image+"' n�o declarada ");
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
			throw new SemanticException("Erro Sem�ntico na linha: "+t.beginLine+"\n\t Vari�vel '"+t.image+"' n�o declarada ");
		else
		{
			s=tab.get(t.image);
			if(!s.isInicializada())
				throw new SemanticException("Erro Sem�ntico na linha: "+t.beginLine+"\n\t Vari�vel '"+t.image+"' n�o inicializada ");
		}
		return s.getTipo();
	}
	public static void testaVarDcl(HashMap<String,Simbolo> tab,Token t) throws SemanticException
	{
		if(tab.containsKey(t.image))
			throw new SemanticException("Erro Sem�ntico na linha: "+t.beginLine+"\n\t Vari�vel '"+t.image+"' j� foi declarada uma vez");
		else
			Simbolo.incInit();
	}
	public static void verificaTipoIncr(char tipo1,char tipo2,Token t) throws SemanticException
	{
		if(tipo1=='s'||tipo2=='s')
			throw new SemanticException("Erro Sem�ntico na linha: "+t.beginLine+"\n\t Tipo errado na constru��o To ... Step ...");
	}
	public static void verificaTipoLista(char tipo1,char tipo2,Token t) throws SemanticException
	{
		if(tipo1!=tipo2)
			throw new SemanticException("Erro Sem�ntico na linha: "+t.beginLine+"\n\t Lista deve ser homog�nea");
	}
	public static void verificaInList(char tipo1,char tipo2,Token t) throws SemanticException
	{
		if(Character.isLowerCase(tipo2) || (Character.toLowerCase(tipo2)!=tipo1))
			throw new SemanticException("Erro Sem�ntico na linha: "+t.beginLine+"\n\t O teste de pertin�ncia s� serve para elementos do mesmo tipo");
	}
	public static void verificaString(char tipo1,Token t) throws SemanticException
	{
		if(tipo1!='s' && Character.isLowerCase(tipo1))
			throw new SemanticException("Erro Sem�ntico na linha: "+t.beginLine+"\n\t Este opera��o s� deve ser para String ou Lista");
	}
	public static void verificaString(char tipo1,char tipo2, Token t) throws SemanticException
	{
		if((tipo1!='s' && Character.isLowerCase(tipo1))||(tipo2!='s' && Character.isLowerCase(tipo2)))
			throw new SemanticException("Erro Sem�ntico na linha: "+t.beginLine+"\n\t Este opera��o s� deve ser para String ou Lista");
	}
	public static void verificaConcat(char tipo1,char tipo2, Token t) throws SemanticException
	{
		verificaString(tipo1,tipo2,t);
		if(tipo1!=tipo2)
		{
			if((tipo1!='s'||tipo2!='C') && (tipo1 !='C' || tipo2!='s'))//string e lista de caracteres podem ser concatenadas
				throw new SemanticException("Erro Sem�ntico na linha: "+t.beginLine+"\n\t A opera��o '.' s� pode ser executada usando operandos do mesmo tipo");
		}
	}
	public static void verificaTipoAritmetica(char tipo1,char tipo2,Token t,String oper) throws SemanticException
	{
		if(tipo1=='s'||tipo2=='s'||Character.isUpperCase(tipo1)||Character.isUpperCase(tipo2))
			throw new SemanticException("Erro Sem�ntico na linha: "+t.beginLine+"\n\t A opera��o "+oper+" n�o � permitida para este tipo");
	}
	public static void verificaTipoRelacional(char tipo1,char tipo2,Token t,String oper) throws SemanticException
	{
		if(tipo1=='s'||tipo2=='s'||Character.isUpperCase(tipo1)||Character.isUpperCase(tipo2))
		{
			verificaConcat(tipo1,tipo2,t);
			if(!("==".equals(oper)||"!=".equals(oper)))
				throw new SemanticException("Erro Sem�ntico na linha: "+t.beginLine+"\n\t A opera��o "+oper+" n�o � permitida para este tipo");
		}
	}
	public static void verificaTipoAritmetica(char tipo1,char tipo2,Token t) throws SemanticException
	{
		if(tipo1=='s'||tipo2=='s'||Character.isUpperCase(tipo1)||Character.isUpperCase(tipo2))
			throw new SemanticException("Erro Sem�ntico na linha: "+t.beginLine+"\n\t A opera��o n�o � permitida para este tipo");
	}
	public static void verificaTipoMod(char tipo1,char tipo2,Token t) throws SemanticException
	{
		verificaTipoAritmetica(tipo1,tipo2,t," 'mod' ");
		if(tipo1=='r'||tipo2=='r')
			throw new SemanticException("Erro Sem�ntico na linha: "+t.beginLine+"\n\t A opera��o: "+tipo1+"%"+tipo2+" n�o existe");
	}
	public static void verificaTipoAtrib(char tipo1,char tipo2,Token t) throws SemanticException
	{
		if(tipo1=='r'||tipo2=='r');
			throw new SemanticException("Erro Sem�ntico na linha: "+t.beginLine+"\n\t Este opera��o n�o � permitida para este tipo");
	}
	public static String verificaLadoDireito(char tipo1,char tipo2,Token t) throws SemanticException
	{
		String warning="";
		boolean erro=false;
		switch(tipo1)
		{
			case 'r':
				if(tipo2=='s'||Character.isUpperCase(tipo2))
					throw new SemanticException("Erro Sem�ntico na linha: "+t.beginLine+"\n\t N�o � poss�vel atribuir String ou Lista a um Real");
				break;
			case 'i':
				if(tipo2=='s'||Character.isUpperCase(tipo2))
					throw new SemanticException("Erro Sem�ntico na linha: "+t.beginLine+"\n\t N�o � poss�vel atribuir String ou Lista a um Inteiro");
				if(tipo2=='r')
					warning="Warning: Real ser� truncado na convers�o para Int";
				break;
			case 'c':
				if(tipo2=='s'||Character.isUpperCase(tipo2))
					throw new SemanticException("Erro Sem�ntico na linha: "+t.beginLine+"\n\t N�o � poss�vel atribuir String ou Lista a um Caracter");
				if(tipo2=='r'||tipo2=='i')
					warning="Warning: Real e Int nem sempre podem ser convertidos para Char. Real ser� truncado.";
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
			throw new SemanticException("Erro Sem�ntico na linha: "+t.beginLine+"\n\t Tipo n�o compat�vel de atribui��o: "+tipo1+" <- "+tipo2);
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
		lst.offerFirst(it);
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
		lst.offerFirst(it);
	}
	public static void addItemLista(ArrayDeque<Item> lst,Object valor,char tipo)
	{
		Item it=new Item(tipo,valor);
		lst.offerFirst(it);
	}
	
	public static void addItemLista(ArrayDeque<Item> lst,ArrayDeque<Item> valor,char tipo)
	{
		Item it=new Item(tipo,valor);
		lst.offerFirst(it);
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
	public static Item execOper2(Item oper,Item var1, Item var2,char tipoA)
	{
		Item res=new Item();
		double valor1=0;int valor2=0;String valor3="";
		ArrayDeque<Item> valorlst=new ArrayDeque<Item>();
		
		switch(oper.oper)
		{
			case MULT:
				valor1=var1.getValorDouble()*var2.getValorDouble();
				break;
			case DIV:
				valor1=var2.getValorDouble()/var1.getValorDouble();
				break;
			case ADD:
				valor1=var1.getValorDouble()+var2.getValorDouble();
				break;
			case SUB:
				valor1=var2.getValorDouble()-var1.getValorDouble();
				break;
			case CONCAT:
				if(var1.isString() && var2.isString())
				{
					valor3=var1+""+var2;
					res=new Item('s',valor3);
				}else
				{
					if(var1.isList()||var2.isList())
					{
						
						valorlst.addAll(var2.getValorList());
						valorlst.addAll(var1.getValorList());
						res=new Item(tipoA,valor3);
					}
				}
				break;
		}
		System.out.println(var2+""+oper+""+var1+" = "+res);
		return res;
	}
	public static ArrayDeque<Item> otimizaExp(ArrayDeque<Item> lst,char tipoA)
	{
		ArrayDeque<Item> stk=new ArrayDeque<Item>();
		Item it1,it2,it3;
		boolean cont=true;
		
		while(cont)
		{
			it1=lst.pollLast();
			try{
				if(it1.isOper())
				{
					System.out.println(it1);
					it2=stk.pollFirst();
					it3=stk.pollFirst();
					stk.offerFirst(execOper(it1,it2,it3,tipoA));
				}else
				{
					if(it1.isVar())
						cont=false;
					else
						stk.offerFirst(it1);
				}
			}catch(Exception E)
			{
				cont=false;
			}
		}
		lst.addAll(stk);
		return lst;
	}
}
