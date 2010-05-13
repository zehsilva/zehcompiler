import java.util.*;
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
}
