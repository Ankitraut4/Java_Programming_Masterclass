package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import sample.dataModel.Contact;
import sample.dataModel.ContactData;

import java.io.IOException;
import java.util.Optional;

public class Controller {

    @FXML
    private BorderPane parentPane;

    @FXML
    private TableView<Contact> contactTableView;

    private ContactData data;

    public void initialize(){
        data=new ContactData();
        data.loadContacts();
        contactTableView.setItems(data.getContacts());
    }

    public void handleOnAddIsPressed(){
        Dialog<ButtonType> dialog=new Dialog<>();
        dialog.initOwner(parentPane.getScene().getWindow());
        dialog.setTitle("Add contact to contact list ");
        FXMLLoader fxmlLoader=new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("contactdialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        }catch (IOException e){
            System.out.println("could not load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result=dialog.showAndWait();
        if (result!=null && result.get().equals(ButtonType.OK)){
            ContactController contactController=fxmlLoader.getController();
            Contact newcontact=contactController.getNewContact();
            data.addContact(newcontact);
            data.saveContacts();

        }

    }
    public void handleEdit(){
        Contact selectedItem=contactTableView.getSelectionModel().getSelectedItem();
        if (selectedItem==null){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No contact is selected");
            alert.setHeaderText(null);//we does not want header text  here
            alert.setContentText("Please select the contact which you want to delete.");
            alert.showAndWait();
            return;
        }
        Dialog<ButtonType> dialog=new Dialog<>();
        dialog.initOwner(parentPane.getScene().getWindow());
        dialog.setTitle("Edit the Contact List");
        FXMLLoader fxmlLoader=new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("contactdialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        }catch (IOException e){
            System.out.println("could not load ");
            e.printStackTrace();
        }
        ContactController contactControllers=fxmlLoader.getController();
        contactControllers.editContact(selectedItem);

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result=dialog.showAndWait();
        if (result.isPresent() && result.get().equals(ButtonType.OK)){
            contactControllers.updateContact(selectedItem);
            data.saveContacts();
        }

    }
    public void handleDelete(){
        Contact selectedItem=contactTableView.getSelectionModel().getSelectedItem();
        if (selectedItem==null){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No Contact is selected");
            alert.setHeaderText(null);
            alert.setContentText("Please select the contact.");
            alert.showAndWait();
            return;
        }
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Contact");
        alert.setContentText("Do you want to delete this Contact:\n"+selectedItem.getFirstName()+" "+selectedItem.getLastName()+"?");

        Optional<ButtonType> result=alert.showAndWait();
        if (result.isPresent() && result.get().equals(ButtonType.OK)){
            data.deleteContact(selectedItem);
            data.saveContacts();
        }

    }

    public void handleExist(){
        Platform.exit();
    }
}
