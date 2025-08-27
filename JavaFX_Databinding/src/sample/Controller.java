package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;

public class Controller {
    private Task<ObservableList<String> > task;

    @FXML
    private ListView listView1;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Label labelMess;


    public void initialize(){
         task=new Task<ObservableList<String>>() {
             @Override
             protected ObservableList<String> call() throws Exception {
                 String[] names={"Ankit Raut","Mohit Raut","Suresh Raut", "Sangita Raut"};
                 ObservableList<String> employees= FXCollections.observableArrayList();

                 for (int i=0;i<4;i++){
                     employees.add(names[i]);
                     updateMessage("employee "+names[i]+" is added to the list");
                     updateProgress(i+1,4);
                     Thread.sleep(200);
                 }

//                 Platform.runLater(new Runnable() {
//                     @Override
//                     public void run() {
//                         listView1.setItems(employees);
//                     }
//                 });//we use data binding instead of this method
                 return employees;
             }
         };
               progressBar.progressProperty().bind(task.progressProperty());
               labelMess.textProperty().bind(task.messageProperty());
               listView1.itemsProperty().bind(task.valueProperty());
    }
    @FXML
    public void printEnplyoe(){
        new Thread(task).start();
    }
}
