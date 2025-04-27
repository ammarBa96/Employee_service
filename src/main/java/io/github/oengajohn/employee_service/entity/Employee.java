package io.github.oengajohn.employee_service.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name= "birthDate")
    @Past(message = "Hire Date have to be in past ")
    private Date birthDate;

    @Column(name= "firstName")
    @NotEmpty
    private String firstName;

    @Column(name= "lastName")
    @NotEmpty
    private String lastName;
    
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name= "hireDate")
    @PastOrPresent(message = "Hire Date have to be in past or persist")
    private Date hireDate;
}
