package myspringboot.ch4.messageConvertor;

import java.io.IOException;
import java.nio.charset.Charset;

import myspringboot.ch4.model.DemoObj;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

public class MyMessageConvertor extends AbstractHttpMessageConverter<DemoObj> {

	public MyMessageConvertor() {
		super(new MediaType("application", "www-ysh", Charset.forName("UTF-8")));
	}
	
	//限制只有DemoObj及其子类才会经过此MessageConvertor进行转换
	@Override
	protected boolean supports(Class<?> clazz) {
		return DemoObj.class.isAssignableFrom(clazz);
	}

	@Override
	protected DemoObj readInternal(Class<? extends DemoObj> clazz,
			HttpInputMessage inputMessage) throws IOException,
			HttpMessageNotReadableException {
		// TODO Auto-generated method stub
		String temp=StreamUtils.copyToString(inputMessage.getBody(), Charset.forName("UTF-8"));
		String[] arr = temp.split("-");
		return new DemoObj(new Long(arr[0]),arr[1]);
	}

	@Override
	protected void writeInternal(DemoObj t, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		String out = "Hello :"+t.getId() +"-"+t.getName();
		outputMessage.getBody().write(out.getBytes());
		
	}

}
