package com.techwish.hms.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techwish.hms.payload.PatientDto;
import com.techwish.hms.service.IPatientService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(description="PATIENT OPERATIONS")
@RequestMapping("/v1/api/patient")
public class PatientRestController {
	
	@Autowired
	private IPatientService service;
	
	@PostMapping("/savePatient")
	@ApiOperation("CREATE PATIENT")
	public ResponseEntity<String> createPatient(@RequestBody @Valid PatientDto patientDto){
		Long id = service.addPatient(patientDto);
		String message="PATIENT WITH "+id+" CREATED";
		return ResponseEntity.ok(message);
	}
	
	@GetMapping("/getAllPatients")
	@ApiOperation("FETCH ALL PATIENTS")
	public ResponseEntity<List<PatientDto>> fetchAllPatients(){
		List<PatientDto> list = service.getAllPatients();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/getPatient/{id}")
	@ApiOperation("GET ONE PATIENT")
	public ResponseEntity<PatientDto> getOnePatient(@PathVariable Long id){
		PatientDto patientDto = service.getOnePatient(id);
		return ResponseEntity.ok(patientDto);
	}
	
	@PutMapping("/updatePatient/{id}")
	@ApiOperation("UPDATE PATIENT")
	public ResponseEntity<String>  updatePatient(@RequestBody PatientDto dto,@PathVariable Long id){
		service.updatePatient(dto);
		String message="PATIENT WITH "+id+ " UPDATED";
		return ResponseEntity.ok(message);
	}
	
	@DeleteMapping("/deletePatient/{id}")
	@ApiOperation("DELETE PATIENT")
	public ResponseEntity<String> deletePatient(@PathVariable Long id){
		service.deletePatient(id);
		String message="PATIENT WITH "+id+ " DELETED";
		return ResponseEntity.ok(message);
	}

}
