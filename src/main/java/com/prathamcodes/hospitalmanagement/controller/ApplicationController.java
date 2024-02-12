package com.prathamcodes.hospitalmanagement.controller;

import com.prathamcodes.hospitalmanagement.model.*;
import com.prathamcodes.hospitalmanagement.services.AppointmentServiceImpl;
import com.prathamcodes.hospitalmanagement.services.DoctorServiceImpl;
import com.prathamcodes.hospitalmanagement.services.PatientServiceImpl;
import com.prathamcodes.hospitalmanagement.services.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin
@RequiredArgsConstructor
public class ApplicationController {
    private final UserServiceImpl userService;
    private final PatientServiceImpl patientService;
    private final DoctorServiceImpl doctorService;
    private final AppointmentServiceImpl appointmentService;
    @GetMapping("/")
    public String greet(){
        return "Welcome to home page";
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.findAll();
    }
    @PostMapping("/users")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PostMapping("/doctors")
    public Doctor saveDoctor(@RequestBody Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }

    @GetMapping("/doctors")
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }
    @GetMapping("/doctors/{id}")
    public Doctor getDoctorById(@PathVariable Long id){
        return doctorService.findById(id);
    }
    @PostMapping("/patients")
    public Patient savePatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }
    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }
    @GetMapping("/patients/{id}")
    public Patient getPatientById(@PathVariable Long id){
        return patientService.findById(id);
    }




    @GetMapping("/doctors/availability/{id}")
    public List<LocalTime[]> getAvailability(@PathVariable Long id){
        System.out.println(id);
        return doctorService.getAvailableTimings(id,LocalDate.now());
    }

    @PostMapping("/appointments")
    public Appointment scheduleAppointment(@RequestBody AppointmentRequest appointmentRequest){

        Doctor doctor = doctorService.findById(appointmentRequest.getDoctorId());
        Patient patient = patientService.findById(appointmentRequest.getPatientId());
        if (doctor == null || patient == null) {
            // Handle scenario when doctor or patient is not found
            throw new RuntimeException("Doctor or patient not found");
        }
        Appointment appointment = new Appointment(appointmentRequest.getDate(),appointmentRequest.getStartTime(),appointmentRequest.getEndTime(),doctor,patient,appointmentRequest.getDescription());
        doctor.getAppointments().add(appointment);
        return appointmentService.save(appointment);
    }
    @GetMapping("/appointments")
    public List<Appointment> getAppointments(){
        return appointmentService.getAppointments();
    }

}
