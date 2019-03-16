package myspringboot.ch4.model;

public class DemoObj {

	private Long id;
	
	private String name;

	//这里我们声明了带参数的构造函数，因为要用到jaskson将其转换为json数据，所以这里必须定义一个默认的构造函数
	public DemoObj(){
		
	}
	
	public DemoObj(Long id,String name){
		this.id=id;
		this.name=name;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
