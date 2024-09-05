package com.emsbackend.emsbackend.Service;


import com.emsbackend.emsbackend.DTO.DepartmentDTO;
import com.emsbackend.emsbackend.Entity.Department;
import com.emsbackend.emsbackend.Exception.ResourceNotFoundException;
import com.emsbackend.emsbackend.Mapper.DepartmentMapper;
import com.emsbackend.emsbackend.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {
        Department department = DepartmentMapper.toDepartment(departmentDTO);
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.toDepartmentDTO(savedDepartment);
    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map((department) -> DepartmentMapper.toDepartmentDTO(department)).collect(Collectors.toList());
    }

    @Override
    public DepartmentDTO getDepartment(String id) {
        Department department = departmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with the given id : " + id));
        return DepartmentMapper.toDepartmentDTO(department);
    }

    @Override
    public DepartmentDTO updateDepartment(String id, DepartmentDTO departmentDTO) {
        Department department = departmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with the given id : " + id));
        department.setDepartmentName(departmentDTO.getDepartmentName());
        department.setDepartmentDescription(departmentDTO.getDepartmentDescription());
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.toDepartmentDTO(savedDepartment);
    }

    @Override
    public void deleteDepartment(String id) {
    Department department = departmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with the given id : " + id));
    departmentRepository.delete(department);
    }
}
