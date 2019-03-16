package Domain;

import java.util.Objects;

public class Client {
    private String id;
    private String firstName;
    private String lastName;
    private String cnp;
    private String birthdayDate;
    private String registrationDate;
    private int points;

    public Client(String id, String firstName, String lastName, String cnp, String birthdayDate, String registrationDate, int points) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cnp = cnp;
        this.birthdayDate = birthdayDate;
        this.registrationDate = registrationDate;
        this.points = points;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cnp='" + cnp + '\'' +
                ", birthdayDate='" + birthdayDate + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                ", points=" + points +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, cnp, birthdayDate, registrationDate, points);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(String birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = this.points + points;
    }
}