package peaksoft.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.models.Hospital;
import peaksoft.models.Patient;

/**
 * name : kutman
 **/
@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
}
