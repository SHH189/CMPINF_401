package transit.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import transit.bus.Bus;
import transit.bus.BusRoute;
import transit.core.Route;
import transit.core.Stop;
import transit.core.Vehicle;
import transit.train.MetroRoute;
import transit.train.Train;

public class TransitGUI extends JFrame {
    public int FRAME_RATE = 60;
    private final int WIDTH = 1000;
    private final int HEIGHT = 1200;
    private Graphics g;
    Random rand = new Random();
    public DataManager dataManager = new DataManager();
    
    public int pixelsPerMile = 40;
    public int centerX = 500;
    public int centerY = 600;
    public int stopWidth = 20;
    public int stopHeight = 20;

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private boolean paused;
    
    public TransitGUI() throws InterruptedException 
    {
        paused = true;
        JPanel panel = new JPanel();
        getContentPane().add(panel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("TransitGUI");
        this.setSize(WIDTH, HEIGHT);
        this.setLayout(null);

        //Start/stop button
        this.button1 = new JButton("MAKE TIME START/STOP");
        this.button1.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                paused = !paused;
            }
        });
        this.button1.setBounds(100, 10, 200, HEIGHT / 10);
        this.add(this.button1);
        
        //Random city button
        this.button2 = new JButton("GENERATE A RANDOM CITY");
        this.button2.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	if(dataManager.getRoutes() != null)
            	{
            		dataManager.clear();
            	}
        		dataManager.randomCity();
        		repaint();
            }
        });
        this.button2.setBounds(300, 10, 200, HEIGHT / 10);
        this.add(this.button2);
        
        //Add bus route button
        this.button3 = new JButton("ADD BUS ROUTE");
        this.button3.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	dataManager.routes.add(dataManager.randomBusRoute());
            	repaint();
            }
        });
        this.button3.setBounds(500, 10, 200, HEIGHT / 10);
        this.add(this.button3);
        
        //Add metro route button
        this.button4 = new JButton("ADD METRO ROUTE");
        this.button4.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
            	dataManager.routes.add(dataManager.randomMetroRoute());
            	repaint();
            }
        });
        this.button4.setBounds(700, 10, 200, HEIGHT / 10);
        this.add(this.button4);

        this.setVisible(true);
        this.g = this.getGraphics();

        this.loop();
    }

    public void paint(Graphics g) 
    {
    	super.paint(g);
        paintGrid();
        for(Route route : dataManager.getRoutes())
        {
        	paintRoute(route, g);
        }
    }
    
    public void paintGrid()
    {
    	int gridWidth = 800;
        int gridHeight = 800;
        int cellSize = 40;
        g.setColor(Color.GRAY);
        for (int x = 0; x <= gridWidth; x += cellSize)
        {
            g.drawLine(x+100, 200, x+100, 200 + gridHeight);
        }
        for (int y = 0; y <= gridHeight; y += cellSize) 
        {
            g.drawLine(100, 200 + y, 100+gridWidth, 200 + y);
        }
    }

    public void paintRoute(Route route, Graphics g) 
    {
        Stop currentStop = route.getFirstStop();
        paintStop(currentStop, g);
        while (true) 
        {
            Stop nextStop = currentStop.getNextStop();
            if (nextStop == route.getFirstStop()) 
            {
                break;
            }
            paintStop(nextStop, g);
            currentStop = nextStop;
        }
        
        if(route instanceof BusRoute)
        {
        	BusRoute busRoute = (BusRoute) route;
        	for(Bus bus : busRoute.getBuses())
        	{
        		paintVehicle(bus, g);
        	}
        }
        else if(route instanceof MetroRoute)
        {
        	MetroRoute metroRoute = (MetroRoute) route;
        	for(Train train : metroRoute.getTrains())
        	{
        		paintVehicle(train, g);
        	}
        }
    }

    public void paintStop(Stop stop, Graphics g)
    {
    	g.setColor(Color.RED);
		g.fillRect(convertX(stop.getxCoordinate()),convertY(stop.getyCoordinate()),stopWidth,stopHeight);
		g.setColor(Color.BLACK);
		g.drawString(stop.getStopName(),convertX(stop.getxCoordinate()),convertY(stop.getyCoordinate()));
    }
    
    public void paintVehicle(Vehicle vehicle, Graphics g)
    {
    	g.setColor(Color.BLUE);
    	g.fillOval(convertX(vehicle.getxCoordinate()),convertY(vehicle.getyCoordinate()),10,10);
    	g.setFont(new Font("Arial", Font.PLAIN, 10));
    	g.drawString(vehicle.toString(),convertX(vehicle.getxCoordinate()),convertY(vehicle.getyCoordinate()));
    }

    public void update()
	{
		dataManager.update();
	}

    public void loop() throws InterruptedException 
    {
        while (true) 
        {
            if (!paused)
            {
                this.update();
                this.repaint();
            }
            TimeUnit.MILLISECONDS.sleep(25000 / FRAME_RATE);
        }
    }
    
    public int convertX(double x)
    {
    	int pixelX = (int) (x * pixelsPerMile + centerX);
    	return pixelX;
    }
    
    public int convertY(double y)
    {
    	int pixelY = (int) (-y * pixelsPerMile + centerY);
    	return pixelY;
    }

    public static void main(String[] args) throws InterruptedException 
    {
        new TransitGUI();
    }
}
