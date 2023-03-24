package com.techwish.hms.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techwish.hms.entity.PatientEntity;
import com.techwish.hms.payload.PatientDto;



@Component
public class PatientMapper {

	@Autowired
	private ModelMapper mapper;
	
	public PatientEntity mapToEntity(PatientDto dto) {
		PatientEntity entity=mapper.map(dto, PatientEntity.class);
		return entity;
	}
	
	
	public PatientDto mapToDto(PatientEntity entity) {
		//ModelMapper mapper=new ModelMapper();
		PatientDto dto=mapper.map(entity, PatientDto.class);
		return dto;
	}
	
	
	
	public List<PatientDto> mapToDtoList(List<PatientEntity> entities){
		List<PatientDto> list=new ArrayList<>(entities.size());
		for(PatientEntity entity:entities) {
			list.add(mapToDto(entity));
		}
		return list;
	}
	
	
	
	
}
