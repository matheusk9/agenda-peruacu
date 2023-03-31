package br.edu.ifnmg.aplicacao_spring.controller_javafx;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class JanelaADM {

    private static final String loginADM = "admin";
    private static final String senhaADM = "1234";
    private static boolean login=false;

    public static boolean isLogin() {
        return login;
    }

    static void callScren(){
        Stage stage = new Stage();
        // Criação dos componentes da janela
        Label lblTitulo = new Label("Login do Administrador");
        lblTitulo.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        Label lblUsuario = new Label("Usuário:");
        Label lblSenha = new Label("Senha:");
        TextField txtUsuario = new TextField();
        PasswordField txtSenha = new PasswordField();
        Button btnEntrar = new Button("Entrar");
        Label lblErro = new Label();
        lblErro.setTextFill(Color.RED);


        // Configuração do layout
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        gridPane.add(lblTitulo, 0, 0, 2, 1);
        gridPane.add(lblUsuario, 0, 1);
        gridPane.add(txtUsuario, 1, 1);
        gridPane.add(lblSenha, 0, 2);
        gridPane.add(txtSenha, 1, 2);
        gridPane.add(btnEntrar, 1, 3);
        gridPane.add(lblErro, 1, 4);


        // Configuração do evento de clique no botão "Entrar"
        btnEntrar.setOnAction(event -> {
            // Verifica se o usuário e a senha são válidos
            String usuario = txtUsuario.getText();
            String senha = txtSenha.getText();
            if (usuario.equals(loginADM) && senha.equals(senhaADM)) {
                login = true;
                stage.close();
            } else {
                lblErro.setText("Credenciais incorretas.");
            }
        });
        // Configuração da cena e exibição da janela
        Scene scene = new Scene(gridPane, 400, 250);
        stage.setTitle("Login do Administrador");
        stage.setScene(scene);
        stage.showAndWait();
    }
}
