package br.sena.sp.jandira.tabuada;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class HelloApplication extends Application {

    TextField textFieldMultiplicando;
    TextField textFieldMenorMultiplicador;
    TextField textFieldMaiorMultplicador;
    ListView listaTabuada = new ListView();


    public void start(Stage stage) throws IOException {

        //Definir o tamanho da tela (Stage)
        stage.setWidth(500);
        stage.setHeight(600);

        //Bloquear o Redirecionamento da janela
        stage.setResizable(false);

        //Controlando o fechamento ao clicar no fechar da tela
        stage.setOnCloseRequest(event -> {
            fechar();
        });

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
        gridFormulario.setPadding(new Insets(20));
        gridFormulario.setHgap(10);
        gridFormulario.setVgap(10);



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
        boxBotoes.setAlignment(Pos.CENTER_RIGHT);

        boxBotoes.setPadding(new Insets(30));
        boxBotoes.setSpacing(20);



        Button btnCalcular = new Button("Calcular");
        btnCalcular.setOnAction(event -> {
            calcularTabuada();

          btnCalcular.setPrefWidth(90);
          btnCalcular.setMaxHeight(80);
        });

        Button btnLimpar = new Button("Limpar");
        btnLimpar.setOnAction(event -> {
            limparFormulario();

            btnLimpar.setPrefWidth (90);

        });


        Button btnSair = new Button("Sair");
        btnSair.setOnAction(event -> {
            fechar();

            btnSair.setPrefWidth(70);
        });


        //Adicionar os botões na boxBotoes
        boxBotoes.getChildren().addAll(btnCalcular, btnLimpar, btnSair);

        //Adicionar um componente ListView
        VBox boxResultado = new VBox(boxBotoes);
        Label labelResultado = new Label("Resultado:");
        labelResultado.setStyle("-fx-text-fill: blue; -fx-font-size: 18;-fx-font-weight: bold");
        boxResultado.setPadding(new Insets(10));

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

    public void limparFormulario() {
        textFieldMultiplicando.setText("");
        textFieldMenorMultiplicador.setText("");
        textFieldMaiorMultplicador.setText("");
        listaTabuada.getItems().clear();
        textFieldMultiplicando.requestFocus();
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
        public void fechar() {

        Alert alertaFechar = new Alert(Alert.AlertType.CONFIRMATION,
                "Confirma a saída do sistema?",
        ButtonType.YES,
        ButtonType.NO
        );
        Optional<ButtonType> resposta = alertaFechar.showAndWait();

        if (resposta.isPresent() && resposta.get() == ButtonType.YES) {
            Platform.exit();
        }

        }
}


