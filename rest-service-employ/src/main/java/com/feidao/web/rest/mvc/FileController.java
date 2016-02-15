package com.feidao.web.rest.mvc;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dbs.web.api.exception.ApplicationException;

@Controller
@RequestMapping("/file")
public class FileController {
	
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadFile(@RequestParam(value="file_path", required=true) String filePath, 
    		final HttpServletRequest req) throws IOException
    { 
    	String fileName = filePath;
    	
    	// retrieve contents of pdf file in byte[]
//        byte[] contents = articleService.getBytesFromPdfFile(pdfPath, country);
    	byte[] contents = null;
    	
        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        headers.setContentType(MediaType.parseMediaType("application/force-download"));
        headers.setContentDispositionFormData(fileName, fileName);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        headers.setContentLength(contents.length);
        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
        
        return "";
    }
	
	@RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<byte[]> downloadFile(@RequestParam(value="file_path", required=true) String filePath, 
    		final HttpServletResponse httpResponse) throws IOException
    { 
    	String fileName = filePath;
    	
    	// retrieve contents of pdf file in byte[]
//        byte[] contents = articleService.getBytesFromPdfFile(pdfPath, country);
    	byte[] contents = null;
    	
        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        headers.setContentType(MediaType.parseMediaType("application/force-download"));
        headers.setContentDispositionFormData(fileName, fileName);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        headers.setContentLength(contents.length);
        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
        
        return response;
    }
	
	
	
}
