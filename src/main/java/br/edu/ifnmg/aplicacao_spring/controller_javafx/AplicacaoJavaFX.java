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
    private static Stage stage, innerStage;
    private static Parent mainScreen;

    public static Parent getMainScreen() {
        return mainScreen;
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        AplicacaoJavaFX.stage = stage;
    }

    public static Stage getInnerStage() {
        return innerStage;
    }

    public static void setInnerStage(Stage innerStage) {
        AplicacaoJavaFX.innerStage = innerStage;
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

    public static Stage carregarTela(Parent telaFXML){

        Scene newScene = new Scene(telaFXML);
        innerStage = new Stage(){{setScene(newScene); }};
        return innerStage;
    }

    @Override
    public void start(Stage primaryStage) {
        FxWeaver fxWeaver = new FxWeaver(contextoSpring::getBean, contextoSpring::close);
        // carregando os FXML
        Parent root = fxWeaver.loadView(LoginController.class);
        mainScreen = fxWeaver.loadView(MainController.class);


        // colocando os FXML em uma scene
        Scene scene = new Scene(root);

        //setando a scene para a janela
        setStage(primaryStage);
        stage.setScene(scene);
        stage.show();



    }
}