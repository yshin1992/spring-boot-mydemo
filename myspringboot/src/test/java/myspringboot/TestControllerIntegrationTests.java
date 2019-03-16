package myspringboot;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import javax.json.JsonObject;

import myspringboot.ch4.MyMvcConfig;
import myspringboot.ch4.model.DemoObj;

import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={MyMvcConfig.class})
@WebAppConfiguration("src/main/resources")
public class TestControllerIntegrationTests {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext wac;
	
	@Autowired
	private MockHttpSession session;

	@Autowired
	private MockHttpServletRequest request;
	
	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	private ObjectMapper mapper= new ObjectMapper();
	@Test
	public void testNormalController() throws Exception {
		mockMvc.perform(get("/hello")).andExpect(status().isOk())
			.andExpect(view().name("hello")).andExpect(forwardedUrl("/WEB-INF/classes/views/hello.jsp"));
	}
	
	//比较返回的数据是不是DemoObj的对象实例
	@Test
	public void testRestController()throws Exception {
		mockMvc.perform(get("/anno/demoobj")).andExpect(status().isOk())
			.andExpect(content().contentType("application/json;charset=UTF-8"))
			.andExpect(content().string(mapper.writeValueAsString(new DemoObj(1233444L, "DDSS"))));
	}
}
