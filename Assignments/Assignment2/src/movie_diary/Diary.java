package movie_diary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Diary 
{
	ArrayList<DiaryEntry> logs = new ArrayList<DiaryEntry>();
	String fileName;
	
	public Diary(String fileName, Library library)
	{
		this.fileName = fileName;
		try
		{
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String line;
			String headerLine = br.readLine();
			while((line = br.readLine()) != null)
			{
				String[] arr = line.split(",");
				Film film = library.getFilm(arr[0], Integer.parseInt(arr[1]));
				String[] date = arr[3].split("/");
				DiaryEntry log = new DiaryEntry(film ,Integer.parseInt(arr[2]), LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2])));
				logs.add(log);
			}
			br.close();
			fr.close();
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void logFilm(DiaryEntry log)
	{
		logs.add(log);
		try
		{
			FileWriter fw = new FileWriter(fileName);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.append(log.toCSV());
			bw.close();
			fw.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void logFilm(Film film, double rating, LocalDate date)
	{
		DiaryEntry log = new DiaryEntry(film,rating,date);
		logs.add(log);
		try
		{
			FileWriter fw = new FileWriter(fileName);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.append(log.toCSV());
			bw.close();
			fw.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void logFilm(Film film, LocalDate date)
	{
		DiaryEntry log = new DiaryEntry(film, date);
		logs.add(log);
		try
		{
			FileWriter fw = new FileWriter(fileName);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.append(log.toCSV());
			bw.close();
			fw.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void logFilm(Film film, double rating)
	{
		DiaryEntry log = new DiaryEntry(film, rating);
		logs.add(log);
		try
		{
			FileWriter fw = new FileWriter(fileName);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.append(log.toCSV());
			bw.close();
			fw.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void logFilm(Film film)
	{
		DiaryEntry log = new DiaryEntry(film);
		logs.add(log);
		try
		{
			FileWriter fw = new FileWriter(fileName);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.append(log.toCSV());
			bw.close();
			fw.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public String[] getMostLoggedDirectors()
	{
		return null;
	}
	
	public String[] getMostLoggedActors()
	{
		return null;
	}
	
	public String[] getHighestRatedDirectors()
	{
		return null;
	}
	
	public String[] getHighestRatedByReleaseYear(int year)
	{
		return null;
	}
	
	public String[] getRecentLogs()
	{
		String[] temp = new String[5];
		temp[0] = logs.get(logs.size()-1).toString();
		temp[1] = logs.get(logs.size()-2).toString();
		temp[2] = logs.get(logs.size()-3).toString();
		temp[3] = logs.get(logs.size()-4).toString();
		temp[4] = logs.get(logs.size()-5).toString();
		return temp;
	}
}
