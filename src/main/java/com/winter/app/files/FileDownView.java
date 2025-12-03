package com.winter.app.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.winter.app.board.BoardFileDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FileDownView extends AbstractView{
	@Value("${app.upload.base}")
	private String filePath;
	
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
//		Iterator<String> it = model.keySet().iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
		FileDTO fileDTO = (FileDTO)model.get("file");
		String category = (String)model.get("category");
		
//		System.out.println(fileDTO);
//		System.out.println(category);
//		System.out.println("Custom View");
		
		File file = new File(filePath+category, fileDTO.getFileName());
		
		response.setCharacterEncoding("UTF-8");
		
		response.setContentLengthLong(file.length());
		
		String origin = URLEncoder.encode(fileDTO.getFileOrigin(), "UTF-8");
		
		response.setHeader("Content-Disposition", "attachment;filename=\""+origin+"\"");
		response.setHeader("content-Transfer-Encoding", "binary");
		
		FileInputStream fi = new FileInputStream(file);
		
		OutputStream os = response.getOutputStream();
		
		FileCopyUtils.copy(fi, os);
		
		os.close();
		fi.close();
		
	}
}
