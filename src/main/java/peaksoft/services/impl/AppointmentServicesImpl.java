package peaksoft.services.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.models.Appointment;
import peaksoft.repositoy.AppointmentRepository;
import peaksoft.services.AppointmentServices;
import peaksoft.services.DepartmentServices;
import peaksoft.services.DoctorServices;
import peaksoft.services.PatientServices;

import java.util.List;

/**
 * name : kutman
 **/
@Service
@Transactional
@RequiredArgsConstructor
public class AppointmentServicesImpl implements AppointmentServices {
    private final AppointmentRepository appointmentRepository;
    private final DepartmentServices departmentServices;
    private final DoctorServices doctorServices;
    private final PatientServices patientServices;

    @Override
    public void save(Appointment appointment) {
        appointment.setDepartment(departmentServices.getById(appointment.getDepartmentId()));
        appointment.setDoctor(doctorServices.getById(appointment.getDoctorId()));
        appointment.setPatient(patientServices.getById(appointment.getPatientId()));
        appointmentRepository.save(appointment);
    }

    @Override
    public void delete(Long id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment getById(Long id) {
        return appointmentRepository.findById(id).get();
    }

    @Override
    public void update(Long id, Appointment appointment) {
        Appointment appointment1 = appointmentRepository.findById(id).get();
        appointment1.setDepartment(departmentServices.getById(appointment.getDepartmentId()));
        appointment1.setDoctor(doctorServices.getById(appointment.getDoctorId()));
        appointment1.setPatient(patientServices.getById(appointment.getPatientId()));
        appointment1.setDate(appointment.getDate());
        appointmentRepository.save(appointment1);
    }
}
