package myspringboot.ch4;

import myspringboot.ch4.ws.PushService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
public class AsynController {
	
	@Autowired
	PushService pushService;
	
	@RequestMapping("/defer")
	public DeferredResult<String> deferredCall(){
		return pushService.getData();
	}
	
}
