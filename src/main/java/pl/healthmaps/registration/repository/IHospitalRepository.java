package pl.healthmaps.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.healthmaps.registration.model.Hospital;

public interface IHospitalRepository extends JpaRepository<Hospital, Long> {
}
