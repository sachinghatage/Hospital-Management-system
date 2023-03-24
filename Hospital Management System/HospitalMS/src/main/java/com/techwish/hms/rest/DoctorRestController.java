package com.techwish.hms.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techwish.hms.payload.DoctorDto;
import com.techwish.hms.service.IDoctorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@Api(description = "DOCTOR OPERATIONS")     //to display name in swagger
@RestController
@RequestMapping("/v1/api/doctor")
public class DoctorRestController {
	
	@Autowired                                                     
	private IDoctorService service;
	
	//     //** and enter
	/**
	 * This method is for Creating a new Doctor in Database
	 * @param doctorDto in JSON Format
	 * @return Success Response on creation
	 */
	@PostMapping("/saveDoctor")
	@ApiOperation("CREATE DOCTOR")
	public ResponseEntity<String> createDoctor(@RequestBody @Valid DoctorDto doctorDto){
		Long id = service.addDoctor(doctorDto);
		String message="DOCTOR " +id+ " IS CREATED";
		return ResponseEntity.ok(message);
	}
	
	@GetMapping("/allDoctors")
	@ApiOperation("FETCH ALL DOCTORS")
	//@ApiIgnore  this will not be displayed in swagger
	public ResponseEntity<List<DoctorDto>> fetchAllDoctors(){
		List<DoctorDto> list=service.getAllDoctors();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/getDoctor/{id}")
	@ApiOperation("GET ONE DOCTOR")
	public ResponseEntity<DoctorDto> getOneDoctor(@PathVariable Long id){
		DoctorDto oneDoctor = service.getOneDoctor(id);
		return ResponseEntity.ok(oneDoctor);
	}
	
	@PutMapping("/updateDoctor/{id}")
	@ApiOperation("UPDATE DOCTOR")
	public ResponseEntity<String> updateDoctor(@RequestBody DoctorDto dto,@PathVariable Long id){
		service.updateDoctor(dto);
		String message="DOCTOR " +id+ " UPDATED";
		
		return ResponseEntity.ok(message);
	}
	
	@PatchMapping("/modify/{id}/{docDept}")
	public ResponseEntity<String> updateDocDeptById(@PathVariable Long id,@PathVariable String docDept){
		
		service.updateDocDeptById(id, docDept);
		return ResponseEntity.ok("DOCTOR " +id+ " UPDATED WITH NEW DEPT");
	}
	
	
	
	@DeleteMapping("/deleteDoctor/{id}")
	@ApiOperation("DELETE DOCTOR")
	public ResponseEntity<String> deleteDoctor(@PathVariable Long id){
		service.deleteDoctor(id);
		String message="DOCTOR " +id+ " DELETED";
		return ResponseEntity.ok(message);
	}		
	
}
