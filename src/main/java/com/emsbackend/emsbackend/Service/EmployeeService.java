package com.emsbackend.emsbackend.Service;


import com.emsbackend.emsbackend.DTO.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployees(String id);

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO updateEmployee(String id, EmployeeDTO employeeDTO);

    void deleteEmployee(String id);
}
