package HashCode;

import java.util.Arrays;
import java.util.List;

public class AutoBoxing {
	
	
	public static void main(String[] args)
	{
		
		Long[] arr= {(long)1,(long) 2,(long)3};
		List<Long> li=Arrays.asList(arr);
		
		
		li.add((long)6);
		
		System.out.println(li.get(0));
		//suppliers = MasterUtil.getBusinessIds(required_Parameter.getDataSourceName(),
			//	Arrays.asList(required_Parameter.getBusinessUnit()));
		
		Integer i1=1;
		Integer i2=1;
		
		if(i1==i2)
			System.out.print("True");
		else
			System.out.print("false");
		
		i2=3;
		
		System.out.println(i1+","+i2);
		
		
	}

}
