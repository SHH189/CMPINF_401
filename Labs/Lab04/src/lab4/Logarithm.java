package lab4;

import java.util.Scanner;

public class Logarithm
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner kbd = new Scanner(System.in);
		
		int value = 0, base = 0; 
		boolean isValid = false;
		
		while(!isValid)
		{
			System.out.println("Enter a value (x)");
			String inValue = kbd.nextLine();
			System.out.println("Enter a base (b)");
			String inBase = kbd.nextLine();
		
			try 
			{
				value = Integer.parseInt(inValue);
				base = Integer.parseInt(inBase);
				
				if (value > 0 && base > 1)
				{
					isValid = true;
				}
			} 
			catch (NumberFormatException e)
			{
				System.out.println("That was not valid input.\n" + "x must be an integer > 0\n"+ "b must be an integer > 1\n");
			}
		}
		
		if (value > 0 && base > 1)
		{
			int result = value;
			int count = 0;
			while (result >= base)
			{
				count++;
				result /= base;
			}
			System.out.println("Log base " + base + " of " + value + " is about " + count);
		}
	
	}
}
