package pl.healthmaps.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.healthmaps.registration.model.Location;

public interface ILocationRepository extends JpaRepository<Location, Long> {
}
