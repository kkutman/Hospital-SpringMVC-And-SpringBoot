package peaksoft.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.models.Appointment;
import peaksoft.models.Department;

/**
 * name : kutman
 **/
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
}
