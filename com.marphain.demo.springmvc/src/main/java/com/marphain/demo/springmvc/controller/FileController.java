package com.marphain.demo.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Controller
@RequestMapping("/file")
public class FileController
{
	private static final Logger log = LoggerFactory.getLogger(FileController.class);
	
	/**
	 * 跳转到文件上传页面
	 * @return
	 */
	@RequestMapping("/toUploadFile")
	public String toUploadFile()
	{
		return "file/uploadFile";
	}
	
	@RequestMapping("/uploadFile")
	public void uploadFile(HttpServletRequest request)
	{
		if (log.isInfoEnabled())
		{
			log.info("start to run uploadFile()");
		}
		
		try 
		{
			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
			if (multipartResolver.isMultipart(request))
			{
				MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
				List<MultipartFile> files = req.getFiles("uploadFile");
				int size = files.size();
				for(int i = 0; i < size; i++)
				{
					//TODO:文件处理
					byte[] file = files.get(i).getBytes();
					System.out.println(file);
				}
			}
		}
		catch (Exception e) 
		{
			
		}
		
	}

}
