package com.example.first_jvfx_proj;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class AirtravelPageController {

    //объявляем переменные по id элементов на view листе
    @FXML
    private ChoiceBox<String> priorityBox;
    @FXML
    private TextField areaTime;
    @FXML
    private DatePicker dataP;
}
