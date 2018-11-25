package pl.healthmaps.registration.controller;

import java.util.List;
import java.util.Optional;
import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.healthmaps.registration.model.DTOUserData;
import pl.healthmaps.registration.model.Patient;
import pl.healthmaps.registration.service.PatientService;

@RestController
public class PatientRestController {

    @Autowired
    private PatientService patientService;

    @GetMapping(value = "/patient/{id}")
    public Optional<Patient> getPatientById(@PathVariable long id) {
        return patientService.findById(id);
    }

    @GetMapping(value = "/patient")
    public List<Patient> getAllPatients() {
        return patientService.findAll();
    }

    @PostMapping(value = "/api/patient")
    public HttpStatus postPatientValues(@RequestBody DTOUserData content) {
        System.out.println(content);
        return HttpStatus.OK;
    }
}
