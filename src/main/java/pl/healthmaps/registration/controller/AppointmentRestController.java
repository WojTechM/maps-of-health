package pl.healthmaps.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.healthmaps.registration.model.Appointment;
import pl.healthmaps.registration.service.AppointmentService;

import java.util.List;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentRestController {

    private AppointmentService appointmentService;

    @Autowired
    public AppointmentRestController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<Appointment> getAppointmentById(@PathVariable long id) {
        return new ResponseEntity<>(this.appointmentService.findById(id), HttpStatus.OK);
    }

    @GetMapping()
    ResponseEntity<List<Appointment>> getAllAppointments() {
        return new ResponseEntity<>(this.appointmentService.findAll(), HttpStatus.OK);
    }
}
