package transit.core;

public abstract class Vehicle 
{
	protected String identifier, driverName;
	protected int passengers;
	protected double speed, xCoordinate, yCoordinate;
	protected Route route; 
	public Stop destination; 
	protected boolean isStopped;
	
	public void thankTheDriver()
	{
		System.out.print("Thanks " + driverName + "!\n");
	}
	
	public int letPassengersOff()
	{
		int numPassengers = passengers;
	    int numPassengersOff = (int) (Math.random() * (numPassengers + 1));
	    passengers -= numPassengersOff;
	    return numPassengersOff;
	}
	
	public int letPassengersOn()
	{
		int count = 0;
		while (passengers < getCapacity() && destination.getPassengersWaiting() > 0)
		{
			passengers += 1;
			destination.passengersWaiting -= 1;
			count += 1;
		}
		return count;
	}

	public abstract double move(int minutes);
	
	public abstract int getCapacity();

	public Stop getDestination() 
	{
		return this.destination;
	}

	public void setDestination(Stop destination) 
	{
		this.destination = destination;
	}
	
	public double getxCoordinate()
	{
		return this.xCoordinate;
	}
	
	public void setxCoordinate(double x) 
	{
		this.xCoordinate = x;
	}
	
	public double getyCoordinate()
	{
		return this.yCoordinate;
	}
	
	public void setyCoordinate(double y)
	{
		this.yCoordinate = y;
	}
	
	public boolean getIsStopped() 
	{
		return this.isStopped;
	}
	
	public void setIsStopped(boolean tf)
	{
		this.isStopped = tf;
	}
}
