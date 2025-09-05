package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

    @FXML
    private Button button;

    public void initialize(){

//        button.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                System.out.println("button was pressed");
//            }
//        });

        //using above method in lambda
        button.setOnAction(actionEvent -> System.out.println("button was pressed"));

    }
}
