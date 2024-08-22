package com.emsbackend.emsbackend.Mapper;

import com.emsbackend.emsbackend.DTO.EmployeeDTO;
import com.emsbackend.emsbackend.Entity.Employee;

public class EmployeeMapper {

    static public EmployeeDTO toEmployeeDTO(Employee employee){
        EmployeeDTO employeeDTO = new EmployeeDTO(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail());
        return employeeDTO;
    }

    static public Employee toEmployee(EmployeeDTO employeeDTO){
        Employee employee = new Employee(employeeDTO.getId(), employeeDTO.getFirstName(), employeeDTO.getLastName(), employeeDTO.getEmail());
        return employee;
    }
}
