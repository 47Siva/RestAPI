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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.EBRAIN.Staffes.common.APIResponse;
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
	
	@PostMapping("/stafesf")
	public String postStaffe (@RequestBody Staffes staffes) {
		staffservice.saveStaffe(staffes);
		return "Staff successfully saved";
	}

	// get list with @RequestParam method
	@GetMapping("/getstaffParam")
	public List<Staffes> getStaffes(@RequestParam(value = "status",required = false) String status) {
		return staffservice.getstaffes(status);
	}
	
	// get list with APIResponse @RequestParam method
	@GetMapping("/getstaffAPIResParam")
	public APIResponse getStaffesAPIRes(@RequestParam(value = "status",required = false) String status) {
		
		return staffservice.getstaffesAPIRes(status);
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
     public List<Staffes> getActiveStaffes(@PathVariable(value = "status",required = false) String status){
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

	// Status update method
	@PutMapping("/statusUpdate")
	public List<Staffes> putActiveStaffes(){
		return staffservice.putActiveStaffes();
	}
	
	//Exception Handling
	@GetMapping("/caughtException")
	public APIResponse geCoughtException(@RequestParam (value = "number",required = false) int number) {
		
		return staffservice.getCoughtException(number);
	}
	
	//get by some entity fields
	@GetMapping("getBySomeFields")
	public Staffes getBySomeFields(@RequestParam(value = "status",required = false) String status,
			                           @RequestParam (value = "name",required = false) String name,
			                           @RequestParam (value = "phoen",required = false) String phoen) {
		
		return staffservice.getBySomeFields(status,name,phoen);
	}
	
}
