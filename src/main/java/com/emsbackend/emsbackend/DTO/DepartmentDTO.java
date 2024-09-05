package com.emsbackend.emsbackend.DTO;


import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
    private String id;
    private String departmentName;
    private String departmentDescription;
}
