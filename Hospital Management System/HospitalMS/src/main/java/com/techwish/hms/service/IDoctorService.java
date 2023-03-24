package com.techwish.hms.service;

import java.util.List;

import com.techwish.hms.payload.DoctorDto;

public interface IDoctorService {
	
	Long addDoctor(DoctorDto dto);
	DoctorDto getOneDoctor(Long id);
	List<DoctorDto> getAllDoctors();
	void deleteDoctor(Long id);
	void updateDoctor(DoctorDto dto);
	String updateDocDeptById(Long id,String docDept);

}
