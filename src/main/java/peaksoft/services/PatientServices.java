package peaksoft.services;

import peaksoft.models.Hospital;
import peaksoft.models.Patient;

import java.util.List;

/**
 * name : kutman
 **/
public interface PatientServices {
    void save(Patient patient);
    void delete(Long id);
    List<Patient> getAll();
    Patient getById(Long id);
    void update(Long id,Patient patient);
}
