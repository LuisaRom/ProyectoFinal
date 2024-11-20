package com.example.Hospital.Controller;

import com.example.Hospital.Model.Cita;
import com.example.Hospital.Model.Paciente;
import com.example.Hospital.Service.CitaService;
import com.example.Hospital.Service.PacienteServicelmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/citas")
public class CitaController {

    private final CitaService citaService;

    @Autowired
    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    @PostMapping
    public ResponseEntity<Cita> crearCita(@RequestBody Cita cita) {
        return new ResponseEntity<>(citaService.guardarCita(cita), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cita> obtenerCitaPorId(@PathVariable Long id) {
        Optional<Cita> cita = citaService.obtenerCitaPorId(id);
        return cita.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<Cita> obtenerTodasLasCitas() {
        return citaService.obtenerTodasLasCitas();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cita> actualizarCita(@PathVariable Long id, @RequestBody Cita cita) {
        cita.setId(id);
        return new ResponseEntity<>(citaService.actualizarCita(cita), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCita(@PathVariable Long id) {
        citaService.eliminarCita(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/doctor")
    public ResponseEntity<List<Cita>> getCitasPorDoctorYFecha(
            @RequestParam Long doctorId,
            @RequestParam String fecha
    ) {
        LocalDate fechaCita = LocalDate.parse(fecha);
        return ResponseEntity.ok(citaService.getCitasPorDoctorYFecha(doctorId, fechaCita));
    }

    @GetMapping("/paciente-doctor")
    public ResponseEntity<List<Cita>> getCitasPorPacienteYDoctor(
            @RequestParam Long pacienteId,
            @RequestParam Long doctorId
    ) {
        return ResponseEntity.ok(citaService.getCitasPorPacienteYDoctor(pacienteId, doctorId));
    }


    @GetMapping("/especialidad")
    public ResponseEntity<List<Cita>> getCitasPorEspecialidad(@RequestParam String especialidad) {
        return ResponseEntity.ok(citaService.getCitasPorEspecialidad(especialidad));
    }

}