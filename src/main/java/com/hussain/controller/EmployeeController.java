package com.hussain.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hussain.model.Employee;
import com.hussain.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;

	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/save")
	public String saveEmployee(Employee employee) {

		empService.saveEmployee(employee);
		return "home.jsp";
	}
	
	@RequestMapping("/saveorupdate")
	public String updateEmployee(Employee employee) {
		empService.saveOrUpdateEmployee(employee);
		return "home.jsp";
	}
	
	
	@RequestMapping("/delete")
	public String deleteEmployee(String empId) {
		empService.deleteEmployee(empId);
		return "home.jsp";
	}
	
	@RequestMapping("/showemployee")
	public ModelAndView showEmployee(String empId) {
		Employee employee = empService.getEmployee(empId);
		ModelAndView mv=new ModelAndView("show-employee.jsp");
		mv.addObject("employee", employee);
		return mv;
	}
	
	@RequestMapping("/showallemployees")
	public ModelAndView showAllEmployee() {
		ArrayList<Employee> employees=empService.getAllEmployees();
		
		ModelAndView mv=new ModelAndView("show-all-employees.jsp");
		mv.addObject("employees", employees);
		return mv;
	}
	
	
	
	
}
