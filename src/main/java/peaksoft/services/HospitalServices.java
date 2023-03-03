package peaksoft.services;

import peaksoft.models.Hospital;

import java.util.List;

/**
 * name : kutman
 **/
public interface HospitalServices {
    void save(Hospital hospital);
    void delete(Long id);
    List<Hospital>getAll();
    Hospital getById(Long id);
    void update(Long id,Hospital hospital);
}
