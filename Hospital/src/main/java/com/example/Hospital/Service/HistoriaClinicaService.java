package com.example.Hospital.Service;

import com.example.Hospital.Model.HistoriaClinica;

import java.util.List;
import java.util.Optional;

public interface HistoriaClinicaService {
    // Crear una nueva historia clínica
    HistoriaClinica guardarHistoriaClinica(HistoriaClinica historiaClinica);

    // Obtener una historia clínica por su ID
    Optional<HistoriaClinica> obtenerHistoriaClinicaPorId(Long id);

    // Obtener todas las historias clínicas
    List<HistoriaClinica> obtenerTodasLasHistoriasClinicas();

    // Actualizar una historia clínica existente
    HistoriaClinica actualizarHistoriaClinica(HistoriaClinica historiaClinica);

    // Eliminar una historia clínica por su ID
    void eliminarHistoriaClinica(Long id);

    List<HistoriaClinica> getHistoriaClinicaConPacientes();
}
