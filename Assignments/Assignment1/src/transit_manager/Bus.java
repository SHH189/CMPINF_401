package transit_manager;

public class Bus 
{
		
	String busIdentifier, driverName;
	int capacity = 30;
	int passengers = 0;
	double speed;		
	BusRoute route;
	BusStop currentStop;
		
	public Bus(String inBusIdentifier, String inDriverName, double inSpeed, BusRoute inRoute) 
	{
		busIdentifier = inBusIdentifier; driverName = inDriverName; speed = inSpeed; route = inRoute; currentStop = route.firstStop;
	}

	public void thankTheDriver()
	{
		System.out.print("Thanks " + driverName + "!\n");
	}
	
	public int letPassengersOff()
	{
		int passengersOff = passengers;
		passengers -= passengersOff;
		return passengersOff;
	}
	
	public int letPassengersOn()
	{
		int count = 0;
		while (passengers < capacity && currentStop.passengersWaiting > 0)
		{
			passengers += 1;
			currentStop.passengersWaiting -= 1;
			count += 1;
		}
		return count;
	}
	
	public double moveToNextStop()
	{
		if (currentStop == route.firstStop)
		{
			currentStop = route.lastStop;
		} 
		else
		{
			currentStop = route.firstStop;
		}
		double time = (route.calculateDistance()/speed) * 60;
		return time;
	}
	
	public String toString()
	{
		return "Bus " + busIdentifier + " (" + driverName + ")" + " travelling on route #" + route.routeNumber + "\nCurrently stopped at " + route.firstStop.stopName + "\n" + passengers + " seats taken out of 30";
	}

	public String getBusIdentifier()
	{
		return busIdentifier;
	}
}
