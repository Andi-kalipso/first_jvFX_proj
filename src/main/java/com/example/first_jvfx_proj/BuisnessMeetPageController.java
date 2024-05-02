package com.example.first_jvfx_proj;

import com.example.first_jvfx_proj.structClasses.buisnessMeetTask;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Objects;

public class BuisnessMeetPageController {

    //объявляем переменные по id элементов на view листе
    @FXML
    private DatePicker dataP;
    @FXML
    private ChoiceBox<String> priorityBox;

    @FXML
    private TextField areaTime;

    @FXML
    private TextField areaPlace;

    @FXML
    private TextField areaAddPart;

    @FXML
    private ListView<String> partnersList;

    @FXML
    private Button saveButton;
    private ObservableList<String> partsList = FXCollections.observableArrayList();
    private Priority priorPP;

    //метод для передачи в ChoiseBox элементов
    public void gettingListOfPrior(){
        String[] strList = {String.valueOf(Priority.prior_0),
                String.valueOf(Priority.prior_1),
                String.valueOf(Priority.prior_2),
                String.valueOf(Priority.prior_3)};

        priorityBox.getItems().addAll(strList);
        priorityBox.setOnAction(this::getPrior);
        System.out.println(Priority.prior_0.ordinal());
    }
    //метод для того, чтобы сохранять в файл понимаемые человеком данные

    @FXML
    public String getPrior(ActionEvent event){

        String prior = priorityBox.getValue();
        String per = null;

        switch (prior){
            case "prior_0":
                per = "не важна";
                priorPP = Priority.prior_0;
                break;
            case "prior_1":
                per = "обычная";
                priorPP = Priority.prior_1;
                break;
            case "prior_2":
                per = "важна";
                priorPP = Priority.prior_2;
                break;
            case "prior_3":
                per = "крайне важна";
                priorPP = Priority.prior_3;
                break;
        }
        return per;
    }

    @FXML
    public void initialize(){
        gettingListOfPrior();   //для нормального отображения выбора приоритета

    }

    @FXML
    public void onAddPartButtonClick(){
        if(!Objects.equals(areaAddPart.getText(), "")){ //areaAddPart.getText() != null ||
            partsList.add(areaAddPart.getText());
            partnersList.setItems(partsList);
            areaAddPart.setText("");
        } else {
            System.out.println("Ошибка, сначала введите кого хотите добавить");
        }
    }

    @FXML
    public void onSaveButtonClick()  throws IOException {
        boolean flagOfForms = isAllFormsfilled();
        if(flagOfForms){
            buisnessMeetTask newbuisnessMeetTask = new buisnessMeetTask(dataP.getValue().toString(), areaTime.getText(), priorPP, areaPlace.getText(), Collections.singletonList(partsList.toString()));
            try{
                FileWriter writer = new FileWriter("output.txt", true);
                writer.write(newbuisnessMeetTask.toString() + "\n");

                writer.close();
                Stage stage = (Stage) saveButton.getScene().getWindow();
                stage.close();

            } catch(Exception e){
                System.out.println("ERROR of write File buisnessMeet.onSaveButtonClick");
                e.printStackTrace();
            }
        } else {
            System.out.println("we here");          //сделать сообщение о том, что ввести или типа того
        }

    }


    private boolean isAllFormsfilled(){

        if(Objects.equals(areaPlace.getText(), "")) {
            System.out.println("заполните поле МЕСТО");
            return false;
        }
        if(Objects.equals(areaTime.getText(), "")) {
            System.out.println("заполните поле ВРЕМЯ");
            return false;
        }
        if(partsList.isEmpty()) {
            System.out.println("добавте тех с кем встреча");
            return false;
        }

        if(Objects.equals(dataP.getValue().toString(), "")) {
            System.out.println("заполните поле ДАТЫ");
            return false;
        }
        if(priorPP == null){
            System.out.println("заполните приоритет");
            return false;
        }

        return true;
    }

}
