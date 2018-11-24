package pl.healthmaps.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.healthmaps.registration.model.Hospital;

import java.util.List;

@Repository
public interface IHospitalRepository extends JpaRepository<Hospital, Long> {


//    private double latitude;
//    private double longitude;
    @Query(value = "SELECT *" +
            " FROM Hospital " +
            " WHERE Hospital.id IN (SELECT hospital.id" +
            " FROM Location" +
            " WHERE (latitude BETWEEN 51 AND 53)" +
            " AND (longitude BETWEEN 20 AND 21));", nativeQuery = true)

    public List<Hospital> findAllInSquare();
}
