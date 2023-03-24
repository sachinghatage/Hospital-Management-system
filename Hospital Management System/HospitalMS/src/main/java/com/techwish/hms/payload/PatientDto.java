package com.techwish.hms.payload;

import javax.validation.constraints.NotNull;



import lombok.Data;

@Data
public class PatientDto {

	
	@NotNull
	private Long id;
	
	@NotNull
	private String patientName;
	
	@NotNull
	private String patAddr;
	
	@NotNull
	private String patContact;
	
	@NotNull
	private String gender;
	
	@NotNull
	private String email;
	
	@NotNull
	private String bloodGroup;

}

