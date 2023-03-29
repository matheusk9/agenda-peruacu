package br.edu.ifnmg.aplicacao_spring.controller_javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class AplicacaoJavaFX extends Application {

    private ConfigurableApplicationContext contextoSpring;

    @Override
    public void init() {
        String[] args = getParameters().getRaw().toArray(new String[0]);

        this.contextoSpring = new SpringApplicationBuilder()
                .sources(AplicacaoSpring.class)
                .run(args);
    }

    @Override
    public void stop() {
        this.contextoSpring.close();
        Platform.exit();
    }

    @Override
    public void start(Stage stage) {
        FxWeaver fxWeaver = new FxWeaver(contextoSpring::getBean, contextoSpring::close);
        Parent root = fxWeaver.loadView(LoginController.class);
        Scene scene = new Scene(root);


        stage.setScene(scene);
        stage.show();
    }
}