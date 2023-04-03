package br.edu.ifnmg.aplicacao_spring.controller_javafx;

import br.edu.ifnmg.aplicacao_spring.entidades.Guia;
import br.edu.ifnmg.aplicacao_spring.entidades.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("viewAdicionarGuia.fxml")
public class AdicionarGuiaController implements Initializable{

    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnConfirmar;
    @FXML
    private AnchorPane paneCriarNovo;

    @FXML
    public Group groupAddNovoGuia;
    @FXML
    private TextField fieldEmailGuia;
    @FXML
    private TextField fieldNomeGuia;
    @FXML
    private TextField fieldTelGuia;

    @FXML
    public Group groupAddNovoUsuario;
    @FXML
    private TextField fieldAddLoginUser;
    @FXML
    private TextField fieldAddSenhaUser;

    public Group getGroupAddNovaVisita() {
        return this.groupAddNovaVisita;
    }

    public Group getGroupAddNovoGuia() {
        return this.groupAddNovoGuia;
    }

    public Group getGroupAddNovoUsuario() {
        return this.groupAddNovoUsuario;
    }

    @FXML
    public Group groupAddNovaVisita;
    @FXML
    private TextField fieldAddNomeVisita;
    @FXML
    private TextField fieldAddTelVisita;
    @FXML
    private TextField fieldAddAtrativoVisita;
    @FXML
    private TextField fieldAddCPFVisita;
    @FXML
    private TextField fieldAddDataVisita;
    @FXML
    private TextField fieldAddGuiaVisita;


    private void adicionarGuia(){
        Guia guia = new Guia();
        if (MainController.guiaRepository.buscaPorEmail(fieldEmailGuia.getText()) == null) {
            guia.setNome(fieldNomeGuia.getText());
            guia.setEmail(fieldEmailGuia.getText());
            guia.setTelefone(fieldTelGuia.getText());
            try {
                // salvando no BD
                MainController.guiaRepository.salvar(guia);
                // limpando campos
                MainController.limparCampos(new TextField[]{fieldNomeGuia, fieldEmailGuia, fieldTelGuia});
                // sucesso
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Cadastrado com sucesso!", ButtonType.FINISH);
                alert.showAndWait();
                AplicacaoJavaFX.carregarTela("main");
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.FINISH);
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Esse email já está cadastrado!", ButtonType.CLOSE);
            alert.showAndWait();
        }
    }

    private void adicionarUsuario(){
        Usuario usuario = new Usuario();

        if (MainController.usuarioRepository.buscarPorLogin(fieldAddLoginUser.getText()) == null) {
            usuario.setLogin(fieldAddLoginUser.getText());
            usuario.setPassword(fieldAddSenhaUser.getText());

            try {
                // salvando no BD
                MainController.usuarioRepository.salvar(usuario);
                // limpando campos
                MainController.limparCampos(new TextField[]{fieldAddLoginUser, fieldAddSenhaUser});
                // sucesso
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Cadastrado com sucesso!", ButtonType.FINISH);
                alert.showAndWait();
                AplicacaoJavaFX.carregarTela("main");
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.FINISH);
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Esse nome de usuario já existe!", ButtonType.CLOSE);
            alert.showAndWait();
        }
    }



    @FXML
    void cancelar() {
        MainController.limparCampos(new TextField[]{fieldNomeGuia, fieldEmailGuia, fieldTelGuia});
        AplicacaoJavaFX.carregarTela("main");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        AplicacaoJavaFX.addOnChangeScreenListener((newScreen, userData) -> {
            if(newScreen.equals("addGuia")){
                if(userData.equals("visita")){
                    getGroupAddNovaVisita().setVisible(true);
                    getGroupAddNovoUsuario().setVisible(false);
                    getGroupAddNovoGuia().setVisible(false);


                } else if (userData.equals("guia")) {
                    getGroupAddNovaVisita().setVisible(false);
                    getGroupAddNovoUsuario().setVisible(false);
                    getGroupAddNovoGuia().setVisible(true);

                    btnConfirmar.setOnMouseClicked(event -> {
                        adicionarGuia();
                    });

                } else if(userData.equals("usuario")){
                    getGroupAddNovaVisita().setVisible(false);
                    getGroupAddNovoUsuario().setVisible(true);
                    getGroupAddNovoGuia().setVisible(false);

                    btnConfirmar.setOnMouseClicked(event -> {
                        adicionarUsuario();
                    });

                } else paneCriarNovo.setDisable(true);
            }
        });

    }
}
