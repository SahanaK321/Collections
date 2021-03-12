package com.sah.empcoll.service;

import java.util.ArrayList;
import com.sah.empcoll.dao.EmployeeDAO;
import com.sah.empcoll.dao.IEmployeeDAO;
import com.sah.empcoll.db.EmployeeDB;
import com.sah.empcoll.dto.Employee;
import com.sah.empcoll.exceptions.InvalidEmployeeIdException;
import com.sah.empcoll.exceptions.WrongSalaryException;

public class EmployeeServiceImpl implements IEmployeeService {
	
		IEmployeeDAO dao;

		public EmployeeServiceImpl() {
			dao = new EmployeeDAO();
		}

		public boolean addEmployee(Employee e) throws WrongSalaryException {
			
				if(e.getSalary()> 50000)
				{
					throw new WrongSalaryException();
				}
				else return dao.addEmployee(e);		
			
		}

		public ArrayList<Employee> getAllEmployees() {

			return dao.getAllEmployees();
		}
		
		public boolean editSalaryByEmployeeId(int id,int empSal1) throws InvalidEmployeeIdException {
			 return dao.editSalaryByEmployeeId(id,empSal1);
		}

		public boolean editExpByEmployeeId(int id,int empNewExp) throws InvalidEmployeeIdException {
			 return dao.editExpByEmployeeId(id,empNewExp);
		}

		public ArrayList<Employee> getEmployeeBySalary(int salary) {
			
			return dao.getEmployeeBySalary(salary);
		}

		public ArrayList<Employee> getEmployeesBySalaryRange(int salaryRangeMin, int salaryRangeMax) {
			
			return dao.getEmployeesBySalaryRange(salaryRangeMin, salaryRangeMax);
		}
		public ArrayList<Employee> getEmployeeByExperience(int exp) {
		
			return dao.getEmployeeByExperience(exp);
		}

	}

