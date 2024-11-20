package com.example.Hospital.Model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fechaCita;
    private String motivo;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    public Cita() {
    }

    public Cita(Long id, Date fechaCita, String motivo, Paciente paciente, Doctor doctor) {
        this.id = id;
        this.fechaCita = fechaCita;
        this.motivo = motivo;
        this.paciente = paciente;
        this.doctor = doctor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "id=" + id +
                ", fechaCita=" + fechaCita +
                ", motivo='" + motivo + '\'' +
                ", paciente=" + paciente +
                ", doctor=" + doctor +
                '}';
    }
}
