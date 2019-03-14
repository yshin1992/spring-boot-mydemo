package myspringboot.ch2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON)
public class SingletonService {
	
	@Value("其他类的属性")
	private String another;

	public String getAnother() {
		return another;
	}

	public void setAnother(String another) {
		this.another = another;
	}
	
	public SingletonService(){
		System.out.println("我要被实例化了！");
	}
	
//	@PostConstruct
	public void init(){
		System.out.println("我跟在构造函数后执行。。。");
	}
	
//	@PreDestroy
	public void destroy(){
		System.out.println("我会在Bean销毁前执行。。。");
	}
	
}
