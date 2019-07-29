package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
    List<Employee> getByManager();
    List<Employee> showEmployee();
    int resetPassword(Long employeeNo);
    int update(String username, String email, String telephone, String position, Long employeeNo);


}
