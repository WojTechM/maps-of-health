package pl.healthmaps.registration.controller;

import java.util.Optional;
import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
}
