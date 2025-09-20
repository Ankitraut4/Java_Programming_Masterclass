package sample.modul;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Artists {

    private SimpleIntegerProperty _id;
    private SimpleStringProperty name;

    public Artists() {
        this._id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
    }

    public int get_id() {
        return _id.get();
    }

    public void set_id(int _id) {
        this._id.set(_id);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }
}
