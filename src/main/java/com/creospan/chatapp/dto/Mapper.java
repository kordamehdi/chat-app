package com.creospan.chatapp.dto;

import com.creospan.chatapp.entities.Channel;
import com.creospan.chatapp.entities.Employee;

public class Mapper {

    public static Employee fromEmployeeDtoToEmployee(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setUsername(employeeDto.getUsername());
        employee.setEmail(employeeDto.getEmail());
        employee.setPassword(employeeDto.getPassword());
        return employee;
    }

}
