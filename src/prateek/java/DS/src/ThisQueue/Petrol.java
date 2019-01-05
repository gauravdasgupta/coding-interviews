package ThisQueue;
import java.util.Deque;
import java.util.LinkedList;

public class Petrol {

	public static void main(String[] args)
	{
		
		PetrolPump[] pp={new PetrolPump(6, 4),
                new PetrolPump(3, 6),
                new PetrolPump(7, 3)};

		//Solution
		Deque<PetrolPump> dq=new LinkedList<>();
		
		for(int i=0;i<pp.length;i++)
			dq.addLast(pp[i]);

	}
		
}



class PetrolPump
{

	int petrol;
	int distance;

	public PetrolPump(int p, int d)
	{
		this.petrol=p;
		this.distance=d;
		
	}
	
}
