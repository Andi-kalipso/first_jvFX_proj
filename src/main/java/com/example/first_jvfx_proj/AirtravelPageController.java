package com.example.first_jvfx_proj;

import com.example.first_jvfx_proj.structClasses.airtravelTask;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
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
                                            //сделать сообщение о том, что ввести или типа того
        }
    }

    private boolean isAllFormsfilled(){
        if(Objects.equals(areaOUT.getText(), "")){
            System.out.println("заполните аэропорт вылета");
            return false;
        }

        if(Objects.equals(areaIN.getText(), "")){
            System.out.println("заполните аэропорт прилёта");
            return false;
        }

        if(Objects.equals(areaTimeFly.getText(), "")){
            System.out.println("заполните время в полёте");
            return false;
        }

        if(Objects.equals(areaTime.getText(), "")){
            System.out.println("заполните время вылета");
            return false;
        }

        if(Objects.equals(dataP.getValue().toString(), "")){
            System.out.println("заполните дату вылета");
            return false;
        }
        if(priorPP == null){
            System.out.println("заполните приоритет");
            return false;
        }


        return true;
    }
}
