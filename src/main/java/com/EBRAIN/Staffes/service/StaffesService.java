package com.EBRAIN.Staffes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EBRAIN.Staffes.entity.Staffes;
import com.EBRAIN.Staffes.repository.StaffesRepositoroy;

@Service
public class StaffesService {

	@Autowired
	StaffesRepositoroy staffrepository;
	
	//post method
	public List<Staffes> post(List<Staffes> staffes) {
		// TODO Auto-generated method stub
		return staffrepository.saveAll(staffes);
	}

	//get by id
	public Optional<Staffes> getbyid(UUID id) {
		// TODO Auto-generated method stub
		return staffrepository.findById(id);
	}

	//get list method
	public List<Staffes> getstaffes() {
		// TODO Auto-generated method stub
		return staffrepository.findAll();
	}

	//get by name
	public Optional<Staffes> getbyname(String name) {
		// TODO Auto-generated method stub
		return staffrepository.findByName(name);
	}




	//update method
	public Staffes update(Staffes request) {
		// TODO Auto-generated method stub
		return staffrepository.save(request);
	}

	//delete method
	public void delete(Staffes staffes) {
		// TODO Auto-generated method stub
		staffrepository.delete(staffes);
	}

	public List<Staffes> getActiveStatusList(String status) {
		List<Staffes> list = staffrepository.findAll();
		List<Staffes> activeList = new ArrayList<>();

		for (Staffes i : list) {

			if (i.getStauts().equalsIgnoreCase(status)) {
				activeList.add(i);
			}
		}
		return activeList;

	}

	public void saveStaff(Staffes staffes) {
		staffrepository.save(staffes);
		
	}

	public List<Staffes> putActiveStaffes() {
		List<Staffes> list =staffrepository.findAll();
		List<Staffes> updatedStaffList = new ArrayList<>();
		
		for(Staffes i : list) {
			if(i.getStauts().equalsIgnoreCase("inactive")) {
			i.setStauts("Active");
			updatedStaffList.add(i);
			}
		}
		return staffrepository.saveAllAndFlush(updatedStaffList);
	}

}
