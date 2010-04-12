import java.util.*;
public class Conjunto {
	Set<String> s;
	Conjunto()
	{
		s=new TreeSet<String>();
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
