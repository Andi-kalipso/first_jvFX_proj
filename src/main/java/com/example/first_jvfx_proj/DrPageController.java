package com.example.first_jvfx_proj;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;


public class DrPageController extends ganeralTaskPage {             // класс для управления задачами др, а именно для формирования задачи, а после её сохраниения в список
    public Date setDateBirthday(){
        date = new Date();
        return date;
    }

    public void setPriority(){
        priorityObj = Priority.prior_1;
    }



    //объявляем переменные по id элементов на view листе
    @FXML
    private ChoiceBox<String> priority;
    //филды
    @FXML
    private TextField areatextfio;
    @FXML
    private TextField areaDateAndTime;

    //кнопка сохранения
    @FXML
    public Label outputText;
    //кнопка сохранения
    @FXML
    public Button saveButton;

    @FXML
    public DatePicker datePickerOff;




    @FXML
    public void initialize(){
        String[] prList = {"0", "1", "2", "3"};
        priority.getItems().addAll(prList);
        priority.setOnAction(this::getPrior);
    }


    @FXML
    public void getPrior(ActionEvent event){
        String prior = priority.getValue();
        outputText.setText(prior);
        //if()
    }


    public void onSaveButtonClick() throws IOException {
        try{
            FileWriter writer = new FileWriter("output.txt");
            writer.write(outputText.getText());
        } catch(Exception e) {
            System.out.println("ERROR of write File dr.onSaveButtonClick");
            e.printStackTrace();
        }

    }


}
