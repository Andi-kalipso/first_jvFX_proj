package com.example.first_jvfx_proj;

import com.example.first_jvfx_proj.DrPageController;
import com.example.first_jvfx_proj.structClasses.birthdayTask;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.AccessibleRole;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;      //вот тут прокидываем
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.*;


public class MainController {
    @FXML
    private Label welcomeText;          // это айдишник лейбла



    @FXML
    private ListView<String> mainListNodes;
    private List<Date> mainListNodesForSort = new ArrayList<Date>();
    private ObservableList<String> langs;
    private ObservableList<String> mainList = FXCollections.observableArrayList();

    //private PageLayout choiceNodePage;
    @FXML
    protected void initialize() throws IOException {
        System.out.print("init_Main_OK");
        FileReader reader;
        reader = new FileReader("output.txt");
        Scanner scanReader = new Scanner(reader);
        int i = 1;
        while (scanReader.hasNextLine()){
            String lineNow;
            lineNow = scanReader.nextLine();
            String[] arrLineNow = lineNow.split("#");

            mainList.add(i + "-->" + lineNow);
            i++;
        }
        reader.close();

        mainListNodes.setItems(mainList); //подумать над этим, думать не к чему, получается отдельно котроллер сделал для choice и погнали дальше
    }




    @FXML
    void onNewNodeButtonClick(ActionEvent event) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("choiceNodePage.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stageChoice = new Stage();
            stageChoice.setTitle("choise Window");
            stageChoice.setScene(new Scene(root1));
            stageChoice.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void onUpdateMainListButtonClick(ActionEvent event) throws IOException {

        mainListNodes.getItems().clear();
        FileReader reader;
        reader = new FileReader("output.txt");
        Scanner scanReader = new Scanner(reader);
        int i = 1;
        while (scanReader.hasNextLine()){
            mainList.add(i + "-->" + scanReader.nextLine());
            i++;
        }
        reader.close();

//        if(DrPageController.birthTasksList.size() != 0){
//            for (birthdayTask birthdayTaskObj : DrPageController.birthTasksList) {
//                mainList.add(birthdayTaskObj.toString());
//            }
//        }
        mainListNodes.setItems(mainList);
    }
}
