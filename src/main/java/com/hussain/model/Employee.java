package com.hussain.model;

public class Employee {
	
	private String empId;
	private String name;
	private String doj;
	private double salary;
	public Employee(String empId, String name, String doj, double salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.doj = doj;
		this.salary = salary;
	}
	public Employee() {
		super();
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", doj=" + doj + ", salary=" + salary + "]";
	}
	
	
	

}
