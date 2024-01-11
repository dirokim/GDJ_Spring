package com.winter.app.regions;

import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.util.FileManager;
import com.winter.app.util.Pager;

@Service
public class RegionService {
	//DB DAO 에 보내기전 전처리 ,후처리
	
	//list 가지고 오는거
	@Autowired
	private RegionDAO regionDAO;
	@Autowired
	private FileManager fileManager;
	
	
	@Autowired
	private ServletContext servletContext;
	//내장 객체 중에서 application
	
	//delete
	public int delete(RegionDTO regionDTO)throws Exception{
		return regionDAO.delete(regionDTO);
	}
	
	//update
	public int update(RegionDTO regionDTO)throws Exception {
		return regionDAO.update(regionDTO);
	}
	
	//insert
	public int add(RegionDTO regionDTO,MultipartFile file) throws Exception {
		int result = regionDAO.add(regionDTO);
		
		String path = servletContext.getRealPath("/resources/uploadd");
		
		
		RegionFileDTO dto = new RegionFileDTO();
		dto.setFileName(fileName);
		dto.setOriName(file.getOriginalFilename());
		dto.setRegion_id(regionDTO.getRegion_id());
		return regionDAO.addFile(dto);
		
	}
	
	//detail
	public RegionDTO getdetail(RegionDTO regionDTO)throws Exception {
		return regionDAO.getDetail(regionDTO);
	}
	//list
	public List<RegionDTO> getlist(Pager pager)throws Exception {
		pager.makeRow();
		Long totalCount = regionDAO.getTotal(pager);
		pager.makeNum(totalCount);

		///////////////////////////////////////////////
		List<RegionDTO> ar = this.regionDAO.getList(pager);
		return ar;
	}
	

	
}
