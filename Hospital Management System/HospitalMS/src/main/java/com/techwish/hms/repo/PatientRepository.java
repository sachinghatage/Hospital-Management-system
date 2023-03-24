package com.techwish.hms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techwish.hms.entity.PatientEntity;



public interface PatientRepository extends JpaRepository<PatientEntity, Long>{

}

