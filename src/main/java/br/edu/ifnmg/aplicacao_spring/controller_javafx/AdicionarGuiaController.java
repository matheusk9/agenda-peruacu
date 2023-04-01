package br.edu.ifnmg.aplicacao_spring.controller_javafx;

import br.edu.ifnmg.aplicacao_spring.entidades.Guia;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView("viewAdicionarGuia.fxml")
public class AdicionarGuiaController{

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


    @FXML
    void adicionar() {
        Guia guia = new Guia();

        if(MainController.guiaRepository.buscaPorEmail(fieldEmailGuia.getText()) == null){
            guia.setNome(fieldNomeGuia.getText());
            guia.setEmail(fieldEmailGuia.getText());
            guia.setTelefone(fieldTelGuia.getText());
            try{
                // salvando no BD
                MainController.guiaRepository.salvar(guia);
                // limpando campos
                MainController.limparCampos(new TextField[]{fieldNomeGuia, fieldEmailGuia, fieldTelGuia});
                // sucesso
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Cadastrado com sucesso!", ButtonType.FINISH);
                alert.showAndWait();
                AplicacaoJavaFX.carregarTela("main");
            }catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.FINISH);
                alert.showAndWait();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR, "Esse email já está cadastrado!", ButtonType.CLOSE);
            alert.showAndWait();
        }
    }

    @FXML
    void cancelar() {
        MainController.limparCampos(new TextField[]{fieldNomeGuia, fieldEmailGuia, fieldTelGuia});
        AplicacaoJavaFX.carregarTela("main");
    }
}
