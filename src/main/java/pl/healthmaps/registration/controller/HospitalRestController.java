package pl.healthmaps.registration.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.healthmaps.registration.model.Hospital;
import pl.healthmaps.registration.service.HospitalService;

import java.util.List;

@RestController
@RequestMapping("/api/hospital")
public class HospitalRestController {

    private final HospitalService hospitalService;

    @Autowired
    public HospitalRestController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping(path = "/{id}")
    String getHospitalById(@PathVariable(value = "id") long id) {
        Hospital entity = hospitalService.getHospitalById(id);
        if (entity == null) {
            return null;
        }
        return entity.toGson();
    }

    @GetMapping
    String getAllHospitals() {
        Gson gson = new Gson();
        return gson.toJson(hospitalService.findAll());
    }

    @GetMapping(path = "/square")
    ResponseEntity<List<Hospital>> getHospitalsInSquare() {
        return new ResponseEntity<>(hospitalService.findAllInSquare(), HttpStatus.OK);
    }
}
