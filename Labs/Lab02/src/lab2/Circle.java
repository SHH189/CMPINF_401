package lab2;
import javax.swing.*;
import java.lang.Math;

public class Circle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String radius = JOptionPane.showInputDialog("Enter the radius of a circle.");
		double r = Double.parseDouble(radius);
		
		double perimeter = 2*Math.PI*r;
		perimeter = perimeter*100;
		perimeter = Math.round(perimeter);
		perimeter = perimeter/100;
		
		double area = Math.PI*r*r;
		area = area*100;
		area = Math.round(area);
		area = area/100;
		
		JOptionPane.showMessageDialog(null, "The circle with radius " + r + " has a perimeter of " + perimeter + " and an area of " + area);
	}

}
