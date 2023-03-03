package peaksoft.services;

import peaksoft.models.Department;
import peaksoft.models.Hospital;

import java.util.List;

/**
 * name : kutman
 **/
public interface DepartmentServices {
    void save(Department department);
    void delete(Long id);
    List<Department> getAll();
    Department getById(Long id);
    void update(Long id,Department department);
}
