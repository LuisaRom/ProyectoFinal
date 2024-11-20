package com.example.Hospital.Service;

import com.example.Hospital.Model.HistoriaClinica;
import com.example.Hospital.Repository.HistoriaClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoriaClinicaServicelmpl implements HistoriaClinicaService {

    private final HistoriaClinicaRepository historiaClinicaRepository;

    @Autowired
    public HistoriaClinicaServicelmpl(HistoriaClinicaRepository historiaClinicaRepository) {
        this.historiaClinicaRepository = historiaClinicaRepository;
    }

    @Override
    public HistoriaClinica guardarHistoriaClinica(HistoriaClinica historiaClinica) {
        return historiaClinicaRepository.save(historiaClinica);
    }

    @Override
    public Optional<HistoriaClinica> obtenerHistoriaClinicaPorId(Long id) {
        return historiaClinicaRepository.findById(id);
    }

    @Override
    public List<HistoriaClinica> obtenerTodasLasHistoriasClinicas() {
        return historiaClinicaRepository.findAll();
    }

    @Override
    public HistoriaClinica actualizarHistoriaClinica(HistoriaClinica historiaClinica) {
        if (historiaClinicaRepository.existsById(historiaClinica.getId())) {
            return historiaClinicaRepository.save(historiaClinica);
        } return null;
    }

    @Override
    public void eliminarHistoriaClinica(Long id) {
        historiaClinicaRepository.deleteById(id);
    }

    public List<HistoriaClinica> getHistoriaClinicaConPacientes() {
        return historiaClinicaRepository.findAllWithPacientes();
    }
}
