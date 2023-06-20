package com.example.springkiemtra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public String createOrUpdateEmployee(Employee employee){
        try {
            employeeRepository.save(employee);
            return "Success";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Error";
        }
    }

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }


}
