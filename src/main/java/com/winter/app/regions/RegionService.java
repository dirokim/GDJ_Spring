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
		//하드에서 삭제
		//1.지울 파일명 조회
		 List<RegionFileDTO> ar = regionDAO.getListFiles(regionDTO);
		//경로생성
		; 
		//hdd 에서 삭제
		String path = servletContext.getRealPath("/resources/uploadd/regions/");	
		for(RegionFileDTO f: ar) {
			boolean num = fileManager.fileDelete(path, f.getFileName()); 
			
			
			if(num==true) {
				return 1;
			}else {
				return 0;
			}
		}

		 
		int result = regionDAO.delete(regionDTO);
		
		
		//DB 에서 삭제
			return result;
	}
	
	//update
	public int update(RegionDTO regionDTO)throws Exception {
		
		
		
		
		return regionDAO.update(regionDTO);
	}
	
	//insert
	public int add(RegionDTO regionDTO,MultipartFile file) throws Exception {
		int result = regionDAO.add(regionDTO);
		
		String path = servletContext.getRealPath("/resources/uploadd/regions");
		System.out.println(path);
		String fileName = fileManager.fileSave(path, file);
		//4.DB에정보 저장 
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
