import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;


public class CodigoDestino2 {
	public static LinkedList<Comando> corpo;
	public static HashMap<String,Simbolo>tabela;
	public static String arq;
	static int label=0;
	
	public CodigoDestino2(String nomearq, LinkedList<Comando> corpo1,HashMap<String,Simbolo>tab )
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
		 BufferedWriter arqSaida=null; 
         try { 
               arqSaida = new BufferedWriter(new FileWriter(arq+".j")); 
               //arq.indexOf(".");
               //System.out.println(arq);
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
         catch(IOException e1) { 
               System.out.println("Problemas no arquivo '"+arq+".j'"); 
         } 
         catch(Exception e2) {
        	 try{
        		 arqSaida.close();
        	 }catch(Exception e3){;}
        	 finally{;}
             e2.printStackTrace();
        	 
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
		//System.out.println("Converting "+tipo1+" to "+tipoCast);
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
		if(tipo1=='i' && tipoCast=='c')
		{
			arqSaida.write("i2c \r\n");
		}
		if(tipo1=='c' && tipoCast=='s')
		{
			arqSaida.write("new java/lang/StringBuffer \r\n");
			arqSaida.write("dup \r\n");
			arqSaida.write("invokespecial java/lang/StringBuffer/<init>()V \r\n");
			arqSaida.write("swap \r\n");
			arqSaida.write("invokevirtual java/lang/StringBuffer/append(C)Ljava/lang/StringBuffer; \r\n");
			arqSaida.write("invokevirtual java/lang/StringBuffer/toString()Ljava/lang/String; \r\n");
		}
	}
	public static void converteTipo(char tipo1,char tipo2, char tipoCast,BufferedWriter arqSaida) throws IOException
	{
		//System.out.println("Converting tipo1="+tipo1+",tipo2="+tipo2+" to "+tipoCast);
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
		if(tipo1=='c' && tipo2=='s' && tipoCast=='s')
		{
			arqSaida.write(";;convertetipo c s\r\n");
			converteTipo('c','s',arqSaida);
			arqSaida.write(";;convertetipo c s\r\n");
		}
		if(tipo1=='s' && tipo2=='c' && tipoCast=='s')
		{
			arqSaida.write("swap ;;convertetipo s c\r\n");
			converteTipo('c','s',arqSaida);
			arqSaida.write("swap ;;convertetipo s c\r\n");
		}
	}
	public static char geraExpr(ArrayDeque<Item> c,BufferedWriter arqSaida) throws IOException
	{
		char tipoant1,tipoant2;
		tipoant1='_';
		tipoant2=tipoant1;
		ArrayDeque<Character> tipos=new ArrayDeque<Character>();

		for(Item x:c)
		{
			tipoant2=tipoant1;
			//System.out.println("Tipos: "+tipos);
			switch(x.tipo)
			{
				case 'i':
					arqSaida.write("ldc "+x.getValorInt()+"\r\n");
					//System.out.println("ldc "+x.getValorInt()+"\r\n");
					//arqSaida.write("ldc2_w "+((double)x.getValorInt())+" \r\n");
					
					tipos.offerLast('i');
					tipoant1='i';
					break;
				case 'r':
					arqSaida.write("ldc2_w "+x.getValorDouble()+" \r\n");
					
					tipos.offerLast('r');
					tipoant1='r';
					break;
				case 'c':
					arqSaida.write("ldc "+((int)x.getValorChar())+" \r\n");
					//System.out.println("ldc "+Character.getNumericValue(x.getValorChar())+" "+(int)x.getValorChar()+" "+((char)Character.getNumericValue(x.getValorChar())));
					//arqSaida.write("i2c  \r\n");
					tipos.offerLast('c');
					tipoant1='c';
					break;
				case 'o':
					switch(x.oper)
					{
						case IN:
							tipoant1=tipos.pollLast();
							tipoant2=tipos.pollLast();
							if(Character.isUpperCase(tipoant1))
							{
								arqSaida.write(";;teste IN para LinkedList \r\n");
								if(tipoant2=='i')
								{
									arqSaida.write("swap \r\n");
									//arqSaida.write("i2d \r\n");
									CodigoDestino.geraIntegerO(arqSaida);
								}
								if(tipoant2=='c')
								{
									arqSaida.write("swap \r\n");
									//arqSaida.write("i2d \r\n");
									CodigoDestino.geraCharacterO(arqSaida);
								}
								if(tipoant2=='r'||tipoant2=='n')
								{
									arqSaida.write("dup_x2 \r\n");
									arqSaida.write("pop \r\n");
									CodigoDestino.geraDoubleO(arqSaida);
								}
								
								arqSaida.write("invokevirtual java/util/LinkedList/contains(Ljava/lang/Object;)Z \r\n");
							}
							if(tipoant1=='s')
							{
								arqSaida.write("swap ;;teste IN para String\r\n");
								if(tipoant2=='i')
									arqSaida.write("i2c \r\n");
								arqSaida.write("invokevirtual java/lang/String/indexOf(I)I \r\n");
								arqSaida.write("ldc 1 \r\n");
								arqSaida.write("iadd \r\n");
								
							}
							tipos.offerLast('i');
							break;
						case GTEQ:
							tipoant1=tipos.pollLast();
							tipoant2=tipos.pollLast();
							if(tipoant1=='r'|| tipoant2=='r'||tipoant1=='n'|| tipoant2=='n')
							{
								converteTipo(tipoant1,tipoant2,'r',arqSaida);
								arqSaida.write("dcmpg \r\n");
							}
							else
							{			
								if(tipoant1=='i'|| tipoant2=='i')
								{
									arqSaida.write("isub  \r\n");
								}
							}
							arqSaida.write("ifge LABGE"+label+"  \r\n");
							arqSaida.write("ldc 0 \r\n");
							arqSaida.write("goto LABGE"+(label+1)+" \r\n");
							arqSaida.write("LABGE"+label+": \n\r" );
							arqSaida.write("ldc 1 \r\n");
							arqSaida.write("LABGE"+(label+1)+": \n\r");
							label+=2;
							tipos.offerLast('i');
							break;
						case LS:
							tipoant1=tipos.pollLast();
							tipoant2=tipos.pollLast();
							if(tipoant1=='r'|| tipoant2=='r'||tipoant1=='n'|| tipoant2=='n')
							{
								converteTipo(tipoant1,tipoant2,'r',arqSaida);
								arqSaida.write("dcmpg \r\n");
							}
							else
							{			
								if(tipoant1=='i'|| tipoant2=='i')
								{
									arqSaida.write("isub  \r\n");
								}
							}
							arqSaida.write("ifge LABLS"+label+"  \r\n");
							arqSaida.write("ldc 1 \r\n");
							arqSaida.write("goto LABLS"+(label+1)+" \r\n");
							arqSaida.write("LABLS"+label+": \n\r" );
							arqSaida.write("ldc 0 \r\n");
							arqSaida.write("LABLS"+(label+1)+": \n\r");
							label+=2;
							tipos.offerLast('i');
							break;
						case GT:
							tipoant1=tipos.pollLast();
							tipoant2=tipos.pollLast();
							if(tipoant1=='r'|| tipoant2=='r'||tipoant1=='n'|| tipoant2=='n')
							{
								converteTipo(tipoant1,tipoant2,'r',arqSaida);
								arqSaida.write("dcmpg \r\n");
							}
							else
							{			
								if(tipoant1=='i'|| tipoant2=='i')
								{
									arqSaida.write("isub  \r\n");
								}
							}
							arqSaida.write("ifle LABGT"+label+"  \r\n");
							arqSaida.write("ldc 1 \r\n");
							arqSaida.write("goto LABGT"+(label+1)+" \r\n");
							arqSaida.write("LABGT"+label+": \n\r" );
							arqSaida.write("ldc 0 \r\n");
							arqSaida.write("LABGT"+(label+1)+": \n\r");
							label+=2;
							tipos.offerLast('i');
							break;
						case LSEQ:
							tipoant1=tipos.pollLast();
							tipoant2=tipos.pollLast();
							if(tipoant1=='r'|| tipoant2=='r'||tipoant1=='n'|| tipoant2=='n')
							{
								converteTipo(tipoant1,tipoant2,'r',arqSaida);
								arqSaida.write("dcmpg \r\n");
							}
							else
							{			
								if(tipoant1=='i'|| tipoant2=='i')
								{
									arqSaida.write("isub  \r\n");
								}
							}
							arqSaida.write("ifle LABLE"+label+"  \r\n");
							arqSaida.write("ldc 0 \r\n");
							arqSaida.write("goto LABLE"+(label+1)+" \r\n");
							arqSaida.write("LABLE"+label+": \n\r" );
							arqSaida.write("ldc 1 \r\n");
							arqSaida.write("LABLE"+(label+1)+": \n\r");
							label+=2;
							tipos.offerLast('i');
							break;
						case EQ:
							tipoant1=tipos.pollLast();
							tipoant2=tipos.pollLast();
							if(tipoant1==tipoant2 && tipoant2=='s')
							{
								arqSaida.write("invokevirtual java/lang/String/compareTo(I)I \r\n");
							}
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
						case DIFF:
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
							icmp(arqSaida);
							not(arqSaida);
							tipos.offerLast('i');
							break;
						case XOR:
							tipoant1=tipos.pollLast();
							tipoant2=tipos.pollLast();
							if(tipoant1=='r' || tipoant2=='r'||tipoant1=='n'||tipoant2=='n')
								converteTipo(tipoant1,tipoant2,'i',arqSaida);
							arqSaida.write("dup2 \r\n");
							arqSaida.write("swap \r\n");
							not(arqSaida);
							and(arqSaida);
							arqSaida.write("dup_x2 \r\n");
							arqSaida.write("pop \r\n");
							not(arqSaida);
							and(arqSaida);
							or(arqSaida);
							
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
							//System.out.println("2Tipos: "+tipos);
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
						
						case ADD:
							tipoant1=tipos.pollLast();
							tipoant2=tipos.pollLast();
							if(tipoant1=='r' || tipoant2=='r'||tipoant1=='n'||tipoant2=='n')
							{
								//arqSaida.write(";;tipo1="+tipoant1+" tipo2="+tipoant2+" \r\n");
								converteTipo(tipoant1,tipoant2,'r',arqSaida);
								arqSaida.write("dadd \r\n");
								//System.out.println("dadd \r\n");
								tipos.offerLast('r');
							}else
							{
								arqSaida.write("iadd \r\n");
								//System.out.println("iadd \r\n");
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
						case MOD:
							tipoant1=tipos.pollLast();
							tipoant2=tipos.pollLast();
							if(tipoant1=='r' || tipoant2=='r'||tipoant1=='n'||tipoant2=='n')
							{
								converteTipo(tipoant1,tipoant2,'r',arqSaida);
								arqSaida.write("drem \r\n");
								tipos.offerLast('r');
							}else
							{
								arqSaida.write("irem \r\n");
								tipos.offerLast('i');
							}
							break;
						case EXP:
							tipoant1=tipos.pollLast();
							tipoant2=tipos.pollLast();
							if(tipoant1=='i' || tipoant2=='i')
								converteTipo(tipoant1,tipoant2,'r',arqSaida);
							arqSaida.write("invokestatic java/lang/Math/pow(DD)D \r\n");
							tipos.offerLast('r');
							break;
						case CONCAT:
							tipoant1=tipos.pollLast();
							tipoant2=tipos.pollLast();
							if(tipoant1=='s' || tipoant2=='s')
							{
								if(tipoant1!='s'||tipoant2!='s')
									converteTipo(tipoant1,tipoant2,'s',arqSaida);
								arqSaida.write("swap \r\n");
								arqSaida.write("new java/lang/StringBuilder \r\n");
								arqSaida.write("dup  \r\n");
								arqSaida.write("invokespecial java/lang/StringBuilder/<init>()V \r\n");
								arqSaida.write("swap \r\n");
								arqSaida.write("invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder; \r\n");
								arqSaida.write("swap \r\n");
								arqSaida.write("invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder; \r\n");
								arqSaida.write("invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String;\r\n");
								tipos.offerLast('s');
							}
							if(Character.isUpperCase(tipoant1) && Character.isUpperCase(tipoant2) )
							{
								arqSaida.write("swap ;;concat lista\r\n");
								arqSaida.write("dup \r\n");
								arqSaida.write("dup2_x1 \r\n");
								arqSaida.write("pop2 \r\n");
								arqSaida.write("checkcast java/util/Collection \r\n");
								arqSaida.write("invokevirtual java/util/LinkedList/addAll(Ljava/util/Collection;)Z\r\n ");
								arqSaida.write("pop \r\n");
								tipos.offerLast(tipoant1);
							}
							
							break;
						case ARROBA:
							tipoant1=tipos.pollLast();
							arqSaida.write("invokestatic java/lang/Double/parseDouble(Ljava/lang/String;)D \r\n");
							tipoant1='r';
							tipos.offerLast('r');
							break;
						case DOLLAR:
							tipoant1=tipos.pollLast();
							if(tipoant1=='r'||tipoant1=='n')
								arqSaida.write("invokestatic java/lang/Double/toString(D)Ljava/lang/String; \r\n");
							if(tipoant1=='i')
								arqSaida.write("invokestatic java/lang/Integer/toString(I)Ljava/lang/String; \r\n");
							tipos.offerLast('s');
							break;
					}
					
					break;
				case 'v':
					String var=x.valor;
					Simbolo vart=tabela.get(var);
					String pref="";
					int ref= vart.getReferencia();
					if(vart.tipo=='i'||vart.tipo=='c')
						pref="i";
					if(vart.tipo=='r'||vart.tipo=='n')
						pref="d";
					if(vart.tipo=='s'||vart.tipo=='I'||vart.tipo=='R'||vart.tipo=='N'||vart.tipo=='C'||vart.tipo=='S')
						pref="a";
					if(ref<=3)
						arqSaida.write(pref+"load_"+ref+" \r\n");
					else
						arqSaida.write(pref+"load "+ref+" \r\n");
					//System.out.println(pref+"load "+ref+" \r\n");
					tipoant1=vart.tipo;
					tipos.offerLast(vart.tipo);
					break;
				case 's':
					arqSaida.write("ldc \""+x.getValor()+"\" \r\n");
					tipos.offerLast('s');
					break;
				case 'I':
					geraLista(x.valorlst,'I',arqSaida);
					tipos.offerLast('I');
					break;
				case 'R':
					geraLista(x.valorlst,'R',arqSaida);
					tipos.offerLast('R');
					break;
				case 'N':
					geraLista(x.valorlst,'R',arqSaida);
					tipos.offerLast('R');
					break;
				case 'C':
					geraLista(x.valorlst,'C',arqSaida);
					tipos.offerLast('C');
					break;
			}
			tipoant2=tipoant1;
		}
		//System.out.println("Tipos final: "+tipos);
		return tipos.pollLast();
	}
	public static void geraDoubleO(BufferedWriter arqSaida) throws IOException
	//supoe que existe um double no topo da pilha e cria um objeto Double com este double
	{
		arqSaida.write("new java/lang/Double  \r\n");
		arqSaida.write("dup  \r\n");//duplica a referencia ao objeto
		arqSaida.write("dup2_x2  \r\n");//copia as duas ref para baixo do double
		arqSaida.write("pop2  \r\n");//desfaz das duas referencias q estao no topo
		arqSaida.write("invokespecial java/lang/Double/<init>(D)V  \r\n");
	}
	public static void geraIntegerO(BufferedWriter arqSaida) throws IOException
	//supoe que existe um double no topo da pilha e cria um objeto Double com este double
	{
		arqSaida.write("new java/lang/Integer  \r\n");
		arqSaida.write("dup  \r\n");//duplica a referencia ao objeto
		arqSaida.write("dup2_x1  \r\n");//copia as duas ref para baixo do double
		arqSaida.write("pop2  \r\n");//desfaz das duas referencias q estao no topo
		arqSaida.write("invokespecial java/lang/Integer/<init>(I)V  \r\n");
	}
	public static void geraCharacterO(BufferedWriter arqSaida) throws IOException
	//supoe que existe um double no topo da pilha e cria um objeto Double com este double
	{
		arqSaida.write("new java/lang/Character  \r\n");
		arqSaida.write("dup  \r\n");//duplica a referencia ao objeto
		arqSaida.write("dup2_x1  \r\n");//copia as duas ref para baixo do double
		arqSaida.write("pop2  \r\n");//desfaz das duas referencias q estao no topo
		arqSaida.write("invokespecial java/lang/Character/<init>(C)V  \r\n");
	}
	public static void geraLista(ArrayDeque<Item> lst,char tipo,BufferedWriter arqSaida) throws IOException
	{
		char tipolst,tipox;
		String objDescript="";
		tipolst=Character.toLowerCase(tipo);
		/*if(tipo=='R' || tipo=='N')
			objDescript="java/lang/Double";
		if(tipo=='I')
			objDescript="java/lang/Integer";
		if(tipo=='C')
			objDescript="java/lang/Character";
		if(tipo=='S')
			objDescript="java/lang/String";*/
		objDescript="java/lang/Object";
		arqSaida.write("new java/util/LinkedList  \r\n");
		arqSaida.write("dup \r\n");
		arqSaida.write("invokespecial java/util/LinkedList/<init>()V  \r\n");
		for(Item x:lst)
		{
			arqSaida.write("dup \r\n");
			tipox=geraExpr(x.valorlst,arqSaida);
			converteTipo(tipox,tipolst,arqSaida);
			if(tipox=='c')
			{
				geraCharacterO(arqSaida);
				//arqSaida.write("i2d \r\n");
				//tipox='r';
			}
			if(tipox=='i')
			{
				geraIntegerO(arqSaida);
				//arqSaida.write("i2d \r\n");
				//tipox='r';
			}
			if(tipox=='r'||tipox=='n')
				geraDoubleO(arqSaida);
			//if(tipox=='i')
				//geraIntegerO(arqSaida);
			arqSaida.write("invokevirtual java/util/LinkedList/add(L"+objDescript+";)Z  \r\n");
			arqSaida.write("pop  \r\n");
		}
	}
	public static void percorreFor(String var,char tipoAnterior,String labelBreak, ComandoCorpo cfor,BufferedWriter arqSaida) throws IOException
	//percorre uma lista. Supoe que no tipo da pilha esta uma referencia para um Iterator de uma lista, do tipo dado por tipoAnterior
	//var eh a variavel q vai receber o valor do next da lista, e deve ser deixado um valor 1, caso v tenha o recebido o elemento,
	//ou seja se foi possivel percorrer, e 0 caso contrario.
	{
		String lab="ITERATOR"+label;
		String lab1="ITERATOR"+(label+1);
		label+=2;
		Simbolo vart=tabela.get(var);
		String pref="";
		char tipo2=Character.toLowerCase(tipoAnterior);
		int ref= vart.getReferencia();
		
		if(vart.tipo=='i'||vart.tipo=='c')
			pref="i";
		if(vart.tipo=='r'||vart.tipo=='n')
			pref="d";
		if(vart.tipo=='s'||vart.tipo=='I'||vart.tipo=='R'||vart.tipo=='N'||vart.tipo=='C'||vart.tipo=='S')
			pref="a";
		
		arqSaida.write(lab+":   \r\n");
		arqSaida.write("dup  \r\n");
		arqSaida.write("checkcast java/util/ListIterator \r\n");
		arqSaida.write("invokeinterface java/util/ListIterator/hasNext()Z 1  \r\n");
		arqSaida.write("ifne "+lab1+"  \r\n");
			arqSaida.write("pop \r\n");
			arqSaida.write("goto "+labelBreak+" \r\n");
		arqSaida.write(lab1+": \r\n" );
			arqSaida.write("dup  \r\n");
			arqSaida.write("invokeinterface java/util/ListIterator/next()Ljava/lang/Object; 1 \r\n");
			switch(tipoAnterior)
			{
				case 'C':
					arqSaida.write("checkcast java/lang/Character \r\n");
					arqSaida.write("invokevirtual java/lang/Character/charValue()C  \r\n");
					break;
				case 'I':
					//arqSaida.write("invokevirtual java/lang/Double/doubleValue()D  \r\n");
					arqSaida.write("checkcast java/lang/Integer \r\n");
					arqSaida.write("invokevirtual java/lang/Integer/intValue()I  \r\n");
					//tipo2='r';
					//System.out.println("oi "+tipo2+" "+vart.tipo);
					break;
				case 'R':
					arqSaida.write("checkcast java/lang/Double  \r\n");
					arqSaida.write("invokevirtual java/lang/Double/doubleValue()D  \r\n");
					break;
				case 'S':
					arqSaida.write("checkcast java/lang/String  \r\n");
					break;
					
			}
			if(vart.tipo!=tipo2);
				converteTipo(tipo2, vart.tipo, arqSaida);
			if(ref<=3)
				arqSaida.write(pref+"store_"+ref+" \r\n");
			else
				arqSaida.write(pref+"store "+ref+" \r\n");
			corpo=cfor.corpo;
			processaCorpo(arqSaida);
			arqSaida.write("goto "+lab+" \r\n");
	}
	
	public static void geraEntrada(ComandoEntrada c,BufferedWriter arqSaida) throws IOException
	{
		for(String v:c.listaVar)
		{
			int ref=tabela.get(v).getReferencia();
			String pref="";
			//arqSaida.write("aconst_null\r\n");
			arqSaida.write("ldc \""+v+"\" \r\n");
			arqSaida.write("invokestatic  javax/swing/JOptionPane/showInputDialog(Ljava/lang/Object;)Ljava/lang/String;\r\n");
			switch(tabela.get(v).tipo)
			{
				case 'r':
					arqSaida.write("invokestatic  java/lang/Double/parseDouble(Ljava/lang/String;)D \r\n");
					pref="d";
					break;
				case 'i':
					arqSaida.write("invokestatic  java/lang/Integer/parseInt(Ljava/lang/String;)I \r\n");
					pref="i";
					break;
				case 'c':
					arqSaida.write("ldc 0 \r\n");
					arqSaida.write("invokevirtual java/lang/String/charAt(I)C  \r\n");
					pref="i";
					break;
				case 's':
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
		LinkedList<Comando> corpoTemp;
		String lab1="";
		String lab2="";//parte do else
		for(Comando c: corpo)
		{
			switch(c.comando)
			{
				case ATRIB:
					String var=c.str;
					Simbolo vart=tabela.get(var);
					String pref="";
					
					int ref= vart.getReferencia();
					tipo=geraExpr(c.expr1,arqSaida);
					if(vart.tipo=='i'||vart.tipo=='c')
						pref="i";
					if(vart.tipo=='r'||vart.tipo=='n')
						pref="d";
					if(vart.tipo=='s'||vart.tipo=='I'||vart.tipo=='R'||vart.tipo=='N'||vart.tipo=='C'||vart.tipo=='S')
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
					//arqSaida.write("getstatic java/lang/System/out Ljava/io/PrintStream; \r\n");
					arqSaida.write("aconst_null \r\n");
					tipo=geraExpr(c.expr1,arqSaida);
					
					if(tipo=='c')
						arqSaida.write("invokevirtual java/lang/Integer/toString(C)Ljava/lang/String; \r\n");
					if(tipo=='i')
						arqSaida.write("invokestatic  java/lang/Integer/toString(I)Ljava/lang/String; \r\n");
					if(tipo=='n'||tipo=='r')
						arqSaida.write("invokestatic  java/lang/Double/toString(D)Ljava/lang/String; \r\n");
					if(tipo=='I'||tipo=='R'||tipo=='N'||tipo=='C'||tipo=='S')
						arqSaida.write("invokestatic  java/lang/Object/toString(Ljava/lang/Object;)Ljava/lang/String; \r\n");
					arqSaida.write("invokestatic  javax/swing/JOptionPane/showMessageDialog(Ljava/awt/Component;Ljava/lang/Object;)V\r\n");
					/*if(c.tipoExpr1=='n'||c.tipoExpr1=='r'||c.tipoExpr1=='i')
						arqSaida.write("invokevirtual java/io/PrintStream/println(D)V \r\n");
					if(c.tipoExpr1=='s')
						arqSaida.write("invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V \r\n");*/
					break;
				case ENTRADA:
					ComandoEntrada ce=(ComandoEntrada)c;
					
					//arqSaida.write("new java/util/Scanner \r\n");
					//arqSaida.write("dup  \r\n");
					//arqSaida.write("getstatic java/lang/System/in Ljava/io/InputStream;  \r\n");
					//arqSaida.write("invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V \r\n");
					//for(String s:ce.listaVar)
						//arqSaida.write("dup  \r\n");
					geraEntrada(ce,arqSaida);
					break;
				case IF:
					ComandoIF cif=(ComandoIF)c;
					corpoTemp=corpo;
					
					lab1="IF"+label;
					lab2="IF"+(label+1);//parte do else
					label+=2;
					
					geraExpr(cif.expr1,arqSaida);
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
					lab1="";
					lab2="";
					break;
				case WHILE:
					ComandoCorpo cwhile=(ComandoCorpo)c;
					corpoTemp=corpo;
					
					lab1="WHILE"+label;
					lab2="WHILE"+(label+1);//parte do else
					label+=2;
					
					arqSaida.write(lab1+":  \r\n");
					geraExpr(cwhile.expr1,arqSaida);
					arqSaida.write("ifeq "+lab2+"  \r\n");
						corpo=cwhile.corpo;
						processaCorpo(arqSaida);
					arqSaida.write("goto "+lab1+"  \r\n");
					arqSaida.write(lab2+":  \r\n");
					
					corpo=corpoTemp;
					break;
				case FOR:
					ComandoCorpo cfor=(ComandoCorpo)c;
					char tipo1;
					corpoTemp=corpo;
					lab1="FOR"+label;
					lab2="FOR"+(label+1);//parte do else
					label+=2;
					
					arqSaida.write(lab1+":  \r\n");
					tipo1=geraExpr(cfor.expr1,arqSaida);
					//pega o ListIterator da Lista que deve estar na pilha
					arqSaida.write("ldc 0 \r\n");//endereço para ser acessado
					arqSaida.write("invokevirtual java/util/LinkedList/listIterator(I)Ljava/util/ListIterator; \r\n");
						percorreFor(cfor.varFor, tipo1,lab2, cfor, arqSaida);
					arqSaida.write(lab2+":  \r\n");
					
					corpo=corpoTemp;
					break;
			}
		}
	}
}

