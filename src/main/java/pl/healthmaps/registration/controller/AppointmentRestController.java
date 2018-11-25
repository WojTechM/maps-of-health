package pl.healthmaps.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.healthmaps.registration.model.Appointment;
import pl.healthmaps.registration.model.Patient;
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

    @GetMapping
    ResponseEntity<List<Appointment>> getAllAppointments() {
        return new ResponseEntity<>(this.appointmentService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/byHospital/{id}")
    ResponseEntity<List<Appointment>> getAppointmentByHospitalId(@PathVariable long id) {
        return new ResponseEntity<>(this.appointmentService.findAppointmentByHospitalId(id), HttpStatus.OK);
    }

    @PostMapping(path = "/reservation/{id}")
    HttpStatus makeReservation(@PathVariable long id) {
        Appointment appointment = appointmentService.findById(id);
        if (appointment == null || appointment.getPatient() != null) {
            return HttpStatus.NOT_FOUND;
        }

        Patient patient = new Patient();
        patient.setFirstName("Stub");
        patient.setLastName("Stub");

        appointment.setPatient(patient);
        appointmentService.persist(appointment);
        return HttpStatus.OK;
    }
}
