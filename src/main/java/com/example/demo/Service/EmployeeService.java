package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.DepartmentRepository;
import com.example.demo.DAO.EmployeeRepository;
import com.example.demo.Entity.Department;
import com.example.demo.Entity.Employees;
import com.example.demo.dto.EmployeeRequest;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private DepartmentRepository deptRepo;

	public List<Employees> getAllEmployees() {

		return empRepo.findAll();
	}

	public Employees addEmployee(Employees empReq) {
		
		System.out.println(empReq);
		
		//Employees emp = empReq.getEmployee();
		//empReq.getDepartment().getDepartmentId();
		
		//System.out.println(empReq.getEmployee());
		
		//return empRepo.save(empReq.getEmployee());
		//return empRepo.save(empReq);
		
		
		
		
		
		return empRepo.save(empReq);
	}

	public EmployeeRequest findEmployee(int empId) {
		
		Optional<Employees> e1 = empRepo.findById(empId);
		
		EmployeeRequest empReq1 = new EmployeeRequest();
		
		Optional<Department> d = deptRepo.findById(e1.get().getDepartmentId());
		
		if(d.isPresent())
		{
			System.out.println("Department ID: " + d.get().getDepartmentName());
			
			empReq1.setEmployeeId(empId);
			
			
			
			
			empReq1.setDepartmentName(d.get().getDepartmentName().toString());
		}else
		{
			System.out.println("Record not present");
		}
		
		return empReq1;
	}

}
