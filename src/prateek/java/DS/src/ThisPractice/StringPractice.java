package ThisPractice;

public class StringPractice {

	// https://www.geeksforgeeks.org/find-excel-column-name-given-number/
	public static void findExcelColumnName(int columnNo) {
		int temp = columnNo;
		int remainder;
		String res = "";
		char chTemp;
		int charAValue = (int) 'A';		
		while (temp != 0) {
			remainder = temp % 26;
			chTemp = (char) ((25 + remainder) % 26 + charAValue);
			res = chTemp + res;
			temp = temp / 26;
		}
		System.out.println(res);
	}
	
	public static void findExcelColumnNumber(String str)
	{
		char[] chArr=str.toCharArray();
		int charAValue = (int) 'A';	
		
		
		int res=0,temp=0;
		
		for(int i=chArr.length-1;i>=0;i--)
		{
			temp=(int)(Math.pow(26, (chArr.length-1-i))*(((int)chArr[i]-charAValue+1)));
		//System.out.println(((int)chArr[i]-charAValue+1)+"--"+temp+"--"+chArr[i]);
			res=res+temp;
		}
		
		System.out.println(res);
		
	}

	public static void main(String[] args) {
		String str = "azxxzy";
		// removeAdjacentDup(str);

		char ch = 'A';
		int chInt = (int) ch;

		// System.out.print((char) ((25+0)%26+chInt) + ",");

		/*
		 * for (int i = 0; i < 26; i++) { System.out.print((char) (chInt + i) + ","); }
		 */
		findExcelColumnName(1121);
		findExcelColumnNumber("AQC");

	}
}
