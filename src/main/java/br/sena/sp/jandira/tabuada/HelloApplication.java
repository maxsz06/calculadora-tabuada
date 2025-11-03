package br.sena.sp.jandira.tabuada;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public void start(Stage stage) throws IOException {

        //Definir o tamanho da tela (Stage)
        stage.setWidth(500);
        stage.setHeight(500);

        //Componente principal da tela
        VBox root = new VBox();
        Scene scene = new Scene(root);

        //Cabeçario da tela
        VBox header = new VBox();
        header.setStyle("-fx-padding: 20;-fx-background-color: #153cbe");

        //Adicionar um label ao header
        Label labelTitulo = new Label("Tabuada");
        labelTitulo.setStyle("-fx-text-fill: white; -fx-font-size: 30;-fx-font-weight: Bold");


        Label labelSubTitulo = new Label("Construa tabuada sem limites!");
        labelSubTitulo.setStyle("-fx-text-fill: white; -fx-font-size: 15");


        HBox multiplicandoBox = new HBox();
        multiplicandoBox.setStyle("-fx-padding: 10");
        Label labelMultiplicando = new Label("Multiplicando");
        TextField textFieldMultiplicando = new TextField();


        multiplicandoBox.getChildren().add(labelMultiplicando);
        multiplicandoBox.getChildren().add(textFieldMultiplicando);




        //(Importante) Colocar a ordem certa de como os textos vão ficar

        header.getChildren().add(labelTitulo);
        root.getChildren().add(header);

        //Colocar o header no root
        header.getChildren().add(labelSubTitulo);

        //colocamos o multplicandoBox no root
        root.getChildren().add(multiplicandoBox);



        stage.setScene(scene);
        stage.setTitle("Tabuada");
        stage.show();
    }

}