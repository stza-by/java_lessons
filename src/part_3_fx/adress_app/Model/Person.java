package part_3_fx.adress_app.Model;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Person {

    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty city;
    private StringProperty street;
    private StringProperty houseNumber;
    private ObjectProperty<LocalDate> birthDay;


    public Person(String firstName, String lastName) {
        this(firstName, lastName, "Не указанно", "Не указанно", "Не указанно", LocalDate.of(1, 1, 1));
    }

    public Person(String firstName,
                  String lastName,
                  String city,
                  String street,
                  String houseNumber,
                  LocalDate birthDay) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.city = new SimpleStringProperty(city);
        this.street = new SimpleStringProperty(street);
        this.houseNumber = new SimpleStringProperty(houseNumber);
        this.birthDay = new SimpleObjectProperty<>(birthDay);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getCity() {
        return city.get();
    }

    public StringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getStreet() {
        return street.get();
    }

    public StringProperty streetProperty() {
        return street;
    }

    public void setStreet(String street) {
        this.street.set(street);
    }

    public String getHouseNumber() {
        return houseNumber.get();
    }

    public StringProperty houseNumberProperty() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber.set(houseNumber);
    }

    public LocalDate getBirthDay() {
        return birthDay.get();
    }

    public ObjectProperty<LocalDate> birthDayProperty() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay.set(birthDay);
    }
}
