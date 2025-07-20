package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import sample.todoItems.TodoItems;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    private ListView<TodoItems> listView;
    @FXML
    private TextArea textareaData;
    @FXML
    private Label labelForDate;


    List<TodoItems> todoItems=new ArrayList<>();

    public void initialize(){
        TodoItems items1=new TodoItems("mohit birthday "," wish him happy birthday as his 17th birthday ",
                LocalDate.of(2022, Month.JULY,1));
        TodoItems items2=new TodoItems("Ankit birthday "," wish him happy birthday as his 22nd birthday ",
                LocalDate.of(2022, Month.MARCH,4));
        TodoItems items3=new TodoItems("Book Ticket "," Book a ticket of train to travel to pune ",
                LocalDate.of(2021, Month.AUGUST,9));
        TodoItems items4=new TodoItems("Bike service "," Service the bike for smooth working of bike  ",
                LocalDate.of(2021, Month.AUGUST,15));

        todoItems.add(items1);
        todoItems.add(items2);
        todoItems.add(items3);
        todoItems.add(items4);



        listView.getItems().setAll(todoItems);
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        listView.getSelectionModel().selectFirst();//this will by default first detail in the list view but it would not initiate event handler because we goes not do mouse click so extented details would be displayed

    }
    public void clickOnlistView(){
        TodoItems todoItem=listView.getSelectionModel().getSelectedItem();
       textareaData.setText(todoItem.getExtendedDetails());
        labelForDate.setText(todoItem.getDeadline().toString());
//        StringBuilder s=new StringBuilder(todoItem.getExtendedDetails());
//        s.append("\n\n\n");
//        s.append("Due : ");
//        s.append(todoItem.getDeadline().toString());
//        textareaData.setText(s.toString());
    }
}
