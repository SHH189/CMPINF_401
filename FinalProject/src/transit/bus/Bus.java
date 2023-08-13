package transit.bus;

import transit.core.Route;
import transit.core.Vehicle;

public class Bus extends Vehicle 
{
	private int capacity;
	
	public Bus(String driver, double sp, BusRoute rt, BusStop stop)
	{
		this.driverName = driver; this.speed = sp; this.route = rt; this.setDestination(stop); this.identifier = Integer.toString(driver.hashCode()); this.isStopped = true; this.capacity = 35;
	}
	
	public Bus(String driver, double sp, BusRoute rt)
	{
		this.driverName = driver; this.speed = sp; this.route = rt; this.setDestination(rt.getFirstStop()); this.identifier = Integer.toString(driver.hashCode()); this.isStopped = true; this.capacity = 35;
	}
	
	public int getCapacity() 
	{
		return this.capacity;
	}
	
	public String toString()
	{
		return "Bus " + getIdentifier() + " (" + getDriverName() + ") Route: " + getRoute().getRouteNumber();
	}
	
	public double move(int minutes)
	{
		double distanceTraveled = 0.0;
		double speedMpm = speed/60;

	    if (isStopped) 
	    {
	        letPassengersOn();
	        isStopped = false;
	        setDestination(getDestination().getNextStop());	    
	    }

	    double remainingTime = minutes;
	    while (remainingTime > 0 && getxCoordinate() != destination.getxCoordinate()) 
	    {
	        double distanceX = Math.min(Math.abs(getxCoordinate() - destination.getxCoordinate()), speedMpm * remainingTime);
	        distanceTraveled += distanceX;
	        remainingTime -= distanceX / speedMpm;
	        if (getxCoordinate() < destination.getxCoordinate()) 
	        {
	            xCoordinate += distanceX;
	        } 
	        else 
	        {
	            xCoordinate -= distanceX;
	        }
	    }

	    while (remainingTime > 0 && getyCoordinate() != destination.getyCoordinate()) 
	    {
	        double distanceY = Math.min(Math.abs(getyCoordinate() - destination.getyCoordinate()), speedMpm * remainingTime);
	        distanceTraveled += distanceY;
	        remainingTime -= distanceY / speedMpm;
	        if (getyCoordinate() < destination.getyCoordinate()) 
	        {
	            yCoordinate += distanceY;
	        } 
	        else 
	        {
	            yCoordinate -= distanceY;
	        }
	    }

	    if (getxCoordinate() == destination.getxCoordinate() && getyCoordinate() == destination.getyCoordinate()) 
	    {
	        isStopped = true;
	        letPassengersOff();
	    }
	    return distanceTraveled;
	}
	
	public String getDriverName() 
	{
		return this.driverName;
	}

	public String getIdentifier() 
	{
		return this.identifier;
	}
	
	public Route getRoute() 
	{
		return this.route;
	}
	
	public int getPassengers() 
	{
		return this.passengers;
	}
}
