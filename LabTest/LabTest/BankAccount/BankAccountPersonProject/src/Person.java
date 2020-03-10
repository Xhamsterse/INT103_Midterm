/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Umaporn
 */
public class Person {
    private long idCard;
    private String firstName;
    private String lastName;

    public Person(long idCard, String firstName, String lastName) {
        this.idCard = idCard;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getIdCard() {
        return idCard;
    }

    public void setIdCard(long idCard) {
        this.idCard = idCard;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" + "idCard=" + idCard + ", firstName=" + firstName + ", lastName=" + lastName + '}';
    }
    
}
