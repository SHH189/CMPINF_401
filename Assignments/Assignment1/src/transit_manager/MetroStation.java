package transit_manager;

import java.util.Random;

public class MetroStation 
{

	String stationName;
	int stationNumber, passengersWaiting;
	double xCoordinate, yCoordinate;
	
	public MetroStation(String inStationName, int inStationNumber, double inXCoordinate, double inYCoordinate) 
	{
		stationName = inStationName; stationNumber = inStationNumber; xCoordinate = inXCoordinate; yCoordinate = inYCoordinate;
	}

	public void gainPassengers()
	{
		Random rand = new Random();
		int random = rand.nextInt(180) + 20;
		passengersWaiting += random;

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
	
	public double distance(MetroStation other)
	{
		return Math.sqrt(Math.pow((other.xCoordinate-xCoordinate), 2) + Math.pow((other.yCoordinate-yCoordinate), 2));	
	}
	
	public String toString()
	{
		return "Station #" + stationNumber + ": " + stationName + "\n" + passengersWaiting + " passengers waiting.";
	}

	public int getPassengersWaiting() 
	{
		return passengersWaiting;
	}

	public String getStationName() 
	{
		return stationName;
	}
	

}
