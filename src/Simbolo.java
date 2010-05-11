
public class Simbolo {
	public String nome;
	public char tipo;
	public int referencia;
	public static int ultimo=1;
	public Simbolo(String nome, char tipo, int ref, int ult)
	{
		this.nome=nome;
		this.tipo=tipo;
		this.referencia=ref;
		setUltimo(ult);
	}
	public Simbolo(String nome, char tipo)
	{
		referencia=ultimo;
		this.nome=nome;
		this.tipo=tipo;
		setUltimo(calculaProximo());
	}
	public Simbolo(String nome, char tipo, int ref)
	{
		this.nome=nome;
		this.tipo=tipo;
		this.referencia=ref;
		setUltimo(calculaProximo());
	}
	public static void setUltimo(int ult)
	{
		ultimo=ult;
	}
	public static int getUltimo()
	{
		return ultimo;
	}
	public void setNome(String nom)
	{
		nome=nom;
	}
	public String getNome()
	{
		return this.nome;
	}
	public void setTipo(char tip)
	{
		tipo=tip;
	}
	public char getTipo()
	{
		return this.tipo;
	}
	public void setReferencia(int ref)
	{
		referencia=ref;
	}
	public int getReferencia()
	{
		return this.referencia;
	}
	public int calculaProximo()
	{
		int prox=0;
		if(tipo=='r')
		{
			prox=referencia+2;
		}else
		{
			prox=referencia+1;
		}
		return prox;
	}
	public String toString()
	{
		return "[nome: "+nome+"; tipo: "+tipo+"; ref: "+referencia+"]";
	}
}
