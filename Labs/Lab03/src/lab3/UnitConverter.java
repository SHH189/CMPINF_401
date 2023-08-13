package lab3;

import java.util.Scanner;

public class UnitConverter 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner kbd = new Scanner(System.in);
		System.out.print("Input a weight or distance amount:");
		String s = kbd.nextLine();
		
		String[] parts = s.split(" ");
		
		double value = Double.parseDouble(parts[0]);
		String unit = parts[1];
		
		if (unit.equals("cm")) 
		{
			value = value/2.54;
			value = value*100;
			value = Math.round(value);
			value = value/100;
			System.out.println(s + " = " + value + " in");
		} 
		else if (unit.equals("in"))
		{
			value = value*2.54;
			value = value*100;
			value = Math.round(value);
			value = value/100;
			System.out.println(s + " = " + value + " cm");
		}
		else if (unit.equals("m"))
		{
			value = value/0.9144;
			value = value*100;
			value = Math.round(value);
			value = value/100;
			System.out.println(s + " = " + value + " yd");
		}
		else if (unit.equals("yd"))
		{
			value = value*0.9144;
			value = value*100;
			value = Math.round(value);
			value = value/100;
			System.out.println(s + " = " + value + " m");
		}
		else if (unit.equals("oz"))
		{
			value = value*28.349523125;
			value = value*100;
			value = Math.round(value);
			value = value/100;
			System.out.println(s + " = " + value + " g");
		}
		else if (unit.equals("g"))
		{
			value = value/28.349523125;
			value = value*100;
			value = Math.round(value);
			value = value/100;
			System.out.println(s + " = " + value + " oz");
		}
		else if (unit.equals("kg"))
		{
			value = value/0.45359237;
			value = value*100;
			value = Math.round(value);
			value = value/100;
			System.out.println(s + " = " + value + " lb");
		}
		else if (unit.equals("lb"))
		{
			value = value*0.45359237;
			value = value*100;
			value = Math.round(value);
			value = value/100;
			System.out.println(s + " = " + value + " kg");
		}
	}

}
