package part_3_fx.phone_book.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PersonCollection {

    private ObservableList<Person> data;

    public PersonCollection(){
        data = FXCollections.observableArrayList();
    }

    public PersonCollection(PersonCollection copy){
        this.data = FXCollections.observableArrayList(copy.getData());
    }

    public void add(Person newPerson){
        data.add(newPerson);
    }

    public void delete(Person deletedPerson) {
        data.remove(deletedPerson);
    }

    public void update(Person updatedPerson){
        // ...
    }

    public ObservableList<Person> getData() {
        return data;
    }

    public void fillTestData() {
        data.add(new Person("Алексей", "1233423"));
        data.add(new Person("Александр", "1233423"));
        data.add(new Person("Дмитрий", "1233423"));
        data.add(new Person("Василий", "1233423"));
        data.add(new Person("Николай", "1233423"));
        data.add(new Person("Сергей", "1233423"));
    }
}
