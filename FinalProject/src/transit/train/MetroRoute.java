package transit.train;

import java.util.ArrayList;

import transit.core.Route;
import transit.core.Stop;

public class MetroRoute extends Route 
{
	private ArrayList<Train> trains = new ArrayList<Train>();
	
	public MetroRoute(int routeNum, String routeDesc, MetroStation first) 
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

	    sb.append("Trains:\n");
	    for (Train train : getTrains()) 
	    {
	        sb.append(train).append("\n");
	    }

	    return sb.toString();
	}

	public void addDriver(String name, double speed) 
	{
		Train newTrain = new Train(name, speed, 3, this);
		trains.add(newTrain);
	}

	public void addStop(String stopName, double x, double y) 
	{
		MetroStation newStop = new MetroStation(stopName, x, y);
		MetroStation currentStop = (MetroStation) getFirstStop();
		while(currentStop.getNextStop() != getFirstStop())
		{
			currentStop = (MetroStation) currentStop.getNextStop();
		}
		currentStop.setNextStop(newStop);
		newStop.setNextStop(getFirstStop());
	}

	public void moveAll(int minutes) 
	{
		for(Train train : getTrains())
		{
			train.move(minutes);
		}
	}
	
	public ArrayList<Train> getTrains() 
	{
		return this.trains;
	}
}
