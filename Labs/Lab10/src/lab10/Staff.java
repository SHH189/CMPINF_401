package lab10;

public class Staff extends Person 
{
	private String school;
	private double pay;
	
	public Staff() 
	{
		
	}
	
	public Staff(String name, String school, double pay)
	{
		super(name);
		this.school = school; this.pay = pay;
	}
	
	public Staff(String name, String address, String school, double pay)
	{
		super(name, address);
		this.school = school; this.pay = pay;
	}
	
	public String getSchool()
	{
		return this.school;
	}
	
	public void setSchool(String school)
	{
		this.school = school;
	}
	
	public double getPay() 
	{
		return this.pay;
	}
	
	public void setPay(double pay)
	{
		this.pay = pay;
	}
	
	public String toString()
	{
		return getName() + getAddress() + school + pay;
	}
}
