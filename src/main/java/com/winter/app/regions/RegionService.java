package com.winter.app.regions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionService {
	//DB DAO 에 보내기전 전처리 ,후처리
	
	//list 가지고 오는거
	@Autowired
	private RegionDAO regionDAO;
	
	public List<RegionDTO> getlist()throws Exception {
		List<RegionDTO> ar = this.regionDAO.getList();
		
		
		
		
		return ar;
	}
	
	
	
}
