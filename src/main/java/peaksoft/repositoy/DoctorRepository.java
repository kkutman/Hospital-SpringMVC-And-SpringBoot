package peaksoft.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.models.Department;
import peaksoft.models.Doctor;

/**
 * name : kutman
 **/
public interface DoctorRepository extends JpaRepository<Doctor,Long> {

}
