package pl.healthmaps.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.healthmaps.registration.model.Illness;
import pl.healthmaps.registration.service.IllnessService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/illnesses")
public class IllnessRestController {

    private final IllnessService service;

    @Autowired
    public IllnessRestController(IllnessService service) {
        this.service = service;
    }

    @GetMapping
    ResponseEntity<List<Illness>> getAllIllnesses() {
        return new ResponseEntity<>(service.getAllIllnesses(), HttpStatus.OK);
    }
}
