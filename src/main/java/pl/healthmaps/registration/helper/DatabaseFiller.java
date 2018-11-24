package pl.healthmaps.registration.helper;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.healthmaps.registration.model.Doctor;
import pl.healthmaps.registration.model.Hospital;
import pl.healthmaps.registration.model.Location;
import pl.healthmaps.registration.repository.IDoctorRepository;
import pl.healthmaps.registration.repository.IHospitalRepository;
import pl.healthmaps.registration.repository.ILocationRepository;

import java.util.Random;

@Service
public class DatabaseFiller implements InitializingBean {

    private final IHospitalRepository hospitalRepository;
    private final ILocationRepository locationRepository;
    private final IDoctorRepository doctorRepository;

    @Autowired
    public DatabaseFiller(IHospitalRepository hospitalRepository, ILocationRepository locationRepository, IDoctorRepository doctorRepository) {
        this.hospitalRepository = hospitalRepository;
        this.locationRepository = locationRepository;
        this.doctorRepository = doctorRepository;
    }

    private void addLocationsAndHospitals() {
        Hospital hospital;
        Location location;

        location = new Location(2, 52.2376808d, 21.0191074d);
        locationRepository.save(location);
        hospital = new Hospital("Warszawski Szpital dla Dzieci SPZOZ", "Szpital dziecięcy", location);
        hospitalRepository.save(hospital);

        location = new Location(4, 52.2314103d, 20.9977099d);
        locationRepository.save(location);
        hospital = new Hospital("Szpital Dziecięcy Bersohnów i Baumanów", "Szpital dziecięcy", location);
        hospitalRepository.save(hospital);

        location = new Location(6, 52.2408873d, 20.9868095d);
        locationRepository.save(location);
        hospital = new Hospital("Centrum Medyczne Żelazna sp z o.o.", "Szpital", location);
        hospitalRepository.save(hospital);

        location = new Location(8, 52.2359371d, 20.9748087d);
        locationRepository.save(location);
        hospital = new Hospital("Szpital Centrum Enel-Med Warszawa Centrum", "Szpital", location);
        hospitalRepository.save(hospital);

        location = new Location(10, 52.2257745d, 21.0022622d);
        locationRepository.save(location);
        hospital = new Hospital("Nowogrodzka Szpital", "Szpital", location);
        hospitalRepository.save(hospital);

        location = new Location(12, 52.235525d, 21.0307418d);
        locationRepository.save(location);
        hospital = new Hospital("Szpital SOLEC", "Szpital", location);
        hospitalRepository.save(hospital);

        location = new Location(14, 52.2190644d, 20.978645d);
        locationRepository.save(location);
        hospital = new Hospital("Mazowieckie Centrum Rehabilitacji STOCER", "Szpital", location);
        hospitalRepository.save(hospital);
    }

    private void addDoctors() {
        for(int doctorsPerHospital = 0; doctorsPerHospital < 3; doctorsPerHospital++) {
            for(int hospitalId = 2; hospitalId < 15; hospitalId += 2) { // Hospitals hold only even ids up to 14
                Doctor doctor = new Doctor(getRandomFirstName(), getRandomLastName(), hospitalId);
                doctorRepository.save(doctor);
            }
        }
    }

    private String getRandomFirstName() {
        String[] firstNames = {"Wojciech", "Filip", "Andrzej", "Adam", "Roman", "Rafał", "Krzysztof", "Karol", "Adrian", "Jakub"};
        Random random = new Random();
        int index = random.nextInt(firstNames.length);
        return firstNames[index];
    }

    private String getRandomLastName() {
        String[] lastNames = {"Kowalski", "Adamowski", "Szczęsny", "Sosnowski", "Balboa", "Atrzyk", "Tuleja", "Rodacki"};
        Random random = new Random();
        int index = random.nextInt(lastNames.length);
        return lastNames[index];
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        addLocationsAndHospitals();
        addDoctors();
    }
}
