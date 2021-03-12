package com.sah.empcoll.dao;

import java.util.ArrayList;
import com.sah.empcoll.dto.Employee;
import com.sah.empcoll.exceptions.InvalidEmployeeIdException;
import com.sah.empcoll.exceptions.WrongSalaryException;

public interface IEmployeeDAO {
	
	 public boolean addEmployee(Employee e)throws WrongSalaryException;
	 
	 public boolean editSalaryByEmployeeId(int id,int empNewSalary)throws InvalidEmployeeIdException;
	 
	 public boolean editExpByEmployeeId(int id,int empNewExp)throws InvalidEmployeeIdException;
	 
	 public ArrayList<Employee> getAllEmployees();
	 
	 public ArrayList<Employee> getEmployeeBySalary(int salary);
	 
	 public ArrayList<Employee> getEmployeeByExperience(int exp);
	 
	 public ArrayList<Employee> getEmployeesBySalaryRange(int salaryRangeMin,int salaryRangeMax);

}