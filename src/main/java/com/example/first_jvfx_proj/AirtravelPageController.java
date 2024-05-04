package com.example.first_jvfx_proj;

import com.example.first_jvfx_proj.structClasses.airtravelTask;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class AirtravelPageController {

    //объявляем переменные по id элементов на view листе
    @FXML
    private ChoiceBox<String> priorityBox;

    @FXML
    private TextField areaTime;

    @FXML
    private DatePicker dataP;

    @FXML
    private TextField areaOUT;

    @FXML
    private TextField areaIN;

    @FXML
    private TextField areaTimeFly;

    @FXML
    private Button saveButton;

    private Priority priorPP;

    @FXML
    private Label outputLabel;

    //метод для передачи в ChoiseBox элементов
    public void gettingListOfPrior(){
        String[] strList = {String.valueOf(Priority.prioritet_0),
                String.valueOf(Priority.prioritet_1),
                String.valueOf(Priority.prioritet_2),
                String.valueOf(Priority.prioritet_3)};

        priorityBox.getItems().addAll(strList);
        priorityBox.setOnAction(this::getPrior);
        System.out.println(Priority.prioritet_0.ordinal());
    }

    //метод для того, чтобы сохранять в файл понимаемые человеком данные
    @FXML
    public void getPrior(ActionEvent event){

        String prior = priorityBox.getValue();
        String per = null;

        switch (prior){
            case "prioritet_0":
                per = "не важна";
                priorPP = Priority.prioritet_0;
                break;
            case "prioritet_1":
                per = "обычная";
                priorPP = Priority.prioritet_1;
                break;
            case "prioritet_2":
                per = "важна";
                priorPP = Priority.prioritet_2;
                break;
            case "prioritet_3":
                per = "крайне важна";
                priorPP = Priority.prioritet_3;
                break;
        }

    }

    @FXML
    public void initialize(){
        gettingListOfPrior();   //для нормального отображения выбора приоритета

    }


    @FXML
    public void onSaveButtonClick()  throws IOException {
        boolean flagOfForms = isAllFormsfilled();
        if(flagOfForms) {
            airtravelTask airtravelTaskObj = new airtravelTask(dataP.getValue().toString(), areaTime.getText(), priorPP,
                    areaOUT.getText(), areaIN.getText(), areaTimeFly.getText());
            try{
                FileWriter writer = new FileWriter("output.txt", true);
                writer.write(airtravelTaskObj.toString() + "\n");

                writer.close();
                Stage stage = (Stage) saveButton.getScene().getWindow();
                stage.close();

            } catch(Exception e){
                System.out.println("ERROR of write File airTrabelPageController.onSaveButtonClick");
                e.printStackTrace();
            }
        } else {
                     flagOfForms = true;                       //сделать сообщение о том, что ввести или типа того
        }
    }

    private boolean isAllFormsfilled(){
        if(Objects.equals(areaOUT.getText(), "")){
            outputLabel.setText("заполните аэропорт вылета");
            System.out.println("заполните аэропорт вылета");
            return false;
        }

        if(Objects.equals(areaIN.getText(), "")){
            outputLabel.setText("заполните аэропорт прилёта");
            System.out.println("заполните аэропорт прилёта");
            return false;
        }

        if(Objects.equals(areaTimeFly.getText(), "")){
            outputLabel.setText("заполните время в полёте");
            System.out.println("заполните время в полёте");
            return false;
        }

        if(Objects.equals(areaTime.getText(), "")){
            outputLabel.setText("заполните время вылета");
            System.out.println("заполните время вылета");
            return false;
        }

        if(dataP.getValue() == null){
            outputLabel.setText("заполните дату вылета");
            System.out.println("заполните дату вылета");
            return false;
        }
        if(priorPP == null){
            outputLabel.setText("заполните приоритет");
            System.out.println("заполните приоритет");
            return false;
        }

        return true;
    }
}
