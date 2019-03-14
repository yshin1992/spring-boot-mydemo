package myspringboot.ch3;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

/**
 * 通过实现BeanNameAware接口来获得Bean名称
 * 通过实现ResourceLoaderAware接口获得资源加载器，这样可以获得外部资源文件
 * @author yanshuai
 *
 */
@Service
public class AwareService implements BeanNameAware,ResourceLoaderAware{

	private String beanName;
	
	private ResourceLoader resourceLoader;
	
	public void setResourceLoader(ResourceLoader arg0) {
		// TODO Auto-generated method stub
		this.resourceLoader =arg0;
	}

	public void setBeanName(String arg0) {
		// TODO Auto-generated method stub
		this.beanName = arg0;
	}
	
	public void output(){
		System.out.println("BeanName = "+this.beanName);
		Resource resource = resourceLoader.getResource("classpath:/jdbc.properties");
		
		try {
			System.out.println("ResourceLoader 加载的文档内容为："+IOUtils.toString(resource.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
