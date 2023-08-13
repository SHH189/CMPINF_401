package lab5;

import java.util.Scanner;

public class Caesar 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner kbd = new Scanner(System.in);
		
		System.out.print("Enter a string to be encoded: ");
		String input = kbd.nextLine();
		
		System.out.print("Enter a key: ");
		int code = Integer.parseInt(kbd.nextLine());
		
		System.out.println(encrypt(input, code));
		System.out.println(decrypt(encrypt(input, code), code));
	}
	
	public static String encrypt(String plaintext, int key)
	{
		if(key < 0)
		{
			return decrypt(plaintext, Math.abs(key));
		}
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String capAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			
		String ciphertext = "";
		
		char[] chars = plaintext.toCharArray();
	    for (int i = 0; i < chars.length; i++)
	    {
	        char c = chars[i];
	        if (Character.isUpperCase(c))
	        {
	            chars[i] = Character.toLowerCase(c);
	        }
	        else if (Character.isLowerCase(c))
	        {
	            chars[i] = Character.toUpperCase(c);
	        }
	    }
	    
	    String newText = new String(chars);
	    
		for (int i = 0; i<newText.length(); i++)
		{

			if (Character.isLetter(newText.charAt(i)))
			{
				if (Character.isLowerCase(newText.charAt(i)))
				{
					int position = alphabet.indexOf(newText.charAt(i));
					int shift = (position + key) % 26;
					char newChar = alphabet.charAt(shift);
					ciphertext += newChar;
				}
				if (Character.isUpperCase(newText.charAt(i)))
				{
					int position = capAlphabet.indexOf(newText.charAt(i));
					int shift = (position + key) % 26;
					char newChar = capAlphabet.charAt(shift);
					ciphertext += newChar;
				}
			}
			else
			{
				ciphertext += plaintext.charAt(i);
			}
		}
		return ciphertext;
	}
	
	public static String decrypt(String ciphertext, int key)
	{
		if(key < 0)
		{
			return encrypt(ciphertext, Math.abs(key));
		}
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String capAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			
		String plaintext = "";
		
		char[] chars = ciphertext.toCharArray();
	    for (int i = 0; i < chars.length; i++)
	    {
	        char c = chars[i];
	        if (Character.isUpperCase(c))
	        {
	            chars[i] = Character.toLowerCase(c);
	        }
	        else if (Character.isLowerCase(c))
	        {
	            chars[i] = Character.toUpperCase(c);
	        }
	    }
		
	    String newText = new String(chars);
	    
		for (int i = 0; i<newText.length(); i++)
		{

			if (Character.isLetter(newText.charAt(i)))
			{
				if (Character.isLowerCase(newText.charAt(i)))
				{
					int position = alphabet.indexOf(newText.charAt(i));
					int shift = (position - key) % 26;
					if (shift < 0)
					{
						shift = alphabet.length() + shift;
					}
					char newChar = alphabet.charAt(shift);
					plaintext += newChar;
				}
				if (Character.isUpperCase(newText.charAt(i)))
				{
					int position = capAlphabet.indexOf(newText.charAt(i));
					int shift = (position - key) % 26;
					if (shift < 0)
					{
						shift = capAlphabet.length() + shift;
					}
					char newChar = capAlphabet.charAt(shift);
					plaintext += newChar;
				}
			}
			else
			{
				plaintext += ciphertext.charAt(i);
			}
		}
		return plaintext;
	}
}