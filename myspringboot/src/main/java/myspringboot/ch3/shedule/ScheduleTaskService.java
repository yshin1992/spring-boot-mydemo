package myspringboot.ch3.shedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleTaskService {
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(fixedRate=5000)
	public void reportCurrentTime(){
		System.out.println("每隔五秒执行一次 "+ dateFormat.format(new Date()));
	}
	
	@Scheduled(cron="0 46 11 * * *")
	public void fixTimeExecution(){
		System.out.println("在指定时间 "+ dateFormat.format(new Date())+"执行");
	}
	
}
