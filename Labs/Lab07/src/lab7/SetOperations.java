package lab7;

public class SetOperations 
{
	
	public static int[] makeSet(int[] data)
	{
		int j = 0;
        int i = 1;
        if(data.length < 2)
        {
            return data;
        }
        while(i < data.length)
        {
            if(data[i] == data[j])
            {
                i++;
            }
            else
            {
                data[++j] = data[i++];
            }    
        }
        int[] newData = new int[j+1];
        for(int k=0; k<newData.length; k++)
        {
            newData[k] = data[k];
        }
         
        return newData;
	}
	
	public static boolean isSet(int[] data)
	{
		for(int i=0; i<data.length; i++)
		{
			for(int j=i+1; j<data.length; j++)
			{
				if(data[i] == data[j])
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public static int[] union(int[] setA, int[] setB)
	{
		if(!(isSet(setA)) || !(isSet(setB)))
		{
			throw new IllegalArgumentException();
		} 
		else 
		{
			int[] unionSet = new int[setA.length + setB.length];	
			int num = 0;
			
			for(int s : setB)
				unionSet[num++] = s;
			for(int s : setA)
				if (!contains(setB, s))
					unionSet[num++] = s;
			int[] newArr = new int[num];
			for (int i = 0; i<num; i++)
				newArr[i] = unionSet[i];
			return newArr;
		}
	}
	
	public static boolean contains(int[] setA, int s)
	{
		for (int i : setA) 
			if (i == s)
				return true;
		return false;
	}
	
	public static int[] intersection(int[] setA, int[] setB)
	{
		if(isSet(setA) == false || isSet(setB) == false)
		{
			throw new IllegalArgumentException();
		}
		
		int count = 0;
	    boolean[] choosen = new boolean[setB.length];

	    for (int i = 0; i < setA.length; i++)
	    {
	        for (int j = 0; j < setB.length; j++)
	        {
	            if (!choosen[j] && setA[i] == setB[j])
	            {
	                choosen[j] = true;
	                count++;
	                break;
	            }
	        }
	    }

	    int[] result = new int[count];
	    count = 0;
	    for (int i = 0; i < setB.length; i++)
	    {
	        if (choosen[i])
	        {
	            result[count] = setB[i];
	            count++;
	        }
	    }

	    return result;
	}
	
	public static void main(String args[])
	{
		int[] test = {3,4,5,6,7,7,8,8,8,9,20};
		int[] newSet = makeSet(test);
		System.out.println(isSet(newSet));
		for(int i:newSet)
		{
			System.out.print(i + " ");
		}
		int[] test2 = {1,2,3,3,4,5,5,6,20};
		int[] newSet2 = makeSet(test2);		
		System.out.println(isSet(newSet2));
		int[] intersectSet = intersection(newSet, newSet2);
		for(int i:intersectSet)
		{
			System.out.print(i + " ");
		}
		int[] unionSet = union(newSet, newSet2);
		for(int i:unionSet)
		{
			System.out.print(i + " ");
		}	
	}
}

