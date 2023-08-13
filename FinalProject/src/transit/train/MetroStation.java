package transit.train;

import java.util.Random;

import transit.core.Stop;

public class MetroStation extends Stop
{
	public MetroStation(String name, double x, double y)
	{
		this.stopName = name; this.setxCoordinate(x); this.setyCoordinate(y); stopNumber = name.hashCode();
		this.setNextStop(this);
	}
	
	public void gainPassengers() 
	{
		Random rand = new Random();
		passengersWaiting += rand.nextInt(195) + 5;
	}

}
