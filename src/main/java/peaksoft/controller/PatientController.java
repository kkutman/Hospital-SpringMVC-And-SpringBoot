package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.models.Doctor;
import peaksoft.models.Hospital;
import peaksoft.models.Patient;
import peaksoft.services.HospitalServices;
import peaksoft.services.PatientServices;

/**
 * name : kutman
 **/
@Controller
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {
    private final PatientServices patientServices;
    private final HospitalServices hospitalServices;

    @GetMapping("/{id}/getAll")
    public String getAll(Model model, @PathVariable Long id){
        model.addAttribute("number",hospitalServices.getById(id).getId());
        model.addAttribute("getAll",patientServices.getAll().stream().filter(department -> department.getHospital().getId()==id).toList());
        return "patient";
    }

    @GetMapping("/{id}/savePatient")
    public String saveDoctor(Model model,@PathVariable("id")Long id){
        model.addAttribute("number",hospitalServices.getById(id).getId());
        model.addAttribute("newPatient",new Patient());
        return "savePatient";
    }

    @PostMapping("/{id}/createPatient")
    public String createDoctor(@PathVariable("id")Long id,@ModelAttribute("newPatient")Patient patient){
        Hospital byId = hospitalServices.getById(id);
        patient.setHospital(byId);
        patientServices.save(patient);
        return "redirect:/hospital";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id")Long id){
        patientServices.delete(id);
        return "redirect:/hospital";
    }

    @GetMapping("/{id}/editPatient")
    public String editDoctor(@PathVariable("id")Long id,Model model){
        model.addAttribute("newUpdatePatient",patientServices.getById(id));
        return "updatePatient";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable("id")Long id,@ModelAttribute("newUpdatePatient")Patient patient){
        patientServices.update(id,patient);
        return "redirect:/hospital";
    }
}
