package peaksoft.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
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
@Table(name = "hospital")
@NoArgsConstructor
@Getter
@Setter
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name should not be empty!")
    @Size(min = 2,max = 100,message = "min 2,max 100!")
    private String name;
    @NotEmpty(message = "Address should not be empty!")
    @Size(min = 2,max = 100,message = "min 2,max 100!")
    private String address;
    @OneToMany(mappedBy = "hospital",cascade = CascadeType.ALL)
    private  List<Doctor>doctors;
    @OneToMany(mappedBy = "hospital",cascade = CascadeType.ALL)
    private  List<Patient>patients;
    @OneToMany(mappedBy = "hospital",cascade = CascadeType.ALL)
    private  List<Department>departments;
    @OneToMany(mappedBy = "hospital",cascade = CascadeType.ALL, orphanRemoval = true)
    private  List<Appointment>appointments;

}
