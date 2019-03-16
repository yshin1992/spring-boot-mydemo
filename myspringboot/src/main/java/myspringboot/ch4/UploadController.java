package myspringboot.ch4;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	@RequestMapping("/initUpload")
	public String initUpload(){
		return "upload";
	}
	
	@RequestMapping("/upload")
	@ResponseBody
	public String upload(MultipartFile file,String fileName){
		System.out.println("--->" + fileName);
		try {
			System.out.println(file.getOriginalFilename());
			FileUtils.writeByteArrayToFile(new File("E:/develop/apache-tomcat-7.0.75/attached/"+file.getOriginalFilename()), file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
			return "ERROR";
		}
		return "SUCCESS";
	}
	
}
