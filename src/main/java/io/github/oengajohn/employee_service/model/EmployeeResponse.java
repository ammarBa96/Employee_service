package io.github.oengajohn.employee_service.model;

import java.sql.Date;

import io.github.oengajohn.employee_service.entity.Gender;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeResponse {

    private Integer id;

    @Past(message = "Hire Date have to be in past ")
    private Date birthDate;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;
    
    private Gender gender;

    @PastOrPresent(message = "Hire Date have to be in past or persist")
    private Date hireDate;
}
