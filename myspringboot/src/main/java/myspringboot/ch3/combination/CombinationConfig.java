package myspringboot.ch3.combination;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@ConfigurationScan
public class CombinationConfig {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext contxt = new AnnotationConfigApplicationContext(CombinationConfig.class);
		CombinationService service = contxt.getBean(CombinationService.class);
		service.outputResult();
		contxt.close();
	}
}
