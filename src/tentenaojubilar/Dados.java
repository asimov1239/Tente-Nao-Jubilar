package tentenaojubilar;

import java.util.Random;

public class Dados {
	private Random random = new Random();
	
	public int rolar() {
		int n1 = random.nextInt(5) + 1;
		int n2 = random.nextInt(5) + 1;
		return n1 + n2;
	}
}
