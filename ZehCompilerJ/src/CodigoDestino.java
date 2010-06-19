import java.io.*;
import java.util.*;


public class CodigoDestino {
	public static LinkedList<Comando> corpo;
	public static HashMap<String,Simbolo>tabela;
	public static String arq;
	static int label=0;
	
	public CodigoDestino(String nomearq, LinkedList<Comando> corpo1,HashMap<String,Simbolo>tab )
	{
		arq=nomearq;
		corpo=corpo1;
		tabela=tab;
		label=0;
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
               arqSaida.write(".limit stack "+(ZelParser.stackLen+10)+"\r\n");    
               arqSaida.write(".limit locals "+(limLocal()+1)+"\r\n"); // máximo de variáveis locais (deve ser calculado) 
               processaCorpo(arqSaida);
               arqSaida.write("return\r\n"); 
               arqSaida.write(".end method\r\n"); 
               arqSaida.close(); 
         } 
         catch(IOException e) { 
               System.out.println("Problemas no arquivo '"+arq+".j'"); 
         } 
         catch(Exception e) { 
             e.printStackTrace();
        	 
         }
	}
	public static void dswap(BufferedWriter arqSaida)throws IOException
	//faz um swap de doubles no topo da pilha 
	{
		arqSaida.write("dup2_x2 \r\n");
		arqSaida.write("pop2  \r\n");
	}
	public static void not_bit(BufferedWriter arqSaida)throws IOException
	//um not que funciona legal para 0 e 1 (inteiros), converte 0 em 1 e 1 em 0
	{
		arqSaida.write("ldc 1 \r\n");
		arqSaida.write("ixor  \r\n");
	}
	public static void icmp(BufferedWriter arqSaida)throws IOException
	{
		//compara dois inteiroes que estejam na pilha
		//se forem iguais deixa 1 na pilha, se forem diferentes deixa 0
		arqSaida.write("isub  \r\n");
		arqSaida.write("ifne LABIF"+label+"  \r\n");
		arqSaida.write("ldc 1 \r\n");
		arqSaida.write("goto LABIF"+(label+1)+" \r\n");
		arqSaida.write("LABIF"+label+": \n\r" );
		arqSaida.write("ldc 0 \r\n");
		arqSaida.write("LABIF"+(label+1)+": \n\r");
		label+=2;
	}
	public static void and(BufferedWriter arqSaida)throws IOException
	//faz and com short-circuiting de dois inteiros
	{
		arqSaida.write("ifeq AND"+label+"  \r\n");
		arqSaida.write("goto AND"+(label+1)+" \r\n");
		arqSaida.write("AND"+label+":  \r\n");
		arqSaida.write("pop \r\n");
		arqSaida.write("ldc 0 \r\n");
		arqSaida.write("AND"+(label+1)+": \r\n");
		label+=2;
	}
	public static void or(BufferedWriter arqSaida)throws IOException
	//faz or com short-circuiting de dois inteiros
	{
		arqSaida.write("ifne OR"+label+"  \r\n");
		arqSaida.write("goto OR"+(label+1)+" \r\n");
		arqSaida.write("OR"+label+":  \r\n");
		arqSaida.write("pop \r\n");
		arqSaida.write("ldc 1 \r\n");
		arqSaida.write("OR"+(label+1)+": \r\n");
		label+=2;
	}
	public static void not(BufferedWriter arqSaida)throws IOException
	//faz not
	{
		arqSaida.write("ifeq NOT"+label+"  \r\n");
		arqSaida.write("ldc 0 \r\n");
		arqSaida.write("goto NOT"+(label+1)+" \r\n");
		arqSaida.write("NOT"+label+":  \r\n");
		arqSaida.write("ldc 1 \r\n");
		arqSaida.write("NOT"+(label+1)+": \r\n");
		label+=2;
	}
	public static void converteTipo(char tipo1, char tipoCast,BufferedWriter arqSaida) throws IOException
	{
		System.out.println("Converting "+tipo1+" to "+tipoCast);
		if(tipo1=='n')
			tipo1='r';
		if(tipo1=='r' && tipoCast=='i')
		{
			arqSaida.write("d2i \r\n");
		}
		if(tipo1=='i' && tipoCast=='r')
		{
			arqSaida.write("i2d \r\n");
		}
	}
	public static void converteTipo(char tipo1,char tipo2, char tipoCast,BufferedWriter arqSaida) throws IOException
	{
		System.out.println("Converting tipo1="+tipo1+",tipo2="+tipo2+" to "+tipoCast);
		if(tipo1=='n')
			tipo1='r';
		if(tipo2=='n')
			tipo2='r';
		if(tipo1=='r' && tipo2=='i' && tipoCast=='r')
		{
			arqSaida.write("dup2_x1 \r\n");
			arqSaida.write("pop2 \r\n");
			arqSaida.write("i2d \r\n");
			dswap(arqSaida);
		}
		if(tipo1=='r' && tipo2=='i' && tipoCast=='i')
		{
			arqSaida.write("d2i \r\n");
		}
		if(tipo1=='i' && tipo2=='r' && tipoCast=='i')
		{
			arqSaida.write("dup_x2 \r\n");
			arqSaida.write("pop \r\n");
			arqSaida.write("d2i \r\n");
			arqSaida.write("swap \r\n");
		}
		if(tipo1=='i' && tipo2=='r' && tipoCast=='r')
		{
			arqSaida.write("i2d \r\n");
		}
		if(tipo1=='i' && tipo2=='i' && tipoCast=='r')
		{
			arqSaida.write("i2d \r\n");
			converteTipo('r','i','r',arqSaida);
		}
		if(tipo1=='r' && tipo2=='r' && tipoCast=='i')
		{
			arqSaida.write("d2i \r\n");
			converteTipo('i','r','i',arqSaida);
		}
	}
	public static char geraExpr(Comando c,BufferedWriter arqSaida) throws IOException
	{
		char tipoant1,tipoant2;
		tipoant1='_';
		tipoant2=tipoant1;
		ArrayDeque<Character> tipos=new ArrayDeque<Character>();

		for(Item x:c.expr1)
		{
			tipoant2=tipoant1;
			System.out.println("Tipos: "+tipos);
			switch(x.tipo)
			{
				case 'i':
					arqSaida.write("ldc "+x.getValorInt()+"\r\n");
					System.out.println("ldc "+x.getValorInt()+"\r\n");
					//arqSaida.write("ldc2_w "+((double)x.getValorInt())+" \r\n");
					
					tipos.offerLast('i');
					tipoant1='i';
					break;
				case 'r':
					arqSaida.write("ldc2_w "+x.getValorDouble()+" \r\n");
					
					tipos.offerLast('r');
					tipoant1='r';
					break;
				case 'o':
					switch(x.oper)
					{
						case GT:
							break;
						case EQ:
							tipoant1=tipos.pollLast();
							tipoant2=tipos.pollLast();
							if(tipoant1==tipoant2 && tipoant2=='r')
							{
								arqSaida.write("dcmpg \r\n");
								arqSaida.write("ldc 0 \r\n");
							}
							else
							{
								if(tipoant1!=tipoant2)
								{				
									converteTipo(tipoant1,tipoant2,'r',arqSaida);
									arqSaida.write("dcmpg \r\n");
									arqSaida.write("ldc 0 \r\n");
								}
							}
							/*arqSaida.write("isub  \r\n");
							arqSaida.write("ifne LABIF"+label+"  \r\n");
							arqSaida.write("ldc 1 \r\n");
							arqSaida.write("goto LABIF"+(label+1)+" \r\n");
							arqSaida.write("LABIF"+label+": \n\r" );
							arqSaida.write("ldc 0 \r\n");
							arqSaida.write("LABIF"+(label+1)+": \n\r");
							label+=2;*/
							icmp(arqSaida);
							tipos.offerLast('i');
							break;
						case AND:
							tipoant1=tipos.pollLast();
							tipoant2=tipos.pollLast();
							arqSaida.write(";;tipo1="+tipoant1+" tipo2="+tipoant2+" \r\n");
							if(tipoant1=='r' || tipoant2=='r'||tipoant1=='n'||tipoant2=='n')
								converteTipo(tipoant1,tipoant2,'i',arqSaida);
							and(arqSaida);
							tipoant1='i';
							tipos.offerLast('i');
							System.out.println("2Tipos: "+tipos);
							break;
						case OR:
							tipoant1=tipos.pollLast();
							tipoant2=tipos.pollLast();
							if(tipoant1=='r' || tipoant2=='r'||tipoant1=='n'||tipoant2=='n')
								converteTipo(tipoant1,tipoant2,'i',arqSaida);
							or(arqSaida);
							tipos.offerLast('i');
							break;
						case NAND:
							tipoant1=tipos.pollLast();
							tipoant2=tipos.pollLast();
							if(tipoant1=='r' || tipoant2=='r'||tipoant1=='n'||tipoant2=='n')
								converteTipo(tipoant1,tipoant2,'i',arqSaida);
							and(arqSaida);
							not(arqSaida);
							tipos.offerLast('i');
							break;
						case NOR:
							tipoant1=tipos.pollLast();
							tipoant2=tipos.pollLast();
							if(tipoant1=='r' || tipoant2=='r'||tipoant1=='n'||tipoant2=='n')
								converteTipo(tipoant1,tipoant2,'i',arqSaida);
							or(arqSaida);
							not(arqSaida);
							tipos.offerLast('i');
							break;
						case XOR:
							tipoant1=tipos.pollLast();
							tipoant2=tipos.pollLast();
							if(tipoant1=='r' || tipoant2=='r'||tipoant1=='n'||tipoant2=='n')
								converteTipo(tipoant1,tipoant2,'i',arqSaida);
							or(arqSaida);
							not(arqSaida);
							tipos.offerLast('i');
							break;
						case ADD:
							tipoant1=tipos.pollLast();
							tipoant2=tipos.pollLast();
							if(tipoant1=='r' || tipoant2=='r'||tipoant1=='n'||tipoant2=='n')
							{
								//arqSaida.write(";;tipo1="+tipoant1+" tipo2="+tipoant2+" \r\n");
								converteTipo(tipoant1,tipoant2,'r',arqSaida);
								arqSaida.write("dadd \r\n");
								System.out.println("dadd \r\n");
								tipos.offerLast('r');
							}else
							{
								arqSaida.write("iadd \r\n");
								System.out.println("iadd \r\n");
								tipos.offerLast('i');
							}
							break;
						case SUB:
							tipoant1=tipos.pollLast();
							tipoant2=tipos.pollLast();
							if(tipoant1=='r' || tipoant2=='r'||tipoant1=='n'||tipoant2=='n')
							{
								converteTipo(tipoant1,tipoant2,'r',arqSaida);
								arqSaida.write("dsub \r\n");
								tipos.offerLast('r');
							}else
							{
								arqSaida.write("isub \r\n");
								tipos.offerLast('i');
							}
							break;
						case MULT:
							tipoant1=tipos.pollLast();
							tipoant2=tipos.pollLast();
							if(tipoant1=='r' || tipoant2=='r'||tipoant1=='n'||tipoant2=='n')
							{
								converteTipo(tipoant1,tipoant2,'r',arqSaida);
								arqSaida.write("dmul \r\n");
								tipos.offerLast('r');
							}else
							{
								arqSaida.write("imul \r\n");
								tipos.offerLast('i');
							}
							break;
						case DIV:
							tipoant1=tipos.pollLast();
							tipoant2=tipos.pollLast();
							if(tipoant1=='r' || tipoant2=='r'||tipoant1=='n'||tipoant2=='n')
							{
								converteTipo(tipoant1,tipoant2,'r',arqSaida);
								arqSaida.write("ddiv \r\n");
								tipos.offerLast('r');
							}else
							{
								arqSaida.write("idiv \r\n");
								tipos.offerLast('i');
							}
							break;
						case EXP:
							if(tipoant1=='i' || tipoant2=='i')
								converteTipo(tipoant1,tipoant2,'r',arqSaida);
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
						case ARROBA:
							arqSaida.write("invokestatic java/lang/Double/parseDouble(Ljava/lang/String;)D \r\n");
							tipoant1='r';
							break;
						case DOLLAR:
							if(tipoant1=='r'||tipoant1=='n')
								arqSaida.write("invokestatic java/lang/Double/toString(D)Ljava/lang/String; \r\n");
							if(tipoant1=='i')
								arqSaida.write("invokestatic java/lang/Integer/toString(I)Ljava/lang/String; \r\n");
							break;
					}
					
					break;
				case 'v':
					String var=x.valor;
					Simbolo vart=tabela.get(var);
					String pref="";
					int ref= vart.getReferencia();
					if(vart.tipo=='i')
						pref="i";
					if(vart.tipo=='r'||vart.tipo=='n')
						pref="d";
					if(vart.tipo=='s')
						pref="a";
					if(ref<=3)
						arqSaida.write(pref+"load_"+ref+" \r\n");
					else
						arqSaida.write(pref+"load "+ref+" \r\n");
					System.out.println(pref+"load "+ref+" \r\n");
					tipoant1=vart.tipo;
					tipos.offerLast(vart.tipo);
					break;
				case 's':
					arqSaida.write("ldc \""+x.getValor()+"\" \r\n");
					break;
					
			}
			tipoant2=tipoant1;
		}
		return tipos.pollLast();
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
		char tipo;
		for(Comando c: corpo)
		{
			switch(c.comando)
			{
				case ATRIB:
					String var=c.str;
					Simbolo vart=tabela.get(var);
					String pref="";
					
					int ref= vart.getReferencia();
					tipo=geraExpr(c,arqSaida);
					if(vart.tipo=='i')
						pref="i";
					if(vart.tipo=='r'||vart.tipo=='n')
						pref="d";
					if(vart.tipo=='s')
						pref="a";
					if(vart.tipo!=tipo);
						converteTipo(tipo, vart.tipo, arqSaida);
					
					if(ref<=3)
						arqSaida.write(pref+"store_"+ref+" \r\n");
					else
						arqSaida.write(pref+"store "+ref+" \r\n");
					break;
				case PRINT:
					c=(ComandoSaida)c;
					arqSaida.write("getstatic java/lang/System/out Ljava/io/PrintStream; \r\n");
					tipo=geraExpr(c,arqSaida);
					System.out.println("Print: tipoexpr="+c.tipoExpr1+" ; tipo="+tipo);
					if(tipo=='i')
						arqSaida.write("invokevirtual java/io/PrintStream/println(I)V \r\n");
					if(tipo=='n'||tipo=='r')
						arqSaida.write("invokevirtual java/io/PrintStream/println(D)V \r\n");
					if(tipo=='s')
						arqSaida.write("invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V \r\n");
						
					/*if(c.tipoExpr1=='n'||c.tipoExpr1=='r'||c.tipoExpr1=='i')
						arqSaida.write("invokevirtual java/io/PrintStream/println(D)V \r\n");
					if(c.tipoExpr1=='s')
						arqSaida.write("invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V \r\n");*/
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
				case IF:
					ComandoIF cif=(ComandoIF)c;
					LinkedList<Comando> corpoTemp=corpo;
					
					String lab1="IF"+label;
					String lab2="IF"+(label+1);//parte do else
					label+=2;
					
					geraExpr(cif,arqSaida);
					///gera a parte do if;
					arqSaida.write("ifeq "+lab1+"  \r\n");
					corpo=cif.corpo;
					processaCorpo(arqSaida);
					arqSaida.write("goto "+lab2+"  \r\n");
					arqSaida.write(lab1+":  \r\n");
					if(cif.corpoelse!=null)
					{
						corpo=cif.corpoelse;
						processaCorpo(arqSaida);
					}
					arqSaida.write(lab2+":  \r\n");
					
					corpo=corpoTemp;
			}
		}
	}
}
