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


public class MainController {
    @FXML
    private Label welcomeText;          // это айдишник лейбла



    @FXML
    private ListView<String> mainListNodes;

    private ObservableList<String> langs;

    //private PageLayout choiceNodePage;
    @FXML
    protected void initialize(){
        System.out.print("init_Main_OK");
        ObservableList<String> langs2;
        langs = FXCollections.observableArrayList("Java", "JavaScript", "C#", "Python");
        mainListNodes.setItems(langs); //подумать над этим, думать не к чему, получается отдельно котроллер сделал для choice и погнали дальше
    }






    @FXML
    protected void onHelloButtonClick() {       //здесь вызов идёт из fxml файла и тут же по идеи можно прокинуть следующую страницу, поверх, свойстом
        welcomeText.setText("Welcome to JavaFX Application!");

    }

    @FXML
    void onNewNodeButtonClick(ActionEvent event) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ChoiceNodePage.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stageChoice = new Stage();
            stageChoice.setTitle("choise Window");
            stageChoice.setScene(new Scene(root1));
            stageChoice.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }




}
