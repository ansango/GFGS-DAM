package Philosophers;

import java.util.Random;;

public class Philosopher extends Thread
{
	private int id;
	private int choosen;
	private Fork left;
	private Fork right;
	private boolean takeLeft;
	private boolean takeRight;
	private boolean flag;
	private Random random;
	
	public Philosopher(int id_, Fork left_, Fork right_) 
	{
		id = id_;
		left = left_;
		right = right_;
		random = new Random();
	}
	
	public void think() 
	{
		try
		{
			Thread.sleep(5000);
		}
		catch (InterruptedException iE) 
		{
		
		}
	}
	
	public void eat() 
	{
		try
		{
			System.out.println("El filósofo " + id + " se encuentra comiendo.");
			Thread.sleep(5000);
			System.out.println("está terminando de comer [...]");
			System.out.println(id);
		}
		catch (InterruptedException iE) 
		{
		
		}
	}
	
	public void run() 
	{
		while(true) // Iniciamos un bucle infinito 
		{
			this.think(); // cada filosofo piensa 5 minutos.
			flag = false;
			choosen = random.nextInt(2); //generamos un numero aleatorio entre 0 y 1 que determina las acciones
			
			if(choosen == 0) 
			{
				if(!left.isBusy()) 
				{
					left.take();
					takeLeft = true;
				}
				else if(!right.isBusy()) 
				{
					right.take();
					takeRight = true;
				}
			}
			
			else if(choosen == 1) 
			{
				if(!right.isBusy()) 
				{
					right.take();
					takeRight = true;
				}
				else if(!left.isBusy()) 
				{
					left.take();
					takeLeft = true;
				}
				if(takeLeft == true) 
				{
					if(!right.isBusy()) 
					{
						right.take();
						takeRight = true;
						flag = true;
					}
					else 
					{
						left.drop();
						takeLeft = false;
					}
				}
				if(takeRight == true && !flag) 
				{
					if(!left.isBusy()) 
					{
						left.take();
						takeLeft = true;
					}
					else
					{
						right.drop();
						takeRight = false;
					}
				}
			}
			
			if(takeRight && takeLeft) 
			{
				this.eat();
				choosen = random.nextInt(2);
				
				if(choosen == 0) 
				{
					left.drop();
					takeLeft = false;
					right.drop();
					takeRight = false;
				}
				else 
				{
					right.drop();
					takeRight = false;
					left.drop();
					takeLeft = false;
				}
			}
		}
	}
	
}
