package transit.train;

import transit.core.Route;
import transit.core.Vehicle;

public class Train extends Vehicle 
{
	private int cars;
	
	public Train(String driver, double sp, int cars, MetroRoute rt, MetroStation stop)
	{
		this.driverName = driver; this.speed = sp; this.cars = cars; this.route = rt; this.setDestination(stop); this.identifier = Integer.toString(driver.hashCode()); this.isStopped = true;
	}
	
	public Train(String driver, double sp, int cars, MetroRoute rt)
	{
		this.driverName = driver; this.speed = sp; this.cars = cars; this.route = rt; this.setDestination(rt.getFirstStop()); this.identifier = Integer.toString(driver.hashCode()); this.isStopped = true;
	}
	
	public int getCapacity()
	{
		return cars * 120;
	}
	
	public String toString()
	{
		if(isStopped)
		{
			return "Train " + getIdentifier() + " (" + getDriverName() + ") travelling on route #" + getRoute().getRouteNumber() + "\nCurrently stopped at " + getDestination().getStopName() + "\nat location (" + getDestination().getxCoordinate() + ", " + getDestination().getyCoordinate() + ") \n" + getPassengers() + " seats taken out of " + getCapacity();
		}
		else
		{
			return "Train " + getIdentifier() + " (" + getDriverName() + ") " + "travelling on route #" + getRoute().getRouteNumber() + "\nMoving towards " + getDestination().getStopName() + "\nat location (" + getxCoordinate() + ", " + getyCoordinate() + ") \n" + getPassengers() + " seats taken out of " + getCapacity();
		}
	}

	public double move(int minutes)
	{
		double totalDistance = 0.0; 
		double speedMpm = speed/60;
		
		 if (isStopped) 
		    {
		        letPassengersOn();
		        isStopped = false;
		        setDestination(getDestination().getNextStop());
		    }
		
		    double distanceMoved = speedMpm * minutes;
		    double distanceToDestination = Math.hypot((getDestination().getxCoordinate() - getxCoordinate()), (getDestination().getyCoordinate() - getyCoordinate()));
		    
		    
		    if (distanceMoved >= distanceToDestination)
		    {
		        setxCoordinate(getDestination().getxCoordinate());
		        setyCoordinate(getDestination().getyCoordinate());
		        letPassengersOff();
		        isStopped = true;
		        totalDistance += distanceToDestination;
		    } 
		    else 
		    {
		        double deltaX = (getDestination().getxCoordinate() - getxCoordinate()) / distanceToDestination;
		        double deltaY = (getDestination().getyCoordinate() - getyCoordinate()) / distanceToDestination;
		        double newX = getxCoordinate() + distanceMoved * deltaX;
		        double newY = getyCoordinate() + distanceMoved * deltaY;
		        setxCoordinate(newX);
		        setyCoordinate(newY);
		        totalDistance += distanceMoved;
		    }
		return totalDistance;
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
