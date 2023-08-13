package movie_diary;

public class Film 
{
	String filmName, director;
	int year, runtime;
	String[] actors;
	
	public Film(String filmName, int year, int runtime)
	{
		this.filmName = filmName; this.director = "Alan Smithee";
		
		if(runtime > 0)
		{
			this.runtime = runtime;
		}
		else
		{
			throw new IllegalStateException();
		}
		
		if(year > 1880)
		{
			this.year = year;
		}
		else
		{
			throw new IllegalStateException();
		}
	}
	
	public Film(String filmName, int year, int runtime, String director)
	{
		this.filmName = filmName; this.director = director;
		
		if(runtime > 0)
		{
			this.runtime = runtime;
		}
		else
		{
			throw new IllegalStateException();
		}
		
		if(year > 1880)
		{
			this.year = year;
		}
		else
		{
			throw new IllegalStateException();
		}
	}
	
	public String getFormattedRuntime()
	{
		int hours = runtime/60;
		int minutes = runtime%60;
		return hours + " hours" + minutes + " minutes";
	}
	
	public void addActor(String actorName)
	{
		int len = actors.length;
		String[] temp = new String[len+1];
		for(int i=0; i<len; i++)
		{
			temp[i] = actors[i];
		}
		temp[len] = actorName;
		actors = temp;
	}
	
	public String toString()
	{
		return filmName + " (" + year + ") " + "directed by " + director + ", " + getFormattedRuntime();
	}
	
	public int getReleaseYear()
	{
		return this.year;
	}
	
	public String getFilmName()
	{
		return this.filmName;
	}
}
