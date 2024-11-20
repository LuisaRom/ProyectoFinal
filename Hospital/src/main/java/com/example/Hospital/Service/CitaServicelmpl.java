package com.example.Hospital.Service;

import com.example.Hospital.Model.Cita;
import com.example.Hospital.Model.Paciente;
import com.example.Hospital.Repository.CitaRepository;
import com.example.Hospital.Repository.DoctorRepository;
import com.example.Hospital.Repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CitaServicelmpl implements CitaService{

    private final CitaRepository citaRepository;


    @Autowired
    public CitaServicelmpl(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    @Override
    public Cita guardarCita(Cita cita) {
        return citaRepository.save(cita);
    }

    @Override
    public Optional<Cita> obtenerCitaPorId(Long id) {
        return citaRepository.findById(id);
    }

    @Override
    public List<Cita> obtenerTodasLasCitas() {
        return citaRepository.findAll();
    }

    @Override
    public Cita actualizarCita(Cita cita) {
        if (citaRepository.existsById(cita.getId())) {
            return citaRepository.save(cita);
        }
         return null;
    }

    @Override
    public void eliminarCita(Long id) {
        citaRepository.deleteById(id);
    }

    public List<Cita> getCitasPorDoctorYFecha(Long doctorId, LocalDate fecha) {
        return citaRepository.findByDoctorAndFecha(doctorId, fecha);
    }

    public List<Cita> getCitasPorPacienteYDoctor(Long pacienteId, Long doctorId) {
        return citaRepository.findByPacienteAndDoctor(pacienteId, doctorId);
    }

    public List<Cita> getCitasPorEspecialidad(String especialidad) {
        return citaRepository.findByEspecialidadOrderByFecha(especialidad);
    }
}
