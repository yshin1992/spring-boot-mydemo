package myspringboot.ch4;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 服务器端的推送技术
 * @author yshin1992
 *
 */
@Controller
public class SSEController {

	
	@ResponseBody
	@RequestMapping(value="/push",produces={"text/event-stream"})
	public String push(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//这里的\n\n是必须的 参见博客https://www.cnblogs.com/accordion/p/7764460.html
		return "data:" + new Date().toString() + "\n\n";
	}
}
