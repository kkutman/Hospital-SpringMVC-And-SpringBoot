package peaksoft.services.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.models.Patient;
import peaksoft.repositoy.PatientRepository;
import peaksoft.services.PatientServices;

import java.util.List;

/**
 * name : kutman
 **/
@Service
@Transactional
@RequiredArgsConstructor
public class PatientServicesImpl implements PatientServices {
    private final PatientRepository patientRepository;
    @Override
    public void save(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public void delete(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getById(Long id) {
        return patientRepository.findById(id).get();
    }
    @Override
    public void update(Long id, Patient patient) {
        Patient patient1 = patientRepository.findById(id).get();
        patient1.setId(patient.getId());
        patient1.setFirstName(patient.getFirstName());
        patient1.setLastName(patient.getLastName());
        patient1.setPhoneNumber(patient.getPhoneNumber());
        patient1.setGender(patient.getGender());
        patient1.setEmail(patient.getEmail());
        patientRepository.save(patient1);
    }
}
