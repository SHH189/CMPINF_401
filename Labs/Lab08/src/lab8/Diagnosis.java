package lab8;

public class Diagnosis
{
	int diagnosisID;
	String name;
	
	public Diagnosis(int diagnosisID, String name)
	{
		this.diagnosisID = diagnosisID; this.name = name;
	}

	public String getName() 
	{
		return this.name;
	}
}
