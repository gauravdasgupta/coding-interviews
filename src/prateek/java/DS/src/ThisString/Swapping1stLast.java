package ThisString;

public class Swapping1stLast {

	public static void main(String[] args)
	{
		String s="  Parteek Passi   ";
		char[] cs=s.toCharArray();
		String s2 =s.toLowerCase();
		//System.out.println(s+"\n"+s2);
		int i=0,j=cs.length-1;
		while(cs[i]==' ')
				i++;
			//System.out.print(cs[i]+"-"+i);	
		
		while(cs[j]==' ')
			j--;
		
		char temp=cs[j];
		cs[j]=cs[i];
		cs[i]=temp;
		
		String s3=new String(cs);
		System.out.print(s3);	
		
		
		
		
		
		
	}
	
}
