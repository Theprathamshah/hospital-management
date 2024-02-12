package com.prathamcodes.hospitalmanagement.services;

import com.prathamcodes.hospitalmanagement.model.Patient;
import com.prathamcodes.hospitalmanagement.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl {
    private final PatientRepository patientRepository;
    public List<Patient> getAllPatients(){
        return (List<Patient>) patientRepository.findAll();
    }
    public Patient savePatient(Patient patient){
        return patientRepository.save(patient);
    }

    public Patient findById(Long id){
        return patientRepository.findById(id).orElseThrow(()->new RuntimeException("Patient with id "+id+" not found!"));
    }
}
