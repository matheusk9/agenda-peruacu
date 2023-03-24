package br.edu.ifnmg.aplicacao_spring.entidades;


import jakarta.persistence.*;

@Entity
@Table(name = "atrativos")
public class Atrativo {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(updatable = false, unique = true)
    private AtrativoEnum nome;

    public Long getId() {
        return id;
    }

    public AtrativoEnum getNome() {
        return nome;
    }

    public void setNome(AtrativoEnum nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "nome = " + nome.getNome();
    }
}
