package pl.healthmaps.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.healthmaps.registration.model.Appointment;
import pl.healthmaps.registration.repository.IAppointmentRepository;

import java.util.List;

@Service
public class AppointmentService {

    private IAppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(IAppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment findById(long id) {
        return this.appointmentRepository.findById(id).orElse(null);
    }

    public List<Appointment> findAll() {
        return this.appointmentRepository.findAll();
    }

    public List<Appointment> findAppointmentByHospitalId(long id) {
        return this.appointmentRepository.getAllByHospital(id);
    }
}
