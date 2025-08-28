package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;

import javafx.concurrent.Worker;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;

public class Controller {
    private Service<ObservableList<String>> service;

    @FXML
    private ListView listView1;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Label labelMess;


    public void initialize(){
//         task=new Task<ObservableList<String>>() {
//             @Override
//             protected ObservableList<String> call() throws Exception {
//                 String[] names={"Ankit Raut","Mohit Raut","Suresh Raut", "Sangita Raut"};
//                 ObservableList<String> employees= FXCollections.observableArrayList();
//
//                 for (int i=0;i<4;i++){
//                     employees.add(names[i]);
//                     updateMessage("employee "+names[i]+" is added to the list");
//                     updateProgress(i+1,4);
//                     Thread.sleep(200);
//                 }
//
//                 return employees;
//             }
//         };
        service=new EmployeeService();
               progressBar.progressProperty().bind(service.progressProperty());
               labelMess.textProperty().bind(service.messageProperty());
               listView1.itemsProperty().bind(service.valueProperty());

//               service.setOnRunning(new EventHandler<WorkerStateEvent>() {
//                   @Override
//                   public void handle(WorkerStateEvent workerStateEvent) {
//                       progressBar.setVisible(true);
//                       labelMess.setVisible(true);
//                   }
//               });
//
//               service.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
//                   @Override
//                   public void handle(WorkerStateEvent workerStateEvent) {
//                       progressBar.setVisible(false);
//                       labelMess.setVisible(false);
//                   }
//               });to replace this line 49 t0 65 code we can use data binding which is on line 67 & 68
//        progressBar.setVisible(false);
//               labelMess.setVisible(false);

        progressBar.visibleProperty().bind(service.runningProperty());
        labelMess.visibleProperty().bind(service.runningProperty());





    }
    @FXML
    public void printEnplyoe(){
        if (service.getState().equals(Service.State.SUCCEEDED)){
            service.reset();
            service.start();
        }else if (service.getState().equals(Service.State.READY)){
            service.start();
        }

    }
}
