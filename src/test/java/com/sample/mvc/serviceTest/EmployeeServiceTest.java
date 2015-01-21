package com.sample.mvc.serviceTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.sample.mvc.dao.EmployeeDAO;
import com.sample.mvc.model.EmployeeCommand;
import com.sample.mvc.service.EmployeeServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

	@Mock
	public EmployeeDAO employeeDao;
	
	private EmployeeCommand emp;
	
	@InjectMocks
	public EmployeeServiceImpl employeeService=new EmployeeServiceImpl();
	
	
	
	 @Before
	    public void setup() {
	 
	        // Process mock annotations
	        MockitoAnnotations.initMocks(this); 
	        emp = new EmployeeCommand();
	      	 emp.setCode(105);
	         emp.setName("vikas");
	         emp.setCity("pune");
	 }
	 
	 
	 
	@Test
	public void testGetEmployeeById() {
		
      
      when(employeeDao.getEmployeebyId(anyInt())).thenReturn(emp);
		Mockito.verify(employeeDao,Mockito.times(0)).getEmployeebyId(20);
		 assertEquals(105,employeeService.getEmployeebyId(20).getCode());
	}
	
	
	@Test()
	public void testUpdateEmployee()
	{
	     doNothing().when(employeeDao).updateEmployee(any(EmployeeCommand.class));
	     employeeService.updateEmployee(emp);	  
	}
	
	@Test
	public void testListContact()
	{
		List<EmployeeCommand> empList=new ArrayList<EmployeeCommand>();
		empList.add(emp);
		when(employeeDao.listContact()).thenReturn(empList);
		assertEquals(1,employeeService.listContact().size());
	}
	
	
	
	@Test
	public void testDeleteEmployee()
	{
		doNothing().when(employeeDao).deleteEmployee(anyInt());
		employeeService.deleteEmployee(102);
	}
	
	
	
	@Test
	public void testAddEmployee()
	{
		doNothing().when(employeeDao).addEmployee(any(EmployeeCommand.class));
		employeeService.addEmployee(emp);
	}
}
