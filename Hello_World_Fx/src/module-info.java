module Hello.World.Fx {
    requires javafx.fxml;
    requires javafx.controls;

    opens sample;//sample is a package name
}