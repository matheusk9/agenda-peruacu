package br.edu.ifnmg.aplicacao_spring.controller_javafx;

import br.edu.ifnmg.aplicacao_spring.entidades.Guia;
import br.edu.ifnmg.aplicacao_spring.entidades.Usuario;
import br.edu.ifnmg.aplicacao_spring.servicos.GuiaDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.Effect;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;


import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

@Component
@FxmlView(value = "viewMain.fxml")
public class MainController implements Initializable {

    @FXML
    private AnchorPane paneGuiasEdit;
    @FXML
    private Button btnAdicionarAdm;
    @FXML
    private Button btnAdicionarGuia;
    @FXML
    private Button btnAdicionarNovo;
    @FXML
    private Button btnPainelControle;
    @FXML
    private Button btnAtualizar;
    @FXML
    private Button btnCancelar;

    @FXML
    private Tab abaGuias;
    @FXML
    private Tab abaUsuarios;
    @FXML
    private Tab abaAgendamento;
    @FXML
    private ImageView iconDelete;
    @FXML
    private ImageView iconEdit;
    @FXML
    private ImageView iconRefresh;

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
    private Group detailsUsers;
    @FXML
    private TextField fieldEditSenha;
    @FXML
    private TextField fieldEditLogin;

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
    private TextField fieldEditEmail;
    @FXML
    private TextField fieldEditNome;
    @FXML
    private TextField fieldEditTelefone;
    @FXML
    private Group detailsGuias;

    @FXML
    private TableView<?> tbViewVisitas;
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
    @FXML
    private TableColumn<?, ?> tcGuia;

    protected static GuiaDAO guiaRepository;

    public MainController( GuiaDAO guiaRepository) {
        MainController.guiaRepository = guiaRepository;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        paneGuiasEdit.setVisible(false);
        abaGuias.setDisable(true);
        abaUsuarios.setDisable(true);

        iconEdit.setOnMouseClicked(event -> paneGuiasEdit.setVisible(!paneGuiasEdit.isVisible()));

    }

    @FXML
    private void adicionarNovoAdm(ActionEvent event) {
    }


    // --- CRUD GUIAS ---
    @FXML
    private void adicionarNovosGuias(ActionEvent event) {
        AplicacaoJavaFX.carregarTela("addGuia");
    }

    private ObservableList<Guia> listarTabelaGuia(){
        //retorna uma ObservableList do BD através de um casting feito com o FXCollections
        return FXCollections.observableArrayList(guiaRepository.buscarTodos());
    }
    @FXML
    private void atualizarTabelaGuias(){
        tcIDGuia.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcNomeGuia.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tcTelefoneGuia.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        tcEmailGuia.setCellValueFactory(new PropertyValueFactory<>("email"));
        tbViewGuias.setItems(listarTabelaGuia());
    }

    @FXML
    private void agendarNovaVisita(ActionEvent event) {
    }

    // --- PAINEL DE CONTROLE ---
    @FXML
    private void painelControle(){
        if(!JanelaADM.isLogin()){
            JanelaADM.callScren();
            if(JanelaADM.isLogin()){
                abaGuias.setDisable(false);
                abaUsuarios.setDisable(false);
                atualizarTabelaGuias();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Tentativa de Login");
            alert.setHeaderText("Você já está logado como administrador.");
            alert.showAndWait();
        }
    }

    // Limpa os campos preenchidos
    protected static void limparCampos(TextField[] campos){
        for(TextField campo:campos){
            campo.clear();
        }
    }

    // --- ABA GUIAS ---
    @FXML
    private void funcoesAbaGuias(){
        paneGuiasEdit.setVisible(false);
        detailsUsers.setVisible(false);
        detailsGuias.setVisible(true);

        //delete
        iconDelete.setOnMouseClicked(event -> {
            Long id = tbViewGuias.getSelectionModel().getSelectedItem().getId();
            int index = tbViewGuias.getSelectionModel().getSelectedIndex();
            guiaRepository.excluir(guiaRepository.buscaPorId(id));
            tbViewGuias.getItems().remove(index);
        });

        //refresh
        iconRefresh.setOnMouseClicked(event -> atualizarTabelaGuias());
    }

    // --- ABA USUARIOS ---
    @FXML
    private void funcoesAbaUsuarios(){
        paneGuiasEdit.setVisible(false);
        detailsGuias.setVisible(false);
        detailsUsers.setVisible(true);

        iconDelete.setOnMouseClicked(event -> {

        });

        iconRefresh.setOnMouseClicked(event -> {});
    }

    // --- ABA AGENDAMENTO ---
    @FXML
    private void funcoesAbaAgendamento(){
        paneGuiasEdit.setVisible(false);
        detailsGuias.setVisible(false);
        detailsUsers.setVisible(false);


        iconDelete.setOnMouseClicked(event -> {

        });

        iconRefresh.setOnMouseClicked(event -> {});
    }


}
