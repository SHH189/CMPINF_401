package transit.core;

public abstract class Route 
{
	protected int routeNumber;
	protected String routeDescription;
	public Stop firstStop;
	
	public void gainPassengersAll()
	{
		Stop currentStop = firstStop;
		do
		{
			currentStop.gainPassengers();
			currentStop = currentStop.getNextStop();
		}
		while(currentStop != firstStop);
	}
	
	public abstract void addDriver(String name, double speed);
	
	public abstract void addStop(String stopName, double x, double y);
	
	public abstract void moveAll(int minutes);

	public Stop getFirstStop() 
	{
		return this.firstStop;
	}

	public void setFirstStop(Stop firstStop) 
	{
		this.firstStop = firstStop;
	}

	public int getRouteNumber() 
	{
		return this.routeNumber;
	}
	
	public String getRouteDescription() 
	{
		return this.routeDescription;
	}
}
