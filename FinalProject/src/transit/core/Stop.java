package transit.core;

public abstract class Stop 
{
	protected String stopName;
	protected int stopNumber, passengersWaiting;
	private double xCoordinate;
	private double yCoordinate;
	public Stop nextStop; 
	
	public boolean losePassengers(int numPassengers)
	{
		if (passengersWaiting - numPassengers > 0)
		{
			passengersWaiting -= numPassengers;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public String toString()
	{
		return "Stop #" + getStopNumber() + ": " + getStopName() + "\n" + getPassengersWaiting() + " passengers waiting.\n";
	}

	public abstract void gainPassengers();
	
	public int getPassengersWaiting()
	{
		return this.passengersWaiting;
	}

	public Stop getNextStop() 
	{
		return this.nextStop;
	}

	public void setNextStop(Stop nextStop) 
	{
		this.nextStop = nextStop;
	}

	public double getyCoordinate() 
	{
		return this.yCoordinate;
	}

	public void setyCoordinate(double yCoordinate)
	{
		this.yCoordinate = yCoordinate;
	}
	
	public double getxCoordinate() 
	{
		return this.xCoordinate;
	}

	public void setxCoordinate(double xCoordinate) 
	{
		this.xCoordinate = xCoordinate;
	}
	
	public int getStopNumber() 
	{
		return this.stopNumber;
	}

	public String getStopName() 
	{
		return this.stopName;
	}
}
