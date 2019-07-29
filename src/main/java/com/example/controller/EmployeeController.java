package com.example.controller;

import com.example.entity.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/em")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/add")
    boolean add(Employee employee){
       return this.employeeService.save(employee);

    }
    @RequestMapping("/delete")
    boolean delete(Long id){
        return this.employeeService.removeById(id);
    }
    @RequestMapping("/getEmployee")
    List<Employee> showEmployee(){
        return this.employeeService.showEmployee();
    }
    @RequestMapping("/getByManager")
    List<Employee> getByManager(){
        return  this.employeeService.getByManager();
    }
}
