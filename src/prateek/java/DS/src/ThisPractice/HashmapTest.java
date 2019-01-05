package ThisPractice;

import java.util.HashMap;
import java.util.Map;


public class HashmapTest {

	public static void main(String[] args)
	{
		Map<Long,Long> m=new HashMap<>();
		
		m.put(1l, 1l);
		m.put(2l, 2l);
		
		Long x=m.get(3);
		
		System.out.println(x);
		
		
		
		
	}

}


