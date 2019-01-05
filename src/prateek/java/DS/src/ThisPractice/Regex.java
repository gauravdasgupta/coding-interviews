package ThisPractice;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

	public static void main(String[] args)
	{
		
		
		
		
		String mydata = "sec=270 | tier=1,2 |";
		System.out.println("Substring is:"+mydata.substring(0, 4));
		
		
		Pattern pattern = Pattern.compile("tier=(.*?)\\|");
		Matcher matcher = pattern.matcher(mydata);
		String y=mydata.substring(mydata.indexOf("tier="));
	   // System.out.println(y);
		
		
	String x=null;
	while (matcher.find()) {
				
			x=matcher.group(1);
		   // System.out.println(x);
		    
		    System.out.println("yo-1:-"+matcher.group(1));
	}
		
		
	Arrays.asList(x.substring(x.indexOf("=")+1).split(","));
		
		
	//	System.out.println(x.substring(x.indexOf("=")+1));
		
		
	}
	
}
