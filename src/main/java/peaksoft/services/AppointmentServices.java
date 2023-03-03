package peaksoft.services;

import peaksoft.models.Appointment;
import peaksoft.models.Department;

import java.util.List;

/**
 * name : kutman
 **/
public interface AppointmentServices {
    void save(Appointment appointment);
    void delete(Long id);
    List<Appointment> getAll();
    Appointment getById(Long id);
    void update(Long id,Appointment appointment);
}
