package com.emsbackend.emsbackend.Controller;


import com.emsbackend.emsbackend.DTO.EmployeeDTO;
import com.emsbackend.emsbackend.Entity.Employee;
import com.emsbackend.emsbackend.Service.DepartmentService;
import com.emsbackend.emsbackend.Service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO employee = employeeService.createEmployee(employeeDTO);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
        List<EmployeeDTO> employeeDTOList = employeeService.getAllEmployees();
        return ResponseEntity.ok(employeeDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable String id){
        EmployeeDTO employeeDTO = employeeService.getEmployees(id);
        return ResponseEntity.ok(employeeDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable String id, @RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO employeeDTO1 = employeeService.updateEmployee(id,employeeDTO);
        return ResponseEntity.ok(employeeDTO1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }
}
