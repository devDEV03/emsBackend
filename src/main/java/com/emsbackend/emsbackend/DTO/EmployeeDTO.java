package com.emsbackend.emsbackend.DTO;


import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String departmentId;


}
