package transit_manager;

public class BusRoute 
{
	
	int routeNumber;
	String routeDescription;
	BusStop firstStop, lastStop;
	
	public BusRoute(int inRouteNumber, String inRouteDescription, BusStop inFirstStop, BusStop inLastStop) 
	{
		routeNumber = inRouteNumber; routeDescription = inRouteDescription; firstStop = inFirstStop; lastStop = inLastStop;
	}

	public double calculateDistance()
	{
		return Math.sqrt(Math.pow((lastStop.xCoordinate-firstStop.xCoordinate), 2) + Math.pow((lastStop.yCoordinate-firstStop.yCoordinate), 2));
	}
	
	public String toString()
	{
		return "Bus Route #" + routeNumber + ": " + routeDescription;
	}
}
