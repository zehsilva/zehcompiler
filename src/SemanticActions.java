import java.util.*;
public class SemanticActions {

	
	public static void testaVar(HashMap<String,Simbolo> tab,Token t) throws SemanticException
	{
		if(!tab.containsKey(t.image))
			throw new SemanticException("Erro Semântico na linha: "+t.beginLine+"\n\t Variável '"+t.image+"' não declarada ");
	}
	public static void testaVarDcl(HashMap<String,Simbolo> tab,Token t) throws SemanticException
	{
		if(tab.containsKey(t.image))
			throw new SemanticException("Erro Semântico na linha: "+t.beginLine+"\n\t Variável '"+t.image+"' já foi declarada uma vez");
	}
	public static void verificaTipoIncr(char tipo1,char tipo2,Token t) throws SemanticException
	{
		if(tipo1=='s')
			throw new SemanticException("Erro Semântico na linha: "+t.beginLine+"\n\t Tipo errado na construção To ... Step ...");
	}
	public static void verificaTipoLista(char tipo1,char tipo2,Token t) throws SemanticException
	{
		if(tipo1!=tipo2)
			throw new SemanticException("Erro Semântico na linha: "+t.beginLine+"\n\t Lista deve ser homogênea");
	}
	public static void verificaString(char tipo1,Token t) throws SemanticException
	{
		
		if(tipo1!='s' && Character.isLowerCase(tipo1))
			throw new SemanticException("Erro Semântico na linha: "+t.beginLine+"\n\t Este operação só deve ser para String ou Lista");
	}
	public static void verificaTipoAritmetica(char tipo1,char tipo2,Token t,String oper) throws SemanticException
	{
		if(tipo1=='s'||tipo2=='s'||Character.isUpperCase(tipo1)||Character.isUpperCase(tipo2))
			throw new SemanticException("Erro Semântico na linha: "+t.beginLine+"\n\t A operação "+oper+" não é permitida para este tipo");
	}
	public static void verificaTipoAritmetica(char tipo1,char tipo2,Token t) throws SemanticException
	{
		if(tipo1=='s'||tipo2=='s'||Character.isUpperCase(tipo1)||Character.isUpperCase(tipo2))
			throw new SemanticException("Erro Semântico na linha: "+t.beginLine+"\n\t A operação não é permitida para este tipo");
	}
	public static void verificaTipoMod(char tipo1,char tipo2,Token t) throws SemanticException
	{
		verificaTipoAritmetica(tipo1,tipo2,t," 'mod' ");
		if(tipo1=='r'||tipo2=='r');
		throw new SemanticException("Erro Semântico na linha: "+t.beginLine+"\n\t Este operação não é permitida para este tipo");
	}
}
