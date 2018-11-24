package pl.healthmaps.registration.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.healthmaps.registration.model.Patient;
import pl.healthmaps.registration.repository.IPatientRepository;

@Service
public class PatientService {

    @Autowired
    private IPatientRepository patientRepository;

    public Optional<Patient> findByPesel(long pesel) {
        return patientRepository.findByPesel(pesel);
    }

    public Optional<Patient> findById(long id) {
        return patientRepository.findById(id);
    }


    public List<Patient> findAll() {
        return patientRepository.findAll();
    }
}
