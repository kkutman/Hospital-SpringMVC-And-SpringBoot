package peaksoft.services.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.models.Department;
import peaksoft.models.Doctor;
import peaksoft.repositoy.DepartmentRepository;
import peaksoft.repositoy.DoctorRepository;
import peaksoft.services.DepartmentServices;
import peaksoft.services.DoctorServices;

import java.util.List;

/**
 * name : kutman
 **/
@Service
@Transactional
@RequiredArgsConstructor
public class DoctorServicesImpl implements DoctorServices {
    private final DoctorRepository doctorRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public void save(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    @Override
    public void delete(Long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getById(Long id) {
        return doctorRepository.findById(id).get();
    }

    @Override
    public void update(Long id, Doctor doctor) {
    Doctor doctor1 = doctorRepository.findById(id).get();
    doctor1.setFirstName(doctor.getFirstName());
    doctor1.setLastName(doctor.getLastName());
    doctor1.setPosition(doctor.getPosition());
    doctor1.setPosition(doctor.getPosition());
    doctorRepository.save(doctor1);
    }

    @Override
    public void assignDepartment(Long doctorId, Long departmentId) {
        System.out.println("doctor");
        Doctor doctor = doctorRepository.findById(doctorId).get();
        System.out.println(doctor.getFirstName());
        System.out.println(doctor.getDepartmentId());
        System.out.println(departmentId);
        System.out.println("doctor2");
        Department department = departmentRepository.findById(departmentId).get();
        System.out.println("department");
        doctor.setDepartments(List.of(department));
        department.setDoctors(List.of(doctor));



    }
}
