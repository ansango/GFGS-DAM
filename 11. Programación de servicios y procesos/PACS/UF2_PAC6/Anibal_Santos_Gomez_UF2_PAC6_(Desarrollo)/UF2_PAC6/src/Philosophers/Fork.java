package Philosophers;

public class Fork
{
	
	private boolean busy = false;
	
	Fork(int id) 
	{
		
	}
	
	synchronized void leave() 
	{
		this.busy = false;
		notify();
	}
	
	synchronized boolean isBusy()
	{
		if (this.busy) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	synchronized void take() 
	{
		this.busy = true;
	}
	
	void drop() 
	{
		this.busy = false;
	}

}
