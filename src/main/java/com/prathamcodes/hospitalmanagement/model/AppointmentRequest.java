package com.prathamcodes.hospitalmanagement.model;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class AppointmentRequest {
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Long patientId;
    private Long doctorId;
    private String description;
}
