package com.winter.app.departments;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.MyTest;
import com.winter.app.departments.DepartmentDAO;
import com.winter.app.departments.DepartmentDTO;

public class DepartmentDAOTest extends MyTest{
	
	@Autowired
	private DepartmentDAO departmentDAO;
	
	public void deleteTest () throws Exception {
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setDepartment_id(290);
		int result = departmentDAO.delete(departmentDTO);
		assertEquals(1, result);
	}
	
	@Test
	public void updateTest() throws Exception {
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setDepartment_id(280);
		departmentDTO.setDepartment_name("Test");
		departmentDTO.setManager_id(100);
		departmentDTO.setLocation_id(1700);
	int result = departmentDAO.update(departmentDTO);
		assertEquals(1, result);
	}
	
	@Test
	public void addTest( ) throws Exception {
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setDepartment_name("Test");
		departmentDTO.setManager_id(100);
		departmentDTO.setLocation_id(1700);
		int result = departmentDAO.add(departmentDTO);
		assertEquals(1, result);
	}
	
	@Test
	public void getDetailTest( ) throws Exception{
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setDepartment_id(10);
		departmentDTO = departmentDAO.getDetail(departmentDTO);
		assertNotNull(departmentDTO);
	}
	
	@Test
	public void getListTest() throws Exception {
		List<DepartmentDTO> ar = departmentDAO.getList();
		assertNotNull("list", ar.size());
	}
}
