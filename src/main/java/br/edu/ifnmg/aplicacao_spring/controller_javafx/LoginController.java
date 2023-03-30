package br.edu.ifnmg.aplicacao_spring.controller_javafx;

import br.edu.ifnmg.aplicacao_spring.entidades.Usuario;
import br.edu.ifnmg.aplicacao_spring.servicos.UsuarioDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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


    private final UsuarioDAO usuarios;
    public LoginController(UsuarioDAO usuarios) {
        this.usuarios = usuarios;
    }

    @FXML
    void autenticar(ActionEvent event) {
        AplicacaoJavaFX.getStage().close();
        AplicacaoJavaFX.carregarTela(AplicacaoJavaFX
                .getMainScreen())
                .show();
    }

}
