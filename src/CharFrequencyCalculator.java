import java.util.HashMap;
import java.util.Map;

/**
 * Created by dasguptag on 10-12-2017.
 */
public class CharFrequencyCalculator {

    private static String tavantInput;
    private static int frequency;

    static {
        tavantInput = "a,b,c,d,a,b,e,f,b,a,c";
        frequency = 0;
    }

    public static void main(String args[]){
        Map<Character,Integer> testSample= new HashMap<>();

        for(char input:tavantInput.toCharArray()){
            char c = input;
            Integer frequency= testSample.get(c);
            if(frequency!=null){
                testSample.put(c,frequency+1);
            }
            else
                testSample.put(c,1);
        }

        System.out.println("frequency of each character--"+testSample);


    }
}
