package pl.healthmaps.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.healthmaps.registration.model.Location;
import pl.healthmaps.registration.repository.ILocationRepository;

@Service
public class LocationService {

    private final ILocationRepository repository;

    @Autowired
    public LocationService(ILocationRepository repository) {
        this.repository = repository;
    }

    public Location getLocationById(long id) { return repository.findById(id).orElse(null); }
}
