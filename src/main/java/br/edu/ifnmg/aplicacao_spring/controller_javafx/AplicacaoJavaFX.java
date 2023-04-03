package br.edu.ifnmg.aplicacao_spring.controller_javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;

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

    public static void carregarTela(String scr, String nomeAba){
        switch (scr){
            case "main":
                stage.setScene(mainScene);
                notifyAllListeners("main", nomeAba);
                break;
            case "addGuia":
                stage.setScene(guiaScene);
                notifyAllListeners("addGuia", nomeAba);
        }
    }

    public static void carregarTela(String scr){
        carregarTela(scr, null);
    }


    // ------------ TROCAR INFORMAÇÕES ENTRE TELAS --------------
    private static ArrayList<OnChangeScreen> listeners = new ArrayList<>();

    public static interface OnChangeScreen{
        void onScreenChanged(String newScreen, Object userData);
    }

    public static void addOnChangeScreenListener(OnChangeScreen newListener){
        listeners.add(newListener);
    }

    private static void notifyAllListeners(String newScreen, Object userData){
        for(OnChangeScreen l : listeners)
            l.onScreenChanged(newScreen, userData);
    }
    // -------------- * ------------- * --------------------


}