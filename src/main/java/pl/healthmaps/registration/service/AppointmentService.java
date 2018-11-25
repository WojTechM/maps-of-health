package pl.healthmaps.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.healthmaps.registration.model.Appointment;
import pl.healthmaps.registration.repository.IAppointmentRepository;

import java.util.List;
import java.util.stream.Collectors;

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
        List<Appointment> appointments = this.appointmentRepository.getAllByHospital(id);
        return appointments.stream()
                .filter(appointment -> appointment.getPatient() == null)
                .collect(Collectors.toList());
    }

    public void persist(Appointment appointment) {
        appointmentRepository.save(appointment);
    }
}
