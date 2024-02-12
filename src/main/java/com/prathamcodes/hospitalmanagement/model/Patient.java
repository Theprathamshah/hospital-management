package com.prathamcodes.hospitalmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Patient extends User{
    private String disease;
    @JsonIgnore
    @OneToMany(mappedBy = "patient")
    List<Appointment>appointments;

}
