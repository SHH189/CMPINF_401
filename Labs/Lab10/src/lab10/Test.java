package lab10;

public class Test 
{
	public static void main(String[] args)
	{
		Cylinder cyl = new Cylinder(5.0, 1.0, "Green");
		System.out.println(cyl.getVolume());
		
		Staff staff = new Staff("Peter Griffin", "1234 Spooner St", "Pitt", 50000); 
		System.out.println(staff.toString());
	}
}
