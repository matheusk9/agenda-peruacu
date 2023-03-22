package br.edu.ifnmg.aplicacao_spring.entidades;


import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "visitas")
public class Visita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "data_visita", nullable = false)
    private LocalDate dataVisita;
    @Column(name = "periodo_visita", nullable = false)
    private PeriodoVisita periodoVisita;
    @Column(name = "tam_grupo", nullable = false)
    private Integer numeroVisitantes;
    @ManyToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "atrativo_id"))
    private Atrativo atrativo;
    @OneToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "responsavel_id"))
    private ResponsavelGrupo responsavelGrupo;
    @ManyToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "guia_id"))
    private Guia guia;

    public Integer getNumeroVisitantes() {
        return numeroVisitantes;
    }

    public void setNumeroVisitantes(Integer numeroVisitantes) {
        this.numeroVisitantes = numeroVisitantes;
    }

    public Guia getGuia() {
        return guia;
    }

    public void setGuia(Guia guia) {
        this.guia = guia;
    }

    public ResponsavelGrupo getResponsavelGrupo() {
        return responsavelGrupo;
    }

    public void setResponsavelGrupo(ResponsavelGrupo responsavelGrupo) {
        this.responsavelGrupo = responsavelGrupo;
    }

    public LocalDate getDataVisita() {
        return dataVisita;
    }

    public void setDataVisita(LocalDate dataVisita) {
        this.dataVisita = dataVisita;
    }

    public PeriodoVisita getPeriodoVisita() {
        return periodoVisita;
    }

    public void setPeriodoVisita(PeriodoVisita periodoVisita) {
        this.periodoVisita = periodoVisita;
    }

    public Atrativo getAtrativo() {
        return atrativo;
    }

    public void setAtrativo(Atrativo atrativo) {
        this.atrativo = atrativo;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Visita{" +
                "responsavelGrupo=" + responsavelGrupo +
                '}';
    }
}
