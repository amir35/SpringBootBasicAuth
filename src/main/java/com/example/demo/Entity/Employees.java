package com.example.demo.Entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table(name = "employees")
public class Employees {

	@Id
	@Column(name = "EMPLOYEE_ID")
	private int employeeId;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Email
	@Column(name = "EMAIL")
	private String email;

	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	@Column(name = "HIRE_DATE")
	private Date hireDate;

	@Column(name = "JOB_ID")
	private String jobId;

	@Column(name = "SALARY")
	private double salary;

	@Column(name = "COMMISSION_PCT")
	private double commissionPct;

	@Column(name = "MANAGER_ID")
	private int managerId;

	@Column(name = "DEPARTMENT_ID")
	private int departmentId;

	// @ManyToOne
	// @JoinColumn(name="DEPARTMENT_ID")
	// private Department dept;

	public Employees(int employeeId, String firstName, String lastName, @Email String email, String phoneNumber,
			Date hireDate, String jobId, double salary, double commissionPct, int managerId, int departmentId,
			Department dept) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.jobId = jobId;
		this.salary = salary;
		this.commissionPct = commissionPct;
		this.managerId = managerId;
		this.departmentId = departmentId;
		// this.dept = dept;
	}

	public Employees() {
		super();
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getCommissionPct() {
		return commissionPct;
	}

	public void setCommissionPct(double commissionPct) {
		this.commissionPct = commissionPct;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	/*
	 * public Department getDept() { return dept; }
	 * 
	 * public void setDept(Department dept) { this.dept = dept; }
	 */

	@Override
	public String toString() {
		return "Employees [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate + ", jobId=" + jobId
				+ ", salary=" + salary + ", commissionPct=" + commissionPct + ", managerId=" + managerId + ","
				+ " departmentId=" + departmentId + ", "
				// + "dept=" + dept
				+ "]";
	}

}
