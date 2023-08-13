package transit_manager;

public class MetroRoute 
{

	int routeNumber;
	String routeDescription;
	MetroStation firstStop, lastStop;
	
	public MetroRoute(int inRouteNumber, String inRouteDescription, MetroStation inFirstStop, MetroStation inLastStop) 
	{
		routeNumber = inRouteNumber; routeDescription = inRouteDescription; firstStop = inFirstStop; lastStop = inLastStop;
	}

	public double calculateDistance()
	{
		return Math.sqrt(Math.pow((lastStop.xCoordinate-firstStop.xCoordinate), 2) + Math.pow((lastStop.yCoordinate-firstStop.yCoordinate), 2));
	}
	
	public String toString()
	{
		return "Metro Route #" + routeNumber + ": " + routeDescription;
	}
}
