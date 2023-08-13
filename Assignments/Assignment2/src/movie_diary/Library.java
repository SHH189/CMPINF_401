package movie_diary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Library 
{
	ArrayList<Film> films = new ArrayList<Film>();
	
	public Library(String fileName)
	{
		try
		{
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String line;
			String headerLine = br.readLine();
			while((line = br.readLine()) != null)
			{
				String[] arr = line.split(",");
				try
				{
					Film film = new Film(arr[0],Integer.parseInt(arr[1]), Integer.parseInt(arr[3]), arr[2]);
					films.add(film);
				}
				catch(IllegalStateException e)
				{
					System.out.println(e.getMessage());
				}
			}
			br.close();
			fr.close();
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	public Film getFilm(String name, int year)
	{
		for(Film film : films)
		{
			if(film.getFilmName().equals(name) && film.getReleaseYear() == year)
			{
				return film;
			}
		}
		return null;
	}
}
