package com.winter.app.util;

import java.io.File;
import java.util.Calendar;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	
	
	
	
	public String fileSave(String path,MultipartFile file) throws Exception {
		//어디에 저장 ?
				//경로 리얼경로
				File f = new File(path); 
//				f = new File(f,"regions");
//				
//				if(f.isFile()) {
//				
//					throw new Exception();
//				}
				
				if(f.exists()) {
					
				}else {
					f.mkdirs();
				}
				//어떤 파일로 저장 ?
				Calendar ca = Calendar.getInstance();
				String fileName = ca.getTimeInMillis()+"_"+file.getOriginalFilename();
				System.out.println(fileName);
				
				//파일을 저장
				f = new File(f,fileName);        // 경로 , 파일이름 
//				FileCopyUtils.copy(file.getBytes(), f);   // 파일 복사 , 어디에? 경로 1.FileCopyUtils
				file.transferTo(f);					//2. MultipartFile .transferTo.
				
				
				
		return fileName;
	}
}
