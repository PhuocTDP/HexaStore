package com.store.service.Impl;

import java.io.File;
import java.util.List;
import java.util.Optional;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.store.service.UploadService;



@Service
public class UploadServiceImpl implements UploadService{

	@Autowired 
	ServletContext app;

	public File save(MultipartFile file, String folder) {
		File dir = new File(app.getRealPath("/assets/"+ folder));
		if(!dir.exists()) {
			dir.mkdirs();
		}
		// Tạo folder nếu chưa tồn 
		String s = System.currentTimeMillis() + file.getOriginalFilename();
		String name = Integer.toHexString(s.hashCode()) + s.substring(s.lastIndexOf("."));
		try {// lưu file vào folder đó
			File savedFile = new File(dir, name);
			file.transferTo(savedFile);
			System.out.println(savedFile.getAbsolutePath());
			return savedFile;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	

}
