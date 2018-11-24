package pl.healthmaps.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.healthmaps.registration.model.Doctor;
import pl.healthmaps.registration.repository.IDoctorRepository;

@Service
public class DoctorService {

    private IDoctorRepository repository;

    @Autowired
    public DoctorService(IDoctorRepository repository) {
        this.repository = repository;
    }

    public Doctor findById(long id) {
        return repository.findById(id).orElse(null);
    }
}
