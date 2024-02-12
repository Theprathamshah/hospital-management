package com.prathamcodes.hospitalmanagement.model;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate date;
    private LocalTime startTime;
    private String description;
    private LocalTime endTime;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Doctor doctor;



    public Appointment(LocalDate date,LocalTime startTime,LocalTime endTime,Doctor doctor,Patient patient,String description){
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.doctor = doctor;
        this.patient = patient;
        this.description = description;
    }


}