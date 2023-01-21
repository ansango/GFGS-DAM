package Philosophers;

public class Main {

	public static void main(String[] args) 
	{
		Fork fork[] = new Fork[5];
		fork[0] = new Fork(0);
		fork[1] = new Fork(1);
		fork[2] = new Fork(2);
		fork[3] = new Fork(3);
		fork[4] = new Fork(4);
		
		Philosopher philosopher[] = new Philosopher[5];
		
		philosopher[0] = new Philosopher(0, fork[0], fork[1]);
		philosopher[1] = new Philosopher(1, fork[1], fork[2]);
		philosopher[2] = new Philosopher(2, fork[2], fork[3]);
		philosopher[3] = new Philosopher(3, fork[3], fork[4]);
		philosopher[4] = new Philosopher(4, fork[4], fork[0]);
		
		philosopher[0].start();
		philosopher[1].start();
		philosopher[2].start();
		philosopher[3].start();
		philosopher[4].start();
	}

}
