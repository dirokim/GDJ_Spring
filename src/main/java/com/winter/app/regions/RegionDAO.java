package com.winter.app.regions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.winter.app.util.Pager;

@Repository
public class RegionDAO {
	
	@Autowired
	private SqlSession sqlSession;	
	
	private final String NAMESPACE="com.winter.app.regions.RegionDAO.";
	
	
	
//	//update
//	public int update(RegionDTO regionDTO) throws Exception {
//		Connection con = DBConnector.getConnector();
//		
//		String sql="UPDATE REGIONS SET REGION_NAME=? WHERE REGION_ID=?";
//		
//		PreparedStatement st = con.prepareStatement(sql);
//		
//		st.setString(1, regionDTO.getRegion_name());
//		st.setInt(2, regionDTO.getRegion_id());
//		
//		int result = st.executeUpdate();
//		
//		DBConnector.disConnect(st, con);
//		
//		return result;
//		
//	}
	//delete
	public Integer delete(RegionDTO regionDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"delete",regionDTO);
	}
	//update
	public Integer update(RegionDTO regionDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"update",regionDTO);
	}
	public int addFile(RegionFileDTO regionFileDTO) throws Exception{
		
		return sqlSession.insert(NAMESPACE+"addFile",regionFileDTO);
		
	}
	
	//add
	public Integer  add(RegionDTO regionDTO) throws Exception {
		return 	sqlSession.insert(NAMESPACE+"add", regionDTO);
	}
	//detail
	public RegionDTO getDetail(RegionDTO regionDTO)throws Exception{
		return	sqlSession.selectOne(NAMESPACE+"getDetail",regionDTO);
	
	
	
	
	}
	
	
	public List<RegionFileDTO> getListFiles(RegionDTO regionDTO) throws Exception  {
		return sqlSession.selectList(NAMESPACE+"getListFiles",regionDTO);
	}
	
	
	//List
	public List<RegionDTO> getList(Pager pager) throws Exception {	
			return sqlSession.selectList(NAMESPACE+"getList",pager);	
	}

	
	public Long getTotal (Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getTotal",pager);
	}
	
	
}
