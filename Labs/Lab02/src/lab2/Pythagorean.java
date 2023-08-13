package lab2;
import javax.swing.*;
import java.lang.Math;

public class Pythagorean {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String firstNumber = JOptionPane.showInputDialog("Please enter your first number:");
		String secondNumber = JOptionPane.showInputDialog("Please enter your second number:");
		
		int a = Integer.parseInt(firstNumber);
		int b = Integer.parseInt(secondNumber);
		
		double c = Math.sqrt(a*a + b*b);
		c = c*100;
		c = Math.round(c);
		c = c/100;
		
		JOptionPane.showMessageDialog(null, "The hypotenuse is " + c);
	}

}
