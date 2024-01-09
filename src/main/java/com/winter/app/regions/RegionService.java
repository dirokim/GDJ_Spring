package com.winter.app.regions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.util.Pager;

@Service
public class RegionService {
	//DB DAO 에 보내기전 전처리 ,후처리
	
	//list 가지고 오는거
	@Autowired
	private RegionDAO regionDAO;
	
	
	//delete
	public int delete(RegionDTO regionDTO)throws Exception{
		return regionDAO.delete(regionDTO);
	}
	
	//update
	public int update(RegionDTO regionDTO)throws Exception {
		return regionDAO.update(regionDTO);
	}
	
	//insert
	public int add(RegionDTO regionDTO) throws Exception {
		return regionDAO.add(regionDTO);
		
	}
	
	//detail
	public RegionDTO getdetail(RegionDTO regionDTO)throws Exception {
		return regionDAO.getDetail(regionDTO);
	}
	//list
	public List<RegionDTO> getlist(Pager pager)throws Exception {
		pager.makeRow();
		Long totalCount = regionDAO.getTotal();
		pager.makeNum(totalCount);

		///////////////////////////////////////////////
		List<RegionDTO> ar = this.regionDAO.getList(pager);
		return ar;
	}
	

	
}
