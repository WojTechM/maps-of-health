package pl.healthmaps.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.healthmaps.registration.model.Doctor;
import pl.healthmaps.registration.service.DoctorService;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class DoctorRestController {

    private final DoctorService service;

    @Autowired
    public DoctorRestController(DoctorService service) {
        this.service = service;
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<Doctor> getDoctorById(@PathVariable(value = "id") long id) {
        Doctor entity = service.findById(id);
        if (entity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity<List<Doctor>> getAllDoctors() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
}
