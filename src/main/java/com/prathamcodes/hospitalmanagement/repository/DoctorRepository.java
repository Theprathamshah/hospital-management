package com.prathamcodes.hospitalmanagement.repository;

import com.prathamcodes.hospitalmanagement.model.Appointment;
import com.prathamcodes.hospitalmanagement.model.Doctor;
import com.prathamcodes.hospitalmanagement.model.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;


@Repository
public interface DoctorRepository extends CrudRepository<Doctor,Long> {
//    public boolean isAvailable(LocalDate startTime, LocalDate endTime);
//    public void bookAppointment(LocalDate startTime, LocalDate endTime, Patient patient,Doctor doctor,String description);
//    public List<LocalDateTime[]> calculateAvailability(List<Appointment> appointments, LocalDate date,LocalTime workingHoursStart, LocalTime workingHoursEnd);
//    public boolean isSlotAvailable(LocalDateTime[] slot, List<Appointment> appointments);
}
