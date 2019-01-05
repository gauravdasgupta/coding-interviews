
public class AllPermutationsOfString {

	
	public static int count=0;
	public static void solveAllPermutationsOfString(String str, int posToSwap) {

		if(posToSwap>=str.length())
		{
			System.out.println(str);
			count++;
			return;
		}
		
		for (int i = posToSwap; i < str.length(); i++) {
			char[] arr=str.toCharArray();
			char temp=arr[i];
			arr[i]=arr[posToSwap];
			arr[posToSwap]=temp;
			String strNew=String.valueOf(arr);
			solveAllPermutationsOfString(strNew,posToSwap+1);	
		}

	}

	public static void main(StringTest[] args) {

		String str = "ABCD";
		solveAllPermutationsOfString(str, 0);
		
		System.out.println("Count is-"+count);

	}

}
