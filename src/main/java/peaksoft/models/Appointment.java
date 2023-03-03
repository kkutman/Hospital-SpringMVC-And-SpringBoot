package peaksoft.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import static jakarta.persistence.CascadeType.*;

/**
 * name : kutman
 **/
@Entity
@Table(name = "appointments")
@NoArgsConstructor
@Getter
@Setter
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    @ManyToOne(cascade = {DETACH,MERGE,REFRESH})
    private Patient patient;
    @ManyToOne(cascade = {DETACH,MERGE,REFRESH})
    private Doctor doctor;
    @ManyToOne
    private Department department;
    @ManyToOne
    private Hospital hospital;

    @Transient
    private Long patientId;
    @Transient
    private Long doctorId;
    @Transient
    private Long departmentId;
    @Transient
    private Long hospitalId;

}
