package com.biblioteka;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PhoneValidator {

	public Boolean validatePhoneNumber(String phoneNumber) 
	{
		Map <String,Integer> countryCodes = getPrefixes();
		phoneNumber = changePrefix(phoneNumber);
		
		if(hasOnlyNumbers(phoneNumber) && isLengthGood(phoneNumber, countryCodes)) return true;
		else return false;
	}

	public void addNumberPrefix(String prefix, int length) 
	{
		Map <String,Integer> countryCodes = getPrefixes();
		Set set = countryCodes.entrySet();
	    Iterator itr = set.iterator();  
	    while(itr.hasNext())
	    {
	    	Map.Entry codes = (Map.Entry)itr.next();
	    	if(prefix.equals(codes.getKey())) return;
	    }
	    try 
		{
			BufferedWriter w = new BufferedWriter(new FileWriter("src\\com\\biblioteka\\resources\\CountryCodes.txt", true));
			w.newLine();
			w.write(prefix + " " + length);
			w.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	Map<String, Integer> getPrefixes()
	{
		Map<String, Integer> countryCodes = new HashMap<String, Integer>();
		String s;
		
		try
		{
			BufferedReader r = new BufferedReader(new FileReader("src\\com\\biblioteka\\resources\\CountryCodes.txt"));
			while((s=r.readLine()) != null)
			{
				String[] arrstr = s.split(" ", 2);
				countryCodes.put(arrstr[0], Integer.parseInt(arrstr[1]));
			}
			r.close();
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return countryCodes;
	}
	
	boolean hasOnlyNumbers (String phoneNumber)
	{
		for(int i=0; i<phoneNumber.length(); i++)
		{
			if(Character.isLetter(phoneNumber.charAt(i))) return false;
		}
		return true;
	}
	
	String changePrefix (String phoneNumber)
	{
		String newNumber = "+370";
		if(phoneNumber.charAt(0) == '8')
		{
			return newNumber+phoneNumber.substring(1);
		}
		else return phoneNumber;
	}
	
	boolean isLengthGood (String phoneNumber, Map<String, Integer> countryCodes)
	{
		Set set = countryCodes.entrySet();
	    Iterator itr = set.iterator();  
	    while(itr.hasNext())
	    {  
	        Map.Entry codes = (Map.Entry)itr.next();
	        if(phoneNumber.contains((CharSequence) codes.getKey()))
	        {
	        	if(phoneNumber.length() == ((Integer) codes.getValue())) return true;
	        	else return false;
	        }
	    }  
		return false;
	}
}
