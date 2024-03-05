package com.mvc.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.mvc.file.model.FileValidator;
import com.mvc.file.model.UploadFile;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	// FileValidator에 자동 생성된 객체와 연결
	private FileValidator fileValidator;
	
	@RequestMapping("/form")
	public String getUploadForm() {
		
		return "uploadForm";
	}
	
	@RequestMapping("/upload")
	public String fileUpload(HttpServletRequest request, Model model, UploadFile uploadFile, BindingResult result) {
	// BindingResult : 유효성 검사 후 에러메세지를 담아 전달한다.
	// UploadFile이라는 클래스를 만들어 넘어오는 설명이나 파일을 받아서 저장한다. (dto 개념)
		
		// 유효성 검사 : 파일 크기가 0인지 확인
		// (이를 위해 FileValidator라는 클래스 생성한다.)
		fileValidator.validate(uploadFile, result);
		// uploadFile과 result를 넘겨 에러가 있으면 validate 메소드에서 에러 메세지를 result에 담아준다.
		
		if(result.hasErrors()) {
			return "uploadForm";
		}
		
		MultipartFile file = uploadFile.getFile(); // 업로드한 파일을 갖고 온다.
		String filename = file.getOriginalFilename(); // 업로드된 파일명
		System.out.println(filename);
		
		UploadFile fileobj = new UploadFile();
		fileobj.setFilename(filename);
		fileobj.setDesc(uploadFile.getDesc());
		
		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		try {
			inputStream = file.getInputStream(); // 업로드한 파일 읽어온다.
			String path = "E:\\upload"; // 파일 저장할 경로
			
			File storage = new File(path);
			
			if(!storage.exists()) { // path 경로에 디렉토리 존재 여부 확인
				storage.mkdirs(); // 없으면 디렉토리 만든다.(폴더 생성)
			}
			
			File newfile = new File(path + "/" + filename);
			
			if(!newfile.exists()) { // path경로에 filename명의 파일이 없다면
				newfile.createNewFile(); // filename명의 파일을 새로 생성한다.
			}
			
			System.out.println(newfile.getPath());
			outputStream = new FileOutputStream(newfile); // 
			
			int read = 0;
			byte [] b = new byte[(int)file.getSize()];
			
			while((read=inputStream.read(b)) != -1) { 
				outputStream.write(b, 0, read);
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		model.addAttribute("fileobj", fileobj);
		
		return "uploadRes";
		
	}
	
}
