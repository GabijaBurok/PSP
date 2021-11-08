package com.psp.psp13.model;

import com.psp.psp13.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class User implements Comparable<User>
{
    @Id
    private Long id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private String address;
    private String password;

    public User() {}

    public User(Long id, String name, String surname, String phoneNumber, String email, String address, String password)
    {
        super();
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.password = password;
        this.id = id;
    }

    public User(String name, String surname, String phoneNumber, String email, String address, String password)
    {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getSurname()
    {
        return surname;
    }
    public void setSurname(String surname)
    {
        this.surname = surname;
    }
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber)
    {
        if(isPhoneNumberValid(phoneNumber)) this.phoneNumber = phoneNumber;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        if(isEmailValid(email)) this.email = email;
    }
    public String getAddress()
    {
        return address;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        if(isPasswordValid(password)) this.password = password;
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        else if(o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(phoneNumber, user.phoneNumber) && Objects.equals(email, user.email) && Objects.equals(address, user.address) && Objects.equals(password, user.password);
    }
    @Override
    public String toString()
    {
        return "User{" +
                "id = " + id +
                ", name = " + name +
                ", surname = " + surname +
                ", phoneNumber = " + phoneNumber +
                ", email = " + email +
                ", address = " + address +
                ", password = " + password +
                "}";
    }
    @Override
    public int hashCode()
    {
        return Objects.hash(id, password);
    }
    public boolean isPhoneNumberValid(String phoneNumber)
    {
        Validator validator = new Validator();
        validator.phoneLength(9);
        if(!validator.numberHasNotNumber(phoneNumber) &&
            validator.numberTooShort(phoneNumber) &&
            validator.numberTooLong(phoneNumber)) return true;
        else if(validator.numberHasNotNumber(phoneNumber) &&
                phoneNumber.length() == 12 &&
                validator.numberMatchesCountryCodeLT(phoneNumber)) return true;
        else return false;
    }
    public boolean isEmailValid(String email)
    {
        Validator validator = new Validator();
        if(validator.emptyEmail(email) &&
            validator.emptyEmailBeforeAt(email) &&
            validator.hasAtSymbol(email) &&
            !validator.hasIllegalSymbol(email) &&
            validator.hasCorrectDomain(email) &&
            validator.hasCorrectTopDomain(email)) return true;
        else return false;
    }
    public boolean isPasswordValid(String password)
    {
        Validator validator = new Validator();
        validator.passwordMinLength(8);
        validator.specialCharacters("!@#$%^&*()_+=-");
        if(validator.passwordTooShort(password) &&
            validator.hasAnUppercase(password) &&
            validator.hasSpecialCharacters(password)) return true;
        else return false;
    }
    @Override
    public int compareTo(User o)
    {
        return 0;
    }
}
