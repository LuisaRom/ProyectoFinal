package com.example.Hospital.Service;

import com.example.Hospital.Model.Doctor;
import com.example.Hospital.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorServicelmpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorServicelmpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Doctor guardarDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Optional<Doctor> obtenerDoctorPorId(Long id) {
        return doctorRepository.findById(id);
    }

    @Override
    public List<Doctor> obtenerTodosLosDoctores() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor actualizarDoctor(Doctor doctor) {
        if (doctorRepository.existsById(doctor.getId())) {
            return doctorRepository.save(doctor);
        }
        return null;
    }

    @Override
    public void eliminarDoctor(Long id) {
        doctorRepository.deleteById(id);
    }


}
