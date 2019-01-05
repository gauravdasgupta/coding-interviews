package Array2;

import java.util.Scanner;

public class MagicalNumbers {

	public static void main(String[] args)
	{
		//Scanner sc=new Scanner(System.in);
		
		String str="77747";//=sc.next();
		char[] chArr=str.toCharArray();
		
		//s=sc.nextLine();
		
		for(char c:chArr)
			System.out.print(c);
		
		
		if(!str.contains("4"))
		{	
			System.out.print("\n");
			System.out.println("4"+str.replace("7", "4"));
			System.out.println("yo -in here");
			return;
			
		}
		
		for(int i=chArr.length-1;i>=0;i--)
		{
			if(chArr[i]=='4')
			{	
				chArr[i]='7';
				int j=i+1;
				while(j<chArr.length)
				{
					chArr[j]='4';
					j++;
				}
			break;
			}						
		}

		System.out.print("\n");
		for(char c:chArr)
			System.out.print(c);

	}
}
