package transit_manager;

public class Train 
{

	String trainIdentifier, conductorName;
	int cars, passengers;
	double speed;
	MetroRoute route;
	MetroStation currentStation;
	
	public Train(String inTrainIdentifier, String inConductorName, int inSpeed, int inCars, MetroRoute inRoute) 
	{
		trainIdentifier = inTrainIdentifier; conductorName = inConductorName; speed = inSpeed; cars = inCars; route = inRoute; currentStation = route.firstStop;
	}

	public void thankTheConductor()
	{
		System.out.print("Thanks " + conductorName + "!\n");
	}
	
	public int calculateCapacity()
	{
		int capacity = cars*120;
		return capacity;
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
		while (passengers < calculateCapacity() && currentStation.passengersWaiting > 0)
		{
			passengers += 1;
			currentStation.passengersWaiting -= 1;
			count += 1;
		}
		return count;
	}
	
	public double moveToNextStation()
	{
		if (currentStation == route.firstStop)
		{
			currentStation = route.lastStop;
		} 
		else
		{
			currentStation = route.firstStop;
		}
		double time = (route.calculateDistance()/speed) * 60;
		return time;
	}
	
	public String toString()
	{
		return "Train " + trainIdentifier + " (" + conductorName + ")" + " travelling on route #" + route.routeNumber + "\nCurrently stopped at " + route.firstStop.stationName + "\n" + passengers + " seats taken out of " + calculateCapacity();
	}

	public String getTrainIdentifier() 
	{
		return trainIdentifier;
	}

}
