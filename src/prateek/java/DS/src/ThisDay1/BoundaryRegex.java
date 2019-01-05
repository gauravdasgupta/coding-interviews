package ThisDay1;
import java.util.regex.*;
public class BoundaryRegex {

	public static void main(String [] args) {
	Pattern p = Pattern.compile("\\b");
	Matcher m = p.matcher("w2w w$ &#w2"); // string to search
	System.out.println("\nsource: " + "w2w w$ &#w2");
	System.out.println(" index: 01234567890123456\n"); // the index
	System.out.println("expression: " + m.pattern()); // the search expression
	System.out.print("match positions: "); // matches positions
	while(m.find()) {
	System.out.println(m.start() + " "+m.group());
	}
	System.out.println("");
	}
	


	
}
