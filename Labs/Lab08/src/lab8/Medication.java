package lab8;

public class Medication 
{
	int medicationID;
	String name;
	
	public Medication(int medicationID, String name)
	{
		this.medicationID = medicationID; this.name = name;
	}

	public String getName() 
	{
		return this.name;
	}
}
