package com.emsbackend.emsbackend.Entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Document(collection = "employee")
public class Employee {

    @Id
    private String id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_id",nullable = false,unique = true)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

}
