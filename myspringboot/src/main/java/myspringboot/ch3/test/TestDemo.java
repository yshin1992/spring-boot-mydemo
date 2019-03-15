package myspringboot.ch3.test;

import junit.framework.Assert;
import myspringboot.ch2.profile.DemoBean;
import myspringboot.ch2.profile.ProfileConfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ProfileConfig.class})
@ActiveProfiles("prod")
public class TestDemo {

	@Autowired
	private DemoBean demoBean;
	
	@Test
	public void prodBeanShouldInject(){
		String expected="From Production";
		String actual = demoBean.getContent();
		Assert.assertEquals(expected, actual);
	}
}
