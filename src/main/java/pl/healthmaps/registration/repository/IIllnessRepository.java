package pl.healthmaps.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.healthmaps.registration.model.Illness;

public interface IIllnessRepository extends JpaRepository<Illness, Long> {
}
