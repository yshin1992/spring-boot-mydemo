package myspringboot.ch4;

import myspringboot.ch4.model.DemoObj;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageConvertorController {

	@RequestMapping(value="/doConvert",produces={"application/www-ysh;charset=UTF-8"})
	public DemoObj doConvert(@RequestBody DemoObj demo){
		return demo;
	}
}
