package com.EBRAIN.Staffes.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EBRAIN.Staffes.entity.Staffes;
import com.EBRAIN.Staffes.service.StaffesService;

@RestController
@RequestMapping("/api/staffes")
public class StaffesController {

	@Autowired
	StaffesService staffservice;

	// posting method
	@PostMapping("/staffpost")
	public List<Staffes> post(@RequestBody List<Staffes> staffes) {
		return staffservice.post(staffes);
	}
	
	@PostMapping("/staff")
	public String postStaff (@RequestBody Staffes staffes) {
		staffservice.saveStaff(staffes);
		return "Staff successfully saved";
	}

	// get list method
	@GetMapping("/getstaff")
	public List<Staffes> getStaffes() {
		return staffservice.getstaffes();
	}

	// get by id method
	@GetMapping("/getbyid/{id}")
	public Optional<Staffes> getbyid(@PathVariable UUID id) {
		return staffservice.getbyid(id);
	}

	// get by name
	@GetMapping("/getbyname/{name}")
	public Optional<Staffes> getbyname(@PathVariable String name) {
		return staffservice.getbyname(name);
	}
	
	// get by status
	 @GetMapping("/getactive/{status}") 
     public List<Staffes> getActiveStaffes(@PathVariable(value = "status") String status){
		  return staffservice.getActiveStatusList(status);
	}

	// update method
	@PutMapping("/update")
	public Staffes update(@RequestBody Staffes request) {
		return staffservice.update(request);
	}

	// delete method
	@DeleteMapping("/delete/{id}")
	public void delete(@RequestBody Staffes staffes) {
		staffservice.delete(staffes);
	}

	@PutMapping("/statusUpdate")
	public List<Staffes> putActiveStaffes(){
		return staffservice.putActiveStaffes();
	}
	
}
