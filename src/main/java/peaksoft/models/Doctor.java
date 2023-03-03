package peaksoft.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

/**
 * name : kutman
 **/
@Entity
@Table(name = "doctors")
@NoArgsConstructor
@Getter
@Setter
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "First name should not be empty!")
    @Size(min = 2,max = 100,message = "min 2,max 100!")
    private String firstName;
    @NotEmpty(message = "Last name should not be empty!")
    @Size(min = 2,max = 100,message = "min 2,max 100!")
    private String lastName;
    @NotEmpty(message = "Position should not be empty!")
    @Size(min = 2,max = 100,message = "min 2,max 100!")
    private String position;
    @NotEmpty(message = "Email should not be empty!")
    @Size(min = 2,max = 100,message = "min 2,max 100!")
    @Email(message = "email should be valid!")
    private String email;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Department>departments;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment>appointments;
    @ManyToOne()
    private Hospital hospital;

    @Transient
    private Long departmentId;
  


}
