package peaksoft.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import peaksoft.models.Hospital;
import peaksoft.services.HospitalServices;

/**
 * name : kutman
 **/
@Controller
@RequestMapping("/hospital")
@RequiredArgsConstructor
public class HospitalController {
    private final HospitalServices hospitalServices;

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("getAll",hospitalServices.getAll());
        return "hospital";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id")Long id){
        hospitalServices.delete(id);
        return "redirect:/hospital";
    }

    @GetMapping("/saveHospital")
    public String saveHospital(Model model){
        model.addAttribute("newHospital",new Hospital());
        return "saveHospital";
    }

    @PostMapping("/createHospital")
    public String createHospital(@ModelAttribute("newHospital") @Valid Hospital hospital ,
                                 BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "saveHospital";
        }
            hospitalServices.save(hospital);
            return "redirect:/hospital";

    }


    @GetMapping("/{id}/edit")
    public String editHospital(@PathVariable("id")Long hospitalId,Model model){
        model.addAttribute("newUpdateHospital",hospitalServices.getById(hospitalId));
        return "updateHospital";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable("id")Long id,@ModelAttribute("newUpdateHospital") @Valid
    Hospital hospital,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "updateHospital";
        }
        hospitalServices.update(id, hospital);
        return "redirect:/hospital";
    }
}
