package com.emsbackend.emsbackend.Mapper;

import com.emsbackend.emsbackend.DTO.DepartmentDTO;
import com.emsbackend.emsbackend.Entity.Department;

public class DepartmentMapper {

    public static DepartmentDTO toDepartmentDTO(Department department){
        DepartmentDTO departmentDTO = new DepartmentDTO(department.getId(),department.getDepartmentName(),department.getDepartmentDescription());
        return departmentDTO;
    }

    public static Department toDepartment(DepartmentDTO departmentDTO){
        Department department = new Department(departmentDTO.getId(),departmentDTO.getDepartmentName(),departmentDTO.getDepartmentDescription());
        return department;
    }
}
