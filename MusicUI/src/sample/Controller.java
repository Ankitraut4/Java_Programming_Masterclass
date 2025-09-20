package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableView;
import sample.modul.Albums;
import sample.modul.Artists;
import sample.modul.Database;

public class Controller {
    @FXML
    private TableView artistTable;

    @FXML
    private ProgressBar progressBar;


    @FXML
    public void listOfArtist(){
        Task<ObservableList<Artists>> task=new getArtistTask();
        artistTable.itemsProperty().bind(task.valueProperty());

        progressBar.progressProperty().bind(task.progressProperty());
        progressBar.setVisible(true);
//        task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
//            @Override
//            public void handle(WorkerStateEvent workerStateEvent) {
//                progressBar.setVisible(false);
//            }
//        });

        task.setOnSucceeded(e -> progressBar.setVisible(false));
        task.setOnCancelled(e -> progressBar.setVisible(false));

        new Thread(task).start();
    }
    @FXML
    public void listOfAlbums(){
        final Object obj = artistTable.getSelectionModel().getSelectedItem();
        if (obj instanceof Albums) {
            return;//if the item selected is album it will return
        }
        final Artists artists = (Artists) obj;
       //final Artists artists=(Artists) artistTable.getSelectionModel().getSelectedItem(); //from line 27 to 30 we check that selected item is artists only
        if (artists==null){
            System.out.println("select the artists");
            return;


        }
        Task<ObservableList<Albums>> task=new Task<ObservableList<Albums>>() {
            @Override
            protected ObservableList<Albums> call() throws Exception {
                return FXCollections.observableArrayList(Database.getInstance().qweryAlbum_by_ArtistID(artists.get_id()));
            }
        };
       artistTable.itemsProperty().bind(task.valueProperty());
        new Thread(task).start();
    }
    @FXML
    public void updateArtistInUI(){
       final Object obj=artistTable.getItems().get(2);// here 2 is the index as AC DC is in position 3 in table so its index is 2
        if (obj instanceof Albums){
            return;
        }
        final Artists artists=(Artists)obj;
        if (artists==null){
            System.out.println("select the artist");
            return;
        }
        Task<Boolean> task=new Task<Boolean>() {
            @Override
            protected Boolean call() throws Exception {
                return Database.getInstance().updateArtist("AC DC",artists.get_id());


            }
        };
       task.setOnSucceeded(e ->{
           if (task.valueProperty().get()){
               artists.setName("AC DC");
               artistTable.refresh();
           }
        });
       new Thread(task).start();
    }


}
 class getArtistTask extends Task{
    @Override
    public ObservableList<Artists> call(){//we can return the observableList in controller bur we need also need this method if user ask the artist list
        return FXCollections.observableArrayList(Database.getInstance().artistQuery(Database.ORDER_BY_ASC));
    }

}