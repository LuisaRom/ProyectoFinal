package com.example.Hospital.Service;

import com.example.Hospital.Model.Paciente;

import java.util.List;
import java.util.Optional;

public interface PacienteService {

    //Crear Paciente
    Paciente guardarPaciente(Paciente paciente);

    // Obtener un paciente por su ID
    Optional<Paciente> obtenerPacientePorId(Long id);

    // Obtener todos los pacientes
    List<Paciente> obtenerTodosLosPacientes();

    // Actualizar un paciente existente
    Paciente actualizarPaciente(Paciente paciente);

    // Eliminar un paciente por su ID
    void eliminarPaciente(Long id);

    List<Paciente> getPacientesConDetalles();
}
