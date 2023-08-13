package transit_manager;

import java.util.Random;

public class BusStop 
{
	
	String stopName;
	int stopNumber; 
	int passengersWaiting = 0;
	double xCoordinate, yCoordinate;
	
	public BusStop(String inStopName, int inStopNumber, double inXCoordinate, double inYCoordinate) 
	{
		stopName = inStopName; stopNumber = inStopNumber; xCoordinate = inXCoordinate; yCoordinate = inYCoordinate;
	}

	public void gainPassengers()
	{
		Random rand = new Random();
		int random = rand.nextInt(25) + 5;
		passengersWaiting = random;
	}
	
	public boolean losePassengers(int numPassengers)
	{
		if (passengersWaiting - numPassengers < 0)
		{
			return false;
		}
		else
		{
			passengersWaiting -= numPassengers;
			return true;
		}
	}
	
	public double distance(BusStop other)
	{
		return Math.sqrt(Math.pow((other.xCoordinate-xCoordinate), 2) + Math.pow((other.yCoordinate-yCoordinate), 2));
	}
	
	public String toString()
	{
		return "Stop #" + stopNumber + ": " + stopName + "\n" + passengersWaiting + " passengers waiting.";
	}

	public int getPassengersWaiting() 
	{
		return passengersWaiting;
	}

	public String getStopName() 
	{
		return stopName;
	}
}
