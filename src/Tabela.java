public class Tabela {
	Conjunto[] table;
	public Tabela()
	{
		table=new Conjunto[26];
	}
	private int index(String key)
	{
		key=key.toLowerCase();
		return (key.charAt(0)-'a');
	}
	public void addKeyValue(String key, Conjunto value)
	{
		table[index(key)]=value;
	}
	public boolean hasValue(String key)
	{
		return table[index(key)]!=null;
	}
	public Conjunto getValue(String key)
	{
		return table[index(key)];
	}
}
