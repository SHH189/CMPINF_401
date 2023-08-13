package movie_diary;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class DiaryEntry 
{
	Film film;
	double rating;
	LocalDate date;
	
	public DiaryEntry(Film film)
	{
		this.film = film; this.rating = -1; date = LocalDate.now();
	}
	
	public DiaryEntry(Film film, double rating)
	{
		this.film = film; date = LocalDate.now();
		
		if(rating==0||rating==0.5||rating==1||rating==1.5||rating==2||rating==2.5||rating==3||rating==3.5||rating==4||rating==4.5||rating==5||rating==-1)
		{
			this.rating = rating;
		}
		else
		{
			throw new IllegalStateException();
		}
			
	}
	
	public DiaryEntry(Film film, LocalDate date)
	{
		this.film = film; this.date = date; this.rating = -1;
	}
	
	public DiaryEntry(Film film, double rating, LocalDate date)
	{
		this.film = film; this.date = date;
		
		if(rating==0||rating==0.5||rating==1||rating==1.5||rating==2||rating==2.5||rating==3||rating==3.5||rating==4||rating==4.5||rating==5||rating==-1)
		{
			this.rating = rating;
		}
		else
		{
			throw new IllegalStateException();
		}
	}
	
	public String toString()
	{
		return film.getFilmName() + " (" + film.getReleaseYear() + "), rated "  + rating + " on " + date;
	}
	
	public String toCSV()
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		return film.getFilmName() + "," + film.getReleaseYear() + "," + rating + "," + formatter.format(date) + "\n";
	}
}
