import java.io.*;
import java.util.*;


public class CodigoDestino {
	public static LinkedList<Comando> corpo;
	public static HashMap<String,Simbolo>tabela;
	public static String arq;
	
	public CodigoDestino(String nomearq, LinkedList<Comando> corpo1,HashMap<String,Simbolo>tab )
	{
		arq=nomearq;
		corpo=corpo1;
		tabela=tab;
	}
	public static int limLocal()
	{
		int n=1+((Simbolo)(tabela.values().toArray())[0]).referencia;
		return n;
	}
	
	public static void geraCod()
	{
		 BufferedWriter arqSaida; 
         try { 
               arqSaida = new BufferedWriter(new FileWriter(arq+".j")); 
               arqSaida.write(".source "+arq+".java\r\n"); 
               arqSaida.write(".class public "+arq+"\r\n"); 
               arqSaida.write(".super java/lang/Object\r\n"); 
               arqSaida.write(".method public <init>()V\r\n");  
               arqSaida.write(".limit stack 1\r\n"); 
               arqSaida.write(".limit locals 1\r\n"); 
               arqSaida.write("aload_0\r\n"); 
               arqSaida.write("invokespecial java/lang/Object/<init>()V\r\n"); 
               arqSaida.write("return\r\n"); 
               arqSaida.write(".end method\r\n"); 
               arqSaida.write(".method public static main([Ljava/lang/String;)V\r\n");  
               arqSaida.write(".limit stack "+ZelParser.stackLen+"\r\n");    
               arqSaida.write(".limit locals "+limLocal()+"\r\n"); // máximo de variáveis locais (deve ser calculado) 
               processaCorpo(arqSaida);
               arqSaida.write("return\r\n"); 
               arqSaida.write(".end method\r\n"); 
               arqSaida.close(); 
         } 
         catch(IOException e) { 
               System.out.println("Problemas no arquivo 'prog_destino.j'"); 
         } 
         catch(Exception e) { 
               System.out.println(e.getMessage()); 
         }
	}
	public static void geraExpr(ArrayDeque<Item> expr,BufferedWriter arqSaida) throws IOException
	{
		for(Item x:expr)
		{
			switch(x.tipo)
			{
				case 'i':
					//arqSaida.write("ldc "+x.getValorInt()+"\r\n");
					arqSaida.write("ldc2_w "+((double)x.getValorInt())+" \r\n");
					break;
				case 'r':
					arqSaida.write("ldc2_w "+x.getValorDouble()+" \r\n");
					break;
				case 'o':
					switch(x.oper)
					{
						case ADD:
							arqSaida.write("dadd \r\n");
							break;
						case SUB:
							arqSaida.write("dsub \r\n");
							break;
						case MULT:
							arqSaida.write("dmult \r\n");
							break;
						case DIV:
							arqSaida.write("ddiv \r\n");
							break;
					}
					break;
				case 'v':
					String var=x.valor;
					Simbolo vart=tabela.get(var);
					int ref= vart.getReferencia();
					if(ref<=3)
						arqSaida.write("dload_"+ref+" \r\n");
					else
						arqSaida.write("dload "+ref+" \r\n");
					break;
			}
		}
	}
	public static void processaCorpo(BufferedWriter arqSaida) throws IOException
	{
		//String strcorpo="";
		for(Comando c: corpo)
		{
			switch(c.comando)
			{
				case ATRIB:
					String var=c.str;
					Simbolo vart=tabela.get(var);
					int ref= vart.getReferencia();
					geraExpr(c.expr1,arqSaida);
					arqSaida.write("dstore_"+ref+" \r\n");		
			}
		}
	}
}
