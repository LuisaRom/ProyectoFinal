package com.example.Hospital.Service;

import com.example.Hospital.Model.Cita;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CitaService {
    // Crear una nueva cita
    Cita guardarCita(Cita cita);

    // Obtener una cita por su ID
    Optional<Cita> obtenerCitaPorId(Long id);

    // Obtener todas las citas
    List<Cita> obtenerTodasLasCitas();

    // Actualizar una cita existente
    Cita actualizarCita(Cita cita);

    // Eliminar una cita por su ID
    void eliminarCita(Long id);

    List<Cita> getCitasPorDoctorYFecha(Long doctorId, LocalDate fechaCita);

    List<Cita> getCitasPorPacienteYDoctor(Long pacienteId, Long doctorId);

    List<Cita> getCitasPorEspecialidad(String especialidad);
}
