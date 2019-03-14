package myspringboot.ch1.aop;


import java.util.List;

import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.ysh.p2p.dao.MemberDao;
import org.ysh.p2p.model.Member;

import junit.framework.TestCase;

@Configuration
@ComponentScan(basePackages={"myspringboot.ch1.aop","org.ysh.p2p.dao.impl"})
public class DaoAroundTest extends TestCase{
	
	public void testMemberQuery(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/aop.xml");
		MemberDao memberDao = context.getBean("memberDaoProxy",MemberDao.class);
		Member m = new Member();
		m.setStatus(null);
		try {
			List<Member> queryList = memberDao.queryList(m, Member.class);
			for(Member tmp:queryList){
				System.out.println(tmp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		context.close();
		
	}
	
	//上述方法和本方法执行的区别 : 请先将 交由Spring自动生成代理的部分注释掉
	public void testMemberQuery2(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/aop.xml");
		MemberDao memberDao = context.getBean("memberDao",MemberDao.class);
		Member m = new Member();
		m.setStatus(null);
		try {
			List<Member> queryList = memberDao.queryList(m, Member.class);
			for(Member tmp:queryList){
				System.out.println(tmp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		context.close();
		
	}
}
