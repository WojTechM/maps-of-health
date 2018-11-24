package pl.healthmaps.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.healthmaps.registration.model.Hospital;
import pl.healthmaps.registration.service.HospitalService;

@RestController
@RequestMapping("/api/hospital")
public class HospitalRestController {

    private final HospitalService hospitalService;

    @Autowired
    public HospitalRestController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<Hospital> getHospitalById(@PathVariable(value = "id") long id) {
        Hospital entity = hospitalService.getHospitalById(id);
        return new ResponseEntity<>(new Hospital(1, "stub", "some random description!"), HttpStatus.OK);
//        if (entity == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(entity, HttpStatus.OK);
    }
}
