package peaksoft.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.models.Department;
import peaksoft.models.Hospital;

/**
 * name : kutman
 **/
@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
