package myspringboot.ch4;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import myspringboot.ch4.model.DemoObj;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/anno")
public class DemoAnnoController {
	
	@RequestMapping(method={RequestMethod.GET},produces="text/plain;charset=UTF-8")
	public @ResponseBody String index(HttpServletRequest request){
		return "URL :" + request.getRequestURI() +" can access";
	}
	
	@RequestMapping(value="/array",produces="application/json;charset=UTF-8")
	public @ResponseBody Object[] getArray(){
		Object[] objs = {"Hello",12,new Date()};
		return objs;
	}
	
	@RequestMapping(value="/collection",produces="application/json;charset=UTF-8")
	public @ResponseBody Collection<?> getCollection(){
		Object[] objs = {"Hello",12,new Date()};
		return Arrays.asList(objs);
	}
	
	@RequestMapping("/path/{str}")
	public @ResponseBody String pathVal(@PathVariable String str,HttpServletRequest request){
		return "URL :" + request.getRequestURI()+"/path/"+str +" can access";
	}
	
	@RequestMapping(value="/demoobj",produces="application/json;charset=UTF-8")
	@ResponseBody
	public DemoObj getDemoObj(){
		return new DemoObj(1233444L, "DDSS");
	}
}
