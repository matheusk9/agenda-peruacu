package br.edu.ifnmg.aplicacao_spring.controller_javafx;

import br.edu.ifnmg.aplicacao_spring.entidades.Guia;
import br.edu.ifnmg.aplicacao_spring.servicos.GuiaDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView("viewAdicionarGuia.fxml")
public class AdicionarGuiaController {

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnConfirmar;

    @FXML
    private TextField fieldEmailGuia;

    @FXML
    private TextField fieldNomeGuia;

    @FXML
    private TextField fieldTelGuia;

    private final GuiaDAO guiaRepository;

    public AdicionarGuiaController(GuiaDAO guiaRepository) {
        this.guiaRepository = guiaRepository;
    }

    @FXML
    void adicionar() {
        Guia guia = new Guia();
        String nome = fieldNomeGuia.getText();
        String email = fieldEmailGuia.getText();
        String tel = fieldTelGuia.getText();

        if(guiaRepository.buscaPorEmail(email) == null){
            guia.setNome(nome);
            guia.setEmail(email);
            guia.setTelefone(tel);
            guiaRepository.salvar(guia);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Cadastrado com sucesso!", ButtonType.FINISH);
            alert.showAndWait();
            AplicacaoJavaFX.carregarTela("main");
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR, "Esse email já está cadastrado!", ButtonType.CLOSE);
            alert.showAndWait();
        }
    }

    @FXML
    void cancelar() {
        AplicacaoJavaFX.carregarTela("main");
    }
}
