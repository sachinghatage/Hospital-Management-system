package com.techwish.patient.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techwish.patient.entity.PatientEntity;

public interface PatientRepository extends JpaRepository<PatientEntity, Long>{

}
