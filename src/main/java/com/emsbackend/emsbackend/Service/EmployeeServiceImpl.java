package com.emsbackend.emsbackend.Service;

import com.emsbackend.emsbackend.DTO.EmployeeDTO;
import com.emsbackend.emsbackend.Entity.Department;
import com.emsbackend.emsbackend.Entity.Employee;
import com.emsbackend.emsbackend.Exception.ResourceNotFoundException;
import com.emsbackend.emsbackend.Mapper.EmployeeMapper;
import com.emsbackend.emsbackend.Repository.DepartmentRepository;
import com.emsbackend.emsbackend.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.toEmployee(employeeDTO);
        Department department = departmentRepository.findById(employeeDTO.getDepartmentId()).orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with the given id : "));
        employee.setDepartment(department);
        Employee savedEmployee = repository.save(employee);
        return EmployeeMapper.toEmployeeDTO(savedEmployee);
    }

    @Override
    public EmployeeDTO getEmployees(String id) {
            Employee employee = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with the given id : " + id));
            return EmployeeMapper.toEmployeeDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employee = repository.findAll();
        return employee.stream().map((employees) -> EmployeeMapper.toEmployeeDTO(employees)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO updateEmployee(String id, EmployeeDTO employeeDTO) {
        Employee employee = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with the given id : " + id));

        Department department = departmentRepository.findById(employeeDTO.getDepartmentId()).orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with the given id : "));
        employee.setDepartment(department);
        if(employeeDTO.getFirstName() != "" && Objects.nonNull(employeeDTO.getFirstName())){
            employee.setFirstName(employeeDTO.getFirstName());
        }

        if(employeeDTO.getLastName() != "" && Objects.nonNull(employeeDTO.getLastName())){
            employee.setLastName(employeeDTO.getLastName());
        }
        if(employeeDTO.getEmail() != "" && Objects.nonNull(employeeDTO.getEmail())){
            employee.setEmail(employeeDTO.getEmail());
        }

        Employee savedEmployee = repository.save(employee);
        return EmployeeMapper.toEmployeeDTO(savedEmployee);
    }

    @Override
    public void deleteEmployee(String id) {
        Employee employee = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with the given id : " + id));
        repository.delete(employee);
    }
}
