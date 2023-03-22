package br.edu.ifnmg.aplicacao_spring.controller_javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class AplicacaoJavaFX extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button button = new Button("Clique para exibir mensagem");

        button.setOnAction(e -> {
            System.out.println("Olá, mundo!");
        });

        VBox root = new VBox();
        root.getChildren().add(button);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Teste JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
