package br.edu.ifnmg.aplicacao_spring.controller_javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView("viewMain.fxml")
public class MainController {

    @FXML
    private Button btnAdicionarAdm;

    @FXML
    private Button btnAdicionarGuia;

    @FXML
    private Button btnAdicionarNovo;

    @FXML
    private TableView<?> tbViewADM;

    @FXML
    private TableView<?> tbViewGuias;

    @FXML
    private TableView<?> tbViewVisitas;

    @FXML
    private TableColumn<?, ?> tcAcao;

    @FXML
    private TableColumn<?, ?> tcAcaoADM;

    @FXML
    private TableColumn<?, ?> tcAcaoGuia;

    @FXML
    private TableColumn<?, ?> tcAtrativo;

    @FXML
    private TableColumn<?, ?> tcCPFADM;

    @FXML
    private TableColumn<?, ?> tcEmailGuia;

    @FXML
    private TableColumn<?, ?> tcCpf;

    @FXML
    private TableColumn<?, ?> tcData;

    @FXML
    private TableColumn<?, ?> tcNome;

    @FXML
    private TableColumn<?, ?> tcNomeADM;

    @FXML
    private TableColumn<?, ?> tcNomeGuia;

    @FXML
    private TableColumn<?, ?> tcTelefone;

    @FXML
    private TableColumn<?, ?> tcTelefoneADM;

    @FXML
    private TableColumn<?, ?> tcTelefoneGuia;

    public MainController() {
    }

    @FXML
    void adicionarNovoAdm(ActionEvent event) {

    }

    @FXML
    void adicionarNovosGuias(ActionEvent event) {
        AplicacaoJavaFX.carregarTela("addGuia");
    }

    @FXML
    void agendarNovaVisita(ActionEvent event) {

    }

}
