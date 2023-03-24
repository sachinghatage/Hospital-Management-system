package com.techwish.hms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.techwish.hms.entity.DoctorEntity;

public interface DoctorRepository extends JpaRepository<DoctorEntity,Long> {

	@Modifying
	@Query("update DoctorEntity de set de.docDept=:docDept where de.id=:id")
	String updateDocDeptById(Long id, String docDept);

}
