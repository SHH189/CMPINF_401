package lab2;
import javax.swing.*;

public class Money {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String money = JOptionPane.showInputDialog("Enter an amount of money from 1 to 9999 dollars");
		int dollarAmount = Integer.parseInt(money);
		
		int grands = dollarAmount/1000;
		int Benjamins = (dollarAmount%1000)/100;
		int sawbucks = (dollarAmount%100)/10;
		int bucks = dollarAmount%10;
		
		JOptionPane.showMessageDialog(null, grands + " grands " + Benjamins + " Benjamins " + sawbucks + " sawbucks " + bucks + " bucks");
	}

}
