package com.example.Hospital.Controller;

import com.example.Hospital.Model.HistoriaClinica;
import com.example.Hospital.Service.HistoriaClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/historias-clinicas")
public class HistoriaClinicaController {

    private final HistoriaClinicaService historiaClinicaService;

    @Autowired
    public HistoriaClinicaController(HistoriaClinicaService historiaClinicaService) {
        this.historiaClinicaService = historiaClinicaService;
    }

    @PostMapping
    public ResponseEntity<HistoriaClinica> crearHistoriaClinica(@RequestBody HistoriaClinica historiaClinica) {
        return new ResponseEntity<>(historiaClinicaService.guardarHistoriaClinica(historiaClinica), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoriaClinica> obtenerHistoriaClinicaPorId(@PathVariable Long id) {
        Optional<HistoriaClinica> historiaClinica = historiaClinicaService.obtenerHistoriaClinicaPorId(id);
        return historiaClinica.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<HistoriaClinica> obtenerTodasLasHistoriasClinicas() {
        return historiaClinicaService.obtenerTodasLasHistoriasClinicas();
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistoriaClinica> actualizarHistoriaClinica(@PathVariable Long id, @RequestBody HistoriaClinica historiaClinica) {
        historiaClinica.setId(id);
        return new ResponseEntity<>(historiaClinicaService.actualizarHistoriaClinica(historiaClinica), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarHistoriaClinica(@PathVariable Long id) {
        historiaClinicaService.eliminarHistoriaClinica(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<HistoriaClinica>> getHistoriasClinicasConPacientes() {
        return ResponseEntity.ok(historiaClinicaService.getHistoriaClinicaConPacientes());
    }
}
