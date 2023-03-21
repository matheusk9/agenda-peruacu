package br.edu.ifnmg.aplicacao_spring.controller_javafx;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@EntityScan("br.edu.ifnmg.aplicacao_spring")
@ComponentScan("br.edu.ifnmg.aplicacao_spring")
@SpringBootApplication
public class AplicacaoSpring {

    public static void main(String[] args) {
        Application.launch(AplicacaoJavaFX.class, args);
    }

}
