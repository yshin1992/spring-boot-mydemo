package myspringboot.ch4.advice;

import java.util.Date;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice//声明这是一个控制器建言
public class MyControllerAdvice {

	private final String[] DATEPATTERN = new String[] {"yyyy-MM-dd HH:mm:ss", "yyyy-M-dd","yyyy-MM-dd","yyyyMMdd","yyyyMdd", "yyyy年MM月dd日 HH时mm分ss秒","yyyy年M月dd日 HH时mm分ss秒", "yyyy年MM月dd日","yyyy年M月dd日"};
	
	@ExceptionHandler//定义一个全局的错误,可以根据Value来设置过滤的条件
	public ModelAndView exception(Exception exception,WebRequest request){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("error");
		mv.addObject("errorMessage", exception.getMessage());
		return mv;
	}
	
	@ModelAttribute//这里声明将键值对添加到全局，如果ModelAttribute在一般的controller里使用的话，那么该controller会在执行RequestMapping的方法前都会调用此方法
	public void addAttributes(Model model){
		model.addAttribute("now",new Date());
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Date.class,new MyDatePropertyEditor(true,DATEPATTERN));
	}
}
