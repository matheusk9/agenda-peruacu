package br.edu.ifnmg.aplicacao_spring.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "responsavel_grupo")
public class ResponsavelGrupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200, nullable = false)
    private String nome;
    @Column(length = 15, nullable = false)
    private String telefone;
    @Column(nullable = false)
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ResponsavelGrupo{" +
                "nome='" + nome + '\'' +
                '}';
    }

}
