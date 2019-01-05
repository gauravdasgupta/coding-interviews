package ThisPractice;

import java.util.*;

public class WordBreakProblem {

	public static void solveWordBreakProblem(String str, Set<String> dict) {
		int[][] res = new int[str.length()][str.length()];

		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < str.length(); j++)
				res[i][j] = -1;
		}
		
		for(int l=1;l<=str.length();l++)
		{
			for(int i=0;i<str.length()-l+1;i++)
			{
				int j=i+l-1;
				if(dict.contains(str.substring(i, j+1)))
				{
					res[i][j]=i;
					continue;
				}
				for(int k=i+1;k<=j;k++)
				{
					if(res[i][k-1]!=-1 && res[k][j]!=-1)
					{
						res[i][j]=k;
						break;
					}
					
				}	
			}
		}
		
		System.out.println("in here");
		
		StringBuffer buffer = new StringBuffer();
        int i = 0; int j = str.length() -1;
        while(i < j){
            int k = res[i][j];
            if(i == k){
                buffer.append(str.substring(i, j+1));
                break;
            }
            buffer.append(str.substring(i,k) + " ");
            i = k;
        }
        System.out.println( buffer.toString());
		
	}

	public static void main(String[] args) {

		Set<String> dictionary = new HashSet<String>();
		dictionary.add("I");
		dictionary.add("like");
		dictionary.add("had");
		dictionary.add("play");
		dictionary.add("to");
		dictionary.add("a");
		String str = "Ihadaliketoplay";

		solveWordBreakProblem(str, dictionary);

	}

}
