package com.example.Hospital.Service;

import com.example.Hospital.Model.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {

    // Crear un nuevo doctor
    Doctor guardarDoctor(Doctor doctor);

    // Obtener un doctor por su ID
    Optional<Doctor> obtenerDoctorPorId(Long id);

    // Obtener todos los doctores
    List<Doctor> obtenerTodosLosDoctores();

    // Actualizar un doctor existente
    Doctor actualizarDoctor(Doctor doctor);

    // Eliminar un doctor por su ID
    void eliminarDoctor(Long id);
}
