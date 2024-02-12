package com.prathamcodes.hospitalmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Doctor extends User{
    private LocalDate contractEndDate;
    LocalTime workingHoursStart = LocalTime.of(8, 0);
    LocalTime workingHoursEnd = LocalTime.of(17, 0);


    @JsonIgnore
    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments=new ArrayList<>();
//    @Column()
    List<LocalTime[]>slots ;

}

/*



	About the project
Online Hospital Management System is a system to manage the Doctors, Patients, and
	to manage the consultation workflow via a single online platform. The system should be consist of the Doctor registration, Patient Registration, Display list of doctors and 	Patients, update or remove the Doctor or Patient entry, and Consultation scheduling 	and removing.
	Functional Requirements

R1 - Doctor Registration
R2 - List of Doctors
R3 - Doctor Update
R4 - Doctor Deletion
R5 - Patient Registration
R6 - List of Patients
R7 - Patient Update
R8 - Patient Deletion
R9 - Consultation Scheduling
R10 - Consultation Cancellation

	User Roles
System supports the following user roles: admin, Doctor, and Patient, and Each role 	support the different permissions and access levels
	 User Management
Admin should be able to register and remove the entry for doctors and patients
	Consultation Workflow
System should provide details around Doctor’s availability, and based on that patient
             or admin should be able to schedule, re-schedule or cancel the appointment. If 	 	Doctor’s contract is getting over on some date, and that doctor has pending 	 	appointments, then that pending appointments should be reassigned to available 	doctors as per their available timeslot.
 
	Authentication/Authorization
Implement user authentication and authorization mechanisms to control access to 	distinct parts of the system based on user roles. Use token-based authentication and 	authorization to secure the API.

	 Database Integration:
Utilize Spring Data JPA for data access and database management. Design 	the database 	schema to store doctor and patient information, scheduled appointments, and other 	relevant data.
	Rest API:
Develop Rest API to manage the system and configure it with open-api docs. Implement 	server-side validation for user inputs and error handling mechanisms to provide 		meaningful feedback to users. API and project structure should be well architected with 	versioning and modularity, and it should be scalable.
	UI:
Develop simple online console using HTML, CSS, and Vanila JavaScript/jQuery. Develop a
	user login screen for authentication. Also develop the screens for Admin, Doctors,
	and Patients. Where users should be able to manage doctors, patients, and 	   	appointments.


•	The API should be developed using spring Boot 3.2.2, and MySQL







 */