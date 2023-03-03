package peaksoft.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

/**
 * name : kutman
 **/
@Entity
@Table(name = "patients")
@NoArgsConstructor
@Getter
@Setter
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String gender;
    private String email;
    @ManyToOne(cascade = {DETACH,MERGE,REFRESH})
    private Hospital hospital;
    @OneToMany(mappedBy = "patient",cascade = ALL)
    private List<Appointment> appointments;
    @Transient
    private Long hospitalId;
}
