package transit.gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import transit.bus.BusRoute;
import transit.bus.BusStop;
import transit.core.Route;
import transit.train.MetroRoute;
import transit.train.MetroStation;

public class DataManager 
{
	public ArrayList<Route> routes = new ArrayList<Route>();
	
	public static final List<String> PREFIXES = Arrays.asList("University", "Parkside", "Harbor", "Skyline", "Meadow", "Grand", "Union", "City", "Metropolitan", "International");
    public static final List<String> SUFFIXES = Arrays.asList("Station", "Terminal", "Depot", "Junction", "Crossing", "Transfer", "Hub", "Plaza", "Exchange", "Yard");
	
	public void update()
	{
		for(Route route : routes)
		{
			route.moveAll(1);
		}
	}
	
	public void clear()
	{
		routes.clear();
	}
	
	public void randomCity()
	{
		routes.add(randomBusRoute());
		routes.add(randomBusRoute());
		routes.add(randomBusRoute());
		routes.add(randomMetroRoute());
		routes.add(randomMetroRoute());
		routes.add(randomMetroRoute());
	}
	
	public BusRoute randomBusRoute()
	{
	    // random items to be passed in constructors
	    Random rand = new Random();
	    String[] routeDescs = {"Express route to the suburbs with limited stops", "Scenic circular route through the city's parks and attractions", "Rapid route with express service between major business districts", "Connector route to multiple bus and rail lines", "Route to all of the city's top attractions", "Express route for commuters between residential areas and major employment centers", "Flexible shuttle service connecting shopping and entertainment districts", "Connector route to airports, train stations, and bus terminals", "Vintage trolley through historic districts and shopping areas", "Route through diverse neighborhoods and cultural centers"};
	    String[] driverNames = {"Veronica", "Jamal", "Olivia", "Miguel", "Lily", "Rashid", "Emily", "Jose", "Simone", "Tyler"};
	    
	    // create random route with 3 random stops
	    BusStop stop1 = new BusStop(generateRandomStopNames(), rand.nextInt(21) - 10, rand.nextInt(21) - 10);
	    BusRoute randBusRoute = new BusRoute(rand.nextInt(99)+1, routeDescs[rand.nextInt(routeDescs.length-1)], stop1);
	    BusStop stop2 = new BusStop(generateRandomStopNames(), rand.nextInt(21) - 10 , rand.nextInt(21) - 10);
	    while(stop2.getxCoordinate() == stop1.getxCoordinate() && stop2.getyCoordinate() == stop1.getyCoordinate()) 
	    {
	        stop2 = new BusStop(generateRandomStopNames(), rand.nextInt(21) - 10 , rand.nextInt(21) - 10);
	    }
	    randBusRoute.addStop(stop2.getStopName(), stop2.getxCoordinate(), stop2.getyCoordinate());
	    BusStop stop3 = new BusStop(generateRandomStopNames(), rand.nextInt(21) - 10, rand.nextInt(21) - 10);
	    while((stop3.getxCoordinate() == stop1.getxCoordinate() && stop3.getyCoordinate() == stop1.getyCoordinate()) || (stop3.getxCoordinate() == stop2.getxCoordinate() && stop3.getyCoordinate() == stop2.getyCoordinate())) 
	    {
	        stop3 = new BusStop(generateRandomStopNames(), rand.nextInt(21) - 10, rand.nextInt(21) - 10);
	    }
	    randBusRoute.addStop(stop3.getStopName(), stop3.getxCoordinate(), stop3.getyCoordinate());

	    // add random driver
	    randBusRoute.addDriver(driverNames[rand.nextInt(driverNames.length-1)], rand.nextInt(21)+10);
	    randBusRoute.addDriver(driverNames[rand.nextInt(driverNames.length-1)], rand.nextInt(41)+20);
	    
	    return randBusRoute;
	}


	
	public MetroRoute randomMetroRoute()
	{
		//random items
		Random rand = new Random();
		String[] routeDescs = {"Line through major business districts and tourist attractions", "Line through shopping districts and residential areas", "Line through suburbs and commuter parking lots", "Line through downtown core and government buildings", "Line with limited stops to the airport", "Line through beaches and parks", "Line connecting major universities and research centers", "Line with express service between major city centers", "Express Line for speedy commute between suburbs and downtown core", "Tourist Line through museums, galleries, and historic landmarks"};
		String[] driverNames = {"Sarah", "Jason", "Rebecca", "Omar", "Julia", "Ryan", "Rachel", "Benjamin", "Laura", "Carlos"};
		
		//create random route with three stops
		MetroStation stop1 = new MetroStation(generateRandomStopNames(), rand.nextInt(21) - 10, rand.nextInt(21) - 10);
	    MetroRoute randMetroRoute = new MetroRoute(rand.nextInt(99)+1, routeDescs[rand.nextInt(routeDescs.length-1)], stop1);
	    MetroStation stop2 = new MetroStation(generateRandomStopNames(), rand.nextInt(21) - 10, rand.nextInt(21) - 10);
	    while(stop2.getxCoordinate() == stop1.getxCoordinate() && stop2.getyCoordinate() == stop1.getyCoordinate())
	    {
	        stop2 = new MetroStation(generateRandomStopNames(), rand.nextInt(21) - 10, rand.nextInt(21) - 10);
	    }
	    randMetroRoute.addStop(stop2.getStopName(), stop2.getxCoordinate(), stop2.getyCoordinate());
	    MetroStation stop3 = new MetroStation(generateRandomStopNames(), rand.nextInt(21) - 10, rand.nextInt(21) - 10);
	    while((stop3.getxCoordinate() == stop1.getxCoordinate() && stop3.getyCoordinate() == stop1.getyCoordinate()) || (stop3.getxCoordinate() == stop2.getxCoordinate() && stop3.getyCoordinate() == stop2.getyCoordinate()))
	    {
	        stop3 = new MetroStation(generateRandomStopNames(), rand.nextInt(21) - 10 , rand.nextInt(21) - 10);
	    }
	    randMetroRoute.addStop(stop3.getStopName(), stop3.getxCoordinate(), stop3.getyCoordinate());

	    // add random driver
	    randMetroRoute.addDriver(driverNames[rand.nextInt(driverNames.length-1)], rand.nextInt(21)+10);
	    randMetroRoute.addDriver(driverNames[rand.nextInt(driverNames.length-1)], rand.nextInt(41)+20);
	    
	    return randMetroRoute;
	}
	
	public static String generateRandomStopNames() 
	{
        Random rand = new Random();
        String prefix = PREFIXES.get(rand.nextInt(PREFIXES.size()));
        String suffix = SUFFIXES.get(rand.nextInt(SUFFIXES.size()));
        String stopName = prefix + " " + suffix;
        return stopName;
    }
	
	public ArrayList<Route> getRoutes()
	{
		return routes;
	}
}
