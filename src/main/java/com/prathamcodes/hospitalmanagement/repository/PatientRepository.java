package com.prathamcodes.hospitalmanagement.repository;

import com.prathamcodes.hospitalmanagement.model.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CrudRepository<Patient,Long> {

}
