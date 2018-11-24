package pl.healthmaps.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.healthmaps.registration.model.Appointment;

public interface IAppointmentRepository  extends JpaRepository<Appointment, Long> {}
