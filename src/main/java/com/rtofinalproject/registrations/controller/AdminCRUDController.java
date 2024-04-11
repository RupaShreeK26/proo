package com.rtofinalproject.registrations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rtofinalproject.registrations.model.LicenseRegisterModel;
import com.rtofinalproject.registrations.model.VehicleDetailsModel;
import com.rtofinalproject.registrations.repositories.LicenseRepository;
import com.rtofinalproject.registrations.repositories.VehicleRepository;
import com.rtofinalproject.registrations.services.LicenseDetailsService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
public class AdminCRUDController {

	@Autowired
	private LicenseRepository licenseRepository;
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	
	@GetMapping("/admin/DisplayRecords")
	public String ListLicenseHolders(Model model) {
		System.out.println("Sanjay");
		model.addAttribute("displayLicense", licenseRepository.findAll());
		return "DisplayLicense";
	}
	
	@GetMapping("/holder/update")
	public String UpdateLicenseHolders(Model model) {
		System.out.println("Sanjay");
		model.addAttribute("displayLicense", licenseRepository.findAll());
		return "UpdateLicense";
	}
	
	@PostMapping("/holder/update")
	public String UpdateLicenseHolder(LicenseRegisterModel licenseRegisterModel) {
		System.out.println("Sanjay");
		licenseRepository.save(licenseRegisterModel);
		return "UpdateLicense";
	}
	
	
	@GetMapping("/LicenseUpdate/{id}")
	public String UpdateLicense(@PathVariable("id") Long id,Model model) {
		System.out.println("Sanjay Inside Update");
		LicenseRegisterModel licenseModel = licenseRepository.findById(id).get();
		model.addAttribute("updateLicense",licenseModel);
		return "UpdateLicenseDetails";	
	}
	
	@PostMapping("/license/update")
	public String SaveUpdatedLicense(LicenseRegisterModel licenseRegisterModel) {
		 String licenseNumber = LicenseDetailsService.generateLicenseNumber(licenseRegisterModel);
	        licenseRegisterModel.setLicenseNumber(licenseNumber);
		licenseRepository.save(licenseRegisterModel);
		
		return "redirect:/admin/DisplayRecords";
	}
	
	@GetMapping("/holder/delete")
	public String DeleteLicenseHolders(Model model) {
		System.out.println("Sanjay");
		model.addAttribute("displayLicense", licenseRepository.findAll());
		return "DeleteLicense";
	}
	
	@PostMapping("/holder/delete")
	public String DeleteLicenseHolder(LicenseRegisterModel licenseRegisterModel) {
		System.out.println("Sanjay");
		licenseRepository.save(licenseRegisterModel);
		return "redirect:/DeleteLicense";
	}
	
	
	
	@GetMapping("/license/delete/{id}")
	public String DeleteLicense(@PathVariable("id") Long id) {
		licenseRepository.deleteById(id);
		return "redirect:/admin/DisplayRecords";	
	}
	
/*<!----------------------- ------------------------------>*/
	
	
	@GetMapping("/admin/vehicleDetails")
	public String DeleteVehicle(Model model) {
		System.out.println("Sanjay");
		model.addAttribute("displayVehicle", vehicleRepository.findAll());
		return "DisplayVehicleDetails";
	}
	
	@PostMapping("/admin/vehicleDetails")
	public String Deletevechile(VehicleDetailsModel vehicleDetailsModel) {
		System.out.println("Sanjay");
		vehicleRepository.save(vehicleDetailsModel);
		return "redirect:/DeleteLicense";
	}
	
	@GetMapping("/delete/vehicle")
	public String DeleteVehicleDetails(Model model) {
		System.out.println("Sanjay");
		model.addAttribute("displayVehicle", vehicleRepository.findAll());

		return "DeleteVehicleDetails";
	}
	
	
	
	@GetMapping("/vehicle/delete/{id}")
	public String DeleteParticularVehicle(@PathVariable("id") Long id) {
		vehicleRepository.deleteById(id);
		return "redirect:/admin/vehicleDetails";	
	}
	
	
}
