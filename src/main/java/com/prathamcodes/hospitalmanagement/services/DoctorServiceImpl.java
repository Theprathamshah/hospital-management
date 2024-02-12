package com.prathamcodes.hospitalmanagement.services;

import com.prathamcodes.hospitalmanagement.model.Appointment;
import com.prathamcodes.hospitalmanagement.model.Doctor;
import com.prathamcodes.hospitalmanagement.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl {
    private final DoctorRepository doctorRepository;
    private final AppointmentServiceImpl appointmentService;
    public Doctor saveDoctor(Doctor doctor){
        return doctorRepository.save(doctor);
    }
    public void deleteDoctor(Long id){
        doctorRepository.deleteById(id);
    }

    public List<Doctor> getAllDoctors(){
        return (List<Doctor>) doctorRepository.findAll();
    }
    public Doctor findById(Long id){
        return doctorRepository.findById(id).orElseThrow(()->new RuntimeException("Doctor with id "+id+" not found."));
    }

    public Doctor updateDoctor(Doctor doctor){
        Doctor savedDoctor = doctorRepository.findById(doctor.getId()).orElseThrow(()->new RuntimeException("Doctor with id "+doctor.getId()+" not found"));
        savedDoctor.setAddress(doctor.getAddress());
        savedDoctor.setContractEndDate(doctor.getContractEndDate());
        savedDoctor.setWorkingHoursStart(doctor.getWorkingHoursStart());
        savedDoctor.setWorkingHoursEnd(doctor.getWorkingHoursEnd());
        savedDoctor.setPassword(doctor.getPassword());
        savedDoctor.setBirthday(doctor.getBirthday());
        savedDoctor.setRole(doctor.getRole());
        return doctorRepository.save(savedDoctor);

    }
    public List<LocalTime[]>getAvailability(LocalDate date,Doctor doctor){

        List<LocalTime[]> availability = new ArrayList<>();

        availability.add(new LocalTime[]{doctor.getWorkingHoursStart(),doctor.getWorkingHoursEnd()});
        for(Appointment appointment:doctor.getAppointments()){
            if(appointment.getDate().equals(date)){
                availability.removeIf(slot->!slot[0].isBefore(appointment.getEndTime())||!slot[1].isAfter(appointment.getStartTime()));
            }
        }
        return availability;
    }

    public List<LocalTime[]> getAvailableTimings(Long doctorId, LocalDate date) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(doctorId);
        if (optionalDoctor.isEmpty()) {
            throw new RuntimeException("Doctor not found with ID: " + doctorId);
        }
        Doctor doctor = optionalDoctor.get();

        // Get existing appointments for the given date
        List<Appointment> appointments = appointmentService.getAppointmentsByDoctorIdAndDate(doctorId, date);

        // Define the doctor's working hours
        LocalTime workingHoursStart = doctor.getWorkingHoursStart();
        LocalTime workingHoursEnd = doctor.getWorkingHoursEnd();

        // Initialize list to store available timings
        List<LocalTime[]> availableTimings = new ArrayList<>();

        // Start with the beginning of the working hours
        LocalTime startTime = workingHoursStart;

        // Iterate over existing appointments to find available slots
        for (Appointment appointment : appointments) {
            LocalTime appointmentStartTime = appointment.getStartTime();
            LocalTime appointmentEndTime = appointment.getEndTime();

            // Check if there is any gap between current start time and appointment start time
            if (startTime.isBefore(appointmentStartTime)) {
                availableTimings.add(new LocalTime[]{startTime, appointmentStartTime});
            }

            // Update start time to appointment end time
            startTime = appointmentEndTime;
        }

        // Check if there is any remaining time after the last appointment
        if (startTime.isBefore(workingHoursEnd)) {
            availableTimings.add(new LocalTime[]{startTime, workingHoursEnd});
        }

        return availableTimings;
    }


}
