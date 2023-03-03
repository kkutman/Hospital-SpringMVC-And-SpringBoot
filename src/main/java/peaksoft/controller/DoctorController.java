package peaksoft.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import peaksoft.models.Department;
import peaksoft.models.Doctor;
import peaksoft.models.Hospital;
import peaksoft.services.DepartmentServices;
import peaksoft.services.DoctorServices;
import peaksoft.services.HospitalServices;

/**
 * name : kutman
 **/
@Controller
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorServices doctorServices;
    private final HospitalServices hospitalServices;
    private final DepartmentServices departmentServices;

    @GetMapping("/{id}/getAll")
    public String getAll(Model model, @PathVariable Long id){
        model.addAttribute("number",hospitalServices.getById(id).getId());
        model.addAttribute("getAll",doctorServices.getAll().stream().filter(department -> department.getHospital().getId()==id).toList());
        return "doctor";
    }
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id")Long id){
        doctorServices.delete(id);
        return "redirect:/hospital";
    }

    @GetMapping("/{id}/saveDoctor")
    public String saveDoctor(Model model,@PathVariable("id")Long id){
        model.addAttribute("number",hospitalServices.getById(id).getId());
        model.addAttribute("newDoctor",new Doctor());
        return "saveDoctor";
    }

    @PostMapping("/{id}/creatDoctor")
    public String createDoctor(@PathVariable("id")Long id, @ModelAttribute("newDoctor") @Valid Doctor doctor
    , BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "saveDoctor";
        }
        Hospital byId = hospitalServices.getById(id);
        doctor.setHospital(byId);
        doctorServices.save(doctor);
        return "redirect:/hospital";
    }


    @GetMapping("/{id}/editDoctor")
    public String editDoctor(@PathVariable("id")Long id,Model model){
        model.addAttribute("newUpdateDoctor",doctorServices.getById(id));
        return "updateDoctor";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable("id")Long id,@ModelAttribute("newUpdateDoctor")@Valid Doctor doctor
            , BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "updateDoctor";
        }
        doctorServices.update(id,doctor);
        return "redirect:/hospital";
    }

    @GetMapping("/{id}/assign")
    public String assign(@PathVariable("id")Long id,Model model){
        model.addAttribute("doctor",doctorServices.getById(id));
        model.addAttribute("getAllDepartment",departmentServices.getAll().stream().filter(department -> department.getHospital().getId()==doctorServices.getById(id).getHospital().getId()).toList());
        System.out.println("/{id}/assign");
        return "assign";
    }

    @PostMapping("/{id}/ass")
    public String ass(@ModelAttribute("doctor")Doctor doctor){
        doctorServices.assignDepartment(doctor.getId(),doctor.getDepartmentId());
        System.out.println("/{id}/ass");
        return "redirect:/hospital";
    }




}
