package com.techwish.patient.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="PATIENT_TAB")
public class PatientEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="PAT_ID_COL")
	private Long id;
	
	@Column(name="PAT_NAME_COL")
	private String patientName;
	
	@Column(name="PAT_ADDR_COL")
	private String patAddr;
	
	@Column(name="PAT_CONTACT_COL")
	private String patContact;
	
	@Column(name="PAT_EMAIL_COL")
	private String email;
	
	@Column(name="PAT_BLDGRP_COL")
	private String bloodGroup;
	
	@Column(name="GENDER_COL")
	private String gender;
	
	
	

}
