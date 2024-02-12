package com.prathamcodes.hospitalmanagement.repository;

import com.prathamcodes.hospitalmanagement.model.Appointment;
import com.prathamcodes.hospitalmanagement.model.Doctor;
import com.prathamcodes.hospitalmanagement.model.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment,Long> {
    public List<Appointment> getAppointmentsByDoctorIdAndDate(Long id, LocalDate date);
    public List<Appointment> getAppointmentsByPatientIdAndDate(Patient patient,LocalDate date);

}
