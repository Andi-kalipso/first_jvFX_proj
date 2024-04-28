package com.example.first_jvfx_proj;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import java.util.Date;


public class DrPageController extends ganeralTaskPage {             // класс для управления задачами др, а именно для формирования задачи, а после её сохраниения в список
    public Date setDateBirthday(){
        date = new Date();
        return date;
    }

    public void setPriority(){
        priorityObj = Priority.prior_1;
    }




    @FXML
    private ChoiceBox<String> priority;

    @FXML
    private TextArea areatextfio;


    @FXML
    public void initialize(){
        String[] prList = {"0", "1", "2", "3"};
        priority.getItems().addAll(prList);
        priority.setOnAction(this::getPrior);
    }


    @FXML
    public void getPrior(ActionEvent event){
        String prior = priority.getValue();
        areatextfio.getText();
        //if()
    }
}
