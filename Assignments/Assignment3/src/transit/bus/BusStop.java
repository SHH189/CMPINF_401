package transit.bus;

import java.util.Random;

import transit.core.Stop;

public class BusStop extends Stop 
{
	
	public BusStop(String name, double x, double y)
	{
		this.stopName = name; this.setxCoordinate(x); this.setyCoordinate(y); this.stopNumber = name.hashCode();
		this.setNextStop(this);
	}
	
	public void gainPassengers() 
	{
		Random rand = new Random();
		passengersWaiting += rand.nextInt(25) + 5;
	}
}
