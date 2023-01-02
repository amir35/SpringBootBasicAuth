package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class Department {
	
	@Id
	@Column(name="DEPARTMENT_ID")
	private int departmentId;
	
	@Column(name="DEPARTMENT_NAME")
	@Enumerated(EnumType.STRING)
	private DepartmentName departmentName;
	
	@Column(name="MANAGER_ID")
	private int managerId;
	
	@Column(name="LOCATION_ID")
	private int locationId;

	public Department(int departmentId, DepartmentName departmentName, int managerId, int locationId) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.managerId = managerId;
		this.locationId = locationId;
	}

	public Department() {
		super();
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public DepartmentName getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(DepartmentName departmentName) {
		this.departmentName = departmentName;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", managerId="
				+ managerId + ", locationId=" + locationId + "]";
	}
	
	//@OneToMany(mappedBy = "dept", targetEntity = Employees.class)
	//private List<Employees> emp;

	

}
