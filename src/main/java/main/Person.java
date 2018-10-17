package main;

public class Person {

    private String firstname;
    private String lastname;
    private Person couple;

    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Person() {
    }

    public Person getCouple() {
        return couple;
    }

    public void setCouple(Person couple) {
        this.couple = couple;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
