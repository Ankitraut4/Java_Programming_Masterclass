package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.modul.Database;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("music.fxml"));//we have ensure that the ui is loaded before the task is executed
        Parent root = loader.load();
        Controller controller=loader.getController();
        controller.listOfArtist();//here we qwery the artist
        primaryStage.setTitle("Music Gallery");
        primaryStage.setScene(new Scene(root, 800, 675));
        primaryStage.show();
    }

    @Override
    public void init() throws Exception {
        super.init();
        if (!Database.getInstance().open()){
            System.out.println("Error : could not connect to database");
            Platform.exit();
        }
        Database.getInstance().open();//this statement is optional because in if we define !Database.getInstance().open() which if we goes not able to open database then in else it will automatically open it
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        Database.getInstance().close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
