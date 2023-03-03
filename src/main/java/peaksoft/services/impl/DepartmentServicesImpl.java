package peaksoft.services.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.models.Department;
import peaksoft.models.Hospital;
import peaksoft.repositoy.DepartmentRepository;
import peaksoft.repositoy.HospitalRepository;
import peaksoft.services.DepartmentServices;

import java.util.List;

/**
 * name : kutman
 **/
@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentServicesImpl implements DepartmentServices {
    private final DepartmentRepository departmentRepository;
    private final HospitalRepository hospitalRepository;

    @Override
    public void save(Department department) {
        Hospital hospital = hospitalRepository.findById(department.getHospitalId()).get();
        department.setHospital(hospital);
        departmentRepository.save(department);
    }

    @Override
    public void delete(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getById(Long id) {
        return departmentRepository.findById(id).get();
    }

    @Override
    public void update(Long id, Department department) {
        Hospital hospital = hospitalRepository.findById(department.getHospitalId()).get();

        Department department1 = departmentRepository.findById(id).get();
        department1.setHospital(hospital);
        department1.setName(department.getName());
    }
}
