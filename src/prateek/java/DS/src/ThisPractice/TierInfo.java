package ThisPractice;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TierInfo {

	public static void main(String[] args) {

		String mydata = "sec=270 | tier=1,2 |";
		Pattern pattern = Pattern.compile("tier=(.*?)\\|");
		Matcher matcher = pattern.matcher(mydata);

		String tiersString=null;
		while (matcher.find()) {
			tiersString = matcher.group(1);
		}

		System.out.println("this is:--"+tiersString);

		String[] arr = tiersString.split(",");
		Long res = 0l;

		for (int i = 0; i < arr.length; i++) {
			res=Math.max(res, Long.parseLong(arr[i].trim()));
			System.out.println(arr[i] + "---" + Integer.parseInt(arr[i].trim()));
		}

		System.out.println("final result set-" + res);

	}

}
