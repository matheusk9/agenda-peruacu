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
    private static Stage stage;
    private static Parent mainScreen, addGuiaScreen;
    private static Scene mainScene, guiaScene;

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        AplicacaoJavaFX.stage = stage;
    }

    @Override
    public void init() {
        String[] args = getParameters().getRaw().toArray(new String[0]);

        contextoSpring = new SpringApplicationBuilder()
                .sources(AplicacaoSpring.class)
                .run(args);
    }

    @Override
    public void stop() {
        contextoSpring.close();
        Platform.exit();
    }

    public static void carregarTela(String scr){
        switch (scr){
            case "main":
                stage.setScene(mainScene);
                break;
            case "addGuia":
                stage.setScene(guiaScene);
        }
    }

    @Override
    public void start(Stage primaryStage) {
        setStage(primaryStage);
        FxWeaver fxWeaver = new FxWeaver(contextoSpring::getBean, contextoSpring::close);

        // carregando as telas
        Parent root = fxWeaver.loadView(LoginController.class);
        Scene scene = new Scene(root);
        mainScreen = fxWeaver.loadView(MainController.class);
        mainScene = new Scene(mainScreen);
        addGuiaScreen = fxWeaver.loadView(AdicionarGuiaController.class);
        guiaScene = new Scene(addGuiaScreen);

        primaryStage.setScene(scene);
        primaryStage.show();
    }



}