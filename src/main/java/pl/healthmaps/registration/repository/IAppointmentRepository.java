package pl.healthmaps.registration.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.healthmaps.registration.model.Appointment;

public interface IAppointmentRepository  extends JpaRepository<Appointment, Long> {

    @Query(value = "SELECT * FROM appointment AS app INNER JOIN doctor ON app.id = doctor_id INNER JOIN hospital AS h ON h.id = doctor.id WHERE h.id = ?1", nativeQuery = true)
    List<Appointment> getAllByHospital(long id);
}
