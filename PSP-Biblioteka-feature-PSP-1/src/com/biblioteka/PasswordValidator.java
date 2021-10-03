package com.biblioteka;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PasswordValidator {

	public Boolean validatePassword (String password)
	{	
		int length = readPasswordLength();
		List<Character> symbols = readSpecialSymbols();
		
		
		if(isLengthGood(password,length) && hasUpperCase(password,length) && hasSpecialSymbol(password,symbols)) return true;
		else return false;
	}
	
	boolean isLengthGood (String password, int length)
	{
		if(password.length()<length) return false;
		else return true;
	}
	
	boolean hasUpperCase (String password, int length)
	{
		for(int i=0; i<password.length(); i++)
		{
			if(Character.isUpperCase(password.charAt(i))) return true;
		}
		
		return false;
	}
	
	boolean hasSpecialSymbol (String password, List<Character> symbols)
	{
		for(int i=0; i<password.length(); i++)
		{
			for(int j=0; j<symbols.size(); j++)
			{
				if(symbols.get(j).equals(password.charAt(i))) return true;
			}
		}
		return false;
	}
	
	int readPasswordLength ()
	{
		int length = 0;
		try
		{
			BufferedReader r = new BufferedReader(new FileReader("src\\com\\biblioteka\\resources\\passwordLenght.txt"));
			length = Integer.parseInt(r.readLine());		
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return length;
	}

	List<Character> readSpecialSymbols()
	{
		List<Character> symbols = new ArrayList<Character>();
		String s;
		try
		{
			BufferedReader r = new BufferedReader(new FileReader("src\\com\\biblioteka\\resources\\passwordSpecialSymbols.txt"));
			while((s=r.readLine()) != null)
			{
				symbols.add(s.charAt(0));
			}	
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return symbols;
	}
}
