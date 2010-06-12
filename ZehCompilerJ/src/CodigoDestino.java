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
		//System.out.println(Simbolo.ultimo);
	}
	public static int limLocal()
	{
		int n=Simbolo.ultimo;
		return n;
	}
	
	public static void geraCod()
	{
		 BufferedWriter arqSaida; 
         try { 
               arqSaida = new BufferedWriter(new FileWriter(arq+".j")); 
               //arq.indexOf(".");
               System.out.println(arq);
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
               System.out.println("Problemas no arquivo '"+arq+".j'"); 
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
							arqSaida.write("dmul \r\n");
							break;
						case DIV:
							arqSaida.write("ddiv \r\n");
							break;
						case EXP:
							arqSaida.write("invokestatic java/lang/Math/pow(DD)D \r\n");
							break;
						case CONCAT:
							arqSaida.write("swap \r\n");
							arqSaida.write("new java/lang/StringBuilder \r\n");
							arqSaida.write("dup  \r\n");
							arqSaida.write("invokespecial java/lang/StringBuilder/<init>()V \r\n");
							arqSaida.write("swap \r\n");
							arqSaida.write("invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder; \r\n");
							arqSaida.write("swap \r\n");
							arqSaida.write("invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder; \r\n");
							arqSaida.write("invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;\r\n"); 
							break;
							
					}
					break;
				case 'v':
					String var=x.valor;
					Simbolo vart=tabela.get(var);
					String pref="";
					int ref= vart.getReferencia();
					if(vart.tipo=='i'||vart.tipo=='r'||vart.tipo=='n')
						pref="d";
					if(vart.tipo=='s')
						pref="a";
					if(ref<=3)
						arqSaida.write(pref+"load_"+ref+" \r\n");
					else
						arqSaida.write(pref+"load "+ref+" \r\n");
					break;
				case 's':
					arqSaida.write("ldc \""+x.getValor()+"\" \r\n");
					break;
					
			}
		}
	}
	public static void geraEntrada(ComandoEntrada c,BufferedWriter arqSaida) throws IOException
	{
		for(String v:c.listaVar)
		{
			int ref=tabela.get(v).getReferencia();
			String pref="";
			switch(tabela.get(v).tipo)
			{
				case 'r':
					arqSaida.write("invokevirtual java/util/Scanner/nextDouble()D  \r\n");
					pref="d";
					break;
				case 'i':
					arqSaida.write("invokevirtual java/util/Scanner/nextInt()I  \r\n");
					pref="i";
					break;
				case 's':
					arqSaida.write("invokevirtual java/util/Scanner/nextLine()Ljava/lang/String; \r\n");
					pref="a";
					break;
			}
			if(ref<=3)
				arqSaida.write(pref+"store_"+ref+" \r\n");
			else
				arqSaida.write(pref+"store "+ref+" \r\n");
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
					String pref="";
					int ref= vart.getReferencia();
					geraExpr(c.expr1,arqSaida);
					if(vart.tipo=='i'||vart.tipo=='r'||vart.tipo=='n')
						pref="d";
					if(vart.tipo=='s')
						pref="a";
					if(ref<=3)
						arqSaida.write(pref+"store_"+ref+" \r\n");
					else
						arqSaida.write(pref+"store "+ref+" \r\n");
					break;
				case PRINT:
					c=(ComandoSaida)c;
					arqSaida.write("getstatic java/lang/System/out Ljava/io/PrintStream; \r\n");
					geraExpr(c.expr1,arqSaida);
					if(c.tipoExpr1=='n'||c.tipoExpr1=='r'||c.tipoExpr1=='i')
						arqSaida.write("invokevirtual java/io/PrintStream/println(D)V \r\n");
					if(c.tipoExpr1=='s')
						arqSaida.write("invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V \r\n");
					break;
				case ENTRADA:
					ComandoEntrada ce=(ComandoEntrada)c;
					
					arqSaida.write("new java/util/Scanner \r\n");
					arqSaida.write("dup  \r\n");
					arqSaida.write("getstatic java/lang/System/in Ljava/io/InputStream;  \r\n");
					arqSaida.write("invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V \r\n");
					for(String s:ce.listaVar)
						arqSaida.write("dup  \r\n");
					geraEntrada(ce,arqSaida);
					break;
			}
		}
	}
}
