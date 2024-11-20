package com.example.Hospital.Repository;

import com.example.Hospital.Model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    //paciente con historia clinica, doctor y cita
    @Query("SELECT p FROM Paciente p " +
            "LEFT JOIN FETCH p.historiaClinica hc " +
            "LEFT JOIN FETCH hc.citas c " +
            "LEFT JOIN FETCH c.doctor")
    static List<Paciente> findAllWithDetails() {
        return null;
    }
}
