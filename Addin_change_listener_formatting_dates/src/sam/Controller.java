package sam;


import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import sam.todoItems.TodoData;
import sam.todoItems.TodoItems;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Controller {
    private List<TodoItems> todoItems;


    @FXML
    private ListView<TodoItems> listView;
    @FXML
    private TextArea textareaData;
    @FXML
    private Label labelForDate;
    @FXML
     private BorderPane mainBorderPane;

    @FXML
    private ContextMenu listContextMenu;

    @FXML
    private ToggleButton filterToggleButton;

    private FilteredList<TodoItems> filteredList;
    private Predicate<TodoItems> wantTodayItem;
    private Predicate<TodoItems> wantAllItems;




    public void initialize(){

        //setting contextMenu
         listContextMenu=new ContextMenu();
        MenuItem deleteMenuItem=new MenuItem("Delete");
        deleteMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                TodoItems items=listView.getSelectionModel().getSelectedItem();
                deleteItem(items);
            }
        });
        listContextMenu.getItems().addAll(deleteMenuItem);//addind deleMenuItem i.e menuItem to context menu







//        TodoItems items1=new TodoItems("mohit birthday "," wish him happy birthday as his 17th birthday ",
//                LocalDate.of(2022, Month.JULY,1));
//        TodoItems items2=new TodoItems("Ankit birthday "," wish him happy birthday as his 22nd birthday ",
//                LocalDate.of(2022, Month.MARCH,4));
//        TodoItems items3=new TodoItems("Book Ticket "," Book a ticket of train to travel to pune ",
//                LocalDate.of(2021, Month.AUGUST,9));
//        TodoItems items4=new TodoItems("Bike service "," Service the bike for smooth working of bike  ",
//                LocalDate.of(2021, Month.AUGUST,15));
//
//        todoItems.add(items1);
//        todoItems.add(items2);
//        todoItems.add(items3);
//        todoItems.add(items4);
//
//       TodoData.getInstance().setTodoItems(todoItems);


        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItems>() {
           @Override
           public void changed(ObservableValue<? extends TodoItems> observableValue, TodoItems oldValue, TodoItems newValue) {
               if (newValue!=null){
                   TodoItems todoItems=listView.getSelectionModel().getSelectedItem();
                   textareaData.setText(todoItems.getExtendedDetails());
                   DateTimeFormatter d=DateTimeFormatter.ofPattern("d , MMMM yyyy");
                   labelForDate.setText(d.format(todoItems.getDeadline()));
               }
           }
       });



        wantTodayItem=new Predicate<TodoItems>() {
            @Override
            public boolean test(TodoItems items) {
                return (items.getDeadline().equals(LocalDate.now()));
            }
        };
        wantAllItems=new Predicate<TodoItems>() {
            @Override
            public boolean test(TodoItems items) {
                return true;
            }
        };

        filteredList=new FilteredList<TodoItems>(TodoData.getInstance().getTodoItems(), wantAllItems );
//         {
//            @Override
//            public boolean test(TodoItems items) {//we deselected this because we define predicate above and give the parameter of predicate wantAllItems because we want all item initially
//                return true;
//            }
//        });

        //sorting list
        SortedList<TodoItems> sortedList=new SortedList<TodoItems>(filteredList,
                new Comparator<TodoItems>() {
                    @Override
                    public int compare(TodoItems o1, TodoItems o2) {
                        return o1.getDeadline().compareTo(o2.getDeadline());
                    }
                });



        listView.setItems(sortedList);
      // listView.setItems(TodoData.getInstance().getTodoItems());//1. added for databinding //2. delected for getting sorted instance fom sorted list but databinding is on
      // listView.getItems().setAll(TodoData.getInstance().getTodoItems());//1. deselected for databinding
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listView.getSelectionModel().selectFirst();

        //cell factory for filling color to text
     listView.setCellFactory(new Callback<ListView<TodoItems>, ListCell<TodoItems>>() {
         @Override
         public ListCell<TodoItems> call(ListView<TodoItems> todoItemsListView) {
             ListCell<TodoItems> cell=new ListCell<>(){
                 @Override
                 protected void updateItem(TodoItems todoItems, boolean empty) {
                     super.updateItem(todoItems, empty);
                     if (empty){
                         setText(null);
                     }else {
                         setText(todoItems.getDetails());
                         if (todoItems.getDeadline().isBefore(LocalDate.now().plusDays(1))){
                             setTextFill(Color.RED);
                         }else if (todoItems.getDeadline().equals(LocalDate.now().plusDays(1))){
                             setTextFill(Color.GREEN);
                         }
                     }
                 }
             };
             //associating menu with listView by associating contextMenu to cellFactory
             cell.emptyProperty().addListener(
                     (obs, wasEmpty, isNowEmpty) -> {
             if (isNowEmpty) {
                 cell.setContextMenu(null);
             } else {
                 cell.setContextMenu(listContextMenu);
             }

         });

             return cell;
         }
     });

    }
    @FXML
    public void showNewItemDialog(){
        Dialog<ButtonType> dialog=new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Todo item update dialog" );
        dialog.setHeaderText("update your item here ");
        FXMLLoader fxmlLoader=new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("TodoItemDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());

        }catch (IOException e){
            System.out.println("Could not load dialoge");
            e.printStackTrace();
            return;
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result=dialog.showAndWait();

        if (result.isPresent() && result.get()==ButtonType.OK){
            DialogController controller=fxmlLoader.getController();
           TodoItems newItem =controller.processResult();
           //listView.getItems().setAll(TodoData.getInstance().getTodoItems());//deselect for databinding
            listView.getSelectionModel().select(newItem);

        }
    }



    //for opening delete dialog when when delete button is pressed on keybord
    @FXML
    public void onKeyPress(KeyEvent keyEvent){
        TodoItems selectedItem=listView.getSelectionModel().getSelectedItem();
        if (selectedItem!=null){
            if (keyEvent.getCode().equals(KeyCode.DELETE)){
                deleteItem(selectedItem);
            }
        }
    }

    @FXML
    public void clickOnListView(){
        TodoItems todoItem=listView.getSelectionModel().getSelectedItem();
        textareaData.setText(todoItem.getExtendedDetails());
        labelForDate.setText(todoItem.getDeadline().toString());
//        StringBuilder s=new StringBuilder(todoItem.getExtendedDetails());
//        s.append("\n\n\n");
//        s.append("Due : ");
//        s.append(todoItem.getDeadline().toString());
//        textareaData.setText(s.toString());
    }

    //creating pop-up window for delection conformattion
    public void deleteItem(TodoItems items){
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete the todoItem");
        alert.setHeaderText("If you want to delete "+items.getDetails());
        alert.setContentText("Press ok or cancel ? if you want to delete Item");

        Optional<ButtonType> result=alert.showAndWait();

        if (result.isPresent() && result.get()==ButtonType.OK){
            TodoData.getInstance().deleteTodoItem(items);
        }
    }

    @FXML
    public void handleClickForToday(){
        TodoItems selectedItem=listView.getSelectionModel().getSelectedItem();
       if (filterToggleButton.isSelected()){
           filteredList.setPredicate(wantTodayItem);
           if (filteredList.isEmpty()){
              textareaData.clear();
              labelForDate.setText("");
           }else if (filteredList.contains(selectedItem)){
               listView.getSelectionModel().select(selectedItem);
           }else {
               listView.getSelectionModel().selectFirst();
           }
       }else {
           filteredList.setPredicate(wantAllItems);
           listView.getSelectionModel().select(selectedItem);
       }
    }
    @FXML
    public void handleExistAction(){
        Platform.exit();
    }
}
