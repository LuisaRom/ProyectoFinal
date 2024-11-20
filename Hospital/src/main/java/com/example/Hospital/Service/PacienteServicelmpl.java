package com.example.Hospital.Service;

import com.example.Hospital.Model.Paciente;
import com.example.Hospital.Repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServicelmpl implements PacienteService {

    private final PacienteRepository pacienteRepository;

    @Autowired
    public PacienteServicelmpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public Paciente guardarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public Optional<Paciente> obtenerPacientePorId(Long id) {
        return pacienteRepository.findById(id);
    }

    @Override
    public List<Paciente> obtenerTodosLosPacientes() {
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente actualizarPaciente(Paciente paciente) {
        if (pacienteRepository.existsById(paciente.getId())) {
            return pacienteRepository.save(paciente);
        }
        return null;
    }

    @Override
    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

    public List<Paciente> getPacientesConDetalles() {
        return PacienteRepository.findAllWithDetails();
    }
}