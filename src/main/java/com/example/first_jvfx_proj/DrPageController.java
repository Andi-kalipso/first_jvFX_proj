package com.example.first_jvfx_proj;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;


public class DrPageController extends ganeralTaskPage {             // класс для управления задачами др, а именно для формирования задачи, а после её сохраниения в список
    public void setDateBirthday(){
        //date = new Date();
    }

    public void setPriority(){
        //priorityObj = Priority.prior_1;
    }



    //объявляем переменные по id элементов на view листе
    @FXML
    private ChoiceBox<String> priorityBox;
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

    private boolean ErrorFlag = false;


    @FXML
    public void initialize(){
        gettingListOfPrior();   //для нормального отображения выбора приоритета
    }


    @FXML
    public void getPrior(ActionEvent event){

        String prior = priorityBox.getValue();
        String per = null;
        switch (prior){
            case "0":
                per = "не важна";
                break;
            case "1":
                per = "обычная";
                break;
            case "2":
                per = "важна";
                break;
            case "3":
                per = "крайне важна";
                break;
        }
        outputText.setText(per);
    }

    public void gettingListOfPrior(){
        String[] strList = {String.valueOf(Priority.prior_0.ordinal()),
                String.valueOf(Priority.prior_1.ordinal()),
                String.valueOf(Priority.prior_2.ordinal()),
                String.valueOf(Priority.prior_3.ordinal())};

        priorityBox.getItems().addAll(strList);
        priorityBox.setOnAction(this::getPrior);
        System.out.println(Priority.prior_0.ordinal());
    }

    public void onSaveButtonClick() throws IOException {        //посмотрим, может сделать отдельный класс формирования строки в нашем формате
        String strok = strMaker();
        if(!ErrorFlag){
            try{
                FileWriter writer = new FileWriter("output.txt");
                writer.write(areatextfio.getText() + "#");
                writer.write(areaDateAndTime.getText() + "#");
                writer.write(outputText.getText() + "*");
                writer.close();
            } catch(Exception e) {
                System.out.println("ERROR of write File dr.onSaveButtonClick");
                e.printStackTrace();
            }
            ErrorFlag = false;
        } else {
            outputText.setText("заполните все поля!!");
            ErrorFlag = false;
        }
    }

    private String strMaker(){
        String strMakes = null;
        if(Objects.equals(areatextfio.getText(), "")) {
            System.out.println("WARNING");
            ErrorFlag = true;
        }
        if(Objects.equals(areaDateAndTime.getText(), "")) {
            System.out.println("FIASCO");
            ErrorFlag = true;
        }
        return strMakes;
    }



}
