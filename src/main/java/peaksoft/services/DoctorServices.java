package peaksoft.services;

import peaksoft.models.Department;
import peaksoft.models.Doctor;

import java.util.List;

/**
 * name : kutman
 **/
public interface DoctorServices {
    void save(Doctor doctor);
    void delete(Long id);
    List<Doctor> getAll();
    Doctor getById(Long id);
    void update(Long id,Doctor doctor);
    void assignDepartment(Long doctorId,Long departmentId);
}
