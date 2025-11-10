package br.sena.sp.jandira.tabuada;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    TextField textFieldMultiplicando;
    TextField textFieldMenorMultiplicador;
    TextField textFieldMaiorMultplicador;
    ListView listaTabuada = new ListView();


    public void start(Stage stage) throws IOException {

        //Definir o tamanho da tela (Stage)
        stage.setWidth(500);
        stage.setHeight(500);

        //Componente principal da tela
        VBox root = new VBox();
        Scene scene = new Scene(root);

        //Cabeçario da tela
        VBox header = new VBox();
        header.setStyle("-fx-padding: 20;-fx-background-color: #2144ad");

        //Adicionar um label ao header
        Label labelTitulo = new Label("Tabuada");
        labelTitulo.setStyle("-fx-text-fill: white; -fx-font-size: 30;-fx-font-weight: Bold");


        Label labelSubTitulo = new Label("Construa tabuada sem limites!");
        labelSubTitulo.setStyle("-fx-text-fill: white; -fx-font-size: 15");

        GridPane gridFormulario = new GridPane();
        Label labelMultiplicando = new Label("Multiplicando");
        textFieldMultiplicando= new TextField();

        Label labelMenorMultiplicador = new Label("Menor Multiplicador:");
        textFieldMenorMultiplicador = new TextField();

        Label labelMaiorMultplicador = new Label("Maior Multiplicador:");
        textFieldMaiorMultplicador = new TextField();


        gridFormulario.add(labelMultiplicando, 0, 0);
        gridFormulario.add(textFieldMultiplicando, 1, 0);
        gridFormulario.add(labelMenorMultiplicador, 0, 1);
        gridFormulario.add(textFieldMenorMultiplicador, 1, 1);
        gridFormulario.add(labelMaiorMultplicador, 0, 2);
        gridFormulario.add(textFieldMaiorMultplicador, 1, 2);





        //(Importante) Colocar a ordem certa de como os textos vão ficar

        header.getChildren().add(labelTitulo);
        root.getChildren().add(header);

        //Criar o componente de botões

        HBox boxBotoes  = new HBox();
        Button btnCalcular = new Button("Calcular");
        btnCalcular.setOnAction(event -> {
            calcularTabuada();
        });

        Button btnLimpar = new Button("Limpar");
        Button btnSair = new Button("Sair");

        //Adicionar os botões na boxBotoes
        boxBotoes.getChildren().addAll(btnCalcular, btnLimpar, btnSair);

        //Adicionar um componente ListView
        VBox boxResultado = new VBox(boxBotoes);
        Label labelResultado = new Label("Resultado:");
        labelResultado.setStyle("-fx-text-fill: blue; -fx-font-size: 18;-fx-font-weight: bold");


        // Adicionar o ListView

      listaTabuada = new ListView();



        //Adicionar o label ao box resultado

        boxResultado.getChildren().add(labelResultado);
        boxResultado.getChildren().add(listaTabuada);


        //Adicionar componentes ao root
        header.getChildren().add(labelSubTitulo);
        root.getChildren().add(gridFormulario);
        root.getChildren().add(boxBotoes);
        root.getChildren().add(boxResultado);


        stage.setScene(scene);
        stage.setTitle("Tabuada");
        stage.show();
    }

    public void calcularTabuada() {

        int multiplicando = Integer.parseInt(textFieldMultiplicando.getText());
        int  menorMultiplicador = Integer.parseInt(textFieldMenorMultiplicador.getText());
        int maiorMultiplicador = Integer.parseInt(textFieldMaiorMultplicador.getText());

        if (menorMultiplicador > maiorMultiplicador) {

            int auxiliar = menorMultiplicador;
            menorMultiplicador = maiorMultiplicador;
            maiorMultiplicador = auxiliar;
        }

        int tamanhoVetor= maiorMultiplicador - menorMultiplicador +1;
        String[] tabuada = new String[tamanhoVetor];


        int contador = 0;

        while (contador < tamanhoVetor) {

            double produto = multiplicando * menorMultiplicador;

            tabuada[contador] = multiplicando + " X " + menorMultiplicador + " = "  + produto;
            contador++;
            menorMultiplicador ++;
        }

        listaTabuada.getItems().clear();
        listaTabuada.getItems().addAll(tabuada);

    }

}