package com.creospan.chatapp.service;

import com.creospan.chatapp.dto.ChannelDto;
import com.creospan.chatapp.dto.EmployeeDto;
import com.creospan.chatapp.dto.Mapper;
import com.creospan.chatapp.entities.Channel;
import com.creospan.chatapp.entities.Employee;
import com.creospan.chatapp.repository.ChannelRepository;
import com.creospan.chatapp.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ChannelRepository channelRepository;

    public void addEmployee(EmployeeDto employeeDto){
        Employee employee = Mapper.fromEmployeeDtoToEmployee(employeeDto);
        employeeRepository.save(employee);
    }

    public void addChannel(ChannelDto channelDto){
        Channel channel = new Channel();
        channel.setName(channelDto.getName());
        List<Employee> employees = employeeRepository.findAllById(channelDto.getUsersId());
        channel.setEmployees(employees);
        channelRepository.save(channel);
    }

    public void deleteChannel(Long id){
        channelRepository.deleteById(id);
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }
}
