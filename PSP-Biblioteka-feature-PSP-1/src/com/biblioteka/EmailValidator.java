package com.biblioteka;

public class EmailValidator {

	public Boolean validateEmail(String email)
	{
		if(hasAtSign(email) && hasNoInvalidChars(email) && hasGoodTLD(email) && hasGoodDomain(email)) return true;
		else return false;
	}

	boolean hasGoodTLD (String email)
	{
		String[] cutAt = email.split("\\@");
        String emailWithoutLocalName = cutAt[1];
        
        if(!emailWithoutLocalName.contains(".")) return false;
        else
        {
	        String[] cutDot = emailWithoutLocalName.split("\\.");
	        
	        String tld = cutDot[cutDot.length-1];
	        if(tld == null || tld == " " || tld.length() == 0) return false;
	        else
	        {
	    		int validSymbols = 0;
	
	    		for(int i=0; i<tld.length(); i++)
	    		{
	    			if(tld.charAt(i) >= 'a' && tld.charAt(i) <= 'z' ||
	    					tld.charAt(i) >= 'A' && tld.charAt(i) <= 'Z')
	    				validSymbols++;
	    		}
	    		
	            if(validSymbols == tld.length()) return true;
	            else return false;
	        }
        }
	}
	
	boolean hasGoodDomain (String email)
	{
		String[] cutAt = email.split("\\@");
        String emailWithoutLocalName = cutAt[1];
        String[] cutDot = emailWithoutLocalName.split("\\.");
        String domain = cutDot[0];
        
        if(domain == null || domain == " " || domain.length() == 0) return false;
        else
        {
    		int validSymbols = 0;

    		for(int i=0; i<domain.length(); i++)
    		{
    			if(domain.charAt(i) >= 'a' && domain.charAt(i) <= 'z' ||
    					domain.charAt(i) >= 'A' && domain.charAt(i) <= 'Z' ||
    					domain.charAt(i) >= '0' && domain.charAt(i) <= '9' ||
    					domain.charAt(i) == '-')
    				validSymbols++;
    		}
    		
            if(validSymbols == domain.length()) return true;
            else return false;
        }
	}
	
	boolean hasAtSign (String email)
	{
		for(int i=0; i<email.length(); i++)
		{
			if(email.charAt(i) == '@') return true;
		}
		return false;
	}
	
	boolean hasNoInvalidChars (String email)
	{
		int count = 0;
		int validSymbols = 0;
		
		for(int i=0; i<email.length(); i++)
		{
			if(email.charAt(i) == '@') count ++;
		}
		if(count>1) return false;

		for(int i=0; i<email.length(); i++)
		{
			if(email.charAt(i) >= 'a' && email.charAt(i) <= 'z' ||
					email.charAt(i) >= 'A' && email.charAt(i) <= 'Z' ||
					email.charAt(i) >= '0' && email.charAt(i) <= '9' ||
					email.charAt(i) == '@' || email.charAt(i) == '.' ||
					email.charAt(i) == '-' || email.charAt(i) == '_')
				validSymbols++;
		}
		
        if(validSymbols == email.length()) return true;
        else return false;
	}
}
