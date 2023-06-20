package com.example.springkiemtra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/getAllEmployee")
    public String getAllEmployee(Model model){
        model.addAttribute("employees", employeeService.getAllEmployee());


        return "list-employee";
    }

    @PostMapping("/create")
    public String createEmployee(@ModelAttribute("employee") Employee employee ){
        try {
            employeeService.createOrUpdateEmployee(employee);

            return "redirect:/api/getAllEmployee";

        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Error";
        }
    }

    @GetMapping("/new")
    public String createFormEmployee(Model model) {
        model.addAttribute("employee",new Employee());
        return "createemployee";
    }

}
