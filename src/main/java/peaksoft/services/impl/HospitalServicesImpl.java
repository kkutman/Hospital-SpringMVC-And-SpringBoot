package peaksoft.services.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.models.Hospital;
import peaksoft.repositoy.HospitalRepository;
import peaksoft.services.HospitalServices;

import java.util.List;

/**
 * name : kutman
 **/
@Service
@Transactional
@RequiredArgsConstructor
public class HospitalServicesImpl implements HospitalServices {

    private final HospitalRepository hospitalRepository;
    @Override
    public void save(Hospital hospital) {
        hospitalRepository.save(hospital);
    }

    @Override
    public void delete(Long id) {
        hospitalRepository.deleteById(id);
    }

    @Override
    public List<Hospital> getAll() {
        return hospitalRepository.findAll();
    }

    @Override
    public Hospital getById(Long id) {
        return hospitalRepository.findById(id).get();
    }

    @Override
    public void update(Long id, Hospital hospital) {
        Hospital hospital1 = hospitalRepository.findById(id).get();
        hospital1.setName(hospital.getName());
        hospital1.setAddress(hospital.getAddress());
        hospitalRepository.save(hospital1);
    }
}
