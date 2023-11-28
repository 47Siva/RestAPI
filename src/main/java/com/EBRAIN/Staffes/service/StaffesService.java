package com.EBRAIN.Staffes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.EBRAIN.Staffes.common.APIResponse;
import com.EBRAIN.Staffes.common.BadRequestException;
import com.EBRAIN.Staffes.common.Error;
import com.EBRAIN.Staffes.common.data.StaffesData;
import com.EBRAIN.Staffes.entity.Staffes;
import com.EBRAIN.Staffes.repository.StaffesRepositoroy;
import com.EBRAIN.Staffes.validator.StaffesValidator;

@Service
public class StaffesService {

	@Autowired
	StaffesRepositoroy staffRepository;

	@Autowired
	StaffesValidator staffesValidator;

	// List post method
	public List<Staffes> post(List<Staffes> staffes) {

		return staffRepository.saveAll(staffes);
	}

	// post method
	public void saveStaffe(Staffes staffes) {

		// validation

		List<Error> errors = staffesValidator.validateCreateStaffesRequest(staffes);

		// if not success
		if (errors.size() > 0) {
			throw new BadRequestException("Bad Request", errors);
		}

		// if success
		staffRepository.save(staffes);
	}

	// get by id
	public Optional<Staffes> getbyid(UUID id) {
		// TODO Auto-generated method stub
		return staffRepository.findById(id);
	}

	// get list with @RequestParam method
	public List<Staffes> getstaffes(String status) {
		// TODO Auto-generated method stub
		if (status == null) {
			return staffRepository.findAll();
		} else {
			return staffRepository.findAllBystatus(status);
		}
	}

	public APIResponse getstaffesAPIRes(String status) {

		APIResponse apiResponse = new APIResponse();

		// DB call
		List<Staffes> staffesList = staffRepository.findAll();

		// Set Data
//		Map<Object, Object> data = new HashMap<>();
//		data.put("staffes", staffesList);
//		         (or)
		// Set data
		StaffesData staffesData = new StaffesData();
		staffesData.setStaffes(staffesList);

		StaffesData staffeData = new StaffesData();
		staffeData.setStaffe(null);

		// set api Response
//		apiResponse.setData(data);
//		apiResponse.setStatus(200);
//		apiResponse.setError(null);
//		return apiResponse;

		if (status == null) {

			apiResponse.setStatus(HttpStatus.OK.value());
			apiResponse.setData(staffesData);
			return apiResponse;
		} else {
			apiResponse.setStatus(HttpStatus.OK.value());
			apiResponse.setData(staffRepository.findAllBystatus(status));
			return apiResponse;
		}
	}

	// get by name
	public Optional<Staffes> getbyname(String name) {
		// TODO Auto-generated method stub
		return staffRepository.findByName(name);
	}

	// update method
	public Staffes update(Staffes request) {
		// TODO Auto-generated method stub
		return staffRepository.save(request);
	}

	// delete method
	public void delete(Staffes staffes) {
		// TODO Auto-generated method stub
		staffRepository.delete(staffes);
	}

	// get some values method
	public List<Staffes> getActiveStatusList(String status) {
		if (status == null) {
			return staffRepository.findAll();
		} else {
			List<Staffes> list = staffRepository.findAll();
			List<Staffes> activeList = new ArrayList<>();
			for (Staffes i : list) {

				if (i.getStatus().equalsIgnoreCase(status)) {
					activeList.add(i);
				}
			}
			return activeList;
		}

	}

	// update by active method
	public List<Staffes> putActiveStaffes() {
		List<Staffes> list = staffRepository.findAll();
		List<Staffes> updatedStaffList = new ArrayList<>();

		for (Staffes i : list) {
			if (i.getStatus().equalsIgnoreCase("inactive")) {
				i.setStatus("Active");
				updatedStaffList.add(i);
			}
		}
		return staffRepository.saveAllAndFlush(updatedStaffList);
	}

	// Exception Handling
	public APIResponse getCoughtException(int number) {

		APIResponse apiResponse = new APIResponse();

		int result = 100 / number;

		apiResponse.setStatus(HttpStatus.OK.value());
		apiResponse.setData(result);

		return apiResponse;
	}

	// get by some fields method
	public Staffes getBySomeFields(String status, String name, String phoen) {

		//if (status == null && name == null && phoen == null) {

			//return staffrepository.findAll();
		//} else {

			return staffRepository.findByFields(status, name, phoen);
		//}
		// return
		// staffrepository.findAllByStatusAndNameAndPhoennum(status,name,phoennum);

	}

}
