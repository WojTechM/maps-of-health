package pl.healthmaps.registration.service;

import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import pl.healthmaps.registration.model.Appointment;
import pl.healthmaps.registration.model.Doctor;
import pl.healthmaps.registration.model.Hospital;
import pl.healthmaps.registration.model.Patient;
import pl.healthmaps.registration.repository.IAppointmentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.*;


class AppointmentServiceTest {

    @Test
    void findAppointmentByHospitalId() {
        IAppointmentRepository stub = new IAppointmentRepository() {
            @Override
            public List<Appointment> getAllByHospital(long id) {
                List<Appointment> result = new ArrayList<>();
                Hospital hospital = new Hospital();
                hospital.setId(1);
                Doctor doctor = new Doctor();
                doctor.setHospital_id(1);
                Appointment noPatient = new Appointment();
                noPatient.setDoctor(doctor);
                result.add(noPatient);
                result.add(noPatient);
                result.add(noPatient);
                Appointment withPatient = new Appointment();
                withPatient.setPatient(new Patient());
                withPatient.setDoctor(doctor);
                result.add(withPatient);
                result.add(withPatient);
                result.add(withPatient);
                return result;
            }

            @Override
            public List<Appointment> findAll() {
                return null;
            }

            @Override
            public List<Appointment> findAll(Sort sort) {
                return null;
            }

            @Override
            public List<Appointment> findAllById(Iterable<Long> iterable) {
                return null;
            }

            @Override
            public <S extends Appointment> List<S> saveAll(Iterable<S> iterable) {
                return null;
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends Appointment> S saveAndFlush(S s) {
                return null;
            }

            @Override
            public void deleteInBatch(Iterable<Appointment> iterable) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public Appointment getOne(Long aLong) {
                return null;
            }

            @Override
            public <S extends Appointment> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends Appointment> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public Page<Appointment> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Appointment> S save(S s) {
                return null;
            }

            @Override
            public Optional<Appointment> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(Appointment appointment) {

            }

            @Override
            public void deleteAll(Iterable<? extends Appointment> iterable) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public <S extends Appointment> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends Appointment> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Appointment> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends Appointment> boolean exists(Example<S> example) {
                return false;
            }
        };
        AppointmentService service = new AppointmentService(stub);
        List<Appointment> appointments = service.findAppointmentByHospitalId(1);
        assertEquals(3, appointments.size());
        assertNull(appointments.get(0).getPatient());
        assertNull(appointments.get(1).getPatient());
        assertNull(appointments.get(2).getPatient());

    }
}