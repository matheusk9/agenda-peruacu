
package br.edu.ifnmg.aplicacao_spring.infraestrutura;

import br.edu.ifnmg.aplicacao_spring.entidades.Atrativo;
import br.edu.ifnmg.aplicacao_spring.entidades.AtrativoEnum;
import br.edu.ifnmg.aplicacao_spring.servicos.AtrativoDAO;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class AtrativoService {
    private static AtrativoDAO atrativosRepository;

    public AtrativoService(AtrativoDAO atrativosRepository) {
        AtrativoService.atrativosRepository = atrativosRepository;
    }

    //executa o código logo após a inicialização do Spring
    @PostConstruct
    public static void popularAtrativos(){
        if(atrativosRepository.buscarTodos().isEmpty()){
            for (AtrativoEnum atrativoEnum : AtrativoEnum.values()) {
                Atrativo atrativo = new Atrativo();
                atrativo.setNome(atrativoEnum);
                atrativosRepository.salvar(atrativo);
            }
        }
    }

    public static void listarAtrativos(){
        System.out.println(atrativosRepository.buscarTodos());
    }
}
