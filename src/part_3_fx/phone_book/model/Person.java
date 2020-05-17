package part_3_fx.phone_book.model;

import javafx.beans.property.SimpleStringProperty;

public class Person {

    private SimpleStringProperty name;
    private SimpleStringProperty phone;

    public Person(String name, String phone) {

        this.name = new SimpleStringProperty(name);
        this.phone = new SimpleStringProperty(phone);

    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getPhone() {
        return phone.get();
    }

    public SimpleStringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }
}
