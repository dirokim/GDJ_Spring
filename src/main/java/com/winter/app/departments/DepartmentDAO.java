package com.winter.app.departments;



import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class DepartmentDAO {
	
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String namespace="com.winter.app.departments.DepartmentDAO.";
	
	//delete
	public Integer delete(DepartmentDTO departmentDTO) throws Exception {
	return sqlSession.delete(namespace+"delete",departmentDTO);
	}
	
	//update
	public Integer update(DepartmentDTO departmentDTO) throws Exception {
		return sqlSession.update(namespace+"update",departmentDTO);
	}
	//add
	public Integer add(DepartmentDTO departmentDTO) throws Exception {
	  return sqlSession.insert(namespace+"add",departmentDTO);
		
	}
	
	//detail
	public DepartmentDTO getDetail(DepartmentDTO departmentDTO) throws Exception {
		
		return sqlSession.selectOne(namespace+"getDetail",departmentDTO);
		
	}
	//list
	public List<DepartmentDTO> getList() throws Exception {
		return sqlSession.selectList(namespace+"getList");
	}
	
}
