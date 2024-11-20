package com.example.Hospital.Repository;

import com.example.Hospital.Model.HistoriaClinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HistoriaClinicaRepository extends JpaRepository<HistoriaClinica, Long> {
    @Query("SELECT hc FROM HistoriaClinica hc JOIN FETCH hc.paciente")
    List<HistoriaClinica> findAllWithPacientes();
}
