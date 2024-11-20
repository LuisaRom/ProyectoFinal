package com.example.Hospital.Repository;

import com.example.Hospital.Model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Long> {
    //citas de un doctor por fecha
    @Query("SELECT c FROM Cita c WHERE c.doctor.id = :doctorId AND c.fechaCita = :fecha")
    List<Cita> findByDoctorAndFecha(@Param("doctorId") Long doctorId, @Param("fecha") LocalDate fecha);

    //citas de un paciente por doctor
    @Query("SELECT c FROM Cita c WHERE c.paciente.id = :pacienteId AND c.doctor.id = :doctorId")
    List<Cita> findByPacienteAndDoctor(@Param("pacienteId") Long pacienteId, @Param("doctorId") Long doctorId);

    //paciente por especialidad
    @Query("SELECT c FROM Cita c JOIN FETCH c.doctor d WHERE d.especialidad = :especialidad ORDER BY c.fechaCita")
    List<Cita> findByEspecialidadOrderByFecha(@Param("especialidad") String especialidad);
}

