package Misc;

public class GoldMine {
	
	public static int getGold(int[][] arr, int r,int c)
	{
		int res=arr[r][c];
		int right_up=0;
		int right_down=0;
		int right=0;
		
	    if(arr[r].length>(c+1))
			right=getGold(arr,r,c+1);
		if((r-1)>=0 && arr[r-1].length>(c+1))
		right_up=getGold(arr,r-1,c+1);
		
		if(arr.length>(r+1) && arr[r+1].length>(c+1))
		right_down=getGold(arr,r+1,c+1);
		
		return res+Math.max(right,Math.max(right_up, right_down));
	}
	
	public static int getMaxGold(int[][] arr, int m, int n )
	{
		int res=0;
		int temp=0;
		for(int i=0;i<m;i++)
			{
			temp=getGold(arr, i,0);
			System.out.println(i+"-"+temp);
			res=Math.max(res,temp);
			}
		
		
		return res;
	}
	
	
	public static void main(String arg[])
    {
        int gold[][]= {{10, 33, 13, 15},
                {22, 21, 04, 1},
                {5, 0, 2, 3},
                {0, 6, 14, 2}};
        
       // System.out.println(gold[2][0]+"-"+gold[3][1]+"-"+gold[2][2]+"-"+gold[2][3]);
        
                         
        int m = 4, n = 4;
        System.out.print("Final Result is:"+getMaxGold(gold, m, n));
    }

}
