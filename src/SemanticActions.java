import java.util.*;
public class SemanticActions {

	
	public static void testaVar(HashMap<String,Simbolo> tab,Token t) throws SemanticException
	{
		if(!tab.containsKey(t.image))
			throw new SemanticException("Erro Sem�ntico na linha: "+t.beginLine+"\n\t Vari�vel '"+t.image+"' n�o declarada ");
	}
	public static void testaVarDcl(HashMap<String,Simbolo> tab,Token t) throws SemanticException
	{
		if(tab.containsKey(t.image))
			throw new SemanticException("Erro Sem�ntico na linha: "+t.beginLine+"\n\t Vari�vel '"+t.image+"' j� foi declarada uma vez");
	}
	public static void verificaTipoIncr(char tipo1,char tipo2,Token t) throws SemanticException
	{
		if(tipo1=='s')
			throw new SemanticException("Erro Sem�ntico na linha: "+t.beginLine+"\n\t Tipo errado na constru��o To ... Step ...");
	}
	public static void verificaTipoLista(char tipo1,char tipo2,Token t) throws SemanticException
	{
		if(tipo1!=tipo2)
			throw new SemanticException("Erro Sem�ntico na linha: "+t.beginLine+"\n\t Lista deve ser homog�nea");
	}
	public static void verificaString(char tipo1,Token t) throws SemanticException
	{
		
		if(tipo1!='s' && Character.isLowerCase(tipo1))
			throw new SemanticException("Erro Sem�ntico na linha: "+t.beginLine+"\n\t Este opera��o s� deve ser para String ou Lista");
	}
	public static void verificaTipoAritmetica(char tipo1,char tipo2,Token t,String oper) throws SemanticException
	{
		if(tipo1=='s'||tipo2=='s'||Character.isUpperCase(tipo1)||Character.isUpperCase(tipo2))
			throw new SemanticException("Erro Sem�ntico na linha: "+t.beginLine+"\n\t A opera��o "+oper+" n�o � permitida para este tipo");
	}
	public static void verificaTipoAritmetica(char tipo1,char tipo2,Token t) throws SemanticException
	{
		if(tipo1=='s'||tipo2=='s'||Character.isUpperCase(tipo1)||Character.isUpperCase(tipo2))
			throw new SemanticException("Erro Sem�ntico na linha: "+t.beginLine+"\n\t A opera��o n�o � permitida para este tipo");
	}
	public static void verificaTipoMod(char tipo1,char tipo2,Token t) throws SemanticException
	{
		verificaTipoAritmetica(tipo1,tipo2,t," 'mod' ");
		if(tipo1=='r'||tipo2=='r');
		throw new SemanticException("Erro Sem�ntico na linha: "+t.beginLine+"\n\t Este opera��o n�o � permitida para este tipo");
	}
}
