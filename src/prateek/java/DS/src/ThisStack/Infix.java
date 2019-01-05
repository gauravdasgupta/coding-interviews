package ThisStack;

import java.util.Stack;

public class Infix {

	public static void main(String[] args)
	{
		String query="2+3*(4^5-6)^(7+1*2)-99";
		
		InfixIntoPostfix inpo=new  InfixIntoPostfix();
		String res=inpo.generator(query);
		
		SolvePostfix sol=new SolvePostfix();
		int fin=sol.solver("231*+9-");
		
		System.out.println(fin);
		
	}
	
	
}

class SolvePostfix
{

	public int solver(String exp)
	{
		Stack<Integer> st=new Stack<>();
		
		for(int i=0;i<exp.length();i++)
		{
			Character c=exp.charAt(i);
			
			if(Character.isDigit(c))
				st.push(c-'0');
			
			else
			{
				int val1=st.pop();
				int val2=st.pop();
				 switch(c)
	                {
	                    case '+':
	                    st.push(val2+val1);
	                    break;
	                     
	                    case '-':
	                    st.push(val2- val1);
	                    break;
	                     
	                    case '/':
	                    st.push(val2/val1);
	                    break;
	                     
	                    case '*':
	                    st.push(val2*val1);
	                    break;
	              }
				
				
				
				
			}
			
			
		}
		
		
		
		return st.pop();
	}
	
	
}




class InfixIntoPostfix{
	
	private int prefer(char operator)
	{
		switch(operator)
		{
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		
		  case '^':
	            return 3;
		
		}
		
		return -1;
		
	}
	public String generator(String exp)
	{
		String result="";
		Stack<Character> st=new Stack<>();
		
		for(int i=0;i<exp.length();i++)
		{
			char c=exp.charAt(i);
			
			if(Character.isLetterOrDigit(c))
				result+=c;
			
			else if(c=='(')
				st.push(c);
			else if(c==')')
			{
				while(!st.isEmpty() && st.peek() != '(' )
				{
					result+=st.pop();
					
				}
				
				if(st.peek() !='(')					
					return "Invalid Expression";
				
				else 
					st.pop();
					
			}
			
			else
			{
				while(!st.isEmpty() && prefer(c)<=prefer(st.peek()))
				{
					result+=st.pop();
					
				}
				st.push(c);
				
				
			}
	
		}
		
		while(!st.isEmpty())
			result+=st.pop();
		
		
		
		return result;
	}
		
}


