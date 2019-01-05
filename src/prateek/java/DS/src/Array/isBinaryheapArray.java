package Array;

public class isBinaryheapArray {
	
	public static boolean isArrayHeap(int[] arr)
	{
		int n=arr.length;
		for(int i=n/2-1;i>=0;i--)
		{
			int l=2*i+1;
			int r=2*i+2;
			boolean lans=true;
			boolean rans=true;
			if(l<n && arr[l]>arr[i])
				lans=false;
			
			if(r<n && arr[r]>arr[i])
				rans=false;
			
			if(!(lans && rans))
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args)
	{
		int[] arr={90, 15, 10, 7, 12, 2, 7, 1};
		if(isArrayHeap(arr))
			System.out.println("Given Array is Binary heap");
		else
			System.out.println("Given Array is NOT Binary heap");

	}

}
