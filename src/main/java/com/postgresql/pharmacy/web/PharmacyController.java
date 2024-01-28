package com.postgresql.pharmacy.web;
import com.postgresql.pharmacy.model.Pharmacy;
import org.springframework.ui.Model;
import com.postgresql.pharmacy.service.PharmacyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("pharmacies")
public class PharmacyController {

    private final PharmacyService pharmacyService;

    public PharmacyController(PharmacyService pharmacyService) {
        this.pharmacyService = pharmacyService;
    }

    @GetMapping
    public String getPharmaciesPage (@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Pharmacy> pharmacies = this.pharmacyService.findAll();
        model.addAttribute("pharmacies", pharmacies);
        model.addAttribute("bodyContent", "pharmacies");
        return "pharmacies";
    }

    @GetMapping("/addPharmacy")
    public String addPharmacyPage (){
        return "addPharmacy";
    }
    @PostMapping("/add")
    public String savePharmacy(@RequestParam String name, @RequestParam String address, @RequestParam String phoneNumber, @RequestParam String openHours){
        this.pharmacyService.save(name, address,phoneNumber,openHours);
        return "redirect:/pharmacies";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        this.pharmacyService.delete(id);
        return "redirect:/pharmacies";
    }

}
