package sample.modul;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Albums {

    private SimpleIntegerProperty _id;
    private SimpleStringProperty name;
    private SimpleIntegerProperty artistId;

    public Albums() {
        this._id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.artistId = new SimpleIntegerProperty();
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

    public int getArtistId() {
        return artistId.get();
    }

    public void setArtistId(int artistId) {
        this.artistId.set(artistId);
    }
}
