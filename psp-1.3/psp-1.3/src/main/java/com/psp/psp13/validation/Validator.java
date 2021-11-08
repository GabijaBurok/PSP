package com.psp.psp13.validation;

public class Validator {
    private int nrLength;
    private String lv;
    private String lvPhoneCode;
    private int passMinLength;
    private String specChars;

    public boolean emptyEmail(String email) {
        if (email != "") return true;
        else return false;
    }

    public boolean emptyEmailBeforeAt(String email) {
        int index = email.indexOf("@");
        if (index == -1) return true;
        else if (email.substring(0, index) != "") return true;
        else return false;
    }

    public boolean hasAtSymbol(String email) {
        return email.contains("@");
    }

    public boolean hasIllegalSymbol(String email) {
        int index = email.indexOf("@");
        String local = email.substring(0, index);
        String localAllowedSymbols = "{!#$%&'*+-/=?^_`{|}~}";
        for (char character : local.toCharArray())
        {
            if (!Character.isDigit(character) && !(character >= 'A' && character <= 'Z') && !(character >= 'a' && character <= 'z') && !localAllowedSymbols.contains(Character.toString(character)))
            {
//                boolean illegalSymbolDetected = true;
//                for (char allowedSymbol : localAllowedSymbols.toCharArray())
//                {
//                    if (allowedSymbol == character) illegalSymbolDetected = false;
//                }
                return true;
            }
        }
        return false;
    }

    public boolean hasCorrectDomain(String email) {
        String domain = email.substring(email.indexOf("@")+1, email.lastIndexOf("."));
        if (domain == "") return false;
        for (char character : domain.toCharArray())
        {
            if (!Character.isDigit(character) && !(character >= 'A' && character <= 'Z') && !(character >= 'a' && character <= 'z') && character != '-')
            {
                return false;
            }
        }
        return true;
    }

    public boolean hasCorrectTopDomain(String email) {
        String tld = email.substring(email.lastIndexOf(".")+1);
        for (char character : tld.toCharArray())
        {
            if (!(character >= 'A' && character <= 'Z') && !(character >= 'a' && character <= 'z'))
            {
                return false;
            }
        }
        return true;
    }

    public void phoneLength(int nrLenght) {
        this.nrLength = nrLenght;
    }

    public void phoneCountry(String lv, String lvPhoneCode) {
        this.lv = lv;
        this.lvPhoneCode = lvPhoneCode;
    }

    public boolean numberTooShort(String number) {
        return !(number.length() < this.nrLength);
    }

    public boolean numberTooLong(String number) {
        return !(number.length() > this.nrLength);
    }

    public boolean numberHasNotNumber(String number) {
        for (char num : number.substring(1).toCharArray())
        {
            if (Character.isDigit(num)) return false;
        }
        return true;
    }

    public boolean numberLTChangedToInternational(String number) {
        if (number.charAt(0) == '8' && number.length() == 9)
        {
            String newNumber = "+370" + number.substring(1);
            if (newNumber.substring(4).equals(number.substring(1))) return true;
        }
        return false;
    }

    public boolean numberMatchesCountryCodeLT(String number) {
        return (number.substring(0, 4).equals("+370"));
    }

    public boolean numberMatchesCountryCodeLV(String number) {
        return (number.substring(0, 4).equals(this.lvPhoneCode));
    }

    public void passwordMinLength(int passMinLength) {
        this.passMinLength = passMinLength;
    }

    public void specialCharacters(String specChars) {
        this.specChars = specChars;
    }

    public boolean passwordTooShort(String password) {
        return !(password.length() < this.passMinLength);
    }

    public boolean hasAnUppercase(String password) {
        for (char symbol : password.toCharArray())
        {
            if (symbol >= 'A' && symbol <= 'Z') return true;
        }
        return false;
    }

    public boolean hasSpecialCharacters(String password) {
        for (char symbol : password.toCharArray())
        {
            for (char specCharacter : this.specChars.toCharArray())
            {
                if (symbol == specCharacter) return true;
            }
        }
        return false;
    }
}

