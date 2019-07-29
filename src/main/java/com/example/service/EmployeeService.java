package com.example.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Employee;
import com.example.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmployeeService extends ServiceImpl<EmployeeMapper, Employee> {
    @Resource
    EmployeeMapper employeeMapper;
    public int addEmployee(Employee employee){
        return employeeMapper.insert(employee);

    }
    public int delete(Long id){
       return employeeMapper.deleteById(id);

    }
public List<Employee> showEmployee(){
        return employeeMapper.showEmployee();
}
public List<Employee> getByManager(){
        return employeeMapper.getByManager();
}
}
