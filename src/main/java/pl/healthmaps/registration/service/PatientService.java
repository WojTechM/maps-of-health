package pl.healthmaps.registration.service;

import java.util.Optional;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import pl.healthmaps.registration.model.Patient;
import pl.healthmaps.registration.repository.PatientRepository;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Optional<Patient> findByPesel(long pesel) {
        return patientRepository.findByPesel(pesel);
    }

    public Optional<Patient> findById(long id) {
        return patientRepository.findById(id);
    }



}
