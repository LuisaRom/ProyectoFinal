package com.example.Hospital.Model;

import jakarta.persistence.*;

@Entity
public class HistoriaClinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "paciente_id", nullable = false, unique = true)
    private Paciente paciente;

    @Column(length = 500)
    private String detalles;

    public HistoriaClinica() {
    }

    public HistoriaClinica(Long id, Paciente paciente, String detalles) {
        this.id = id;
        this.paciente = paciente;
        this.detalles = detalles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return "HistoriaClinica{" +
                "id=" + id +
                ", paciente=" + paciente +
                ", detalles='" + detalles + '\'' +
                '}';
    }
}
