package ThisPractice2;

public class ArrayBinaryHeapTest2 {

	public static boolean solve(int[] arr) {
		int n = arr.length;
		for (int i = n / 2 - 1; i >= 0; i--) {
			int l=2*i+1;
			int r=2*i+2;
			
			if((l<n && arr[l]>arr[i]) || (r<n && arr[r]>arr[i]))
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		int[] arr = { 90, 15, 10, 7, 12, 2, 7, 1,99 };
		if(solve(arr))
			System.out.println("it is binary");
		else
			System.out.println("not binary");

	}

}
