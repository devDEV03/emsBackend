package com.emsbackend.emsbackend.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Document(collection = "departments")
public class Department {
    @Id
    private String id;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "department_description")
    private String departmentDescription;
}
