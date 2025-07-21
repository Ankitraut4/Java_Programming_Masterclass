package sam;

import sam.todoItems.TodoData;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sam.todoItems.TodoItems;

import java.time.LocalDate;

public class DialogController {
    @FXML
    private TextField detailsField;
    @FXML
    private TextArea extendField;
    @FXML
    private DatePicker datePicker;

    public TodoItems processResult(){
        String details=detailsField.getText().trim();
        String extendDetails=extendField.getText().trim();
        LocalDate date=datePicker.getValue();

        TodoItems newItems=new TodoItems(details,extendDetails,date);
        TodoData.getInstance().addTodoItem(newItems);
        return newItems;
    }
}
