package peaksoft.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import peaksoft.models.Department;
import peaksoft.models.Hospital;
import peaksoft.services.DepartmentServices;
import peaksoft.services.HospitalServices;

/**
 * name : kutman
 **/
@Controller
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentServices departmentServices;
    private final HospitalServices hospitalServices;

    @GetMapping("/{id}/getAll")
    public String getAll(Model model,@PathVariable Long id){
        model.addAttribute("getAll",departmentServices.getAll().stream().filter(department -> department.getHospital().getId()==id).toList());
        return "department";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id")Long id){
        departmentServices.delete(id);
        return "redirect:/hospital";
    }

    @GetMapping("/saveDepartment")
    public String saveHospital(Model model){
        model.addAttribute("newDepartment",new Department());
        model.addAttribute("getAllHospital",hospitalServices.getAll());
        return "saveDepartment";
    }

    @PostMapping("/creatDepartment")
    public String createHospital(@ModelAttribute("newDepartment") @Valid Department department, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "saveDepartment";
        }
        departmentServices.save(department);
        return "redirect:/hospital";
    }


    @GetMapping("/{id}/edit")
    public String editDepartment(@PathVariable("id")Long id,Model model){
        model.addAttribute("newUpdateDepartment",departmentServices.getById(id));
        model.addAttribute("getAllHospital",hospitalServices.getAll());
        return "updateDepartment";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable("id")Long id,@ModelAttribute("newUpdateDepartment") @Valid Department department,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "updateDepartment";
        }
        departmentServices.update(id,department);
        return "redirect:/hospital";
    }
}
