package pl.healthmaps.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.healthmaps.registration.model.Illness;
import pl.healthmaps.registration.repository.IIllnessRepository;

@Service
public class IllnessService {

    private IIllnessRepository repository;

    @Autowired
    public IllnessService(IIllnessRepository repository) {
        this.repository = repository;
    }

    public Illness getIllnessById(long id) { return repository.findById(id).orElse(null); }
}
