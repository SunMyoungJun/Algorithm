import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger[] bi = new BigInteger[251];
		bi[0] = new BigInteger("1");
		bi[1] = new BigInteger("1");
		bi[2] = new BigInteger("3");
		
		for(int i=3;i<251;i++) {
			bi[i] = new BigInteger("0");
			bi[i] = bi[i].add(bi[i-2].multiply(new BigInteger("2"))).add(bi[i-1]);
		}
		while(true) {
			String s = br.readLine();
			if(s == null) {
				break;
			}
			System.out.println(bi[Integer.parseInt(s)]);
		}
	}
}