package pl.healthmaps.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.healthmaps.registration.model.Hospital;
import pl.healthmaps.registration.repository.IHospitalRepository;

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
}
