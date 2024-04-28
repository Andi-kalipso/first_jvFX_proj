package com.example.first_jvfx_proj;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;      //вот тут прокидываем
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class ChoiceNodePageController {                                         //форма для выбора какую задачу ставим


    @FXML
    private Button birthButton;

    @FXML
    private Button buisnessMeetButton;

    @FXML
    private Button airtravelButton;

    @FXML
    protected void onbirthButtonClick()  throws Exception {                     //при нажатии кнопки переходим на форму дня рождения

        //закрываем окно и открываем то, которое будет с конкретной формой работать
        Stage stage = (Stage) birthButton.getScene().getWindow();
        stage.close();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("drPage.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stageChoice = new Stage();
            stageChoice.setTitle("Birthday Window");
            stageChoice.setScene(new Scene(root1));

            stageChoice.show();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    protected void onBuisnessMeetButtonClick()  throws Exception {              //при нажатии кнопки переходим на форму бизнес встречи

        //закрываем окно и открываем то, которое будет с конкретной формой работать
        Stage stage = (Stage) buisnessMeetButton.getScene().getWindow();
        stage.close();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("buisnessMeetPage.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stageChoice = new Stage();
            stageChoice.setTitle("Buisness Meet Window");
            stageChoice.setScene(new Scene(root1));
            stageChoice.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    protected void onAirtravelButtonClick()  throws Exception {                 //при нажатии кнопки переходим на форму авиаперелёта

        //закрываем окно и открываем то, которое будет с конкретной формой работать
        Stage stage = (Stage) airtravelButton.getScene().getWindow();
        stage.close();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("airtravelPage.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stageChoice = new Stage();
            stageChoice.setTitle("Air Travel Window");
            stageChoice.setScene(new Scene(root1));
            stageChoice.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
