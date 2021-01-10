
import java.util.*;
public class Main{
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int person[] = new int[3];
	for(int i=0;i<person.length;i++)
		person[i] = sc.nextInt();
	
	int k = person[2];
	for(int i=0; i<person[2]; i++)
	{
		if(person[0] %2 == 1)
		{
			person[0] --;
			k--;
		}
		else if((person[0]/2) > person[1])
		{
			person[0]--;
			k--;
		}
		else if((person[0]/2) == person[1])
		{
			person[1]--;
			k--;
		}
		else if((person[0]/2) < person[1])
		{
			person[1]--;
			k--;
		}
	}
	
	if((person[0]/2) >= person[1])
		System.out.println(person[1]);
	else
		System.out.println(person[0]/2);
	
	}
}
