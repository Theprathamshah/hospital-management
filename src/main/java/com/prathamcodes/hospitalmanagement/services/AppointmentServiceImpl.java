package com.prathamcodes.hospitalmanagement.services;
import com.prathamcodes.hospitalmanagement.model.Appointment;
import com.prathamcodes.hospitalmanagement.model.Doctor;
import com.prathamcodes.hospitalmanagement.model.Patient;
import com.prathamcodes.hospitalmanagement.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AppointmentServiceImpl {
    private final AppointmentRepository appointmentRepository;
    public Appointment save(Appointment appointment){
        return appointmentRepository.save(appointment);
    }
    public List<Appointment> getAppointments(){
        return (List<Appointment>) appointmentRepository.findAll();
    }
    public List<Appointment> getAppointmentsByDoctorIdAndDate(Long id, LocalDate date){
        return appointmentRepository.getAppointmentsByDoctorIdAndDate(id,date);
    }
    public List<Appointment> getAppointmentsByPatientIdAndDate(Patient patient, LocalDate date){
        return appointmentRepository.getAppointmentsByPatientIdAndDate(patient,date);
    }
}
