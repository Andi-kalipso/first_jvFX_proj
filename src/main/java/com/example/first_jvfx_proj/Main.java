package com.example.first_jvfx_proj;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;


public class Main  extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainWindowTRY.fxml"));     //вставляем сюда окно вида на fxml (css)
        Scene scene = new Scene(fxmlLoader.load(), 800, 900);                               //настройки сцены
        stage.setResizable(false);                                                                 //ограничим размер окна для безопасного использования
        stage.setTitle("The Main Window!");                                                        //название окна
        stage.setScene(scene);                                                                     //передаем и показываем
        stage.show();
    }



    public static void main(String[] args) {
        Application.launch();
    }


}
