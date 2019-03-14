package myspringboot.ch2;

public class BeanUsedByPostPreService {
	public BeanUsedByPostPreService(){
		System.out.println("你正在执行我的构造函数。。");
	}
	
	public void init(){
		System.out.println("我跟在构造函数后执行。。。");
	}
	
	public void destroy(){
		System.out.println("我会在Bean销毁前执行。。。");
	}
}
