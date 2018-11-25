package pl.healthmaps.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.healthmaps.registration.model.Hospital;

import java.util.List;

@Repository
public interface IHospitalRepository extends JpaRepository<Hospital, Long> {

    @Query(value = "select * from hospital as h left join location as l on (h.id = l.hospital_id) where l.latitude between (?1 -1) and (?1 + 1) and l.longitude between (?2 - 1) and (?2 + 1);", nativeQuery = true)
    public List<Hospital> findAllInSquare(double latitude, double longitude);
}
