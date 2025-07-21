package sam.todoItems;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

public class TodoData {
    private static TodoData instance=new TodoData();
    private static String filenane="TododataItems.txt";

    private ObservableList<TodoItems> todoItems;
    private DateTimeFormatter formatter;

    public static TodoData getInstance(){
        return instance;
    }

    public TodoData() {
        formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    public ObservableList<TodoItems> getTodoItems() {
        return todoItems;
    }

    public void addTodoItem(TodoItems items){
        todoItems.add(items);
    }

//    public void setTodoItems(List<TodoItems> todoItems) {
//        this.todoItems = todoItems;
//    }

    public void loadTodoItems() throws IOException{
        todoItems= FXCollections.observableArrayList();
        Path path= Paths.get(filenane);
        BufferedReader br=Files.newBufferedReader(path);
        String input;
        try{
            while ((input=br.readLine())!=null){
                String[] itempieces=input.split("\t");

                String details=itempieces[0];
                String extentedDetails=itempieces[1];
                String dateString=itempieces[2];

                LocalDate date=LocalDate.parse(dateString,formatter);
                TodoItems todoItem=new TodoItems(details,extentedDetails,date);
                todoItems.add(todoItem);
            }

        }finally {
            if (br!=null){
                br.close();
            }
        }
    }

    public void storeTodoItems() throws IOException{
        Path path=Paths.get(filenane);
        BufferedWriter bw=Files.newBufferedWriter(path);
        try {
            Iterator<TodoItems> itr=todoItems.iterator();
            while (itr.hasNext()){
                TodoItems items=itr.next();
                bw.write(String.format("%s\t%s\t%s",
                        items.getDetails(),
                        items.getExtendedDetails(),
                        items.getDeadline().format(formatter)));
                bw.newLine();
            }
        }finally {
            if(bw!=null){
                bw.close();
            }
        }
    }

    //method which remove todoItem
    public void deleteTodoItem(TodoItems items){
        todoItems.remove(items);//here it is not required to create deletion operation class because we use data binding which would update the UI
    }
}
