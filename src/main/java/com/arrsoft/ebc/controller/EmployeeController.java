package com.arrsoft.ebc.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.arrsoft.ebc.dao.EmployeeDao;
import com.arrsoft.ebc.model.Department;
import com.arrsoft.ebc.model.Employee;
import com.arrsoft.ebc.model.Role;
import com.arrsoft.ebc.service.DepartmentService;
import com.arrsoft.ebc.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "birthDate", new CustomDateEditor(dateFormat, true));
	} 
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	DepartmentService departmentService;
	
	@ModelAttribute("employeeForm")
	public Employee getEmployeeForm(){
		return new Employee();
	}
	
	@RequestMapping
	public String getIndex(Model model){
		List<Employee> employees = employeeService.getAllEmployee();
		List<Department> departments = departmentService.getAllDepartments();
		model.addAttribute("employees", employees);
		model.addAttribute("departments", departments);
		
		return "employee-fd";
	}
	
	//do save
	@RequestMapping(value="/dosave", method=RequestMethod.POST)
	public String save(@Valid @ModelAttribute("employeeForm") Employee employee, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){

		if(bindingResult.hasErrors()){
			List<Employee> employees = employeeService.getAllEmployee();
			List<Department> departments = departmentService.getAllDepartments();
			model.addAttribute("employees", employees);
			model.addAttribute("departments", departments);
			
			return "employee-fd";
		}
		employeeService.save(employee);
		
		redirectAttributes.addFlashAttribute("message", "Employee berhasil ditambahkan");
		return "redirect:/employee";
	}
		
	/*@RequestMapping
	public String index(Model model){
		
		List<Employee> employees = employeeService.getAllEmployee();
		model.addAttribute("employees", employees);
		
		return "employee";
	}*/
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void save(@RequestBody Employee employee ){
			employeeService.save(employee);	
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable int id){
		employeeService.delete(id);
	}
	
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Employee getEmployeeById(@PathVariable int id){
		Employee employee = employeeService.getEmployeeById(id);
		
		return employee;
	}
	
	@RequestMapping(value="/example", method=RequestMethod.GET)
	@ResponseBody
	public String getExample(@RequestParam("data") String data){
		System.out.println(""+ data);
		return "value:  "+ data;
	}
}
