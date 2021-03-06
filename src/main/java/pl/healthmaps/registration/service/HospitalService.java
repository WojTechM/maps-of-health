package pl.healthmaps.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.healthmaps.registration.model.Hospital;
import pl.healthmaps.registration.repository.IHospitalRepository;

import java.util.List;

@Service
public class HospitalService {

    private final IHospitalRepository repository;

    @Autowired
    public HospitalService(IHospitalRepository repository) {
        this.repository = repository;
    }

    public Hospital getHospitalById(long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Hospital> findAll() {
        return repository.findAll();
    }

    public List<Hospital> findAllInSquare(double latitude, double longitude) {
        return repository.findAllInSquare(latitude, longitude);
    }
}
