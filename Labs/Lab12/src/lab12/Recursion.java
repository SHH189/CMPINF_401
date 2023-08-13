package lab12;

public class Recursion 
{
	public static int productOfDigits(int x) 
	{
		if (x < 0)
		{
			x = Math.abs(x);
		}
		
	    if (x < 10) 
	    {
	        return x;
	    } 
	    else 
	    {
	        return productOfDigits(x/10) * (x%10);
	    }
	}
	
	public static String arrayToString(int[] a, int index) 
	{
	    if (index == a.length - 1) 
	    {
	        return Integer.toString(a[index]);
	    } 
	    else 
	    {
	        return a[index] + ", " + arrayToString(a, index + 1);
	    }
	}
	
	public static int log(int base, int value) 
	{
	    if (value < base) 
	    {
	        return 0;
	    } 
	    else 
	    {
	        return 1 + log(base, value / base);
	    }
	}
}
