package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.models.Appointment;
import peaksoft.models.Department;
import peaksoft.services.*;

/**
 * name : kutman
 **/
@Controller
@RequestMapping("/appointment")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentServices appointmentServices;
    private final HospitalServices hospitalServices;
    private final DoctorServices doctorServices;
    private final PatientServices patientServices;
    private final DepartmentServices departmentServices;


    @GetMapping("/{id}/getAll")
    public String getAll(Model model, @PathVariable Long id){
        model.addAttribute("number",id);
        model.addAttribute("getAll",appointmentServices.getAll().stream().filter(department -> department.getHospital().getId()==id).toList());
        return "appointment";
    }

    @GetMapping("{id}/saveAppointment")
    public String saveAppointment(Model model,@PathVariable("id")Long id){
        model.addAttribute("HospitalId",hospitalServices.getById(id).getId());
        model.addAttribute("getAllDoctor",doctorServices.getAll().stream().filter(doctor -> doctor.getHospital().getId()==id).toList());
        model.addAttribute("getAllPatient",patientServices.getAll().stream().filter(doctor -> doctor.getHospital().getId()==id).toList());
        model.addAttribute("getAllDepartment",departmentServices.getAll().stream().filter(doctor -> doctor.getHospital().getId()==id).toList());
        model.addAttribute("appointment",new Appointment());
        return "saveAppointment";
    }
    @PostMapping("{id}/createAppointment")
    public String createAppointment(@ModelAttribute("appointment")Appointment appointment,@PathVariable("id")Long id){
        appointment.setHospital(hospitalServices.getById(id));
        appointmentServices.save(appointment);
        return "redirect:/hospital";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id")Long id){
        appointmentServices.delete(id);
        return "redirect:/hospital";
    }

    @GetMapping("{id}/editAppointment")
    public String editDoctor(@PathVariable("id")Long id,Model model){
        model.addAttribute("getAllDoctor",doctorServices.getAll());
        model.addAttribute("getAllPatient",patientServices.getAll());
        model.addAttribute("getAllDepartment",departmentServices.getAll());
        model.addAttribute("updateAppointment",appointmentServices.getById(id));
        return "updateAppointment";
    }
    @PostMapping("{id}/updateAppointment")
    public String updateDoctor(@PathVariable("id")Long id, @ModelAttribute("updateAppointment")Appointment appointment){
        appointmentServices.update(id,appointment);
        return "redirect:/hospital";
    }
}
