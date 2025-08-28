package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class EmployeeService extends Service<ObservableList<String>>{
    @Override
    protected Task<ObservableList<String>> createTask() {
        return new Task<ObservableList<String>>() {
            @Override
            protected ObservableList<String> call() throws Exception {
                String[] name={"Ankit Raut","Mohit Raut","Suresh raut","Sangita Raut"};
                ObservableList<String> employee= FXCollections.observableArrayList();

                for (int i=0;i<4;i++){
                    employee.add(name[i]);
                    updateMessage("employee "+name[i]+" is add to the list");
                    updateProgress(i+1,4);
                    Thread.sleep(200);
                }
                return employee;
            }
        };
    }
}
