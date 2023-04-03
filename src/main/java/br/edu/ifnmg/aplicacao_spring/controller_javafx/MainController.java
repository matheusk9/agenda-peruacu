package br.edu.ifnmg.aplicacao_spring.controller_javafx;

import br.edu.ifnmg.aplicacao_spring.entidades.Guia;
import br.edu.ifnmg.aplicacao_spring.entidades.Usuario;
import br.edu.ifnmg.aplicacao_spring.servicos.AtrativoDAO;
import br.edu.ifnmg.aplicacao_spring.servicos.GuiaDAO;
import br.edu.ifnmg.aplicacao_spring.servicos.ResponsavelGrupoDAO;
import br.edu.ifnmg.aplicacao_spring.servicos.UsuarioDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private AnchorPane anchorPaneEdit;
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
    private TextField fieldEditSenhaUser;
    @FXML
    private TextField fieldEditLoginUser;

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
    private TextField fieldEditEmailGuia;
    @FXML
    private TextField fieldEditNomeGuia;
    @FXML
    private TextField fieldEditTelefoneGuia;
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

    protected static ResponsavelGrupoDAO responsavelRepository;
    protected static AtrativoDAO atrativoRepository;
    protected static GuiaDAO guiaRepository;
    protected static UsuarioDAO usuarioRepository;
    protected static ResponsavelGrupoDAO visitaRepository;


    public MainController(ResponsavelGrupoDAO responsavelRepository,AtrativoDAO atrativoRepository,GuiaDAO guiaRepository, UsuarioDAO usuarioRepository, ResponsavelGrupoDAO visitaRepository) {
        MainController.responsavelRepository = responsavelRepository;
        MainController.atrativoRepository = atrativoRepository;
        MainController.guiaRepository = guiaRepository;
        MainController.usuarioRepository = usuarioRepository;
        MainController.visitaRepository = visitaRepository;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        anchorPaneEdit.setVisible(false);
        abaGuias.setDisable(true);
        abaUsuarios.setDisable(true);

        iconEdit.setOnMouseClicked(event -> anchorPaneEdit.setVisible(!anchorPaneEdit.isVisible()));
        btnCancelar.setOnMouseClicked(event -> anchorPaneEdit.setVisible(false));

        btnAdicionarNovo.setOnMouseClicked(event -> {
            AplicacaoJavaFX.carregarTela("addNew","visita");
        });





    }

    private ObservableList<?> listarTabela(String tabela){
        switch (tabela) {
            case "guia":
                return FXCollections.observableArrayList(guiaRepository.buscarTodos());
            case "usuario":
                return FXCollections.observableArrayList(usuarioRepository.buscarTodos());
            case "visita":
                return FXCollections.observableArrayList(visitaRepository.buscarTodos());
            default:
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Carregar tabela");
                alert.setHeaderText("Não foi possível carregar a tabela. Tente novamente mais tarde!");
                alert.showAndWait();
                return null;
        }
    }
    @FXML
    private void atualizarTabelaGuias(){
        tcIDGuia.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcNomeGuia.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tcTelefoneGuia.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        tcEmailGuia.setCellValueFactory(new PropertyValueFactory<>("email"));
        tbViewGuias.setItems((ObservableList<Guia>) listarTabela("guia"));
    }

    @FXML
    private void atualizarTabelaUsuario(){
        tcIDUsuario.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcLoginUsuario.setCellValueFactory(new PropertyValueFactory<>("login"));
        tcSenhaUsuario.setCellValueFactory(new PropertyValueFactory<>("password"));
        tcDateCreateUsuario.setCellValueFactory(new PropertyValueFactory<>("dateCreate"));
        tbViewUsuario.setItems((ObservableList<Usuario>) listarTabela("usuario"));
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
                atualizarTabelaUsuario();
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
        anchorPaneEdit.setVisible(false);
        detailsUsers.setVisible(false);
        detailsGuias.setVisible(true);

        //Insert
        btnAdicionarGuia.setOnMouseClicked(event -> AplicacaoJavaFX.carregarTela("addNew", "guia"));

        //refresh
        iconRefresh.setOnMouseClicked(event -> atualizarTabelaGuias());

        // Edit
        tbViewGuias.setOnMouseClicked(event -> {
            int index = tbViewGuias.getSelectionModel().getSelectedIndex();
            Guia guiaSelecionado = tbViewGuias.getItems().get(index);
            fieldEditNomeGuia.setText(guiaSelecionado.getNome());
            fieldEditEmailGuia.setText(guiaSelecionado.getEmail());
            fieldEditTelefoneGuia.setText(guiaSelecionado.getTelefone());

            //delete
            iconDelete.setOnMouseClicked(event0 -> {
                guiaRepository.excluir(guiaRepository.buscaPorId(guiaSelecionado.getId()));
                tbViewGuias.getItems().remove(index);
            });

            //update
            btnAtualizar.setOnMouseClicked(event1 -> {
                Guia editarGuia = guiaRepository.buscaPorId(guiaSelecionado.getId());

                editarGuia.setNome(fieldEditNomeGuia.getText());
                editarGuia.setEmail(fieldEditEmailGuia.getText());
                editarGuia.setTelefone(fieldEditTelefoneGuia.getText());
                guiaRepository.atualizar(editarGuia);
                atualizarTabelaGuias();
                anchorPaneEdit.setVisible(false);
                tbViewGuias.refresh();
            });
        });
    }

    // --- ABA USUARIOS ---
    @FXML
    private void funcoesAbaUsuarios(){
        anchorPaneEdit.setVisible(false);
        detailsGuias.setVisible(false);
        detailsUsers.setVisible(true);

        //insert
        btnAdicionarAdm.setOnMouseClicked(event -> AplicacaoJavaFX.carregarTela("addNew", "usuario"));

        //refresh
        iconRefresh.setOnMouseClicked(event -> atualizarTabelaUsuario());

        // Edit
        tbViewUsuario.setOnMouseClicked(event -> {
            int index = tbViewUsuario.getSelectionModel().getSelectedIndex();
            Usuario usuarioSelecionado = tbViewUsuario.getItems().get(index);
            fieldEditLoginUser.setText(usuarioSelecionado.getLogin());
            fieldEditSenhaUser.setText(usuarioSelecionado.getPassword());

            //delete
            iconDelete.setOnMouseClicked(event0 -> {
                usuarioRepository.excluir(usuarioRepository.buscaPorId(usuarioSelecionado.getId()));
                tbViewUsuario.getItems().remove(index);
            });

            //update
            btnAtualizar.setOnMouseClicked(event1 -> {
                Usuario editarUsuario = usuarioRepository.buscaPorId(usuarioSelecionado.getId());

                editarUsuario.setLogin(fieldEditLoginUser.getText());
                editarUsuario.setPassword(fieldEditSenhaUser.getText());
                usuarioRepository.atualizar(editarUsuario);
                atualizarTabelaUsuario();
                anchorPaneEdit.setVisible(false);
                tbViewUsuario.refresh();
            });
        });
    }

    // --- ABA AGENDAMENTO ---

}
