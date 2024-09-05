package com.emsbackend.emsbackend.Service;

import com.emsbackend.emsbackend.DTO.DepartmentDTO;

import java.util.List;

public interface DepartmentService {
    DepartmentDTO saveDepartment(DepartmentDTO departmentDTO);

    List<DepartmentDTO> getAllDepartments();

    DepartmentDTO getDepartment(String id);

    DepartmentDTO updateDepartment(String id, DepartmentDTO departmentDTO);

    void deleteDepartment(String id);
}
