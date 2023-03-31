package br.edu.ifnmg.aplicacao_spring.controller_javafx;

import br.edu.ifnmg.aplicacao_spring.entidades.Guia;
import br.edu.ifnmg.aplicacao_spring.entidades.Usuario;
import br.edu.ifnmg.aplicacao_spring.servicos.GuiaDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

@Component
@FxmlView("viewMain.fxml")
public class MainController implements Initializable {

    @FXML
    private Button btnAdicionarAdm;
    @FXML
    private Button btnAdicionarGuia;
    @FXML
    private Button btnAdicionarNovo;
    @FXML
    private Button btnPainelControle;
    @FXML
    private Tab abaGuias;
    @FXML
    private Tab abaUsuarios;

    @FXML
    private TableView<Usuario> tbViewUsuario;
    @FXML
    private TableColumn<Usuario, Long> tcIDUsuario;
    @FXML
    private TableColumn<Usuario, Date> tcDateCreateUsuario;
    @FXML
    private TableColumn<Usuario, String> tcLoginUsuario;
    @FXML
    private TableColumn<Usuario, String> tcSenhaUsuario;
    @FXML
    private TableColumn<?, ?> tcAcaoUsuario;

    @FXML
    private TableView<Guia> tbViewGuias;
    @FXML
    private TableColumn<Guia, Long> tcIDGuia;
    @FXML
    private TableColumn<Guia, String> tcEmailGuia;
    @FXML
    private TableColumn<Guia, String> tcNomeGuia;
    @FXML
    private TableColumn<Guia, String> tcTelefoneGuia;
    @FXML
    private TableColumn<?, ?> tcAcaoGuia;

    @FXML
    private TableView<?> tbViewVisitas;
    @FXML
    private TableColumn<?, ?> tcAcao;
    @FXML
    private TableColumn<?, ?> tcAtrativo;
    @FXML
    private TableColumn<?, ?> tcCpf;
    @FXML
    private TableColumn<?, ?> tcData;
    @FXML
    private TableColumn<?, ?> tcNome;
    @FXML
    private TableColumn<?, ?> tcTelefone;

    private final GuiaDAO guiaRepository;
    public MainController(GuiaDAO guiaRepository) {
        this.guiaRepository = guiaRepository;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        abaGuias.setDisable(true);
        abaUsuarios.setDisable(true);
    }

    @FXML
    void adicionarNovoAdm(ActionEvent event) {
    }


    // --- GUIAS ---
    @FXML
    void adicionarNovosGuias(ActionEvent event) {
        AplicacaoJavaFX.carregarTela("addGuia");
    }

    ObservableList<Guia> listarTabelaGuia(){
        //retorna uma ObservableList do BD através de um casting feito com o FXCollections
        return FXCollections.observableArrayList(guiaRepository.buscarTodos());
    }
    @FXML
    void tableViewGuias(){
        tcIDGuia.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcNomeGuia.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tcTelefoneGuia.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        tcEmailGuia.setCellValueFactory(new PropertyValueFactory<>("email"));
        tbViewGuias.setItems(listarTabelaGuia());
    }

    @FXML
    void agendarNovaVisita(ActionEvent event) {
    }

    // --- PAINEL DE CONTROLE ---
    @FXML
    void painelControle(){
        if(!JanelaADM.isLogin()){
            JanelaADM.callScren();
            if(JanelaADM.isLogin()){
                abaGuias.setDisable(false);
                abaUsuarios.setDisable(false);
                tableViewGuias();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Tentativa de Login");
            alert.setHeaderText("Você já está logado como administrador.");
            alert.showAndWait();
        }

    }
}
