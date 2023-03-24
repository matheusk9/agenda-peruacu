package br.edu.ifnmg.aplicacao_spring.entidades;

public enum AtrativoEnum {
        GRUTA_DO_JANELAO("Gruta do Janelão"),
        LAPA_DO_INDIO("Lapa do Índio"),
        LAPA_BONITA("Lapa Bonita"),
        LAPA_DO_BOQUETE("Lapa do Boquete"),
        LAPA_DOS_DESENHOS("Lapa dos Desenhos"),
        LAPA_DO_CABOCLO_E_CARLUCIO("Lapa do Caboclo e Carlucio"),
        LAPA_DO_REZAR("Lapa do Rezar"),
        ARCO_DO_ANDRE("Arco do André");


        private final String nome;

        AtrativoEnum(String nome) {
                this.nome = nome;
        }
        public String getNome() {
                return nome;
        }

}
