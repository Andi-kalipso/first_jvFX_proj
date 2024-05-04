package com.example.first_jvfx_proj;

import com.example.first_jvfx_proj.structClasses.birthdayTask;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class DrPageController {             // класс для управления задачами др, а именно для формирования задачи, а после её сохраниения в список


    //объявляем переменные по id элементов на view листе
    @FXML
    private ChoiceBox<String> priorityBox;
    //филды
    @FXML
    private TextField areatextfio;

    @FXML
    private TextField areaTime;
    @FXML
    private DatePicker dataP;
    private Priority priorPP;

    public static List<birthdayTask> birthTasksList = new ArrayList<birthdayTask>();



    //сообщение об ошибках
    @FXML
    public Label outputText;
    //кнопка сохранения
    @FXML
    public Button saveButton;


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
                priorPP = Priority.prioritet_0;
                break;
            case "1":
                per = "обычная";
                priorPP = Priority.prioritet_1;
                break;
            case "2":
                per = "важна";
                priorPP = Priority.prioritet_2;
                break;
            case "3":
                per = "крайне важна";
                priorPP = Priority.prioritet_3;
                break;
        }

    }

    public void gettingListOfPrior(){
        String[] strList = {String.valueOf(Priority.prioritet_0.ordinal()),
                String.valueOf(Priority.prioritet_1.ordinal()),
                String.valueOf(Priority.prioritet_2.ordinal()),
                String.valueOf(Priority.prioritet_3.ordinal())};

        priorityBox.getItems().addAll(strList);
        priorityBox.setOnAction(this::getPrior);
        System.out.println(Priority.prioritet_0.ordinal());
    }

    public void onSaveButtonClick() throws IOException {
        String strok = strMaker();
        if(!ErrorFlag){
            try{
                System.out.println(dataP.getValue().toString());
                birthdayTask newBirth = new birthdayTask(dataP.getValue().toString(),areaTime.getText(),priorPP,areatextfio.getText());
                birthTasksList.addFirst(newBirth);
                FileWriter writer = new FileWriter("output.txt", true);
                writer.write(newBirth.toString() + "\n");

                writer.close();
                Stage stage = (Stage) saveButton.getScene().getWindow();
                stage.close();

            } catch(Exception e) {
                System.out.println("ERROR of write File dr.onSaveButtonClick");
                e.printStackTrace();
            }
            ErrorFlag = false;
            outputText.setText("запись создана!");
        } else {
            outputText.setText("ОШИБКА - заполните все поля!!");
            ErrorFlag = false;
        }
    }

    private String strMaker(){
        String strMakes = null;
        if(Objects.equals(areatextfio.getText(), "")) {
            System.out.println("WARNING");
            ErrorFlag = true;
        }

        if(dataP.getValue() == null) {
            System.out.println("FIASCO");
            ErrorFlag = true;
        }
        if(Objects.equals(areaTime.getText(), "")){
            System.out.println("FINNITO");
            ErrorFlag = true;
        }
        return strMakes;
    }



}
