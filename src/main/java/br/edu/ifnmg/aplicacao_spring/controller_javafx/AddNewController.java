package br.edu.ifnmg.aplicacao_spring.controller_javafx;

import br.edu.ifnmg.aplicacao_spring.entidades.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.*;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@Component
@FxmlView("viewAddNew.fxml")
public class AddNewController implements Initializable{
    @FXML
    private ComboBox<Atrativo> boxAddAtrativoVisita;
    @FXML
    private ComboBox<Guia> boxAddGuiaVisita;
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

    @FXML
    public Group groupAddNovaVisita;
    @FXML
    private TextField fieldAddNomeVisita;
    @FXML
    private TextField fieldAddTelVisita;
    @FXML
    private TextField fieldAddCPFVisita;
    @FXML
    private TextField fieldAddDataVisita;
    @FXML
    private TextField fieldAddEmailVisita;

    public Group getGroupAddNovaVisita() {
        return this.groupAddNovaVisita;
    }

    public Group getGroupAddNovoGuia() {
        return this.groupAddNovoGuia;
    }

    public Group getGroupAddNovoUsuario() {
        return this.groupAddNovoUsuario;
    }

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
                clear();
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
                clear();
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

    private void adicionarVisita(){
        ResponsavelGrupo dadosResponsavel = new ResponsavelGrupo();
        Visita dadosVisita = new Visita();

        if (MainController.responsavelRepository.buscaPorCPF(fieldAddCPFVisita.getText()) == null) {
            dadosResponsavel.setCpf(fieldAddCPFVisita.getText());
            dadosResponsavel.setNome(fieldAddNomeVisita.getText());
            dadosResponsavel.setEmail(fieldAddEmailVisita.getText());
            dadosResponsavel.setTelefone(fieldAddTelVisita.getText());

            try {
                // salvando no BD
                MainController.responsavelRepository.salvar(dadosResponsavel);
                // limpando campos
                clear();
                // sucesso
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Cadastrado com sucesso!", ButtonType.FINISH);
                alert.showAndWait();
                AplicacaoJavaFX.carregarTela("main");
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.FINISH);
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "CPF já cadastrado no sistema!", ButtonType.CLOSE);
            alert.showAndWait();
        }
    }

    private void carregarBox() {
        ObservableList<Guia> obsListaGuias = FXCollections.observableArrayList(MainController.guiaRepository.buscarTodos());
        boxAddGuiaVisita.setItems(obsListaGuias);
        ObservableList<Atrativo> obsListaAtrativos = FXCollections.observableArrayList(MainController.atrativoRepository.buscarTodos());
        boxAddAtrativoVisita.setItems(obsListaAtrativos);
    }

    void clear(){
        MainController.limparCampos(new TextField[]
                {fieldNomeGuia, fieldTelGuia, fieldEmailGuia,
                        fieldAddLoginUser, fieldAddSenhaUser,
                        fieldAddCPFVisita,fieldAddNomeVisita,fieldAddEmailVisita,fieldAddTelVisita});
    }

    @FXML
    void cancelar() {
        clear();
        AplicacaoJavaFX.carregarTela("main");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        AplicacaoJavaFX.addOnChangeScreenListener((newScreen, userData) -> {
            if(newScreen.equals("addNew")){
                if(userData.equals("visita")){
                    getGroupAddNovaVisita().setVisible(true);
                    getGroupAddNovoUsuario().setVisible(false);
                    getGroupAddNovoGuia().setVisible(false);
                    carregarBox();

                    btnConfirmar.setOnMouseClicked(event -> adicionarVisita());

                } else if (userData.equals("guia")) {
                    getGroupAddNovaVisita().setVisible(false);
                    getGroupAddNovoUsuario().setVisible(false);
                    getGroupAddNovoGuia().setVisible(true);

                    btnConfirmar.setOnMouseClicked(event -> adicionarGuia());

                } else if(userData.equals("usuario")){
                    getGroupAddNovaVisita().setVisible(false);
                    getGroupAddNovoUsuario().setVisible(true);
                    getGroupAddNovoGuia().setVisible(false);

                    btnConfirmar.setOnMouseClicked(event -> adicionarUsuario());

                } else paneCriarNovo.setDisable(true);
            }
        });

    }
}
