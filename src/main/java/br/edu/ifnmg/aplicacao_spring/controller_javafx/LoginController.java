package br.edu.ifnmg.aplicacao_spring.controller_javafx;

import br.edu.ifnmg.aplicacao_spring.servicos.Autenticacao;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView("viewLogin.fxml")
public class LoginController {

    @FXML
    private Button btnLogin;

    @FXML
    private TextField fieldLogin;

    @FXML
    private TextField fieldPassword;


    private final Autenticacao login;
    public LoginController(Autenticacao login) {
        this.login = login;
    }

    @FXML
    void autenticar() {
        String user = fieldLogin.getText();
        String password = fieldPassword.getText();
        if(login.autenticar(user, password)){
            AplicacaoJavaFX.getStage().close();
            AplicacaoJavaFX.carregarTela(AplicacaoJavaFX.getMainScreen()).show();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR, "Usuário ou senha inválidos. Deseja sair?", ButtonType.YES, ButtonType.NO);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                Platform.exit();
            }
        }
    }

}
