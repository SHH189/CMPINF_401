package transit.bus;

import java.util.ArrayList;

import transit.core.Route;
import transit.core.Stop;

public class BusRoute extends Route 
{
	private ArrayList<Bus> buses = new ArrayList<Bus>();
	
	public BusRoute(int routeNum, String routeDesc, BusStop first)
	{
		this.routeNumber = routeNum; this.routeDescription = routeDesc; this.setFirstStop(first); this.getFirstStop().setNextStop(this.getFirstStop()); 
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
	    sb.append("Route: #").append(getRouteNumber()).append(": ").append(getRouteDescription()).append("\n");

	    sb.append("Stops:\n");
	    Stop currentStop = getFirstStop();
	    do 
	    {
	        sb.append(currentStop).append("\n");
	        currentStop = currentStop.getNextStop();
	    } 
	    while (currentStop != getFirstStop());

	    sb.append("Buses:\n");
	    for (Bus bus : getBuses()) 
	    {
	        sb.append(bus).append("\n");
	    }

	    return sb.toString();
	}

	public void addDriver(String name, double speed) 
	{
		Bus newBus = new Bus(name, speed, this);
		buses.add(newBus);
	}

	public void addStop(String stopName, double x, double y) 
	{
		BusStop newStop = new BusStop(stopName, x, y);
		BusStop currentStop = (BusStop) getFirstStop();
		while(currentStop.getNextStop() != getFirstStop())
		{
			currentStop = (BusStop) currentStop.getNextStop();
		}
		newStop.setNextStop(getFirstStop());
		currentStop.setNextStop(newStop);
	}

	public void moveAll(int minutes) 
	{
		for(Bus bus : getBuses())
		{
			bus.move(minutes);
		}
	}
	
	public ArrayList<Bus> getBuses() 
	{
		return this.buses;
	}
}
