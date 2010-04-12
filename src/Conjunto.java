import java.util.*;
public class Conjunto {
	public Set<String> s;
	Conjunto()
	{
		s=new TreeSet<String>();
	}
	Conjunto(Collection<String> c)
	{
		s=new TreeSet<String>(c);
	}
	Conjunto(String[] arrstr)
	{
		s=new TreeSet<String>();
		for(String e: arrstr)
		{
			s.add(e);
		}
	}
	TreeSet<String> getTreeSetX()
	{
		return new TreeSet<String>(s);
	}
	public void add(String str)
	{
		s.add(str);
	}
	public void addAll(Collection<String> c)
	{
		s.addAll(c);
	}
	public void addAll(Conjunto c)
	{
		s.addAll(c.s);
	}
	public boolean contains(String str)
	//testa se o elemento str pertence ao conjunto atual
	{
		return s.contains(str);
	}
	public boolean containsAll(Conjunto c2)
	//testa se o conjunto atual contem um subconjunto c2
	{
		return s.containsAll(c2.s);
	}
	public Conjunto Union(Conjunto c2)
	{
		Conjunto r=new Conjunto(s);
		r.addAll(c2);
		return r;
	}
	public Conjunto Intersect(Conjunto c2)
	{
		Conjunto res=new Conjunto();
		for(String e: this.s)
		{
			if(c2.contains(e))
			{
				res.add(e);
			}
		}
		return res;
	}
	public String toString()
	{
		String str="{";
		Iterator<String> i=s.iterator();
		str+=i.next();
		while(i.hasNext())
		{
			str+=","+i.next();
		}
		return str+"}";
	}

}
