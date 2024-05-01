package com.example.first_jvfx_proj;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class BuisnessMeetPageController {

    //объявляем переменные по id элементов на view листе
    @FXML
    private ChoiceBox<String> priorityBox;

    @FXML
    private TextField areaTime;

    @FXML
    private TextField areaPlace;


    public void gettingListOfPrior(){

    }


    @FXML
    public void initialize(){
        gettingListOfPrior();   //для нормального отображения выбора приоритета
    }
}
