package com.winter.app.util;

import java.io.File;
import java.util.Calendar;

import javax.servlet.ServletContext;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileManager {
	
	
	
	
	
	public void fileSave(String path,MultipartFile file) throws Exception {
		//어디에 저장 ?
				File f = new File("/resources/upload"); 
				f = new File(f,path);
				
				if(f.isFile()) {
				
					throw new Exception();
				}
				
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
				FileCopyUtils.copy(file.getBytes(), f);   // 파일 복사 , 어디에? 경로
		
	}
}
