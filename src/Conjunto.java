import java.util.*;
public class Conjunto {
	Set<String> s;
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
	
	Conjunto Union(Conjunto c2)
	{
		Conjunto r=new Conjunto(s);
		r.s.addAll(c2.s);
		return r;
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
