package com.techwish.hms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techwish.hms.entity.PatientEntity;
import com.techwish.hms.exception.PatientNotFoundException;
import com.techwish.hms.mapper.PatientMapper;
import com.techwish.hms.payload.PatientDto;
import com.techwish.hms.repo.PatientRepository;
import com.techwish.hms.service.IPatientService;

@Service
public class PatientServiceImpl implements IPatientService{
	
	@Autowired
	private PatientRepository repo;
	
	@Autowired
	private PatientMapper mapper;

	@Override
	public Long addPatient(PatientDto dto) {
	PatientEntity	patientEntity=mapper.mapToEntity(dto);
	patientEntity = repo.save(patientEntity);
		return patientEntity.getId();
	}

	@Override
	public PatientDto getOnePatient(Long id) {
		PatientEntity patientEntity=repo.findById(id).orElseThrow(()->new PatientNotFoundException("PATIENT WITH "+id+" DOESNOT EXIST"));
				return mapper.mapToDto(patientEntity);
	}

	@Override
	public List<PatientDto> getAllPatients() {
		List<PatientEntity> list = repo.findAll();
		List<PatientDto> listDto = mapper.mapToDtoList(list);
		return listDto;
	}

	@Override
	public void deletePatient(Long id) {
		repo.delete(repo.findById(id).orElseThrow(()->new PatientNotFoundException("PATIENT WITH "+id+" DOESNOT EXIST")));
	}

	@Override
	public void updatePatient(PatientDto dto) {
		if(repo.existsById(dto.getId())) {
			PatientEntity entity = mapper.mapToEntity(dto);
			repo.save(entity);
		}else
			throw new PatientNotFoundException("PATIENT "+dto.getId()+" DOESNOT EXIST");
	}

}
