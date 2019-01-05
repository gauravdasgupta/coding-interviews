package ThisDay1;

import java.util.*;
interface AdvancedArithmetic{
  int divisor_sum(int n);
}



class MyCalculator implements AdvancedArithmetic{
    
   public int divisor_sum(int n) {
    	
	   
	   System.out.println("you are here");
	   	Map <Integer,Integer> m= new HashMap<Integer,Integer>();
	   	int fr=0;
	   
	   	System.out.println("you are here2");
	   	int p=n;
	   	
	   	while(n%2==0)
	   	{
	   		if(!m.containsKey(2))
	   		{
	   			m.put(2, 1);
	   		}
	   		else
	   		{
	   			fr=m.get(2);
	   			m.put(2, ++fr);
	   		}
	   		n=n/2;
	   		
	   	}
	   	
	   	for(int i=3;i<=Math.sqrt(p);i=i+2)
	   	{
	   		while(n%i==0)
	   		{
	   			if(!m.containsKey(i))
	   			{
	   				m.put(i, 1);
	   			}
	   			else 
	   			{
	   				fr=m.get(i);
	   				m.put(i,++fr);
	   			}
	   		n=n/i;
	   		}
	   		
	   	}
	   	
	   	
	   	System.out.println(m.containsKey(5));
	   	
	   	for(Integer k: m.keySet())
	   	{
	   		System.out.println(k+"--"+m.get(k));
	   	}
	   	
	   
    	
    	return n;
    }
}




class Solution{
    public static void main(String []args){
        MyCalculator my_calculator = new MyCalculator();
        System.out.print("I implemented: ");
       // ImplementedInterfaceNames(my_calculator);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(my_calculator.divisor_sum(n) + "\n");
      	sc.close();
    }
    /*
     *  ImplementedInterfaceNames method takes an object and prints the name of the interfaces it implemented
     */
    static void ImplementedInterfaceNames(Object o){
        Class[] theInterfaces = o.getClass().getInterfaces();
        for (int i = 0; i < theInterfaces.length; i++){
            String interfaceName = theInterfaces[i].getName();
            System.out.println(interfaceName);
        }
    }
}

