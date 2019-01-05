package ThisJune42018;

public class ArrayRoatation {

	public void rotate1(int[] arr, int dim)
	{
		for(int i=0;i<dim;i++)
		{
			leftrotate(arr);
			
		}
		
	}
	
	private void leftrotate(int[] arr)
	{
		int temp=arr[0];
		for(int i=1;i<arr.length;i++)
		{
			arr[i-1]=arr[i];
			
		}
		arr[arr.length-1]=temp;
		
	}
	
	
	public int gcd(int a, int b)
	{
		int n1=Integer.max(a,b);
		int n2=Integer.min(a,b);
		int r=n1%n2;
		while(r !=0)
		{
			n1=n2;
			n2=r;
			r=n1%n2;
		}
		
		return n2;
	}
	
	public int gcdRecursion(int a,int b)
	{
		if(b==0)
			return a;
		else return gcdRecursion(b,a%b);
	}
	
	public void rotateArrayLeft(int[] arr, int dim)
	{
		int temp,k,j;
		
		for(int i=0;i<gcd(arr.length,dim);i++)
		{
			temp=arr[i];
			
			j=i;
			while(true)
			{
				k=j+dim;
				if(k>=arr.length)
					k=k-arr.length;
				
				if(k==i)
					break;
				
				arr[j]=arr[k];
				j=k;
			}
			arr[j]=temp;

		}
		
		
	}
	
	public void reversalRotation(int[] arr, int dim)
	{
		int n=arr.length;
		reverseArray(arr,0,dim-1);
		reverseArray(arr,dim,n-1);
		reverseArray(arr,0,n-1);
	}
	
	public void reverseArray(int[] arr, int start , int end)
	{
		int temp;
		while(start<end)
		{
			temp=arr[start];
			arr[start]=arr[end];
			arr[end]=temp;
			start++;
			end--;
		}
		
	}
	
	public static void main(String[] args)
	{
		
		ArrayCreation a=new ArrayCreation(10);
		int[] arr=a.createArray();
		a.print();
		ArrayRoatation rot=new ArrayRoatation();
		//rot.rotate1(arr, 6);
		//a.print();
	//	rot.rotateArrayLeft(arr, 4);
		//a.print();
		rot.reversalRotation(arr, 3);
		a.print();
		
		
		System.out.println("GCD for numbers is :" +rot.gcd(642, 246));
		System.out.println("GCD for numbers is :" +rot.gcdRecursion(642, 246));
		
		
	}
	
	
}
