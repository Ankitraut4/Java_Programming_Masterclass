package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
@FXML
   private TextField nameOfField;
@FXML
private Button helloButton;
@FXML
private Button byeButton;
@FXML
private CheckBox ourCheckBox;
@FXML
private Label labelUpdate;

@FXML
public void initialize(){
 helloButton.setDisable(true);
 byeButton.setDisable(true);
}
@FXML
    public void onPress(ActionEvent e){
        if (e.getSource().equals(helloButton)){
            System.out.println("Hello , "+nameOfField.getText());
        }else if(e.getSource().equals(byeButton)){
            System.out.println("Bye , " +nameOfField.getText());
        }
        Runnable task=new Runnable() {
            @Override
            public void run() {
                try{
                    String s= Platform.isFxApplicationThread()? " Ui thread ":" backgroung thread ";
                    System.out.println("we are on : "+s);
                    Thread.sleep(10000);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            labelUpdate.setText("we done something!!!");
                            String s= Platform.isFxApplicationThread()? " Ui thread ":" backgroung thread ";
                            System.out.println("we are  updating on  : "+s);
                        }
                    });

                }catch (InterruptedException te) {
                }
            }
        };
new Thread(task).start();

        if (ourCheckBox.isSelected()){
            nameOfField.clear();
            helloButton.setDisable(true);
            byeButton.setDisable(true);
        }

    }
@FXML
    public void whenTypeOnTextField(){
    String text=nameOfField.getText();
    boolean disableText=text.isEmpty()||text.trim().isEmpty();
    helloButton.setDisable(disableText);
    byeButton.setDisable(disableText);
    }

    public void callCheckBox(){
        System.out.println("The checkBox is "+(((ourCheckBox.isSelected()))? " checked " : " unchecked "));
    }
}
