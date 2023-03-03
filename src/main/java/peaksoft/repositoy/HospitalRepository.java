package peaksoft.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.models.Hospital;

/**
 * name : kutman
 **/
@Repository
public interface HospitalRepository extends JpaRepository<Hospital,Long> {

}
