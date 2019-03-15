package myspringboot.ch3.asyn;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsynTaskService {

	@Async(value="logExecutor")//声明该方法是异步方法，
	public void executeAsynTask(Integer i){
		System.out.println("执行异步任务 "+i);
	}
	
	@Async(value="daoExecutor")
	public void executeAsynTaskPlus(Integer i){
		System.out.println("执行异步任务 "+i+" plus");
	}
}
