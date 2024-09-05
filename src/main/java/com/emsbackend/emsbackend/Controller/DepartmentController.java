package com.emsbackend.emsbackend.Controller;


import com.emsbackend.emsbackend.DTO.DepartmentDTO;
import com.emsbackend.emsbackend.Mapper.DepartmentMapper;
import com.emsbackend.emsbackend.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody  DepartmentDTO departmentDTO){
        DepartmentDTO departmentDTO1 = departmentService.saveDepartment(departmentDTO);
        return new ResponseEntity<>(departmentDTO1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments(){
        List<DepartmentDTO> departmentDTOList = departmentService.getAllDepartments();
        return ResponseEntity.ok(departmentDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> getDepartment(@PathVariable String id){
        DepartmentDTO departmentDTO = departmentService.getDepartment(id);
        return ResponseEntity.ok(departmentDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDTO> updateDepartment(@PathVariable String id, @RequestBody DepartmentDTO departmentDTO){
        DepartmentDTO departmentDTO1 = departmentService.updateDepartment(id,departmentDTO);
        return ResponseEntity.ok(departmentDTO1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable String id){
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok("Department has been deleted");
    }
}
