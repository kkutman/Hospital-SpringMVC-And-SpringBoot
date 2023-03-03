package peaksoft.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

/**
 * name : kutman
 **/
@Entity
@Table(name = "departments")
@NoArgsConstructor
@Getter
@Setter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Name should not be empty!")
    @Size(min = 2,max = 100,message = "min 2,max 100!")
    private String name;
    @ManyToMany(mappedBy = "departments",cascade = {DETACH,MERGE,REFRESH})
    private List<Doctor>doctors;
    @ManyToOne(cascade = {DETACH,MERGE,REFRESH})
    private Hospital hospital;
    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointment;
    @Transient
    private Long hospitalId;
}
