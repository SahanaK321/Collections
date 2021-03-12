package com.sah.empcoll.dao;

import java.util.ArrayList;
import java.util.List;

import com.sah.empcoll.db.EmployeeDB;
import com.sah.empcoll.dto.Employee;
import com.sah.empcoll.exceptions.InvalidEmployeeIdException;
import com.sah.empcoll.exceptions.WrongSalaryException;

public class EmployeeDAO implements IEmployeeDAO {
	
	public boolean addEmployee(Employee e) throws WrongSalaryException{
       
		return EmployeeDB.addEmployee(e);
	}

	public  ArrayList<Employee> getAllEmployees() {

		return EmployeeDB.employees;
	}
	
	public boolean editSalaryByEmployeeId(int id,int empNewExp) throws InvalidEmployeeIdException {
		
		return EmployeeDB.editSalaryByEmployeeID(id,empNewExp);
	}

	public boolean editExpByEmployeeId(int id,int empNewSalary) throws InvalidEmployeeIdException {
	
		return EmployeeDB.editExpByEmployeeId(id,empNewSalary);
	}

	public ArrayList<Employee> getEmployeeBySalary(int salary) {
		
		return EmployeeDB.getEmployeeBySalary(salary);
	}

	public ArrayList<Employee> getEmployeeByExperience(int exp) {
	
		return EmployeeDB.getEmployeeByExperience(exp);
	}
	public ArrayList<Employee> getEmployeesBySalaryRange(int salaryRangeMin, int salaryRangeMax) {

		return EmployeeDB.getEmployessBySalaryRange(salaryRangeMin, salaryRangeMax);
	}

}


