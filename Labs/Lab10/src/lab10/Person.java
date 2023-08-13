package lab10;

public abstract class Person 
{
	private String name; 
	private String address = "String";
	
	public Person() 
	{
		
	}
	
	public Person(String name) 
	{
		this.name = name;
	}

	public Person(String name, String address) 
	{
		this.name = name; this.address = address;
	}

	
	public String getName()
	{
		return this.name;
	}
	
	public String getAddress()
	{
		return this.address;
	}
	
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
}
