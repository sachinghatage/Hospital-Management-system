package com.techwish.hms.service;

import java.util.List;

import com.techwish.hms.payload.PatientDto;


public interface IPatientService {
	
	Long addPatient(PatientDto dto);
	PatientDto getOnePatient(Long id);
	List<PatientDto> getAllPatients();
	void deletePatient(Long id);
	void updatePatient(PatientDto dto);

}
