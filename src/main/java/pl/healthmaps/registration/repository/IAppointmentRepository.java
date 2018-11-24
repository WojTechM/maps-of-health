package pl.healthmaps.registration.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.healthmaps.registration.model.Appointment;

public interface IAppointmentRepository  extends JpaRepository<Appointment, Long> {

    @Query(value = "SELECT * FROM appointment as app INNER JOIN doctor ON app.doctor_id = doctor.id INNER JOIN hospital AS h ON h.id = doctor.hospital_id WHERE h.id = ?1", nativeQuery = true)
    List<Appointment> getAllByHospital(long id);
}
