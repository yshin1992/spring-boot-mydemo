package myspringboot.ch4.ws;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

@Service
public class PushService {

	private DeferredResult<String> result;
	
	public DeferredResult<String> getData(){
		result = new  DeferredResult<String>();
		return result; 
	}
	
	@Scheduled(fixedDelay=5000)
	public void push(){
		if(result !=null){
			result.setResult(System.currentTimeMillis()+"");
		}
	}
}
