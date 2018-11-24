package pl.healthmaps.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.healthmaps.registration.model.Doctor;

public interface IDoctorRepository extends JpaRepository<Doctor, Long> {
}
